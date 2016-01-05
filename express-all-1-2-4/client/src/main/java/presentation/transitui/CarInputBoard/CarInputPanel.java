package presentation.transitui.CarInputBoard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.UserID;
import controller.corporationcontroller.LogController;
import controller.transitController.CarInputFormController;
import controller.transitController.OrderFormController;
import state.BeiJingDistrict;
import state.City;
import state.GuangZhouDistrict;
import state.NanJingDistrict;
import state.Operation;
import state.OperationObject;
import state.ShangHaiDistrict;
import state.Transportation;
import state.UserRole;
import vo.CarInputFormVO;
import vo.LogVO;
import vo.OrderFormVO;



public class CarInputPanel  extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel carInputPanel;
	
	JLabel inputDateLabel,qiyunIDLabel,destinationLabel,carIDLabel,carStateLabel,loadingMemberLabel,superCargoLabel,IDLabel,costLabel,NOLabel;
	
	/*          装车日期                                汽运编号                                                                             车辆代号                        监装员                                           押运员                                                                         装车单编号         */
	JTextField inputDateText,qiyunIDText,destinationText,carIDText,loadingMemberText,superCargoText,costText,NOText;
	JTextArea IDText;				//订单号批量
	JButton cancelbutton,savebutton,submitbutton;
	JComboBox<String> jcbcity,jcbdistrict,jcbcity2,jcbdistrict2;
	DefaultComboBoxModel<String> BeijingModel;
	DefaultComboBoxModel<String> NanjingModel;
	DefaultComboBoxModel<String> ShanghaiModel;
	DefaultComboBoxModel<String> GuangzhouModel;
	DefaultComboBoxModel<String> model;
	DefaultComboBoxModel<String> BeijingModel2;
	DefaultComboBoxModel<String> NanjingModel2;
	DefaultComboBoxModel<String> ShanghaiModel2;
	DefaultComboBoxModel<String> GuangzhouModel2;
	DefaultComboBoxModel<String> model2;
	
	int a,b;
	//JRadioButton free,busy;
	public CarInputPanel(){
//		this.setBorder(new TitledBorder("中转中心装车单"));
		carInputPanel=new JPanel();
		
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
		
		costText.setText("不同输入自动计算");
		
		jcbcity = new JComboBox<String>();
		jcbcity.addItem("----");
		jcbcity.addItem(City.BEIJING.toString());
		jcbcity.addItem(City.GUANGZHOU.toString());
		jcbcity.addItem(City.NANJING.toString());
		jcbcity.addItem(City.SHANGHAI.toString());
		String[] none = {"----"};
		model = new DefaultComboBoxModel<String>(none);
		
		String[] beijingdistricts = {"----",BeiJingDistrict.ChangPing.toString(),BeiJingDistrict.ChaoYang.toString(),
				BeiJingDistrict.ChongWen.toString(),BeiJingDistrict.DaXing.toString(),BeiJingDistrict.DongCheng.toString(),
				BeiJingDistrict.FangShan.toString(),BeiJingDistrict.FengTai.toString(),BeiJingDistrict.HaiDian.toString(),
				BeiJingDistrict.HuaiRou.toString(),BeiJingDistrict.MenTouGou.toString(),BeiJingDistrict.MiYun.toString(),
				BeiJingDistrict.PingGu.toString(),BeiJingDistrict.ShiJingShan.toString(),BeiJingDistrict.ShunYi.toString(),
				BeiJingDistrict.TongZhou.toString(),BeiJingDistrict.XiCheng.toString(),BeiJingDistrict.Xuanwu.toString(),
				BeiJingDistrict.YanQing.toString()};
		BeijingModel = new DefaultComboBoxModel<String>(beijingdistricts);
		
		String[] nanjingdistricts = {"----",NanJingDistrict.BaiXia.toString(),NanJingDistrict.GaoChun.toString(),
				NanJingDistrict.GuLou.toString(),NanJingDistrict.JiangNing.toString(),NanJingDistrict.JianYe.toString(),
				NanJingDistrict.LiShui.toString(),NanJingDistrict.LiuHe.toString(),NanJingDistrict.PuKou.toString(),
				NanJingDistrict.QinHuai.toString(),NanJingDistrict.QiXia.toString(),NanJingDistrict.XiaGuan.toString(),
				NanJingDistrict.XuanWu.toString(),NanJingDistrict.YuHuaTai.toString()};
		NanjingModel = new DefaultComboBoxModel<String>(nanjingdistricts);
		
		String[] shanghaidistricts = {"----",ShangHaiDistrict.ChangNing.toString(),ShangHaiDistrict.ChongMing.toString(),
				ShangHaiDistrict.FengXian.toString(),ShangHaiDistrict.HongKou.toString(),ShangHaiDistrict.HuangPu.toString(),
				ShangHaiDistrict.JiangAn.toString(),ShangHaiDistrict.JinShan.toString(),ShangHaiDistrict.LuWan.toString(),
				ShangHaiDistrict.NanHui.toString(),ShangHaiDistrict.PuDong.toString(),ShangHaiDistrict.PuTuo.toString(),
				ShangHaiDistrict.QingPu.toString(),ShangHaiDistrict.SongJiang.toString(),ShangHaiDistrict.XuHui.toString(),
				ShangHaiDistrict.YangPu.toString(),ShangHaiDistrict.ZhaBei.toString()};
		ShanghaiModel = new DefaultComboBoxModel<String>(shanghaidistricts);
		
		String[] guangzhoudistricts = {"----",GuangZhouDistrict.BaiYun.toString(),GuangZhouDistrict.CongHua.toString(),
				GuangZhouDistrict.FanYu.toString(),GuangZhouDistrict.HaiZhu.toString(),GuangZhouDistrict.HuaDu.toString(),
				GuangZhouDistrict.HuangPu.toString(),GuangZhouDistrict.LiWan.toString(),GuangZhouDistrict.LuoGang.toString(),
				GuangZhouDistrict.NanSha.toString(),GuangZhouDistrict.TianHe.toString(),GuangZhouDistrict.YueXiu.toString(),
				GuangZhouDistrict.ZengCheng.toString()};
		GuangzhouModel = new DefaultComboBoxModel<String>(guangzhoudistricts);
		
		jcbdistrict = new JComboBox<String>();
		jcbdistrict.setModel(model);
		
		jcbcity.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getItem().equals(City.BEIJING.toString())){
					jcbdistrict.setModel(BeijingModel);
					a=1;
				}else if(e.getItem().equals(City.SHANGHAI.toString())){
					jcbdistrict.setModel(ShanghaiModel);
					a=2;
				}else if(e.getItem().equals(City.GUANGZHOU.toString())){
					jcbdistrict.setModel(GuangzhouModel);
					a=3;
				}else if(e.getItem().equals(City.NANJING.toString())){
					jcbdistrict.setModel(NanjingModel);
					a=4;
				}else if(e.getItem().equals("----")){
					jcbdistrict.setModel(model);
					a=5;
				}
			}
			
		});
		jcbdistrict.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(!(e.getItem().equals(null))){
//					System.out.println("!");
				}
			}
			
		});
		
		
		
		jcbcity2 = new JComboBox<String>();
		jcbcity2.addItem("----");
		jcbcity2.addItem(City.BEIJING.toString());
		jcbcity2.addItem(City.GUANGZHOU.toString());
		jcbcity2.addItem(City.NANJING.toString());
		jcbcity2.addItem(City.SHANGHAI.toString());
		String[] none2 = {"----"};
		model2 = new DefaultComboBoxModel<String>(none2);
		
		String[] beijingdistricts2 = {"----",BeiJingDistrict.ChangPing.toString(),BeiJingDistrict.ChaoYang.toString(),
				BeiJingDistrict.ChongWen.toString(),BeiJingDistrict.DaXing.toString(),BeiJingDistrict.DongCheng.toString(),
				BeiJingDistrict.FangShan.toString(),BeiJingDistrict.FengTai.toString(),BeiJingDistrict.HaiDian.toString(),
				BeiJingDistrict.HuaiRou.toString(),BeiJingDistrict.MenTouGou.toString(),BeiJingDistrict.MiYun.toString(),
				BeiJingDistrict.PingGu.toString(),BeiJingDistrict.ShiJingShan.toString(),BeiJingDistrict.ShunYi.toString(),
				BeiJingDistrict.TongZhou.toString(),BeiJingDistrict.XiCheng.toString(),BeiJingDistrict.Xuanwu.toString(),
				BeiJingDistrict.YanQing.toString()};
		BeijingModel2 = new DefaultComboBoxModel<String>(beijingdistricts2);
		
		String[] nanjingdistricts2 = {"----",NanJingDistrict.BaiXia.toString(),NanJingDistrict.GaoChun.toString(),
				NanJingDistrict.GuLou.toString(),NanJingDistrict.JiangNing.toString(),NanJingDistrict.JianYe.toString(),
				NanJingDistrict.LiShui.toString(),NanJingDistrict.LiuHe.toString(),NanJingDistrict.PuKou.toString(),
				NanJingDistrict.QinHuai.toString(),NanJingDistrict.QiXia.toString(),NanJingDistrict.XiaGuan.toString(),
				NanJingDistrict.XuanWu.toString(),NanJingDistrict.YuHuaTai.toString()};
		NanjingModel2 = new DefaultComboBoxModel<String>(nanjingdistricts2);
		
		String[] shanghaidistricts2 = {"----",ShangHaiDistrict.ChangNing.toString(),ShangHaiDistrict.ChongMing.toString(),
				ShangHaiDistrict.FengXian.toString(),ShangHaiDistrict.HongKou.toString(),ShangHaiDistrict.HuangPu.toString(),
				ShangHaiDistrict.JiangAn.toString(),ShangHaiDistrict.JinShan.toString(),ShangHaiDistrict.LuWan.toString(),
				ShangHaiDistrict.NanHui.toString(),ShangHaiDistrict.PuDong.toString(),ShangHaiDistrict.PuTuo.toString(),
				ShangHaiDistrict.QingPu.toString(),ShangHaiDistrict.SongJiang.toString(),ShangHaiDistrict.XuHui.toString(),
				ShangHaiDistrict.YangPu.toString(),ShangHaiDistrict.ZhaBei.toString()};
		ShanghaiModel2 = new DefaultComboBoxModel<String>(shanghaidistricts2);
		
		String[] guangzhoudistricts2 = {"----",GuangZhouDistrict.BaiYun.toString(),GuangZhouDistrict.CongHua.toString(),
				GuangZhouDistrict.FanYu.toString(),GuangZhouDistrict.HaiZhu.toString(),GuangZhouDistrict.HuaDu.toString(),
				GuangZhouDistrict.HuangPu.toString(),GuangZhouDistrict.LiWan.toString(),GuangZhouDistrict.LuoGang.toString(),
				GuangZhouDistrict.NanSha.toString(),GuangZhouDistrict.TianHe.toString(),GuangZhouDistrict.YueXiu.toString(),
				GuangZhouDistrict.ZengCheng.toString()};
		GuangzhouModel2 = new DefaultComboBoxModel<String>(guangzhoudistricts2);
		
		jcbdistrict2 = new JComboBox<String>();
		jcbdistrict2.setModel(model);
		
		jcbcity2.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getItem().equals(City.BEIJING.toString())){
					jcbdistrict2.setModel(BeijingModel2);
					b=1;
				}else if(e.getItem().equals(City.SHANGHAI.toString())){
					jcbdistrict2.setModel(ShanghaiModel2);
					b=2;
				}else if(e.getItem().equals(City.GUANGZHOU.toString())){
					jcbdistrict2.setModel(GuangzhouModel2);
					b=3;
				}else if(e.getItem().equals(City.NANJING.toString())){
					jcbdistrict2.setModel(NanjingModel2);
					b=4;
				}else if(e.getItem().equals("----")){
					jcbdistrict2.setModel(model2);
					b=5;
				}
			}
			
		});
		jcbdistrict2.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(!(e.getItem().equals(null))){
//					System.out.println("!");
				}
			}
			
		});
		
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
		box2.add(scroll);
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
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("装车城市:", JLabel.CENTER));
		box5.add(Box.createHorizontalStrut(30));
		box5.add(jcbcity);
		box5.add(new JLabel("目的城市:", JLabel.CENTER));
		box5.add(Box.createHorizontalStrut(30));
		box5.add(jcbcity2);
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("装车区:", JLabel.CENTER));
		box6.add(Box.createHorizontalStrut(30));
		box6.add(jcbdistrict);
		box6.add(new JLabel("目的区:", JLabel.CENTER));
		box6.add(Box.createHorizontalStrut(30));
		box6.add(jcbdistrict2);
		//垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box5);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box6);
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
		
		return year+"-"+month+"-"+day;
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cancelbutton){
			textClear();
		}
		if(e.getSource()==savebutton){
			setMoney();
			String number = "";
			number = IDText.getText();
			
			if(number.length()>0){
				CarInputFormVO vo = null;
				CarInputFormController carInputFormController = new CarInputFormController();
				try {
					vo = carInputFormController.findDriver(number);
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
						
						String NO = NOText.getText(); //装车单编号
						String destination = destinationText.getText(); //目的地
						String motorNumber = qiyunIDText.getText(); //汽运编号
						String carNumber = carIDText.getText(); //车辆代号
						String loadingMember = loadingMemberText.getText(); //监装员
						String supercargo = superCargoText.getText(); //押运员
						String putOnCarDate = inputDateText.getText(); //装车日期
						ArrayList<String> allIDs = new ArrayList<String>();
						BufferedReader br = new BufferedReader(new StringReader(IDText.getText()));
						String line = ""; 
						try{
							while((line = br.readLine()) != null){
								allIDs.add(line);
								OrderFormController oo=new OrderFormController();
								OrderFormVO ovo=oo.findDriver(line);
								ArrayList<Transportation> a=ovo.getTransportation();
								ArrayList<String> b=ovo.getAlldates();
								b.add(getCurrenTime());
								ovo.setAlldates(b);
								a.add(Transportation.SENDERRELAYARRIVED);
								ovo.setTransportation(a);				
							//	oo.submitDriver(ovo);
							}
						} 
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						double transCharge = Double.parseDouble(costText.getText()); //运费
						
						
						CarInputFormVO voToAdd = new CarInputFormVO();
						voToAdd.setCarNumber(carNumber);
						voToAdd.setDestination(destination);
						voToAdd.setLoadingMember(loadingMember);
						voToAdd.setMotorNumber(motorNumber);
						voToAdd.setNO(NO);
						voToAdd.setPutOnCarDate(putOnCarDate);
						voToAdd.setSupercargo(supercargo);
						voToAdd.setTransCharge(transCharge);
						voToAdd.setAllIDs(allIDs);
						carInputFormController.saveDriver(voToAdd);//添加车辆
						
						
						LogController logController;
						logController = new LogController();
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.ADD);
						logToAdd.setOperationObject(OperationObject.CarInputForm);
						logToAdd.setOperationTime(new GregorianCalendar());
						logToAdd.setOperatorID(UserID.userid);
						logToAdd.setOperatorRole(UserRole.TRANSITCENTERMAN);
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
			CarInputFormController carInputFormController = new CarInputFormController();
			
			String NO = NOText.getText(); //装车单编号
			String destination = destinationText.getText(); //目的地
			String motorNumber = qiyunIDText.getText(); //汽运编号
			String carNumber = carIDText.getText(); //车辆代号
			String loadingMember = loadingMemberText.getText(); //监装员
			String supercargo = superCargoText.getText(); //押运员
			String putOnCarDate = inputDateText.getText(); //装车日期
			ArrayList<String> allIDs = new ArrayList<String>();
			BufferedReader br = new BufferedReader(new StringReader(IDText.getText()));
			String line = ""; 
			try{
				while((line = br.readLine()) != null){
					allIDs.add(line);
					OrderFormController oo=new OrderFormController();
					OrderFormVO ovo=oo.findDriver(line);
					ArrayList<Transportation> a=ovo.getTransportation();
					a.add(Transportation.SENDERRELAYARRIVED);
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
			double transCharge = Double.parseDouble(costText.getText()); //运费
			
			
			CarInputFormVO voToAdd = new CarInputFormVO();
			voToAdd.setCarNumber(carNumber);
			voToAdd.setDestination(destination);
			voToAdd.setLoadingMember(loadingMember);
			voToAdd.setMotorNumber(motorNumber);
			voToAdd.setNO(NO);
			voToAdd.setPutOnCarDate(putOnCarDate);
			voToAdd.setSupercargo(supercargo);
			voToAdd.setTransCharge(transCharge);
			voToAdd.setAllIDs(allIDs);
			carInputFormController.submitDriver(voToAdd);
			
			
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
		costText.setText("不同输入自动计算");
		NOText.setText(null);
		jcbcity.setSelectedItem("----");
		jcbdistrict.setSelectedItem("----");
		jcbcity2.setSelectedItem("----");
		jcbdistrict2.setSelectedItem("----");
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
	
		cost=cost/20;
		costText.setText(cost+"");
	}

}
