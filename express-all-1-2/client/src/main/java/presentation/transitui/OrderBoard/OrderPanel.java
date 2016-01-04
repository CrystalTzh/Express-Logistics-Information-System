package presentation.transitui.OrderBoard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.UserID;
import controller.corporationcontroller.LogController;
import controller.transitController.OrderFormController;
import state.City;
import state.Operation;
import state.OperationObject;
import state.Transportation;
import state.UserRole;
import vo.LogVO;
import vo.OrderFormVO;

public class OrderPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel orderInfoPanel;
	JLabel sNameLabel, rNameLabel, sHomeLabel,rHomeLabel,sPhoneLabel,rPhoneLabel,sTeleLabel,rTeleLabel,sAdressLabel,rAdressLabel,
	orderNumLabel,weightLabel,orderNameLabel,hugeLabel,orderKindLabel,costPicLabel,costLabel,IDLabel,dateLabel;
	
	
	/*          寄件人                                                                 寄件人单位                                            寄件人手机                                                     寄件人电话                                                     寄件人地址                                     */
	JTextField sNameText, rNameText, sHomeText,rHomeText,sPhoneText,rPhoneText,sTeleText,rTeleText,sAdressText,rAdressText,
	/* 原件数                        重量                                 内件品名                             体积                                                    订单号           日期            */
	orderNumText,weightText,orderNameText,hugeText,costText,IDText,dateText;
	JButton cancelbutton,savebutton,submitbutton;
	JRadioButton ecnomic,normal,fast,five,ten,one;
	ButtonGroup group1,group2;
	JComboBox<String> jcbcity,jcbcity2;
	DefaultComboBoxModel<String> BeijingModel;
	DefaultComboBoxModel<String> NanjingModel;
	DefaultComboBoxModel<String> ShanghaiModel;
	DefaultComboBoxModel<String> GuangzhouModel;
	DefaultComboBoxModel<String> model;
	int a,b;
	
	public OrderPanel(){
		this.setBorder(new TitledBorder("寄件单01"));
		orderInfoPanel=new JPanel();
		sNameLabel=new JLabel("寄件人姓名");
		rNameLabel=new JLabel("收件人姓名");
		sHomeLabel=new JLabel("寄件人单位");
		rHomeLabel=new JLabel("收件人单位");
		sPhoneLabel=new JLabel("寄件人手机");
		rPhoneLabel=new JLabel("收件人手机");
		sTeleLabel=new JLabel("寄件人电话");
		rTeleLabel=new JLabel("收件人电话");
		sAdressLabel=new JLabel("寄件人地址");
		rAdressLabel=new JLabel("收件人地址");
		orderNumLabel=new JLabel("原件数");
		weightLabel=new JLabel("实际重量");
		orderNameLabel=new JLabel("内件品名");
		hugeLabel=new JLabel("体积");
		orderKindLabel =new JLabel("快递种类");
		dateLabel=new JLabel("日期");
		costPicLabel=new JLabel("包装费");
		costLabel=new JLabel("费用合计");
		IDLabel=new JLabel("订单号");
		
		
		jcbcity = new JComboBox<String>();
		jcbcity.addItem("----");
		jcbcity.addItem(City.BEIJING.toString());
		jcbcity.addItem(City.GUANGZHOU.toString());
		jcbcity.addItem(City.NANJING.toString());
		jcbcity.addItem(City.SHANGHAI.toString());
		String[] none = {"----"};
		model = new DefaultComboBoxModel<String>(none);
		
		jcbcity2 = new JComboBox<String>();
		jcbcity2.addItem("----");
		jcbcity2.addItem(City.BEIJING.toString());
		jcbcity2.addItem(City.GUANGZHOU.toString());
		jcbcity2.addItem(City.NANJING.toString());
		jcbcity2.addItem(City.SHANGHAI.toString());
		String[] none2 = {"----"};
		model = new DefaultComboBoxModel<String>(none2);
		
		
		
		
		jcbcity.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getItem().equals(City.BEIJING.toString())){
					a=1;
				}else if(e.getItem().equals(City.SHANGHAI.toString())){
					a=2;
				}else if(e.getItem().equals(City.GUANGZHOU.toString())){
					a=3;
				}else if(e.getItem().equals(City.NANJING.toString())){
					a=4;
				}else if(e.getItem().equals("----")){
					a=5;
				}
			}
			
		});
		
		jcbcity2.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getItem().equals(City.BEIJING.toString())){
					b=1;
				}else if(e.getItem().equals(City.SHANGHAI.toString())){
					b=2;
				}else if(e.getItem().equals(City.GUANGZHOU.toString())){
					b=3;
				}else if(e.getItem().equals(City.NANJING.toString())){
					b=4;
				}else if(e.getItem().equals("----")){
					b=5;
				}
			}
			
		});
		
		sNameText=new JTextField(20);
		rNameText=new JTextField(20);
		sHomeText=new JTextField(20);
		rHomeText=new JTextField(20);
		sPhoneText=new JTextField(20);
		rPhoneText=new JTextField(20);
		sTeleText=new JTextField(20);
		rTeleText=new JTextField(20);
		sAdressText=new JTextField(30);
		rAdressText=new JTextField(30);
		orderNumText=new JTextField(20);
		weightText=new JTextField(20);
		orderNameText=new JTextField(20);
		hugeText=new JTextField(20);
		costText=new JTextField(15);
		costText.setText("自动计算不必填写");
		costText.setEditable(false);
		IDText=new JTextField(15);
		dateText=new JTextField(15);
		
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
		
		ecnomic=new JRadioButton("经济", true);
		normal=new JRadioButton("标准",false);
		fast=new JRadioButton("特快", false);
		five=new JRadioButton("纸箱5元", true);
		ten=new JRadioButton("木箱10元",false);
		one=new JRadioButton("快递袋1元",false);
		
		group1=new ButtonGroup();
		group1.add(ecnomic);
		group1.add(normal);
		group1.add(fast);
		group2=new ButtonGroup();
		group2.add(five);
		group2.add(ten);
		group2.add(one);
		
		dateText.setText(getCurrenTime());
		
		Box box1 = Box.createHorizontalBox();
		box1.add(sNameLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(sNameText);
		box1.add(Box.createHorizontalStrut(25));
		box1.add(rNameLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(rNameText);
		Box box2 = Box.createHorizontalBox();
		box2.add(sHomeLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(sHomeText);
		box2.add(Box.createHorizontalStrut(25));
		box2.add(rHomeLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(rHomeText);
		Box box3 = Box.createHorizontalBox();
		box3.add(sTeleLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(sTeleText);
		box3.add(Box.createHorizontalStrut(25));
		box3.add(rTeleLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(rTeleText);
		Box box4 = Box.createHorizontalBox();
		box4.add(sPhoneLabel);
		box4.add(Box.createHorizontalStrut(12));
		box4.add(sPhoneText);
		box4.add(Box.createHorizontalStrut(25));
		box4.add(rPhoneLabel);
		box4.add(Box.createHorizontalStrut(12));
		box4.add(rPhoneText);
		Box box5 = Box.createHorizontalBox();
		box5.add(sAdressLabel);
		box5.add(Box.createHorizontalStrut(12));
		box5.add(sAdressText);
		box5.add(new JLabel("出发城市:", JLabel.CENTER));
		box5.add(Box.createHorizontalStrut(12));
		box5.add(jcbcity);
		Box box6 = Box.createHorizontalBox();
		box6.add(rAdressLabel);
		box6.add(Box.createHorizontalStrut(12));
		box6.add(rAdressText);
		box6.add(new JLabel("到达城市:", JLabel.CENTER));
		box6.add(Box.createHorizontalStrut(12));
		box6.add(jcbcity2);
		Box box7 = Box.createHorizontalBox();
		box7.add(orderNumLabel);
		box7.add(Box.createHorizontalStrut(12));
		box7.add(orderNumText);
		box7.add(Box.createHorizontalStrut(25));
		box7.add(weightLabel);
		box7.add(Box.createHorizontalStrut(12));
		box7.add(weightText);
		Box box8 = Box.createHorizontalBox();
		box8.add(sNameLabel);
		box8.add(Box.createHorizontalStrut(12));
		box8.add(sNameText);
		box8.add(Box.createHorizontalStrut(25));
		box8.add(rNameLabel);
		box8.add(Box.createHorizontalStrut(12));
		box8.add(rNameText);
		Box box9 = Box.createHorizontalBox();
		box9.add(orderNameLabel);
		box9.add(Box.createHorizontalStrut(12));
		box9.add(orderNameText);
		box9.add(Box.createHorizontalStrut(25));
		box9.add(hugeLabel);
		box9.add(Box.createHorizontalStrut(12));
		box9.add(hugeText);
		Box box10 = Box.createHorizontalBox();
		box10.add(orderKindLabel);
		box10.add(Box.createHorizontalStrut(12));
		box10.add(ecnomic);
		box10.add(Box.createHorizontalStrut(5));
		box10.add(normal);
		box10.add(Box.createHorizontalStrut(5));
		box10.add(fast);
		Box box11 = Box.createHorizontalBox();
		box11.add(costPicLabel);
		box11.add(Box.createHorizontalStrut(12));
		box11.add(five);
		box10.add(Box.createHorizontalStrut(5));
		box11.add(ten);
		box10.add(Box.createHorizontalStrut(5));
		box11.add(one);
		Box box12 = Box.createHorizontalBox();
		box12.add(costLabel);
		box12.add(Box.createHorizontalStrut(12));
		box12.add(costText);
		box12.add(Box.createHorizontalStrut(10));
		box12.add(IDLabel);
		box12.add(Box.createHorizontalStrut(12));
		box12.add(IDText);
		box12.add(Box.createHorizontalStrut(10));
		box12.add(dateLabel);
		box12.add(Box.createHorizontalStrut(12));
		box12.add(dateText);
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
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box5);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box6);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box7);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box8);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box9);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box10);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box11);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box12);
		
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
		OrderFormVO vo = null;
		OrderFormController orderFormController = new OrderFormController();
		
		if(e.getSource()==cancelbutton){
			textClear();
			JOptionPane.getFrameForComponent(this).dispose();
		}
		if(e.getSource()==savebutton){
			setMoney();
			String NO = "";
			NO = IDText.getText();
			if(NO.length()>0){
				
				try {
					vo = orderFormController.findDriver(NO);
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
						//包装OrderFormVO
						String sendername=sNameText.getText();
						String senderaddress=sAdressText.getText();
						String sendercompany=sHomeText.getText();
						String sendertel=sTeleText.getText();
						String sendermobiletel=sPhoneText.getText();
						String receivername=rNameText.getText();
						String receiveraddress=rAdressText.getText();
						String receivercompany=rHomeText.getText();
						String receivertel=rTeleText.getText();
						String date=dateText.getText(); //寄件日期
						String receivermobiletel=rPhoneText.getText();
						int number=Integer.parseInt(orderNumText.getText());		//原件数
						double weight=Double.parseDouble(weightText.getText());  //实际重量
						double size=Double.parseDouble(hugeText.getText());    //体积
						String name=orderNameText.getText();    //内件品名
					//	ExpressType type;    //快递种类
			//			double packingCharges=Double.parseDouble(s);//包装费
						double transCharges=Double.parseDouble(costText.getText());//运费
			//			double expressCharges;//快递费
						String ID=IDText.getText(); //快递订单号
						ArrayList<Transportation> allTransportations=new ArrayList<>();
						allTransportations.add(Transportation.COLLECTED);
						ArrayList<String> alldates=new ArrayList<>();
						alldates.add(getCurrenTime());
				//		String date; //寄件日期
					//	String realReceiver; //实际收件人
				//		String realReceiveDate;//实际收件日期
						OrderFormVO voToAdd = new OrderFormVO();
						voToAdd.setID(ID);
						voToAdd.setName(name);
						voToAdd.setNumber(number);
						voToAdd.setReceiveraddress(receiveraddress);
						voToAdd.setReceivercompany(receivercompany);
						voToAdd.setReceivermobiletel(receivermobiletel);
						voToAdd.setReceivername(receivername);
						voToAdd.setReceivertel(receivertel);
						voToAdd.setSenderaddress(senderaddress);
						voToAdd.setDate(date);
						voToAdd.setSendercompany(sendercompany);
						voToAdd.setSendermobiletel(sendermobiletel);
						voToAdd.setSendername(sendername);
						voToAdd.setSendertel(sendertel);
						voToAdd.setSize(size);
						voToAdd.setTransCharges(transCharges);
						voToAdd.setWeight(weight);
						voToAdd.setTransportation(allTransportations);
						voToAdd.setAlldates(alldates);
						orderFormController.saveDriver(voToAdd);//添加车辆
						
						LogController logController;
						logController = new LogController();
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.ADD);
						logToAdd.setOperationObject(OperationObject.OrderForm);
						logToAdd.setOperationTime(new GregorianCalendar());
						logToAdd.setOperatorID(UserID.userid);
						logToAdd.setOperatorRole(UserRole.EXPRESSMAN);
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
			String sendername=sNameText.getText();
			String senderaddress=sAdressText.getText();
			String sendercompany=sHomeText.getText();
			String sendertel=sTeleText.getText();
			String sendermobiletel=sPhoneText.getText();
			String receivername=rNameText.getText();
			String receiveraddress=rAdressText.getText();
			String receivercompany=rHomeText.getText();
			String receivertel=rTeleText.getText();
			String receivermobiletel=rPhoneText.getText();
			int number=Integer.parseInt(orderNumText.getText());		//原件数
			double weight=Double.parseDouble(weightText.getText());  //实际重量
			double size=Double.parseDouble(hugeText.getText());    //体积
			String name=orderNameText.getText();    //内件品名
		//	ExpressType type;    //快递种类
//			double packingCharges=Double.parseDouble(s);//包装费
			double transCharges=Double.parseDouble(costText.getText());//运费
//			double expressCharges;//快递费
			String ID=IDText.getText(); //快递订单号
			String date=dateText.getText(); //寄件日期
			ArrayList<Transportation> allTransportations=new ArrayList<>();
			allTransportations.add(Transportation.COLLECTED);
			ArrayList<String> alldates=new ArrayList<>();
			alldates.add(getCurrenTime());
		//	String realReceiver; //实际收件人
	//		String realReceiveDate;//实际收件日期
			OrderFormVO voToAdd = new OrderFormVO();
			voToAdd.setID(ID);
			voToAdd.setName(name);
			voToAdd.setNumber(number);
			voToAdd.setReceiveraddress(receiveraddress);
			voToAdd.setReceivercompany(receivercompany);
			voToAdd.setReceivermobiletel(receivermobiletel);
			voToAdd.setReceivername(receivername);
			voToAdd.setReceivertel(receivertel);
			voToAdd.setSenderaddress(senderaddress);
			voToAdd.setSendercompany(sendercompany);
			voToAdd.setSendermobiletel(sendermobiletel);
			voToAdd.setSendername(sendername);
			voToAdd.setSendertel(sendertel);
			voToAdd.setSize(size);
			voToAdd.setDate(date);
			voToAdd.setTransCharges(transCharges);
			voToAdd.setWeight(weight);
			voToAdd.setTransportation(allTransportations);
			voToAdd.setAlldates(alldates);
			orderFormController.submitDriver(voToAdd);//添加车辆
			
			JOptionPane.getFrameForComponent(this).dispose();
			
		}
	}
	private void textClear() {
		// TODO Auto-generated method stub
		sNameText.setText(null);
		rNameText.setText(null);
		sHomeText.setText(null);
		rHomeText.setText(null);
		sPhoneText.setText(null);
		rPhoneText.setText(null);
		sTeleText.setText(null);
		rTeleText.setText(null);
		sAdressText.setText(null);
		rAdressText.setText(null);
		orderNumText.setText(null);
		weightText.setText(null);
		orderNameText.setText(null);
		hugeText.setText(null);
		costText.setText("自动计算不必填写");
		costText.setEditable(false);
		IDText.setText(null);
		jcbcity.setSelectedItem("----");
		jcbcity2.setSelectedItem("----");
	}
	private void setMoney(){
		double cost=0;
		if((a==1&&b==2)||(a==2&&b==1)){
			cost=25;
		}
		else if((a==1&&b==3)||(a==3&&b==1)){
			cost=30;
		}
		else if((a==1&&b==4)||(a==4&&b==1)){
			cost=25;
		}
		else if((a==2&&b==3)||(a==3&&b==2)){
			cost=25;
		}
		else if((a==2&&b==4)||(a==4&&b==2)){
			cost=15;
		}
		else if((a==3&&b==4)||(a==4&&b==3)){
			cost=15;
		}
	
		double weight=Double.parseDouble(weightText.getText());
		
		cost=cost*weight/15;
		if(ecnomic.isSelected()){
			cost=cost+0;
		}
		else if(normal.isSelected()){
			cost=cost+5;
		}
		else if(fast.isSelected()){
			cost=cost+10;
		}
		if(five.isSelected()){
			cost=cost+5;
		}
		else if(ten.isSelected()){
			cost=cost+10;
		}
		else if(one.isSelected()){
			cost=cost+1;
		}
		costText.setText(cost+"");
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
