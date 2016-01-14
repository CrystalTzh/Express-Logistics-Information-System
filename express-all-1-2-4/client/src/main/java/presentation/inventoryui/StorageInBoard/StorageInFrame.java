package presentation.inventoryui.StorageInBoard;

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
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import controller.inventorycontroller.InventoryController;
import controller.inventorycontroller.StorageInFormController;
import po.Position;
import state.BeiJingDistrict;
import state.City;
import state.GuangZhouDistrict;
import state.Line;
import state.NanJingDistrict;
import state.NodeState;
import state.ShangHaiDistrict;
import state.Shelf;
import state.Tag;
import state.Zone;
import vo.InventoryInfoVO;
import vo.StorageInFormVO;


public class StorageInFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JPanel panel;
	private JTextField date,jtfNumber;
	private JComboBox<String> destination1;
	private JComboBox<String> destination2;
	private JTextField expressNumber;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel InInfo;
	private JLabel Ldate;
	private JLabel Ldestination;
	private JLabel OrderInfo;
	private JLabel LexpressNumber;
	private JLabel Lzone;
	private JLabel Lline;
	private JLabel Lshelf;
	private JLabel Ltag;
	private JLabel jlrelay;
	private JComboBox<String> zonebox;
	private JComboBox<String> linebox;
	private JComboBox<String> shelfbox;
	private JComboBox<String> tagbox;
	private JButton save;
	private JButton cancel;
	private String InventoryID;
	private DefaultComboBoxModel<String> BeijingModel;
	private DefaultComboBoxModel<String> NanjingModel;
	private DefaultComboBoxModel<String> ShanghaiModel;
	private DefaultComboBoxModel<String> GuangzhouModel;
	private DefaultComboBoxModel<String> LineModel;
	private DefaultComboBoxModel<String> ShelfModel;
	private DefaultComboBoxModel<String> TagModel;
	private Vector<String> Lines;
	private Vector<String> Shelfs;
	private Vector<String> Tags;
	
	public StorageInFrame(){
		initialize();
//		StorageInPanel panel = new StorageInPanel();
//		frame = new JFrame();
//		frame.setTitle("\u5165\u5E93\u5355");
//		frame.setBounds(100, 100, 490, 545);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
//		frame.getContentPane().setLayout(null);
//		frame.setVisible(true);
//		frame.getContentPane().add(panel);
		
//		frame.dispose();
	}
	
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("入库单");
		frame.setSize(490, 545);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		int x = (screen.width - frame.getWidth())/2;
		int y = (screen.height - frame.getHeight())/2;
		frame.setLocation(x, y);
//		frame.setBounds(100, 100, 490, 545);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
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
		
		InInfo = new JLabel("入库信息");
		InInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		InInfo.setBounds(10, 10, 64, 22);
		panel_1.add(InInfo);
		
		Ldate = new JLabel("入库日期 ：");
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
		System.out.println("did add date");
		
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
		LexpressNumber.setBounds(25, 45, 85, 28);
		panel_2.add(LexpressNumber);
		
		expressNumber = new JTextField();
		expressNumber.setColumns(10);
		expressNumber.setBounds(105, 45, 86, 28);
		panel_2.add(expressNumber);
		
		jlrelay = new JLabel();
		jlrelay.setText("中转中心编号：");
		jlrelay.setForeground(Color.BLACK);
		jlrelay.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jlrelay.setBounds(210, 45, 108, 22);
		panel_2.add(jlrelay);
		
		jtfNumber = new JTextField();
		jtfNumber.setBounds(320, 45, 60, 28);
		panel_2.add(jtfNumber);
		Document doc = jtfNumber.getDocument();  
		 doc.addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Document doc = e.getDocument();  
				try {
					InventoryID = doc.getText(0, doc.getLength());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Document doc = e.getDocument();  
				try {
					InventoryID = doc.getText(0, doc.getLength());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				Document doc = e.getDocument();  
				try {
					InventoryID = doc.getText(0, doc.getLength());
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});  
		
		
		Lzone = new JLabel("区号 ：");
		Lzone.setForeground(Color.BLACK);
		Lzone.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lzone.setBackground(Color.GRAY);
		Lzone.setBounds(29, 95, 64, 28);
		panel_2.add(Lzone);
		
		Lline = new JLabel("排号 ：");
		Lline.setForeground(Color.BLACK);
		Lline.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lline.setBackground(Color.GRAY);
		Lline.setBounds(218, 95, 64, 28);
		panel_2.add(Lline);
		
		Lshelf = new JLabel("架号 ：");
		Lshelf.setForeground(Color.BLACK);
		Lshelf.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lshelf.setBackground(Color.GRAY);
		Lshelf.setBounds(29, 145, 64, 28);
		panel_2.add(Lshelf);
		
		Ltag = new JLabel("位号 ：");
		Ltag.setForeground(Color.BLACK);
		Ltag.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ltag.setBackground(Color.GRAY);
		Ltag.setBounds(218, 145, 64, 28);
		panel_2.add(Ltag);
		
		LineModel = new DefaultComboBoxModel<String>(new String[]{"---","一排","二排","三排","四排"});
		ShelfModel = new DefaultComboBoxModel<String>(new String[]{"---","A架","B架","C架","D架"});
		TagModel = new DefaultComboBoxModel<String>(new String[]{"---","1位","2位","3位","4位","5位"});
		
		linebox = new JComboBox<String>();
		shelfbox = new JComboBox<String>();
		tagbox = new JComboBox<String>();
		
		linebox.setModel(LineModel);
		shelfbox.setModel(ShelfModel);
		tagbox.setModel(TagModel);
		zonebox = new JComboBox<String>();
		zonebox.setBackground(Color.WHITE);
		zonebox.setModel(new DefaultComboBoxModel<String>(new String[] {"---","航空区", "火车区", "汽车区"}));//飞机，火车，汽车
		zonebox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		zonebox.setBounds(103, 95, 85, 28);
		panel_2.add(zonebox);
		zonebox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				InventoryController inventoryController= new InventoryController();
				if(inventoryController.findInventory(InventoryID)==null){
					JOptionPane.showMessageDialog(panel, "请输入正确的中转中心编号","警告", JOptionPane.WARNING_MESSAGE);
				}else{
					switch (e.getItem().toString()) {
					case "航空区":
						Lines = inventoryController.getvacantline(InventoryID, Zone.PLANE);
						Lines.add(0, "---");
						LineModel = new DefaultComboBoxModel<String>(Lines);
						linebox.setModel(LineModel);
						System.out.println(e.getItem().toString());
						break;
					case "火车区":
						Lines = inventoryController.getvacantline(InventoryID, Zone.TRAIN);
						Lines.add(0, "---");
						LineModel = new DefaultComboBoxModel<String>(Lines);
						linebox.setModel(LineModel);
						System.out.println(e.getItem().toString());
						break;
					case "汽车区":
						Lines = inventoryController.getvacantline(InventoryID, Zone.CAR);
						Lines.add(0, "---");
						LineModel = new DefaultComboBoxModel<String>(Lines);
						linebox.setModel(LineModel);
						System.out.println(e.getItem().toString());
						break;

					default:
//						JOptionPane.showConfirmDialog(null, "请填写正确的库存位置", "请填写正确的区号", JOptionPane.YES_OPTION); 
						break;
					}
					
				}
				
//				if(e.getItem().toString()=="航空区"){
//					Lines = inventoryController.getvacantline(InventoryID, Zone.PLANE);
//					LineModel = new DefaultComboBoxModel<String>(Lines);
//				}
//				
//				if(e.getItem().toString()=="火车区"){
//					Lines = inventoryController.getvacantline(InventoryID, Zone.TRAIN);
//					LineModel = new DefaultComboBoxModel<String>(Lines);
//				}
//				
//				if(e.getItem().toString()=="汽车区"){
//					Lines = inventoryController.getvacantline(InventoryID, Zone.CAR);
//					LineModel = new DefaultComboBoxModel<String>(Lines);
//				}
				
			}
		});
		
		linebox.setBackground(Color.WHITE);
		linebox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		linebox.setBounds(292, 95, 85, 28);
		panel_2.add(linebox);
		linebox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				InventoryController inventoryController= new InventoryController();
				
				switch (e.getItem().toString()) {
				case "一排":
					Shelfs = inventoryController.getvacantshelf(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.OneLine);
					Shelfs.add(0, "---");
					ShelfModel = new DefaultComboBoxModel<String>(Shelfs);
					shelfbox.setModel(ShelfModel);
					System.out.println("didsetshelf");
					System.out.println(e.getItem().toString());
					break;
				case "二排":
					Shelfs = inventoryController.getvacantshelf(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.TwoLine);
					Shelfs.add(0, "---");
					ShelfModel = new DefaultComboBoxModel<String>(Shelfs);
					shelfbox.setModel(ShelfModel);
					System.out.println(e.getItem().toString());
					break;
				case "三排":
					Shelfs = inventoryController.getvacantshelf(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.ThreeLine);
					Shelfs.add(0, "---");
					ShelfModel = new DefaultComboBoxModel<String>(Shelfs);
					shelfbox.setModel(ShelfModel);
					System.out.println(e.getItem().toString());
					break;
				case "四排":
					Shelfs = inventoryController.getvacantshelf(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.FourLine);
					Shelfs.add(0, "---");
					ShelfModel = new DefaultComboBoxModel<String>(Shelfs);
					shelfbox.setModel(ShelfModel);
					System.out.println(e.getItem().toString());
					break;
				default:
//					JOptionPane.showConfirmDialog(null, "请填写正确的排号", "请填写正确的库存位置", JOptionPane.YES_OPTION); 
					break;
				}
				
//				if(e.getItem().toString()=="一排"){
//					Shelfs = inventoryController.getvacantshelf(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.OneLine);
//					ShelfModel = new DefaultComboBoxModel<String>(Shelfs);
//				}
//				if(e.getItem().toString()=="二排"){
//					Shelfs = inventoryController.getvacantshelf(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.TwoLine);
//					ShelfModel = new DefaultComboBoxModel<String>(Shelfs);
//				}
//				if(e.getItem().toString()=="三排"){
//					Shelfs = inventoryController.getvacantshelf(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.ThreeLine);
//					ShelfModel = new DefaultComboBoxModel<String>(Shelfs);
//				}
//				if(e.getItem().toString()=="四排"){
//					Shelfs = inventoryController.getvacantshelf(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.FourLine);
//					ShelfModel = new DefaultComboBoxModel<String>(Shelfs);
//				}
			}
		});
		
		shelfbox.setBackground(Color.WHITE);
		shelfbox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		shelfbox.setBounds(103, 145, 85, 28);
		panel_2.add(shelfbox);
		shelfbox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				InventoryController inventoryController= new InventoryController();
				switch (e.getItem().toString()) {
				case "A架":
					Tags = inventoryController.getvacanttag(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.getbyStr(linebox.getSelectedItem().toString()), Shelf.AShelf);
					Tags.add(0, "---");
					for(int j=0;j<Tags.size();j++){
						System.out.println(Tags.size());
						System.out.println(Tags.get(j));
					}
					TagModel = new DefaultComboBoxModel<String>(Tags);
					tagbox.setModel(TagModel);
					System.out.println(e.getItem().toString());
					break;
				case "B架":
					Tags = inventoryController.getvacanttag(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.getbyStr(linebox.getSelectedItem().toString()), Shelf.BShelf);
					Tags.add(0, "---");
					TagModel = new DefaultComboBoxModel<String>(Tags);
					tagbox.setModel(TagModel);
					System.out.println(e.getItem().toString());
					break;
				case "C架":
					Tags = inventoryController.getvacanttag(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.getbyStr(linebox.getSelectedItem().toString()), Shelf.CShelf);
					Tags.add(0, "---");
					TagModel = new DefaultComboBoxModel<String>(Tags);
					tagbox.setModel(TagModel);
					System.out.println(e.getItem().toString());
					break;
				case "D架":
					Tags = inventoryController.getvacanttag(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.getbyStr(linebox.getSelectedItem().toString()), Shelf.DShelf);
					Tags.add(0, "---");
					TagModel = new DefaultComboBoxModel<String>(Tags);
					tagbox.setModel(TagModel);
					System.out.println(e.getItem().toString());
					break;
				default:
//					JOptionPane.showConfirmDialog(null, "请填写正确的架号", "请填写正确的库存位置", JOptionPane.YES_OPTION); 
					break;
				}
//				if(e.getItem().toString()=="A架"){
//					Tags = inventoryController.getvacanttag(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.getbyStr(linebox.getSelectedItem().toString()), Shelf.AShelf);
//					TagModel = new DefaultComboBoxModel<String>(Tags);
//				}
//				if(e.getItem().toString()=="B架"){
//					Tags = inventoryController.getvacanttag(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.getbyStr(linebox.getSelectedItem().toString()), Shelf.BShelf);
//					TagModel = new DefaultComboBoxModel<String>(Tags);
//				}
//				if(e.getItem().toString()=="C架"){
//					Tags = inventoryController.getvacanttag(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.getbyStr(linebox.getSelectedItem().toString()), Shelf.CShelf);
//					TagModel = new DefaultComboBoxModel<String>(Tags);
//				}
//				if(e.getItem().toString()=="D架"){
//					Tags = inventoryController.getvacanttag(InventoryID, Zone.getbyStr(zonebox.getSelectedItem().toString()), Line.getbyStr(linebox.getSelectedItem().toString()), Shelf.DShelf);
//					TagModel = new DefaultComboBoxModel<String>(Tags);
//				}
			}
		});
		
		tagbox.setBackground(Color.WHITE);
		tagbox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		tagbox.setBounds(292, 145, 85, 28);
		panel_2.add(tagbox);
		
		save = new JButton("保存");
		save.setBounds(216, 451, 93, 36);
		save.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(save);
		save.setContentAreaFilled(false);
		save.addActionListener(this);
		
		cancel = new JButton("取消");
		cancel.setBounds(337, 451, 93, 36);
		cancel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(cancel);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		StorageInFormController storageInFormController = new StorageInFormController();
		InventoryController inventoryController = new InventoryController();
		
		
		
		if(e.getSource()==cancel){
			frame.dispose();
		}
		if(e.getSource()==save){
			
			
			
			if(save.getText()=="提交"){//提交
				
				String m = "确认提交!";
				int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (ok == JOptionPane.YES_OPTION) {
					String dates = date.getText(); 
					String destinations= (String)destination1.getSelectedItem() + (String)destination2.getSelectedItem();
					String expressNumbers=expressNumber.getText();
					String zones = (String)zonebox.getSelectedItem();
					Zone zonez = null;
					if(zones=="航空区"){
						zonez = Zone.PLANE;
					}
					if(zones=="火车区"){
						zonez = Zone.TRAIN;
					}
					if(zones=="汽车区"){
						zonez = Zone.CAR;
					}
					Line lines = Line.getbyStr((String)linebox.getSelectedItem());
					Shelf shelfs = Shelf.getbyStr((String)shelfbox.getSelectedItem());
					Tag tags = Tag.getbyStr((String)tagbox.getSelectedItem());
					Position position = new Position();
					position.setID(expressNumbers);
					position.setLine(lines);
					position.setShelf(shelfs);
					position.setTag(tags);
					position.setZone(zonez);
					position.setState(NodeState.TAKEN);
//					System.out.println(zonez+" "+lines+" "+shelfs+" "+tags+" "+position.getID()+" "+position.getState());
					
					StorageInFormVO voToAdd= new StorageInFormVO();
					voToAdd.setDate(dates);
					voToAdd.setDestination(destinations);
					voToAdd.setExpressNumber(expressNumbers);
					voToAdd.setLine(lines);
					voToAdd.setShelf(shelfs);
					voToAdd.setTag(tags);
					voToAdd.setZone(zonez);
//					voToAdd.setNO(NO);
					
					InventoryInfoVO vo = inventoryController.findInventory(InventoryID);
//					System.out.println(vo.getPlaneZoneInfo().get(NodeState.VACANT).get(0).getTag().toString());
//					System.out.println(vo.getPlaneZoneInfo().get(NodeState.VACANT).get(0).getShelf().toString());
//					System.out.println(vo.getPlaneZoneInfo().get(NodeState.VACANT).get(0).getLine().toString());
//					System.out.println(vo.getPlaneZoneInfo().get(NodeState.VACANT).get(0).getZone().toString());

					switch (zonez) {
					case CAR:
						System.out.println(deleteposition(position, vo, zonez));
						vo.getCarZoneInfo().get(NodeState.TAKEN).add(position);
						break;
					case PLANE:
						System.out.println(deleteposition(position, vo, zonez));
						System.out.println("did");
						vo.getPlaneZoneInfo().get(NodeState.TAKEN).add(position);
						break;
					case TRAIN:
						System.out.println(deleteposition(position, vo, zonez));
						vo.getTrainZoneInfo().get(NodeState.TAKEN).add(position);
						break;
						
					default:
						break;
					}
					
					boolean isAlarm = inventoryController.inventoryAlarm(InventoryID, zonez);
					if(isAlarm){
						JOptionPane.showMessageDialog(this, "该仓库库存报警");
						return;
					}
					inventoryController.updateInventory(vo);
					storageInFormController.submitDriver(voToAdd);//
					
					String warning = "提交成功!";
					Object[] options = { "OK" }; 
					int go = JOptionPane.showOptionDialog(this, warning, "", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					 
					if(go == JOptionPane.YES_OPTION){
						frame.dispose();
					}
					
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
							
						String dates = date.getText(); 
						String destinations= (String)destination1.getSelectedItem() + (String)destination2.getSelectedItem();
						String expressNumbers=expressNumber.getText();
						String zones = (String)zonebox.getSelectedItem();
						Zone zonez = null;
						if(zones=="航空区"){
							zonez = Zone.PLANE;
						}
						if(zones=="火车区"){
							zonez = Zone.TRAIN;
						}
						if(zones=="汽车区"){
							zonez = Zone.CAR;
						}
						Line lines = Line.getbyStr((String)linebox.getSelectedItem());
						Shelf shelfs = Shelf.getbyStr((String)shelfbox.getSelectedItem());
						Tag tags = Tag.getbyStr((String)tagbox.getSelectedItem());
						
						
						StorageInFormVO voToAdd= new StorageInFormVO();
						voToAdd.setDate(dates);
						voToAdd.setDestination(destinations);
						voToAdd.setExpressNumber(expressNumbers);
						voToAdd.setLine(lines);
						voToAdd.setShelf(shelfs);
						voToAdd.setTag(tags);
						voToAdd.setZone(zonez);
//						voToAdd.setNO("01");
						
						storageInFormController.saveDriver(voToAdd);//添加车辆
					}//录入结束
					save.setText("提交");
				}
					
				else {//1.2 未输入司机编号
					String warning = "必须要输入信息!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
			
			
		}
		
	}

	private boolean deleteposition(Position position,InventoryInfoVO vo,Zone zone){
		switch (zone) {
		case CAR:
			ArrayList<Position> positioncar = vo.getCarZoneInfo().get(NodeState.VACANT);
			for(int i=0;i<positioncar.size();i++){
				if(position.getLine()==positioncar.get(i).getLine()){
					if(position.getShelf()==positioncar.get(i).getShelf()){
						if(position.getTag()==positioncar.get(i).getTag()){
							positioncar.remove(i);
						}
					}
				}
			}
			return true;
		case PLANE:
			ArrayList<Position> positionplane = vo.getPlaneZoneInfo().get(NodeState.VACANT);
			for(int i=0;i<positionplane.size();i++){
				if(position.getLine()==positionplane.get(i).getLine()){
					if(position.getShelf()==positionplane.get(i).getShelf()){
						if(position.getTag()==positionplane.get(i).getTag()){
							positionplane.remove(i);
						}
					}
				}
			}
			System.out.println("did");
			return true;
		case TRAIN:
			ArrayList<Position> positiontrain = vo.getCarZoneInfo().get(NodeState.VACANT);
			for(int i=0;i<positiontrain.size();i++){
				if(position.getLine()==positiontrain.get(i).getLine()){
					if(position.getShelf()==positiontrain.get(i).getShelf()){
						if(position.getTag()==positiontrain.get(i).getTag()){
							positiontrain.remove(i);
						}
					}
				}
			}
			return true;
			

		default:
			break;
		}
		return false;
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
		if(linebox.getSelectedItem()==null){
			flag = false;
		}
		if(shelfbox.getSelectedItem()==null){
			flag = false;
		}
		if(tagbox.getSelectedItem()==null){
			flag = false;
		}
		return flag;
	}
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StorageInFrame window = new StorageInFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
