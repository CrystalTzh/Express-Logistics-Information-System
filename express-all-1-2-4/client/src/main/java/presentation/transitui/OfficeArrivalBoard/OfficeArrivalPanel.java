package presentation.transitui.OfficeArrivalBoard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.UserID;
import controller.corporationcontroller.LogController;
import controller.transitController.OfficeArrivalFormController;
import controller.transitController.OrderFormController;
import state.Operation;
import state.OperationObject;
import state.State;
import state.Transportation;
import state.UserRole;
import vo.LogVO;
import vo.OfficeArrivalFormVO;
import vo.OrderFormVO;



public class OfficeArrivalPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel storeArrivalPanel;
	JLabel dateLabel,destinationLabel, formIDLabel,packageStateLabel,NOLabel,IDLabel;
	JTextField dateText,destinationText,formIDText,NOText,IDText;
			/*                       中转单编号                 营业厅到达单编号        订单号       */
	JButton cancelbutton,savebutton,submitbutton;
	JRadioButton nice,broken,miss;
	ButtonGroup group1;
	public OfficeArrivalPanel(){
		this.setBorder(new TitledBorder("营业厅到达单"));
		storeArrivalPanel=new JPanel();
		dateLabel=new JLabel("日期");
		NOLabel=new JLabel("营业厅到达单编号");
		destinationLabel=new JLabel("出发地");
		formIDLabel=new JLabel("中转单编号");
		IDLabel = new JLabel("订单号");
		packageStateLabel=new JLabel("货物到达状态");
		dateText=new JTextField(20);
		NOText=new JTextField(20);
		destinationText=new JTextField(20);
		formIDText=new JTextField(20);
		IDText=new JTextField(20);
		dateText.setText(getCurrenTime());
		
		cancelbutton=new JButton("取消");
		savebutton=new JButton("保存");
		submitbutton=new JButton("提交");
		cancelbutton.addActionListener(this);
		savebutton.addActionListener(this);
		submitbutton.addActionListener(this);
		submitbutton.setEnabled(false);
		cancelbutton.setContentAreaFilled(false);
		savebutton.setContentAreaFilled(false);
		submitbutton.setContentAreaFilled(false);
		
		nice=new JRadioButton("完好", true);
		broken=new JRadioButton("破损", false);
		miss=new JRadioButton("丢失", false);
		group1=new ButtonGroup();
		group1.add(nice);
		group1.add(broken);
		group1.add(miss);
		
		Box box1 = Box.createHorizontalBox();
		box1.add(dateLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(dateText);
		box1.add(Box.createHorizontalStrut(25));
		Box box2 = Box.createHorizontalBox();
		box2.add(destinationLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(destinationText);
		box1.add(Box.createHorizontalStrut(25));
		box2.add(IDLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(IDText);
		Box box3 = Box.createHorizontalBox();
		box3.add(formIDLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(formIDText);
		box3.add(Box.createHorizontalStrut(25));
		box1.add(NOLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(NOText);
		Box box4 = Box.createHorizontalBox();
		box3.add(packageStateLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(nice);
		box3.add(Box.createHorizontalStrut(5));
		box3.add(broken);
		box3.add(Box.createHorizontalStrut(5));
		box3.add(miss);
	
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box4);
		
		boxH.add(Box.createVerticalGlue());
		JPanel pCenter;
		//JScrollPane处理滚动
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);
		
		setLayout(new BorderLayout());
		//主要的信息界面显示在中央
		add(scrollPane, BorderLayout.CENTER);
		JPanel pSouth = new JPanel();
		pSouth.add(cancelbutton);
		pSouth.add(savebutton);
		pSouth.add(submitbutton);
		//两个按钮显示在南边
		add(pSouth, BorderLayout.SOUTH);
	}
	@SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelbutton){
			textClear();
			JOptionPane.getFrameForComponent(this).dispose();
		}
		if(e.getSource()==savebutton){
			
			String number = "";
			number = NOText.getText();
			
			if(number.length()>0){
				OfficeArrivalFormVO vo = null;
				OfficeArrivalFormController officeArrivalFormController = new OfficeArrivalFormController();
				try {
					vo = officeArrivalFormController.findDriver(number);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(vo!= null) { //1.1.1 输入的车辆代号存在
					String warning = "信息已存在,请到修改页面修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {//1.1.2 输出的车辆代号不存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//确认录入
						//包装CarInputFormVO
						
						String NO=NOText.getText();//编号
						String arriveDate=dateText.getText();//到达日期
						String relayformnumber=formIDText.getText(); //中转单编号
						String destination=dateText.getText(); //目的地
						State state=null;
						if(nice.isSelected()){
							state=state.WELL;
						}else if(broken.isSelected()){
							state=state.DAMAGED;
						}else{
							state=state.MISSING;
						}
						
						OfficeArrivalFormVO voToAdd = new OfficeArrivalFormVO();
						voToAdd.setArriveDate(arriveDate);
						voToAdd.setDestination(destination);
						voToAdd.setNO(NO);
						voToAdd.setRelayformnumber(relayformnumber);
						voToAdd.setState(state);
						officeArrivalFormController.saveDriver(voToAdd);//添加车辆
						
						OrderFormController oo=new OrderFormController();
						OrderFormVO ovo;
						try {
							ovo = oo.findDriver(IDText.getText());
							ArrayList<Transportation> a=ovo.getTransportation();
							a.add(Transportation.RECEIVEROFFICEARRIVED);
							ovo.setTransportation(a);
							ArrayList<String> b=ovo.getAlldates();
							b.add(getCurrenTime());
							ovo.setAlldates(b);
							oo.submitDriver(ovo);
							
						} catch (RemoteException | IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						LogController logController;
						logController = new LogController();
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.ADD);
						logToAdd.setOperationObject(OperationObject.OfficeArrivalForm);
						logToAdd.setOperationTime(new GregorianCalendar());
						logToAdd.setOperatorID(UserID.userid);
						logToAdd.setOperatorRole(UserRole.OFFICEMAN);
						logController.addLog(logToAdd);//添加一条日志
						
					}//录入结束
					
				}
				submitbutton.setEnabled(true);
			}else {//1.2 未输入司机编号
				String warning = "必须要输入信息!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if(e.getSource()==submitbutton){
			OfficeArrivalFormController officeArrivalFormController = new OfficeArrivalFormController();

			String NO=NOText.getText();//编号
			String arriveDate=dateText.getText();//到达日期
			String relayformnumber=formIDText.getText(); //中转单编号
			String destination=dateText.getText(); //目的地
			State state=null;
			if(nice.isSelected()){
				state=state.WELL;
			}else if(broken.isSelected()){
				state=state.DAMAGED;
			}else{
				state=state.MISSING;
			}
			
			OfficeArrivalFormVO voToAdd = new OfficeArrivalFormVO();
			voToAdd.setArriveDate(arriveDate);
			voToAdd.setDestination(destination);
			voToAdd.setNO(NO);
			voToAdd.setRelayformnumber(relayformnumber);
			voToAdd.setState(state);
			officeArrivalFormController.submitDriver(voToAdd);
			
			OrderFormController oo=new OrderFormController();
			OrderFormVO ovo;
			try {
				ovo = oo.findDriver(IDText.getText());
				ArrayList<Transportation> a=ovo.getTransportation();
				a.add(Transportation.RECEIVEROFFICEARRIVED);
				ovo.setTransportation(a);
				
				ArrayList<String> b=ovo.getAlldates();
				b.add(getCurrenTime());
				ovo.setAlldates(b);
			//	oo.submitDriver(ovo);
				
			} catch (RemoteException | IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.getFrameForComponent(this).dispose();
		}
		
	}
	private void textClear() {
		// TODO Auto-generated method stub
		
		NOText.setText(null);
		destinationText.setText(null);
		formIDText.setText(null);
	}
	public String getCurrenTime() {
		int year, month, day;
		
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);
		
		return year+"-"+month+"-"+day;
	}
}
