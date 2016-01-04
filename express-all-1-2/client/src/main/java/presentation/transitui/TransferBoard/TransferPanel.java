package presentation.transitui.TransferBoard;

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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.UserID;
import controller.corporationcontroller.LogController;
import controller.transitController.OrderFormController;
import controller.transitController.TransferFormController;
import state.BeiJingDistrict;
import state.City;
import state.GuangZhouDistrict;
import state.Line;
import state.NanJingDistrict;
import state.Operation;
import state.OperationObject;
import state.ShangHaiDistrict;
import state.Shelf;
import state.Tag;
import state.Transport;
import state.Transportation;
import state.UserRole;
import state.Zone;
import vo.LogVO;
import vo.OrderFormVO;
import vo.TransferFormVO;


public class TransferPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel transferPanel;
	JLabel putOnCarDateL,relayFormNumberL,startingpointL, destinationL,loadingMemberL,transportL,zoneL,storeL,allIDsL,transChargeL;
	JTextField putOnCarDateT,relayFormNumberT,startingpointT, destinationT,loadingMemberT,transChargeT;
	/*         中转日期                                     中转单号                                       出发地                                                目的地                              监装员                                  运费                                                                                    */
	JTextArea allIDsT;//订单号
	JButton cancelbutton,savebutton,submitbutton;
	JRadioButton fly,water,earth,storeF,storeW,storeE;
	ButtonGroup g1,g2;
	JComboBox<String> jcbcity,jcbdistrict,jcbcity2,jcbdistrict2,lineJCB,shelfJCB,tagJCB;
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
	public TransferPanel(){
//		this.setBorder(new TitledBorder("中转单"));
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
		
		
		putOnCarDateL=new JLabel("中转日期");
		relayFormNumberL=new JLabel("中转单编号");
		startingpointL=new JLabel("出发地");
		destinationL=new JLabel("目的地");
		loadingMemberL=new JLabel("监装员");
		transportL=new JLabel("运输工具");
		zoneL=new JLabel("区号");
		allIDsL=new JLabel("订单信息");
		transChargeL=new JLabel("运费");
		storeL=new JLabel("存储地址");
		
		putOnCarDateT=new JTextField(20);
		relayFormNumberT=new JTextField(20);
		startingpointT=new JTextField(20);
		destinationT=new JTextField(20);
		loadingMemberT=new JTextField(20);
	
	
		transChargeT=new JTextField(20);
		allIDsT=new JTextArea(3,5);
		
		transChargeT.setText("自动计算无需填写");
		JScrollPane scroll = new JScrollPane(allIDsT); 
		//把定义的JTextArea放到JScrollPane里面去 

		//分别设置水平和垂直滚动条自动出现 
		scroll.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scroll.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		fly=new JRadioButton("飞机", true);
		water=new JRadioButton("火车", false);
		earth=new JRadioButton("汽车",false);
		storeF=new JRadioButton("飞机区", true);
		storeW=new JRadioButton("火车区", false);
		storeE=new JRadioButton("汽车区", false);
		g1 = new ButtonGroup();
		g2 = new ButtonGroup();
		g1.add(fly);
		g1.add(earth);
		g1.add(water);
		g2.add(storeE);
		g2.add(storeF);
		g2.add(storeW);
		putOnCarDateT.setText(getCurrenTime());
		
		
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
		jcbdistrict2.setModel(model2);
		
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
		
		
		lineJCB = new JComboBox<String>();
		lineJCB.addItem("----");
		lineJCB.addItem(Line.OneLine.toString());
		lineJCB.addItem(Line.TwoLine.toString());
		lineJCB.addItem(Line.ThreeLine.toString());
		lineJCB.addItem(Line.FourLine.toString());
		
		shelfJCB = new JComboBox<String>();
		shelfJCB.addItem("----");
		shelfJCB.addItem(Shelf.AShelf.toString());
		shelfJCB.addItem(Shelf.BShelf.toString());
		shelfJCB.addItem(Shelf.CShelf.toString());
		shelfJCB.addItem(Shelf.DShelf.toString());
		
		tagJCB = new JComboBox<String>();
		tagJCB.addItem("----");
		tagJCB.addItem(Tag.OneTag.toString());
		tagJCB.addItem(Tag.TwoTag.toString());
		tagJCB.addItem(Tag.ThreeTag.toString());
		tagJCB.addItem(Tag.FourTag.toString());
		tagJCB.addItem(Tag.FiveTag.toString());
		
		Box box1 = Box.createHorizontalBox();
		box1.add(relayFormNumberL);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(relayFormNumberT);
		Box box2 = Box.createHorizontalBox();
		box2.add(startingpointL);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(jcbcity);
		box2.add(jcbdistrict);
		box2.add(Box.createHorizontalStrut(25));
		box2.add(destinationL);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(jcbcity2);
		box2.add(jcbdistrict2);
		Box box3 = Box.createHorizontalBox();
		box3.add(loadingMemberL);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(loadingMemberT);
		Box box4 = Box.createHorizontalBox();
		box4.add(transportL);
		box4.add(Box.createHorizontalStrut(12));
		box4.add(fly);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(water);
		box4.add(Box.createHorizontalStrut(5));
		box4.add(earth);
		Box box5 = Box.createHorizontalBox();
		box5.add(zoneL);
		box5.add(Box.createHorizontalStrut(12));
		box5.add(storeF);
		box5.add(Box.createHorizontalStrut(5));
		box5.add(storeW);
		box5.add(Box.createHorizontalStrut(5));
		box5.add(storeE);
		Box box6 = Box.createHorizontalBox();
		box6.add(storeL);
		box6.add(Box.createHorizontalStrut(12));
		box6.add(lineJCB);
		box6.add(Box.createHorizontalStrut(5));
		box6.add(shelfJCB);
		box6.add(Box.createHorizontalStrut(5));
		box6.add(tagJCB);
		box6.add(Box.createHorizontalStrut(25));
		box6.add(transChargeL);
		box6.add(Box.createHorizontalStrut(12));
		box6.add(transChargeT);
		Box box7=Box.createHorizontalBox();
		box7.add(allIDsL);
		box7.add(scroll);
		//垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box7);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box4);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box5);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box6);
		
		
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
		// TODO Auto-generated method stub
		TransferFormVO vo = null;
		TransferFormController transferFormController = new TransferFormController();
		if(e.getSource()==cancelbutton){
			textClear();
		}
		if(e.getSource()==savebutton){
			setMoney();
			String number = "";
			number = relayFormNumberT.getText();
			if(number.length()>0){
				
				try {
					vo = transferFormController.findDriver(number);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(vo!= null) { //1.1.1 输入的车辆代号存在
					String warning = "该派件单信息已存在,请到修改页面修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {//1.1.2 输出的车辆代号不存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//确认录入
						String putOnCarDate=putOnCarDateT.getText(); //装车日期
						String relayFormNumber=relayFormNumberT.getText();//中转单编号
						String startingpoint=relayFormNumberT.getText(); //出发地
						String destination=destinationT.getText(); //到达地
						String loadingMember=loadingMemberT.getText(); //监装员
						Transport transport=null;
						Zone zone=null;
						Line line=null;
						Shelf shelf=null;
						Tag tag=null;
						
						ArrayList<String> allIDs=new ArrayList<String>(); // 所有订单号
						
						if(fly.isSelected()){
							transport=transport.PLANE;
						}else if(water.isSelected()){
							transport=transport.TRAIN;
						}else{
							transport=transport.CAR;
						}
						if(storeE.isSelected()){
							zone=zone.CAR;
						}else if(storeF.isSelected()){
							zone=zone.PLANE;
						}else if(storeW.isSelected()){
							zone=zone.TRAIN;
						}
								
						
						if(lineJCB.getSelectedItem().equals(Line.OneLine.toString())){
							line=Line.OneLine;
						}else if(lineJCB.getSelectedItem().equals(Line.TwoLine.toString())){
							line=Line.TwoLine;
						}else if(lineJCB.getSelectedItem().equals(Line.ThreeLine.toString())){
							line=Line.ThreeLine;
						}else if(lineJCB.getSelectedItem().equals(Line.FourLine.toString())){
							line=Line.FourLine;
						}
						
						if(tagJCB.getSelectedItem().equals(Tag.OneTag.toString())){
							tag=Tag.OneTag;
						}else if(tagJCB.getSelectedItem().equals(Tag.TwoTag.toString())){
							tag=Tag.TwoTag;
						}else if(tagJCB.getSelectedItem().equals(Tag.ThreeTag.toString())){
							tag=Tag.ThreeTag;
						}else if(tagJCB.getSelectedItem().equals(Tag.FourTag.toString())){
							tag=Tag.FourTag;
						}else if(tagJCB.getSelectedItem().equals(Tag.FiveTag.toString())){
							tag=Tag.FiveTag;
						}
						
						
						if(shelfJCB.getSelectedItem().equals(Shelf.AShelf.toString())){
							shelf=Shelf.AShelf;
						}else if(shelfJCB.getSelectedItem().equals(Shelf.BShelf.toString())){
							shelf=Shelf.BShelf;
						}else if(shelfJCB.getSelectedItem().equals(Shelf.CShelf.toString())){
							shelf=Shelf.CShelf;
						}else if(shelfJCB.getSelectedItem().equals(Shelf.DShelf.toString())){
							shelf=Shelf.DShelf;
						}
						BufferedReader br = new BufferedReader(new StringReader(allIDsT.getText()));
						String l = ""; 
						try{
							while((l = br.readLine()) != null){
								allIDs.add(l);
								OrderFormController oo=new OrderFormController();
								OrderFormVO ovo=oo.findDriver(l);
								
								ArrayList<Transportation> a=ovo.getTransportation();
								a.add(Transportation.TRANFERING);
								ovo.setTransportation(a);
								ArrayList<String> b=ovo.getAlldates();
								b.add(getCurrenTime());
								ovo.setAlldates(b);
				//				oo.submitDriver(ovo);
							}
						} 
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						double transCharge=Double.parseDouble(transChargeT.getText()); //运费
						
						TransferFormVO voToAdd = new TransferFormVO();
						voToAdd.setDestination(destination);
						voToAdd.setLine(line);
						voToAdd.setLoadingMember(loadingMember);
						voToAdd.setPutOnCarDate(putOnCarDate);
						voToAdd.setRelayFormNumber(relayFormNumber);
						voToAdd.setShelf(shelf);
						voToAdd.setStartingpoint(startingpoint);
						voToAdd.setTag(tag);
						voToAdd.setTransCharge(transCharge);
						voToAdd.setZone(zone);
						voToAdd.setTransport(transport);
						voToAdd.setAllIDs(allIDs);
						transferFormController.saveDriver(voToAdd);//添加车辆
						
						
						LogController logController;
						logController = new LogController();
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.ADD);
						logToAdd.setOperationObject(OperationObject.TransferForm);
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
			String m = "基本信息将被提交!";
			int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (ok == JOptionPane.YES_OPTION) {//确认提交
				String putOnCarDate=putOnCarDateT.getText(); //装车日期
				String relayFormNumber=relayFormNumberT.getText();//中转单编号
				String startingpoint=jcbcity.toString()+jcbdistrict.toString(); //出发地
				String destination=jcbcity2.toString()+jcbdistrict2.toString() ;//到达地
				String loadingMember=loadingMemberT.getText(); //监装员
				Transport transport=null;
				Line line=null;
				Shelf shelf=null;
				Tag tag=null;
				Zone zone=null;
				ArrayList<String> allIDs=new ArrayList<String>(); // 所有订单号
				
				if(fly.isSelected()){
					transport=transport.PLANE;
				}else if(water.isSelected()){
					transport=transport.TRAIN;
				}else{
					transport=transport.CAR;
				}
				if(storeE.isSelected()){
					zone=zone.CAR;
				}else if(storeF.isSelected()){
					zone=zone.PLANE;
				}else if(storeW.isSelected()){
					zone=zone.TRAIN;
				}
						
				
				if(lineJCB.getSelectedItem().equals(Line.OneLine.toString())){
					line=Line.OneLine;
				}else if(lineJCB.getSelectedItem().equals(Line.TwoLine.toString())){
					line=Line.TwoLine;
				}else if(lineJCB.getSelectedItem().equals(Line.ThreeLine.toString())){
					line=Line.ThreeLine;
				}else if(lineJCB.getSelectedItem().equals(Line.FourLine.toString())){
					line=Line.FourLine;
				}
				
				if(tagJCB.getSelectedItem().equals(Tag.OneTag.toString())){
					tag=Tag.OneTag;
				}else if(tagJCB.getSelectedItem().equals(Tag.TwoTag.toString())){
					tag=Tag.TwoTag;
				}else if(tagJCB.getSelectedItem().equals(Tag.ThreeTag.toString())){
					tag=Tag.ThreeTag;
				}else if(tagJCB.getSelectedItem().equals(Tag.FourTag.toString())){
					tag=Tag.FourTag;
				}else if(tagJCB.getSelectedItem().equals(Tag.FiveTag.toString())){
					tag=Tag.FiveTag;
				}
				
				
				if(shelfJCB.getSelectedItem().equals(Shelf.AShelf.toString())){
					shelf=Shelf.AShelf;
				}else if(shelfJCB.getSelectedItem().equals(Shelf.BShelf.toString())){
					shelf=Shelf.BShelf;
				}else if(shelfJCB.getSelectedItem().equals(Shelf.CShelf.toString())){
					shelf=Shelf.CShelf;
				}else if(shelfJCB.getSelectedItem().equals(Shelf.DShelf.toString())){
					shelf=Shelf.DShelf;
				}
				
				BufferedReader br = new BufferedReader(new StringReader(allIDsT.getText()));
				String l = ""; 
				try{
					while((l = br.readLine()) != null){
						allIDs.add(l);
						OrderFormController oo=new OrderFormController();
						OrderFormVO ovo=oo.findDriver(l);
						ArrayList<Transportation> a=ovo.getTransportation();
						a.add(Transportation.TRANFERING);
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
				
				double transCharge=Double.parseDouble(transChargeT.getText()); //运费
				
				TransferFormVO voToAdd = new TransferFormVO();
				voToAdd.setDestination(destination);
				voToAdd.setLine(line);
				voToAdd.setLoadingMember(loadingMember);
				voToAdd.setPutOnCarDate(putOnCarDate);
				voToAdd.setRelayFormNumber(relayFormNumber);
				voToAdd.setShelf(shelf);
				voToAdd.setStartingpoint(startingpoint);
				voToAdd.setTag(tag);
				voToAdd.setTransCharge(transCharge);
				voToAdd.setZone(zone);
				voToAdd.setTransport(transport);
				voToAdd.setAllIDs(allIDs);
				
				transferFormController.submitDriver(voToAdd);//添加车辆
				

				
			}
		}	
	}

	private void textClear() {
		// TODO Auto-generated method stub
		putOnCarDateT.setText(null);
		relayFormNumberT.setText(null);
		startingpointT.setText(null);
		destinationT.setText(null);
		loadingMemberT.setText(null);
		fly.setSelected(true);
		storeF.setSelected(true);
		lineJCB.setSelectedItem("----");
		shelfJCB.setSelectedItem("----");
		tagJCB.setSelectedItem("----");
		allIDsT.setText(null);
		transChargeT.setText("自动计算无需填写");

	}
	public String getCurrenTime() {
		int year, month, day;
		
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);
		
		return year+"-"+month+"-"+day;
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
		transChargeT.setText(cost+"");
	}
}
