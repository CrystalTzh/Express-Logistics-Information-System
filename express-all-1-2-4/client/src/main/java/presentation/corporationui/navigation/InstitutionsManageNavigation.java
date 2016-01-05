package presentation.corporationui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.corporationcontroller.OfficeInfoController;
import controller.corporationcontroller.TransferOfficeInfoController;
import presentation.corporationui.institutionsmanageboard.InstitutionsManageDriver;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import state.City;
import vo.OfficeVO;
import vo.TransferOfficeVO;

public class InstitutionsManageNavigation extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏7个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	static private JButton jbPrice,jbSalary,jbAccountID,jbJudge,
					jbCheckCostPayChart,jbCheckProfitChart,
					jbCheckDiary,jbInstitutionsManage;
	
	private ImageIcon imagelogo,imagePrice,imageSalary,
					  imageAccount,imageJudge,
					  imageCheckCostPayChart,imageCheckProfitChart,
					  imageCheckDiary,imageInstitutionsManage;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	Vector<String> tableValues ;
	Vector<String> columnNames ;
	Vector<String> row;
	DefaultTableModel model ;
	OfficeInfoController officeInfoController;
	TransferOfficeInfoController transferOfficeInfoController;
	
	public InstitutionsManageNavigation(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(8, 1,5,10));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

		setJbPrice(new JButton());//制定价格常量
		imagePrice = new ImageIcon("image/price.jpg");
		getJbPrice().setIcon(imagePrice);
		getJbPrice().setPreferredSize(new Dimension(imagePrice.getIconWidth(),
				imagePrice.getIconHeight()));
		getJbPrice().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbPrice()){
//					new MainFrame().setContentPane(new PriceNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbSalary(new JButton());//制定薪资标准
		imageSalary = new ImageIcon("image/salary.jpg");
		getJbSalary().setIcon(imageSalary);
		getJbSalary().setPreferredSize(new Dimension(imageSalary.getIconWidth(),
				imageSalary.getIconHeight()));
		getJbSalary().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbSalary()){
//					new MainFrame().setContentPane(new SalaryNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbJudge(new JButton());//审批单据
		imageJudge = new ImageIcon("image/judge.jpg");
		getJbJudge().setIcon(imageJudge);
		getJbJudge().setPreferredSize(new Dimension(imageJudge.getIconWidth(),
				imageJudge.getIconHeight()));
		
		setJbAccountID(new JButton());//查看账户
		imageAccount = new ImageIcon("image/checkaccount.jpg");
		getJbAccountID().setIcon(imageAccount);
		getJbAccountID().setPreferredSize(new Dimension(imageAccount.getIconWidth(),
				imageAccount.getIconHeight()));
		getJbAccountID().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbAccountID()){
//					new MainFrame().setContentPane(new BossCheckAccountsNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbCheckCostPayChart(new JButton());//查看成本收益表
		imageCheckCostPayChart = new ImageIcon("image/checkcostpaychart.jpg");
		getJbCheckCostPayChart().setIcon(imageCheckCostPayChart);
		getJbCheckCostPayChart().setPreferredSize(new Dimension(imageCheckCostPayChart.getIconWidth(),
				imageCheckCostPayChart.getIconHeight()));
		getJbCheckCostPayChart().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCheckCostPayChart()){
//					new MainFrame().setContentPane(new BossCheckCostPayChartNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbCheckProfitChart(new JButton());//查看经营情况表
		imageCheckProfitChart = new ImageIcon("image/checkprofitchart.jpg");
		getJbCheckProfitChart().setIcon(imageCheckProfitChart);
		getJbCheckProfitChart().setPreferredSize(new Dimension(imageCheckProfitChart.getIconWidth(),
				imageCheckProfitChart.getIconHeight()));
		getJbCheckProfitChart().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCheckProfitChart()){
//					new MainFrame().setContentPane(new BossCheckProfitChartNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbCheckDiary(new JButton());//查看日志
		imageCheckDiary = new ImageIcon("image/checkdiary.jpg");
		getJbCheckDiary().setIcon(imageCheckDiary);
		getJbCheckDiary().setPreferredSize(new Dimension(imageCheckDiary.getIconWidth(),
				imageCheckDiary.getIconHeight()));
		getJbCheckDiary().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCheckDiary()){
//					new MainFrame().setContentPane(new BossCheckDiaryNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbInstitutionsManage(new JButton());//机构管理
		imageInstitutionsManage = new ImageIcon("image/institutionsmanage.jpg");
		getJbInstitutionsManage().setIcon(imageInstitutionsManage);
		getJbInstitutionsManage().setPreferredSize(new Dimension(imageInstitutionsManage.getIconWidth(),
				imageInstitutionsManage.getIconHeight()));
		getJbInstitutionsManage().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbInstitutionsManage()){
//					new MainFrame().setContentPane(new InstitutionsManageNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		jpanel2.add(getJbPrice());
		jpanel2.add(getJbSalary());
		jpanel2.add(getJbJudge());
		jpanel2.add(getJbAccountID());
		jpanel2.add(getJbCheckCostPayChart());
		jpanel2.add(getJbCheckProfitChart());
		jpanel2.add(getJbCheckDiary());
		jpanel2.add(getJbInstitutionsManage());
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：总经理   "+UserID.userid+" 当前任务：机构管理");
		jlcurrentID.setFont(new Font("微软雅黑",Font.PLAIN,15));

		jbmodify = new JButton("修改密码");
		jbmodify.setFont(new Font("修改密码",Font.PLAIN,12));
		jbmodify.setContentAreaFilled(false);
		jbmodify.addActionListener(this);
		
		jbexit = new JButton("退出登录");
		jbexit.setFont(new Font("退出登录",Font.PLAIN,12));
		jbexit.setContentAreaFilled(false);
		jbexit.addActionListener(this);
		
		b = Box.createHorizontalBox();
		b.add(jlcurrentID);
		b.add(Box.createHorizontalGlue());
		b.add(jbmodify);
		b.add(Box.createHorizontalStrut(13));
		b.add(jbexit);
		b.add(Box.createHorizontalStrut(3));
		
//		String[] columnNames = { "机构名称","机构编号"};  
//        String[][] tableValues = { { "A1"}, { "A2"},  
//                { "A3"}, { "A4" }, 
//                { "A5" },{ "A6"}}; 
        
		
		columnNames = new Vector<String>();
		columnNames.add("机构名称");
		columnNames.add("机构编号");
        columnNames.add("城市");
        columnNames.add("区");
        tableValues = new Vector<String>();
        
        model = new DefaultTableModel(tableValues,columnNames){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			
			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        
        table = new JTable(); 
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table); 
        
        transferOfficeInfoController = new TransferOfficeInfoController();
       //添加北京中转中心
        ArrayList<TransferOfficeVO> allBeiJingTransferOfficeVOOld = transferOfficeInfoController.findAll(City.BEIJING);
        if(allBeiJingTransferOfficeVOOld!=null){
        	//对中转中心按编号进行排序
        	ArrayList<TransferOfficeVO> allBeiJingTransferOfficeVO =transferOfficeInfoController.sortByIDs(allBeiJingTransferOfficeVOOld);
        	for(int i = 0;i<allBeiJingTransferOfficeVO.size();i++){
        		
        		row = new Vector<String>();
        		
        		String name = "中转中心";
        		String ID = allBeiJingTransferOfficeVO.get(i).getTransferOfficeID();
        		String city = allBeiJingTransferOfficeVO.get(i).getCity().toString();
        		String district = "----";
        		
        		row.add(0, name);
        		row.add(1, ID);
        		row.add(2, city);
        		row.add(3, district);
        		model.addRow(row);
        	}
        }
        //添加广州中转中心
        ArrayList<TransferOfficeVO> allGuangZhouTransferOfficeVOOld = transferOfficeInfoController.findAll(City.GUANGZHOU);
        if(allGuangZhouTransferOfficeVOOld!=null){
        	 ArrayList<TransferOfficeVO> allGuangZhouTransferOfficeVO = transferOfficeInfoController.sortByIDs(allGuangZhouTransferOfficeVOOld);
        	for(int i = 0;i<allGuangZhouTransferOfficeVO.size();i++){
        		row = new Vector<String>();
        		
        		String name = "中转中心";
        		String ID = allGuangZhouTransferOfficeVO.get(i).getTransferOfficeID();
        		String city = allGuangZhouTransferOfficeVO.get(i).getCity().toString();
        		String district = "----";
        		
        		row.add(0, name);
        		row.add(1, ID);
        		row.add(2, city);
        		row.add(3, district);
        		model.addRow(row);
        	}
        }
        //添加上海中转中心
        ArrayList<TransferOfficeVO> allShangHaiTransferOfficeVOOld = transferOfficeInfoController.findAll(City.SHANGHAI);
        if(allShangHaiTransferOfficeVOOld!=null){
        	ArrayList<TransferOfficeVO> allShangHaiTransferOfficeVO = transferOfficeInfoController.sortByIDs(allShangHaiTransferOfficeVOOld);
        	for(int i = 0;i<allShangHaiTransferOfficeVO.size();i++){
        		row = new Vector<String>();
        		
        		String name = "中转中心";
        		String ID = allShangHaiTransferOfficeVO.get(i).getTransferOfficeID();
        		String city = allShangHaiTransferOfficeVO.get(i).getCity().toString();
        		String district = "----";
        		
        		row.add(0, name);
        		row.add(1, ID);
        		row.add(2, city);
        		row.add(3, district);
        		model.addRow(row);
        	}
        }
        //添加南京中转中心
        ArrayList<TransferOfficeVO> allNanJingTransferOfficeVOOld = transferOfficeInfoController.findAll(City.NANJING);
        if(allNanJingTransferOfficeVOOld!=null){
        	ArrayList<TransferOfficeVO> allNanJingTransferOfficeVO = transferOfficeInfoController.sortByIDs(allNanJingTransferOfficeVOOld);
        	for(int i = 0;i<allNanJingTransferOfficeVO.size();i++){
        		row = new Vector<String>();
        		
        		String name = "中转中心";
        		String ID = allNanJingTransferOfficeVO.get(i).getTransferOfficeID();
        		String city = allNanJingTransferOfficeVO.get(i).getCity().toString();
        		String district = "----";
        		
        		row.add(0, name);
        		row.add(1, ID);
        		row.add(2, city);
        		row.add(3, district);
        		model.addRow(row);
        	}
        }
        
        officeInfoController = new OfficeInfoController();
      //添加北京营业厅
        ArrayList<OfficeVO> allBeiJingOfficeVOOld =officeInfoController.findAll(City.BEIJING);
        if(allBeiJingOfficeVOOld!=null){
        	ArrayList<OfficeVO> allBeiJingOfficeVO = officeInfoController.sortByIDs(allBeiJingOfficeVOOld);
        	for(int i = 0;i<allBeiJingOfficeVO.size();i++){
        		row = new Vector<String>();
        		
        		String name = "营业厅";
        		String ID = allBeiJingOfficeVO.get(i).getOfficeID();
        		String city = allBeiJingOfficeVO.get(i).getCity().toString();
        		String district = allBeiJingOfficeVO.get(i).getBeiJingDistrict().toString();
        		
        		row.add(0, name);
        		row.add(1, ID);
        		row.add(2, city);
        		row.add(3, district);
        		model.addRow(row);
        	}
        }
        
      //添加广州营业厅
        ArrayList<OfficeVO> allGuangZhouOfficeVOOld =officeInfoController.findAll(City.GUANGZHOU);
        if(allGuangZhouOfficeVOOld!=null){
        	ArrayList<OfficeVO> allGuangZhouOfficeVO = officeInfoController.sortByIDs(allGuangZhouOfficeVOOld);
        	for(int i = 0;i<allGuangZhouOfficeVO.size();i++){
        		row = new Vector<String>();
        		
        		String name = "营业厅";
        		String ID = allGuangZhouOfficeVO.get(i).getOfficeID();
        		String city = allGuangZhouOfficeVO.get(i).getCity().toString();
        		String district = allGuangZhouOfficeVO.get(i).getGuangZhouDistrict().toString();
        		
        		row.add(0, name);
        		row.add(1, ID);
        		row.add(2, city);
        		row.add(3, district);
        		model.addRow(row);
        	}
        }
        
      //添加上海营业厅
        ArrayList<OfficeVO> allShangHaiOfficeVOOld = officeInfoController.findAll(City.SHANGHAI);
        if(allShangHaiOfficeVOOld!=null){
        	ArrayList<OfficeVO> allShangHaiOfficeVO = officeInfoController.sortByIDs(allShangHaiOfficeVOOld);
        	for(int i = 0;i<allShangHaiOfficeVO.size();i++){
        		row = new Vector<String>();
        		
        		String name = "营业厅";
        		String ID = allShangHaiOfficeVO.get(i).getOfficeID();
        		String city = allShangHaiOfficeVO.get(i).getCity().toString();
        		String district = allShangHaiOfficeVO.get(i).getShangHaiDistrict().toString();
        		
        		row.add(0, name);
        		row.add(1, ID);
        		row.add(2, city);
        		row.add(3, district);
        		model.addRow(row);
        	}
        }
        
      //添加南京营业厅
        ArrayList<OfficeVO> allNanJingOfficeVOOld = officeInfoController.findAll(City.NANJING);
        if(allBeiJingOfficeVOOld!=null){
        	ArrayList<OfficeVO> allNanJingOfficeVO = officeInfoController.sortByIDs(allNanJingOfficeVOOld);
        	for(int i = 0;i<allNanJingOfficeVO.size();i++){
        		row = new Vector<String>();
        		
        		String name = "营业厅";
        		String ID = allNanJingOfficeVO.get(i).getOfficeID();
        		String city = allNanJingOfficeVO.get(i).getCity().toString();
        		String district = allNanJingOfficeVO.get(i).getNanJingDistrict().toString();
        		
        		row.add(0, name);
        		row.add(1, ID);
        		row.add(2, city);
        		row.add(3, district);
        		model.addRow(row);
        	}
        }
        
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startform.jpg");
		jbstart.setIcon(imageStart);
		jbstart.setPreferredSize(new Dimension(imageStart.getIconWidth(),
				imageStart.getIconHeight()));
		jbstart.addActionListener(this);
		
		jpanel4.add(Box.createHorizontalStrut(622));
		jpanel4.add(jbstart);
		jpanel4.add(Box.createHorizontalGlue());
		
		this.add(jpanel4,BorderLayout.SOUTH);
		this.add(jpanel3,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbstart){
			new InstitutionsManageDriver();
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this,UserID.userid).setVisible(true);
		}
		if(e.getSource() == jbexit){
			JOptionPane.getFrameForComponent(this).dispose();
			new MainFrame().setVisible(true);
		}
		
	}

	public static JButton getJbPrice() {
		return jbPrice;
	}

	public static void setJbPrice(JButton jbPrice) {
		InstitutionsManageNavigation.jbPrice = jbPrice;
	}

	public static JButton getJbSalary() {
		return jbSalary;
	}

	public static void setJbSalary(JButton jbSalary) {
		InstitutionsManageNavigation.jbSalary = jbSalary;
	}

	public static JButton getJbJudge() {
		return jbJudge;
	}

	public static void setJbJudge(JButton jbJudge) {
		InstitutionsManageNavigation.jbJudge = jbJudge;
	}

	public static JButton getJbAccountID() {
		return jbAccountID;
	}

	public static void setJbAccountID(JButton jbAccountID) {
		InstitutionsManageNavigation.jbAccountID = jbAccountID;
	}

	public static JButton getJbCheckCostPayChart() {
		return jbCheckCostPayChart;
	}

	public static void setJbCheckCostPayChart(JButton jbCheckCostPayChart) {
		InstitutionsManageNavigation.jbCheckCostPayChart = jbCheckCostPayChart;
	}

	public static JButton getJbCheckProfitChart() {
		return jbCheckProfitChart;
	}

	public static void setJbCheckProfitChart(JButton jbCheckProfitChart) {
		InstitutionsManageNavigation.jbCheckProfitChart = jbCheckProfitChart;
	}

	public static JButton getJbCheckDiary() {
		return jbCheckDiary;
	}

	public static void setJbCheckDiary(JButton jbCheckDiary) {
		InstitutionsManageNavigation.jbCheckDiary = jbCheckDiary;
	}

	public static JButton getJbInstitutionsManage() {
		return jbInstitutionsManage;
	}

	public static void setJbInstitutionsManage(JButton jbInstitutionsManage) {
		InstitutionsManageNavigation.jbInstitutionsManage = jbInstitutionsManage;
	}

}
