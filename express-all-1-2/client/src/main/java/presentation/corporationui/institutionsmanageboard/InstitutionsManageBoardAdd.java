/**
 * @author 陶子涵
 * 2015/12/11
 */
package presentation.corporationui.institutionsmanageboard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

import controller.UserID;
import controller.corporationcontroller.LogController;
import controller.corporationcontroller.OfficeInfoController;
import controller.corporationcontroller.TransferOfficeInfoController;
import controller.inventorycontroller.InventoryController;
import state.BeiJingDistrict;
import state.City;
import state.GuangZhouDistrict;
import state.NanJingDistrict;
import state.Operation;
import state.OperationObject;
import state.ShangHaiDistrict;
import state.UserRole;
import vo.InventoryInfoVO;
import vo.LogVO;
import vo.OfficeVO;
import vo.TransferOfficeVO;

public class InstitutionsManageBoardAdd extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextField jtfCity, jtfDistrict, jtfNumber;
	JButton addButton, resetButton, jbnumberstart;
	ButtonGroup group;
	JRadioButton office, transfer;
	JComboBox<String> jcbcity, jcbdistrict;
	DefaultComboBoxModel<String> BeijingModel;
	DefaultComboBoxModel<String> NanjingModel;
	DefaultComboBoxModel<String> ShanghaiModel;
	DefaultComboBoxModel<String> GuangzhouModel;
	DefaultComboBoxModel<String> model;
	OfficeInfoController officeinfocontroller;
	TransferOfficeInfoController transferOfficeInfocontroller;
	LogController logController;

	public InstitutionsManageBoardAdd() {
		officeinfocontroller = new OfficeInfoController();
		transferOfficeInfocontroller = new TransferOfficeInfoController();
		logController = new LogController();
		// 初始化文本框、按钮等组件
		jtfCity = new JTextField(20);
		jtfDistrict = new JTextField(20);
		jtfNumber = new JTextField(10);
		jtfNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		jtfNumber.setEnabled(false);
		addButton = new JButton("录入");
		addButton.setContentAreaFilled(false);
		resetButton = new JButton("重置");
		resetButton.setContentAreaFilled(false);
		jbnumberstart = new JButton("生成编号");
		jbnumberstart.setContentAreaFilled(false);
		jbnumberstart.setFont(new Font("微软雅黑", Font.PLAIN, 14));

		jcbcity = new JComboBox<String>();
		jcbcity.addItem("----");
		jcbcity.addItem(City.BEIJING.toString());
		jcbcity.addItem(City.GUANGZHOU.toString());
		jcbcity.addItem(City.NANJING.toString());
		jcbcity.addItem(City.SHANGHAI.toString());
		String[] none = { "----" };
		model = new DefaultComboBoxModel<String>(none);

		String[] beijingdistricts = { "----", BeiJingDistrict.ChangPing.toString(), BeiJingDistrict.ChaoYang.toString(),
				BeiJingDistrict.ChongWen.toString(), BeiJingDistrict.DaXing.toString(),
				BeiJingDistrict.DongCheng.toString(), BeiJingDistrict.FangShan.toString(),
				BeiJingDistrict.FengTai.toString(), BeiJingDistrict.HaiDian.toString(),
				BeiJingDistrict.HuaiRou.toString(), BeiJingDistrict.MenTouGou.toString(),
				BeiJingDistrict.MiYun.toString(), BeiJingDistrict.PingGu.toString(),
				BeiJingDistrict.ShiJingShan.toString(), BeiJingDistrict.ShunYi.toString(),
				BeiJingDistrict.TongZhou.toString(), BeiJingDistrict.XiCheng.toString(),
				BeiJingDistrict.Xuanwu.toString(), BeiJingDistrict.YanQing.toString() };
		BeijingModel = new DefaultComboBoxModel<String>(beijingdistricts);

		String[] nanjingdistricts = { "----", NanJingDistrict.BaiXia.toString(), NanJingDistrict.GaoChun.toString(),
				NanJingDistrict.GuLou.toString(), NanJingDistrict.JiangNing.toString(),
				NanJingDistrict.JianYe.toString(), NanJingDistrict.LiShui.toString(), NanJingDistrict.LiuHe.toString(),
				NanJingDistrict.PuKou.toString(), NanJingDistrict.QinHuai.toString(), NanJingDistrict.QiXia.toString(),
				NanJingDistrict.XiaGuan.toString(), NanJingDistrict.XuanWu.toString(),
				NanJingDistrict.YuHuaTai.toString() };
		NanjingModel = new DefaultComboBoxModel<String>(nanjingdistricts);

		String[] shanghaidistricts = { "----", ShangHaiDistrict.ChangNing.toString(),
				ShangHaiDistrict.ChongMing.toString(), ShangHaiDistrict.FengXian.toString(),
				ShangHaiDistrict.HongKou.toString(), ShangHaiDistrict.HuangPu.toString(),
				ShangHaiDistrict.JiangAn.toString(), ShangHaiDistrict.JinShan.toString(),
				ShangHaiDistrict.LuWan.toString(), ShangHaiDistrict.NanHui.toString(),
				ShangHaiDistrict.PuDong.toString(), ShangHaiDistrict.PuTuo.toString(),
				ShangHaiDistrict.QingPu.toString(), ShangHaiDistrict.SongJiang.toString(),
				ShangHaiDistrict.XuHui.toString(), ShangHaiDistrict.YangPu.toString(),
				ShangHaiDistrict.ZhaBei.toString() };
		ShanghaiModel = new DefaultComboBoxModel<String>(shanghaidistricts);

		String[] guangzhoudistricts = { "----", GuangZhouDistrict.BaiYun.toString(),
				GuangZhouDistrict.CongHua.toString(), GuangZhouDistrict.FanYu.toString(),
				GuangZhouDistrict.HaiZhu.toString(), GuangZhouDistrict.HuaDu.toString(),
				GuangZhouDistrict.HuangPu.toString(), GuangZhouDistrict.LiWan.toString(),
				GuangZhouDistrict.LuoGang.toString(), GuangZhouDistrict.NanSha.toString(),
				GuangZhouDistrict.TianHe.toString(), GuangZhouDistrict.YueXiu.toString(),
				GuangZhouDistrict.ZengCheng.toString() };
		GuangzhouModel = new DefaultComboBoxModel<String>(guangzhoudistricts);

		jcbdistrict = new JComboBox<String>();
		jcbdistrict.setModel(model);

		group = new ButtonGroup();
		office = new JRadioButton("营业厅", true);
		transfer = new JRadioButton("中转中心", false);
		group.add(office);
		group.add(transfer);
		transfer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == transfer) {
					jcbdistrict.setModel(model);
					jcbdistrict.setEnabled(false);
				}
			}

		});
		office.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jcbdistrict.setModel(model);
				jcbdistrict.setEnabled(true);

			}

		});

		// 监听录入和重置按钮
		addButton.addActionListener(this);
		resetButton.addActionListener(this);
		jcbcity.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getItem().equals(City.BEIJING.toString()) && office.isSelected()) {
					jcbdistrict.setModel(BeijingModel);
				} else if (e.getItem().equals(City.SHANGHAI.toString()) && office.isSelected()) {
					jcbdistrict.setModel(ShanghaiModel);
				} else if (e.getItem().equals(City.GUANGZHOU.toString()) && office.isSelected()) {
					jcbdistrict.setModel(GuangzhouModel);
				} else if (e.getItem().equals(City.NANJING.toString()) && office.isSelected()) {
					jcbdistrict.setModel(NanjingModel);
				} else if (e.getItem().equals("----") && office.isSelected()) {
					jcbdistrict.setModel(model);
				}
			}

		});
		jcbdistrict.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (!(e.getItem().equals(null))) {
					// System.out.println("!");
				}
			}

		});
		jbnumberstart.addActionListener(this);

		// 水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("城市:", JLabel.CENTER));
		box1.add(Box.createHorizontalStrut(30));
		box1.add(jcbcity);
		Box box = Box.createHorizontalBox();
		box.add(new JLabel("选择机构类型：", JLabel.CENTER));
		box.add(Box.createHorizontalStrut(20));
		box.add(office);
		box.add(Box.createHorizontalStrut(10));
		box.add(transfer);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("区名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(30));
		box2.add(jcbdistrict);
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("编号:", JLabel.CENTER));
		box3.add(Box.createHorizontalStrut(30));
		box3.add(jtfNumber);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(jbnumberstart);

		// 垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);

		JPanel pCenter;
		// JScrollPane处理滚动
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);

		setLayout(new BorderLayout());
		// 主要的信息界面显示在中央
		add(scrollPane, BorderLayout.CENTER);
		JPanel pSouth = new JPanel();
		pSouth.add(addButton);
		pSouth.add(resetButton);
		// 两个按钮显示在南边
		add(pSouth, BorderLayout.SOUTH);
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == jbnumberstart) {// 点击了生成编号
			if (!(jcbcity.getSelectedItem().toString().equals("----"))) {//选择了某一个城市
				//选择添加的是营业厅且选择了某个区
				if (office.isSelected() && !(jcbdistrict.getSelectedItem().toString().equals("----"))) {
					String currentcitystr = jcbcity.getSelectedItem().toString();
					String next = officeinfocontroller.getNextOfficeID(City.getbyStr(currentcitystr));
					jtfNumber.setText(next);
					jbnumberstart.setEnabled(false);// 生成编号按钮设为不可点击
					System.out.println(next);
				} else if (transfer.isSelected()) {//选择添加的是中转中心
					String currenttransfer = jcbcity.getSelectedItem().toString();
					String next = transferOfficeInfocontroller.getNextTransferOffceID(City.getbyStr(currenttransfer));
					jtfNumber.setText(next);
					jbnumberstart.setEnabled(false);// 生成编号按钮设为不可点击
				}
			} else {//未选择某个城市
				JOptionPane.showMessageDialog(this, "城市不能为空！", "警告", JOptionPane.WARNING_MESSAGE);
				System.out.println("城市不能为空！");
			}

		}

		if (e.getSource() == addButton) {//点击了添加按钮
			if (jtfNumber.getText().length() > 0) {// 已经生成编号
				if (office.isSelected()) {//选择添加的是营业厅
					String district = jcbdistrict.getSelectedItem().toString();
					String city = jcbcity.getSelectedItem().toString();
					OfficeVO officevo;
					if (city.equals(City.BEIJING.toString())) {// 北京营业厅
						officevo = new OfficeVO(City.getbyStr(city), BeiJingDistrict.districtByStr(district));
					} else if (city.equals(City.GUANGZHOU.toString())) {// 广州营业厅
						officevo = new OfficeVO(City.getbyStr(city), GuangZhouDistrict.getByStr(district));
					} else if (city.equals(City.SHANGHAI.toString())) {// 上海营业厅
						officevo = new OfficeVO(City.getbyStr(city), ShangHaiDistrict.districtByStr(district));
					} else {// 南京营业厅
						officevo = new OfficeVO(City.getbyStr(city), NanJingDistrict.getByStr(district));
					}
					officevo.setOfficeID(jtfNumber.getText());
					officeinfocontroller.addOffice(officevo);// 添加营业厅
					//添加一条日志
					LogVO logToAdd = new LogVO();
					logToAdd.setOperation(Operation.ADD);
					logToAdd.setOperationObject(OperationObject.Office);
					logToAdd.setOperationTime(new GregorianCalendar());
					logToAdd.setOperatorID(UserID.userid);
					logToAdd.setOperatorRole(UserRole.MANAGER);
					logController.addLog(logToAdd);
					
				} else if (transfer.isSelected()) {//选择添加的是中转中心
					TransferOfficeVO vo = new TransferOfficeVO(City.getbyStr(jcbcity.getSelectedItem().toString()));
					vo.setTransferOfficeID(jtfNumber.getText());
					transferOfficeInfocontroller.addTransferOffice(vo);// 添加中转中心
					InventoryController inventoryController = new InventoryController();
					InventoryInfoVO inventoryInfoVO = new InventoryInfoVO(jtfNumber.getText());
					inventoryController.addInventory(inventoryInfoVO);
					
					//添加一条日志
					LogVO logToAdd = new LogVO();
					logToAdd.setOperation(Operation.ADD);
					logToAdd.setOperationObject(OperationObject.TransferOffice);
					logToAdd.setOperationTime(new GregorianCalendar());
					logToAdd.setOperatorID(UserID.userid);
					logToAdd.setOperatorRole(UserRole.MANAGER);
					logController.addLog(logToAdd);
					
				}
				String m = "营业厅基本信息已录入!";
				JOptionPane.showMessageDialog(this, m, "提示", JOptionPane.INFORMATION_MESSAGE);
				jcbcity.setEnabled(false);//城市组合框不可选
				jcbdistrict.setEnabled(false);//地区组合框不可选
			} else {//还未生成编号
				JOptionPane.showMessageDialog(this, "信息不能为空！", "警告", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == resetButton) {
			//重置之后，生成编号变为可点击
			jbnumberstart.setEnabled(true);
			jcbcity.setEnabled(true);//城市组合框不可选
			jcbdistrict.setEnabled(true);//地区组合框不可选
			textClear();
		}

	}

	public void textClear() {
		office.setSelected(false);
		transfer.setSelected(false);
		jcbcity.setSelectedIndex(0);
		jcbdistrict.setModel(model);
		jtfNumber.setText(null);
	}

}
