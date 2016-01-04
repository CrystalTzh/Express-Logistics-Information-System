package presentation.transitui.CarOfficeBoard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.UserID;
import controller.corporationcontroller.LogController;
import controller.transitController.CarOfficeFormController;
import controller.transitController.OrderFormController;
import state.Operation;
import state.OperationObject;
import state.Transportation;
import state.UserRole;
import vo.CarOfficeFormVO;
import vo.LogVO;
import vo.OrderFormVO;

public class CarOfficePanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel carOfficePanel;
	JLabel inputDateLabel,qiyunIDLabel,destinationLabel,carIDLabel,carStateLabel,loadingMemberLabel,superCargoLabel,IDLabel,costLabel,NOLabel;
	
	
	
	/*           装车日期                            汽运编号                                                                                  车辆代号                                                                                                                                                                       装车单编号    */
	JTextField inputDateText,qiyunIDText,destinationText,carIDText,loadingMemberText,superCargoText,costText,NOText;
	JTextArea IDText;  				//订单号
	JButton cancelbutton,savebutton,submitbutton;
	public CarOfficePanel(){
//		this.setBorder(new TitledBorder("中转中心装车单01"));
		carOfficePanel=new JPanel();
		
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
		
		inputDateLabel=new JLabel("装车日期");
		qiyunIDLabel=new JLabel("汽运编号");
		destinationLabel=new JLabel("目的地");
		carIDLabel=new JLabel("车辆代号");
	//	carStateLabel=new JLabel("车辆状态");
		loadingMemberLabel=new JLabel("监装员");
		superCargoLabel=new JLabel("押运员");
		IDLabel=new JLabel("订单编号");
		costLabel=new JLabel("运费");
		NOLabel=new JLabel("装车单编号");
		
		inputDateText=new JTextField(20);
		qiyunIDText=new JTextField(20);
		destinationText=new JTextField(20);
		carIDText=new JTextField(20);
		loadingMemberText=new JTextField(20);
		superCargoText=new JTextField(20);
		IDText=new JTextArea(3,15);
		costText=new JTextField(20);
		NOText=new JTextField(20);
		costText.setText("自动生成不必填写");
		JScrollPane scroll = new JScrollPane(IDText); 
		//把定义的JTextArea放到JScrollPane里面去 

		//分别设置水平和垂直滚动条自动出现 
		scroll.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scroll.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

		
		
		
		inputDateText.setText(getCurrenTime());

		
		Box box1 = Box.createHorizontalBox();
		box1.add(inputDateLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(inputDateText);
		box1.add(Box.createHorizontalStrut(25));
		box1.add(carIDLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(carIDText);
		Box box2 = Box.createHorizontalBox();
		box2.add(qiyunIDLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(qiyunIDText);
		box2.add(Box.createHorizontalStrut(25));
		box2.add(IDLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(IDText);
		Box box3 = Box.createHorizontalBox();
		box3.add(loadingMemberLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(loadingMemberText);
		box3.add(Box.createHorizontalStrut(25));
		box3.add(superCargoLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(superCargoText);
		Box box4 = Box.createHorizontalBox();
		box4.add(costLabel);
		box4.add(Box.createHorizontalStrut(12));
		box4.add(costText);
		box4.add(Box.createHorizontalStrut(25));
		box4.add(NOLabel);
		box4.add(Box.createHorizontalStrut(12));
		box4.add(NOText);
		//垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box4);
		/*
		 */
		
		/*
		 */
		//组件之间的距离自动扩充平均分配
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
	public String getCurrenTime() {
		int year, month, day;
		
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);
		System.out.println(year+"-"+month+"-"+day);
		return year+"-"+month+"-"+day;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelbutton){
			textClear();
		}
		if(e.getSource()==savebutton){
			costText.setText(4+"");
			String number = "";
			number = IDText.getText();
			
			if(number.length()>0){
				CarOfficeFormVO vo = null;
				CarOfficeFormController carOfficeFormController = new CarOfficeFormController();
				try {
					vo = carOfficeFormController.findDriver(number);
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
						
						String NO=NOText.getText(); //装车单编号
						String destination=destinationText.getText(); //目的地
						String motorNumber=qiyunIDText.getText(); //汽运编号
						String carNumber=carIDText.getText(); //车辆代号
						String loadingMember=loadingMemberText.getText(); //监装员
						String supercargo=superCargoText.getText(); //押运员
						String putOnCarDate=inputDateText.getText(); //装车日期
						ArrayList<String> allIDs = new ArrayList<String>();
						BufferedReader br = new BufferedReader(new StringReader(IDText.getText()));
						String line = ""; 
						try{
							while((line = br.readLine()) != null){
								allIDs.add(line);
								OrderFormController oo=new OrderFormController();
								OrderFormVO ovo=oo.findDriver(line);
								ArrayList<Transportation> a=ovo.getTransportation();
								a.add(Transportation.SENDEROFFICEARRIVED);
								ovo.setTransportation(a);
								ArrayList<String> b=ovo.getAlldates();
								for(int i = 0;i<b.size();i++){
									
									System.out.println(b.get(i));
								}
								b.add(getCurrenTime());
								ovo.setAlldates(b);
						//		oo.submitDriver(ovo);
							}
						} 
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						@SuppressWarnings("unused")
						double transCharge = Double.parseDouble(costText.getText()); //运费
						double transitCharge=Double.parseDouble(costText.getText()); //运费
						
						
						CarOfficeFormVO voToAdd = new CarOfficeFormVO();
						voToAdd.setCarNumber(carNumber);
						voToAdd.setDestination(destination);
						voToAdd.setLoadingMember(loadingMember);
						voToAdd.setMotorNumber(motorNumber);
						voToAdd.setNO(NO);
						voToAdd.setPutOnCarDate(putOnCarDate);
						voToAdd.setSupercargo(supercargo);
						voToAdd.setTransitCharge(transitCharge);
						voToAdd.setAllIDs(allIDs);
						carOfficeFormController.saveDriver(voToAdd);//添加车辆
						
						
						LogController logController;
						logController = new LogController();
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.ADD);
						logToAdd.setOperationObject(OperationObject.CarOfficeForm);
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
			CarOfficeFormController carOfficeFormController = new CarOfficeFormController();
			
			String NO=NOText.getText(); //装车单编号
			String destination=destinationText.getText(); //目的地
			String motorNumber=qiyunIDText.getText(); //汽运编号
			String carNumber=carIDText.getText(); //车辆代号
			String loadingMember=loadingMemberText.getText(); //监装员
			String supercargo=superCargoText.getText(); //押运员
			String putOnCarDate=inputDateText.getText(); //装车日期
			ArrayList<String> allIDs = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new StringReader(IDText.getText()));
			String line = ""; 
			try{
				while((line = br.readLine()) != null){
					allIDs.add(line);
					OrderFormController oo=new OrderFormController();
					OrderFormVO ovo=oo.findDriver(line);
					ArrayList<Transportation> a=ovo.getTransportation();
					a.add(Transportation.SENDEROFFICEARRIVED);
					ovo.setTransportation(a);
					ArrayList<String> b=ovo.getAlldates();
					b.add(getCurrenTime());
					ovo.setAlldates(b);
					oo.submitDriver(ovo);
				}
			} 
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			double transitCharge=Double.parseDouble(costText.getText()); //运费
			
			
			CarOfficeFormVO voToAdd = new CarOfficeFormVO();
			voToAdd.setCarNumber(carNumber);
			voToAdd.setDestination(destination);
			voToAdd.setLoadingMember(loadingMember);
			voToAdd.setMotorNumber(motorNumber);
			voToAdd.setNO(NO);
			voToAdd.setPutOnCarDate(putOnCarDate);
			voToAdd.setSupercargo(supercargo);
			voToAdd.setTransitCharge(transitCharge);
			voToAdd.setAllIDs(allIDs);
			carOfficeFormController.submitDriver(voToAdd);
			
			
		}
	}

	private void textClear() {
		// TODO Auto-generated method stub
	
		qiyunIDText.setText(null);
		destinationText.setText(null);
		carIDText.setText(null);
		loadingMemberText.setText(null);
		superCargoText.setText(null);
		IDText.setText(null);
		costText.setText("自动生成不必填写");
		NOText.setText(null);
	}
}
