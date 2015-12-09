package presentation.transitui.TransferBoard;

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

import controller.transitController.TransferFormController;
import state.Transport;
import state.Zone;
import vo.TransferFormVO;


public class TransferPanel extends JPanel implements ActionListener{
	JPanel transferPanel;
	JLabel putOnCarDateL,relayFormNumberL,startingpointL, destinationL,loadingMemberL,transportL,zoneL,storeL,allIDsL,transChargeL;
	JTextField putOnCarDateT,relayFormNumberT,startingpointT, destinationT,loadingMemberT,transportT,lineT,shelfT,tagT, allIDsT,transChargeT;
	JButton cancelbutton,savebutton,submitbutton;
	JRadioButton fly,water,earth,storeF,storeW,storeE;
	ButtonGroup g1,g2;
	
	public TransferPanel(){
//		this.setBorder(new TitledBorder("中转单"));
		cancelbutton=new JButton("取消");
		savebutton=new JButton("保存");
		submitbutton=new JButton("提交");
		cancelbutton.addActionListener(this);
		savebutton.addActionListener(this);
		submitbutton.addActionListener(this);
		submitbutton.setEnabled(false);
		
		
		putOnCarDateL=new JLabel("中转日期");
		relayFormNumberL=new JLabel("中转单编号");
		startingpointL=new JLabel("出发地");
		destinationL=new JLabel("目的地");
		loadingMemberL=new JLabel("监装员");
		transportL=new JLabel("运输工具");
		zoneL=new JLabel("区号");
		allIDsL=new JLabel("");
		transChargeL=new JLabel("运费");
		storeL=new JLabel("存储地址");
		
		putOnCarDateT=new JTextField(20);
		relayFormNumberT=new JTextField(20);
		startingpointT=new JTextField(20);
		destinationT=new JTextField(20);
		loadingMemberT=new JTextField(20);
		transportT=new JTextField(20);
		lineT=new JTextField(5);
		shelfT=new JTextField(5);
		tagT=new JTextField(5);
		allIDsT=new JTextField(20);
		transChargeT=new JTextField(20);
		
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
		
		Box box1 = Box.createHorizontalBox();
		box1.add(relayFormNumberL);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(relayFormNumberT);
		Box box2 = Box.createHorizontalBox();
		box2.add(startingpointL);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(startingpointT);
		box2.add(Box.createHorizontalStrut(25));
		box2.add(destinationL);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(destinationT);
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
		box6.add(lineT);
		box6.add(Box.createHorizontalStrut(5));
		box6.add(shelfT);
		box6.add(Box.createHorizontalStrut(5));
		box6.add(tagT);
		box6.add(Box.createHorizontalStrut(25));
		box6.add(transChargeL);
		box6.add(Box.createHorizontalStrut(12));
		box6.add(transChargeT);
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
		// TODO Auto-generated method stub
		if(e.getSource()==cancelbutton){
			textClear();
		}
		if(e.getSource()==savebutton){
			String number = "";
			number = relayFormNumberT.getText();
			if(number.length()>0){
				TransferFormVO vo = null;
				TransferFormController transferFormController = new TransferFormController();
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
//						Transport transport=transportT.getText(); //运输方式
//						Zone zone=zoneT.getText();
						int line=Integer.parseInt(lineT.getText());
						int shelf=Integer.parseInt(shelfT.getText());
						int tag=Integer.parseInt(tagT.getText());; //区号排号架号位号
//						ArrayList<String> allIDs; // 所有订单号
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
						
						transferFormController.saveDriver(voToAdd);//添加车辆
					}//录入结束
				}
				submitbutton.setEnabled(true);
			}else {//1.2 未输入司机编号
				String warning = "必须要输入信息!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
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
		transportT.setText(null);
		lineT.setText(null);
		shelfT.setText(null);
		tagT.setText(null);
		allIDsT.setText(null);
		transChargeT.setText(null);

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
