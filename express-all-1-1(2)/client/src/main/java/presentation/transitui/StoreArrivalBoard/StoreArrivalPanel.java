package presentation.transitui.StoreArrivalBoard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
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

import controller.transitController.StoreArrivalFormController;
import state.State;
import vo.OrderFormVO;
import vo.StoreArrivalFormVO;

public class StoreArrivalPanel extends JPanel implements ActionListener{
	JPanel storeArrivalPanel;
	JLabel dateLabel,storeIDLabel,fromLabel, formIDLabel,packageStateLabel,NOLabel;
	JTextField dateText,storeIDText,fromText,formIDText,NOText;
	JButton cancelbutton,savebutton,submitbutton;
	JRadioButton nice,broken,miss;
	ButtonGroup group1;
	
	public StoreArrivalPanel(){
		this.setBorder(new TitledBorder("中转中心到达单01"));
		storeArrivalPanel=new JPanel();
		dateLabel=new JLabel("日期");
		storeIDLabel=new JLabel("中转中心编号");
		fromLabel=new JLabel("出发地");
		formIDLabel=new JLabel("中转单编号");
		packageStateLabel=new JLabel("货物到达状态");
		NOLabel=new JLabel("中转中心到达单编号");
		dateText=new JTextField(20);
		storeIDText=new JTextField(20);
		fromText=new JTextField(20);
		formIDText=new JTextField(20);
		NOText=new JTextField(20);
		
		dateText.setText(getCurrenTime());
		
		cancelbutton=new JButton("取消");
		savebutton=new JButton("保存");
		submitbutton=new JButton("提交");
		cancelbutton.addActionListener(this);
		savebutton.addActionListener(this);
		submitbutton.addActionListener(this);
		submitbutton.setEnabled(false);
		
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
		box1.add(storeIDLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(storeIDText);
		Box box2 = Box.createHorizontalBox();
		box2.add(fromLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(fromText);
		Box box3 = Box.createHorizontalBox();
		box3.add(formIDLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(formIDText);
		box3.add(Box.createHorizontalStrut(25));
		box3.add(NOLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(NOText);
		Box box4 = Box.createHorizontalBox();
		box4.add(packageStateLabel);
		box4.add(Box.createHorizontalStrut(12));
		box4.add(nice);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(broken);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(miss);
	
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
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelbutton){
			textClear();
		}
		if(e.getSource()==savebutton){
			String number = "";
			number = formIDText.getText();
			if(number.length()>0){
				StoreArrivalFormVO vo = null;
				StoreArrivalFormController storeArrivalFormController = new StoreArrivalFormController();
				try {
					vo = storeArrivalFormController.findDriver(number);
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
						//包装VO
						String NO=NOText.getText(); //营业厅到达单编号
						String relaynumber=storeIDText.getText(); //中转中心编号
						String arriveDate=dateText.getText(); // 到达日期
						String relayformnumber=formIDText.getText(); //中转单编号
						String startingPoint=fromText.getText(); //出发地
					//	State state;
						
						StoreArrivalFormVO voToAdd = new StoreArrivalFormVO();
						voToAdd.setArriveDate(arriveDate);
						voToAdd.setNO(NO);
						voToAdd.setRelayformnumber(relayformnumber);
						voToAdd.setRelaynumber(relaynumber);
						voToAdd.setStartingPoint(startingPoint);
						
						storeArrivalFormController.saveDriver(voToAdd);
						
					}//录入结束
				}
			}else {//1.2 未输入司机编号
				String warning = "必须要输入信息!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	private void textClear() {
		// TODO Auto-generated method stub
	
		storeIDText.setText(null);
		fromText.setText(null);
		formIDText.setText(null);
		NOText.setText(null);
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
