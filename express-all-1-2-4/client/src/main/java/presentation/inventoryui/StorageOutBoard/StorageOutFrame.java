package presentation.inventoryui.StorageOutBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import controller.inventorycontroller.InventoryController;
import controller.inventorycontroller.StorageOutFormController;
import po.Position;
import state.BeiJingDistrict;
import state.City;
import state.GuangZhouDistrict;
import state.NanJingDistrict;
import state.NodeState;
import state.ShangHaiDistrict;
import state.Transport;
import vo.InventoryInfoVO;
import vo.StorageOutFormVO;


public class StorageOutFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame frame;
	private JPanel panel;
	private JTextField date;
	private JComboBox<String> destination1;
	private JComboBox<String> destination2;
	private JTextField expressNumber;
	private JTextField formNO;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel OutInfo;
	private JLabel Ldate;
	private JLabel Ldestination;
	private JLabel OrderInfo;
	private JLabel LexpressNumber;
	private JLabel transport;
	private JComboBox<String> transportbox;
	private JComboBox<String> NObox;
	private JButton save;
	private JButton cancel;
	private String InventoryID = "0200";
	private DefaultComboBoxModel<String> BeijingModel;
	private DefaultComboBoxModel<String> NanjingModel;
	private DefaultComboBoxModel<String> ShanghaiModel;
	private DefaultComboBoxModel<String> GuangzhouModel;
	
	public StorageOutFrame(){
		initialize();
//		StorageOutPanel panel = new StorageOutPanel();
//		frame = new JFrame();
//		frame.setTitle("\u51FA\u5E93\u5355");
//		frame.setBounds(100, 100, 490, 545);
//		frame.getContentPane().setLayout(null);
//		frame.setResizable(false);
//		frame.setVisible(true);
//		frame.getContentPane().add(panel);
	}

	private void initialize(){
		frame = new JFrame();
		frame.setTitle("出库单");
//		frame.setBounds(100, 100, 490, 545);
		frame.setSize(490, 545);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		int x = (screen.width - frame.getWidth())/2;
		int y = (screen.height - frame.getHeight())/2;
		frame.setLocation(x, y);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBounds(0, 0, 484, 517);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_1.setBounds(35, 28, 414, 158);
		panel.add(panel_1);
		
		OutInfo = new JLabel("出库信息");
		OutInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		OutInfo.setBounds(10, 10, 64, 22);
		panel_1.add(OutInfo);
		
		Ldate = new JLabel("出库日期 ：");
		Ldate.setForeground(Color.BLACK);
		Ldate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ldate.setBackground(Color.GRAY);
		Ldate.setBounds(55, 45, 85, 28);
		panel_1.add(Ldate);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(155, 45, 166, 28);
		date.setText(getCurrenTime());
		panel_1.add(date);
		
		Ldestination = new JLabel("目的地 ：");
		Ldestination.setForeground(Color.BLACK);
		Ldestination.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ldestination.setBackground(Color.GRAY);
		Ldestination.setBounds(23, 95, 67, 28);
		panel_1.add(Ldestination);
		
		String[] beijingdistricts = {BeiJingDistrict.ChangPing.toString(),BeiJingDistrict.ChaoYang.toString(),
				BeiJingDistrict.ChongWen.toString(),BeiJingDistrict.DaXing.toString(),BeiJingDistrict.DongCheng.toString(),
				BeiJingDistrict.FangShan.toString(),BeiJingDistrict.FengTai.toString(),BeiJingDistrict.HaiDian.toString(),
				BeiJingDistrict.HuaiRou.toString(),BeiJingDistrict.MenTouGou.toString(),BeiJingDistrict.MiYun.toString(),
				BeiJingDistrict.PingGu.toString(),BeiJingDistrict.ShiJingShan.toString(),BeiJingDistrict.ShunYi.toString(),
				BeiJingDistrict.TongZhou.toString(),BeiJingDistrict.XiCheng.toString(),BeiJingDistrict.Xuanwu.toString(),
				BeiJingDistrict.YanQing.toString()};
		BeijingModel = new DefaultComboBoxModel<String>(beijingdistricts);
		
		String[] nanjingdistricts = {NanJingDistrict.BaiXia.toString(),NanJingDistrict.GaoChun.toString(),
				NanJingDistrict.GuLou.toString(),NanJingDistrict.JiangNing.toString(),NanJingDistrict.JianYe.toString(),
				NanJingDistrict.LiShui.toString(),NanJingDistrict.LiuHe.toString(),NanJingDistrict.PuKou.toString(),
				NanJingDistrict.QinHuai.toString(),NanJingDistrict.QiXia.toString(),NanJingDistrict.XiaGuan.toString(),
				NanJingDistrict.XuanWu.toString(),NanJingDistrict.YuHuaTai.toString()};
		NanjingModel = new DefaultComboBoxModel<String>(nanjingdistricts);
		
		String[] shanghaidistricts = {ShangHaiDistrict.ChangNing.toString(),ShangHaiDistrict.ChongMing.toString(),
				ShangHaiDistrict.FengXian.toString(),ShangHaiDistrict.HongKou.toString(),ShangHaiDistrict.HuangPu.toString(),
				ShangHaiDistrict.JiangAn.toString(),ShangHaiDistrict.JinShan.toString(),ShangHaiDistrict.LuWan.toString(),
				ShangHaiDistrict.NanHui.toString(),ShangHaiDistrict.PuDong.toString(),ShangHaiDistrict.PuTuo.toString(),
				ShangHaiDistrict.QingPu.toString(),ShangHaiDistrict.SongJiang.toString(),ShangHaiDistrict.XuHui.toString(),
				ShangHaiDistrict.YangPu.toString(),ShangHaiDistrict.ZhaBei.toString()};
		ShanghaiModel = new DefaultComboBoxModel<String>(shanghaidistricts);
		
		String[] guangzhoudistricts = {GuangZhouDistrict.BaiYun.toString(),GuangZhouDistrict.CongHua.toString(),
				GuangZhouDistrict.FanYu.toString(),GuangZhouDistrict.HaiZhu.toString(),GuangZhouDistrict.HuaDu.toString(),
				GuangZhouDistrict.HuangPu.toString(),GuangZhouDistrict.LiWan.toString(),GuangZhouDistrict.LuoGang.toString(),
				GuangZhouDistrict.NanSha.toString(),GuangZhouDistrict.TianHe.toString(),GuangZhouDistrict.YueXiu.toString(),
				GuangZhouDistrict.ZengCheng.toString()};
		GuangzhouModel = new DefaultComboBoxModel<String>(guangzhoudistricts);
		
		
		destination1 = new JComboBox<String>();
		destination1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		destination1.setBackground(Color.WHITE);
		DefaultComboBoxModel<String> dcm = new DefaultComboBoxModel<String>();
		dcm.addElement(City.BEIJING.toString());
		dcm.addElement(City.GUANGZHOU.toString());
		dcm.addElement(City.NANJING.toString());
		dcm.addElement(City.SHANGHAI.toString());
		destination1.setModel(dcm);
		destination1.setBounds(105, 95, 120, 28);
		destination1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getItem().equals(City.BEIJING.toString())){
					destination2.setModel(BeijingModel);
				}else if(e.getItem().equals(City.SHANGHAI.toString())){
					destination2.setModel(ShanghaiModel);
				}else if(e.getItem().equals(City.GUANGZHOU.toString())){
					destination2.setModel(GuangzhouModel);
				}else if(e.getItem().equals(City.NANJING.toString())){
					destination2.setModel(NanjingModel);
				}
			}
		});
		panel_1.add(destination1);
		
		
		destination2 = new JComboBox<String>();
		destination2.setModel(BeijingModel);
		destination2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		destination2.setBackground(Color.WHITE);
		destination2.setBounds(245, 95, 120, 28);
		panel_1.add(destination2);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_2.setBounds(35, 214, 414, 212);
		panel.add(panel_2);
		
		OrderInfo = new JLabel("订单信息");
		OrderInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		OrderInfo.setBounds(10, 10, 64, 22);
		panel_2.add(OrderInfo);
		
		LexpressNumber = new JLabel("订单编号 ：");
		LexpressNumber.setForeground(Color.BLACK);
		LexpressNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LexpressNumber.setBackground(Color.GRAY);
		LexpressNumber.setBounds(55, 45, 85, 28);
		panel_2.add(LexpressNumber);
		
		expressNumber = new JTextField();
		expressNumber.setColumns(10);
		expressNumber.setBounds(155, 45, 166, 28);
		panel_2.add(expressNumber);
		
		transport = new JLabel("运送方式 ：");
		transport.setForeground(Color.BLACK);
		transport.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		transport.setBackground(Color.GRAY);
		transport.setBounds(55, 95, 85, 28);
		panel_2.add(transport);
		
		transportbox = new JComboBox<String>();
		transportbox.setModel(new DefaultComboBoxModel<String>(new String[] {"汽运", "铁路", "空运"}));
		transportbox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		transportbox.setBackground(Color.WHITE);
		transportbox.setBounds(155, 95, 93, 28);
		panel_2.add(transportbox);
		
		NObox = new JComboBox<String>();
		NObox.setModel(new DefaultComboBoxModel<String>(new String[] {"中转单编号", "汽运编号"}));
		NObox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		NObox.setBackground(Color.WHITE);
		NObox.setBounds(34, 145, 106, 28);
		panel_2.add(NObox);
		
		formNO = new JTextField();
		formNO.setColumns(10);
		formNO.setBounds(155, 145, 166, 28);
		panel_2.add(formNO);
		
		save = new JButton("保存");
		save.setBounds(216, 452, 93, 36);
		save.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(save);
		save.setContentAreaFilled(false);
		save.addActionListener(this);
		
		cancel = new JButton("取消");
		cancel.setBounds(337, 452, 93, 36);
		cancel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(cancel);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel){
			frame.dispose();
		}
		if(e.getSource()==save){
			
			StorageOutFormController storageOutFormController = new StorageOutFormController();
			InventoryController inventoryController = new InventoryController();

			if(save.getText()=="提交"){//提交
				
				String dates = date.getText(); //装车单编号
				String destinations= (String)destination1.getSelectedItem() + (String)destination2.getSelectedItem();
				String expressNumbers = expressNumber.getText();
				String transportboxs = (String)transportbox.getSelectedItem();
				Transport transports = null;
				
				if(transportboxs=="汽运"){
					transports = Transport.CAR;
				}
				if(transportboxs=="铁路"){
					transports = Transport.TRAIN;
				}
				if(transportboxs=="空运"){
					transports = Transport.PLANE;
				}
				
//				switch (transportboxs) {
//				case "     \u6C7D\u8FD0":
//					transports = Transport.CAR;
//					break;
//				case "     \u94C1\u8DEF":
//					transports = Transport.TRAIN;
//					break;
//				case "     \u7A7A\u8FD0":
//					transports = Transport.PLANE;
//					break;
//				default:
//					break;
//				}
				
				String NOboxs = (String)NObox.getSelectedItem();
				String transferNO = "";
				String sportNO = "";
				
				if(NOboxs=="中转单编号"){
					transferNO = formNO.getText();
				}
				if(NOboxs=="汽运编号"){
					sportNO = formNO.getText();
				}
				
//				switch (NOboxs) {
//				case " \u4E2D\u8F6C\u5355\u7F16\u53F7":
//					NOs = NO.getText();
//					break;
//				case "  \u6C7D\u8FD0\u7F16\u53F7":
//					NOs = NO.getText();
//					break;
//				default:
//					break;
//				}
				
				InventoryInfoVO vo = inventoryController.findInventory(InventoryID);
//				System.out.println("did");
				Position position = findposition(vo,expressNumbers);
				position.setID(null);
				position.setState(NodeState.VACANT);
				System.out.println("ID: "+position.getID()+" Zone: "+position.getZone()+"Line: "+position.getLine()+"Shelf: "+position.getShelf()+"Tag: "+position.getTag());
				switch (position.getZone()) {
				case CAR:
					vo.getCarZoneInfo().get(NodeState.VACANT).add(position);
					break;
				case PLANE:
//					System.out.println("didplane");
					vo.getPlaneZoneInfo().get(NodeState.VACANT).add(position);
					break;
				case TRAIN:
					vo.getTrainZoneInfo().get(NodeState.VACANT).add(position);
					break;
				default:
					break;
				}
				
				
				StorageOutFormVO voToAdd = new StorageOutFormVO();
				voToAdd.setDate(dates);
				voToAdd.setDestination(destinations);
				voToAdd.setExpressNumber(expressNumbers);
				voToAdd.setTransport(transports);
//				voToAdd.setNO("001");
				voToAdd.setSportNO(sportNO);
				voToAdd.setTransferNO(transferNO);
				
	
				inventoryController.updateInventory(vo);
				storageOutFormController.submitDriver(voToAdd);

				String warning = "提交成功!";
				Object[] options = { "OK" }; 
				int go = JOptionPane.showOptionDialog(this, warning, "", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				 
				if(go == JOptionPane.YES_OPTION){
					frame.dispose();
				}
			}
			
			if(save.getText()=="保存"){//保存
				
				if(isTextFull()){
					//1.1.2 输出的车辆代号不存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//确认录入
							//包装CarInputFormVO
							
						String dates = date.getText(); //装车单编号
						String destinations= (String)destination1.getSelectedItem() + (String)destination2.getSelectedItem();
						String expressNumbers = expressNumber.getText();
						String transportboxs = (String)transportbox.getSelectedItem();
						Transport transports = null;
						
						if(transportboxs=="汽运"){
							transports = Transport.CAR;
						}
						if(transportboxs=="铁路"){
							transports = Transport.TRAIN;
						}
						if(transportboxs=="空运"){
							transports = Transport.PLANE;
						}
						
//						switch (transportboxs) {
//						case "     \u6C7D\u8FD0":
//							transports = Transport.CAR;
//							break;
//						case "     \u94C1\u8DEF":
//							transports = Transport.TRAIN;
//							break;
//						case "     \u7A7A\u8FD0":
//							transports = Transport.PLANE;
//							break;
//						default:
//							break;
//						}
						
						String NOboxs = (String)NObox.getSelectedItem();
						String transferNO = "";
						String sportNO = "";
						
						if(NOboxs=="中转单编号"){
							transferNO = formNO.getText();
						}
						if(NOboxs=="汽运编号"){
							sportNO = formNO.getText();
						}
						
//						switch (NOboxs) {
//						case " \u4E2D\u8F6C\u5355\u7F16\u53F7":
//							NOs = NO.getText();
//							break;
//						case "  \u6C7D\u8FD0\u7F16\u53F7":
//							NOs = NO.getText();
//							break;
//						default:
//							break;
//						}
						
						
						StorageOutFormVO voToAdd = new StorageOutFormVO();
						voToAdd.setDate(dates);
						voToAdd.setDestination(destinations);
						voToAdd.setExpressNumber(expressNumbers);
						voToAdd.setTransport(transports);
//						voToAdd.setNO("001");
						voToAdd.setSportNO(sportNO);
						voToAdd.setTransferNO(transferNO);
						
			
						
						storageOutFormController.saveDriver(voToAdd);
						save.setText("提交");
					}//录入结束
					
				}
					
				else {//1.2 未输入司机编号
					String warning = "必须要输入信息!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
			
			
		}
		
	}
	
	public Position findposition(InventoryInfoVO vo,String NO){
		ArrayList<Position> car = vo.getCarZoneInfo().get(NodeState.TAKEN);
		ArrayList<Position> plane = vo.getPlaneZoneInfo().get(NodeState.TAKEN);
		ArrayList<Position> train = vo.getTrainZoneInfo().get(NodeState.TAKEN);
		Position position = new Position();
		System.out.println("进入findposition..........");
		System.out.println("NO: "+NO);
		for(int i=0;i<car.size();i++){
			if(car.get(i).getID().compareTo(NO)==0){
				position = car.get(i);
				car.remove(i);
			}
		}
		for(int i=0;i<plane.size();i++){
//			System.out.println("ID: "+plane.get(i).getID());
			if(plane.get(i).getID().compareTo(NO)==0){
//				System.out.println("did find and delete taken position");
				position = plane.get(i);
				plane.remove(i);
			}
		}
		for(int i=0;i<train.size();i++){
			if(train.get(i).getID().compareTo(NO)==0){
				position = train.get(i);
				train.remove(i);
			}
		}
		return position;
	}
	
	public String getCurrenTime() {
		int year, month, day;
		
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);
		
		return year+"-"+month+"-"+day;
	}
	
	private boolean isTextFull(){
		boolean flag = true;
		if(expressNumber.getText().length()==0){
			flag = false;
		}
		if(formNO.getText().length()==0){
			flag = false;
		}
		return flag;
	}
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StorageOutFrame window = new StorageOutFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
