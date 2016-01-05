/**
 * @author 陶子涵
 */
package presentation.formapprovalui.navigation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.financeController.PaymentFormController;
import controller.financeController.ReceiptFormController;
import controller.formapprovalcontroller.FormapprovalController;
import controller.inventorycontroller.StorageInFormController;
import controller.inventorycontroller.StorageOutFormController;
import controller.transitController.CarInputFormController;
import controller.transitController.CarOfficeFormController;
import controller.transitController.DeliveryFormController;
import controller.transitController.OfficeArrivalFormController;
import controller.transitController.OrderFormController;
import controller.transitController.StoreArrivalFormController;
import controller.transitController.TransferFormController;
import po.CarInputFormPO;
import po.CarOfficeFormPO;
import po.DeliveryFormPO;
import po.OfficeArrivalFormPO;
import po.OrderFormPO;
import po.PaymentFormPO;
import po.ReceiptFormPO;
import po.StorageInFormPO;
import po.StorageOutFormPO;
import po.StoreArrivalFormPO;
import po.TransferFormPO;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import state.FormState;

public class JudgeNavigation extends JPanel implements ActionListener{

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
//	private JPanel table;
	private JButton jbstart,jbexit,jbmodify;
	@SuppressWarnings("rawtypes")
	private JList listCheckBox;
	@SuppressWarnings("rawtypes")
	private JList listDescription;
	private CheckBoxRenderer cbr;
	private Box b;
	private String[] listData;
//	private boolean flag = false;
//	private JCheckBox box1;
	Vector<String> tableValues ;
	Vector<String> columnNames ;
	Vector<Object> row;
	DefaultTableModel model ;
//	JCheckBox jcbox;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JudgeNavigation(){
		
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
		jpanel3.setLayout(null);
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：总经理   "+UserID.userid+" 当前任务：审批单据");
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
		b.setBounds(10, 0,550,35);
		
		String str = "";
		
		ArrayList<PaymentFormPO> all1 = findPaymentForm();
		ArrayList<CarInputFormPO> all2 = findCarInputForm();
		ArrayList<CarOfficeFormPO> all3 = findCarOfficeForm();
		ArrayList<DeliveryFormPO> all4 = findDeliveryForm();
		ArrayList<OfficeArrivalFormPO> all5 = findOfficeArrivalForm();
		ArrayList<OrderFormPO> all6 = findOrderForm();
		ArrayList<ReceiptFormPO> all7 = findReceiptForm();
		@SuppressWarnings("unused")
		ArrayList<StorageInFormPO> all8 = findStorageInForm();
		@SuppressWarnings("unused")
		ArrayList<StorageOutFormPO> all9 = findStorageOutForm();
		ArrayList<StoreArrivalFormPO> all10 = findStoreArrivalForm();
		ArrayList<TransferFormPO> all11 = findTransferForm();
		
		for(int i=0;i<all1.size();i++){
			if(all1.get(i).getFormState()==FormState.SUBMITTED){
				str += "付款单"+all1.get(i).getNO()+" ";
			}	
		}
		for(int i=0;i<all2.size();i++){
			if(all2.get(i).getFormstate()==FormState.SUBMITTED){
				str += "中转中心装车单"+all2.get(i).getNO()+" ";
			}
			
		}
		for(int i=0;i<all3.size();i++){
			if(all3.get(i).getFormstate()==FormState.SUBMITTED){
				str += "营业厅装车单"+all3.get(i).getNO()+" ";
			}
			
		}
		for(int i=0;i<all4.size();i++){
			if(all4.get(i).getFormstate()==FormState.SUBMITTED){
				str += "派件单"+all4.get(i).getID()+" ";
			}
			
		}
		for(int i=0;i<all5.size();i++){
			if(all5.get(i).getFormstate()==FormState.SUBMITTED){
				str += "营业厅到达单"+all5.get(i).getNO()+" ";
			}
			
		}
		for(int i=0;i<all6.size();i++){
			if(all6.get(i).getFormstate()==FormState.SUBMITTED){
				str += "寄件单"+all6.get(i).getID()+" ";
			}
			
		}
		for(int i=0;i<all7.size();i++){
			if(all7.get(i).getFormstate()==FormState.SUBMITTED){
				str += "收款单"+all7.get(i).getNO()+" ";
			}
			
		}
		for(int i=0;i<all8.size();i++){
			if(all8.get(i).getFormstate()==FormState.SUBMITTED){
				str += "入库单"+all8.get(i).getNO()+" ";
			}
			
		}
		for(int i=0;i<all9.size();i++){
			if(all9.get(i).getFormstate()==FormState.SUBMITTED){
				str += "出库单"+all9.get(i).getNO()+" ";
			}
			
		}
		for(int i=0;i<all10.size();i++){
			if(all10.get(i).getFormstate()==FormState.SUBMITTED){
				str += "中转中心到达单"+all10.get(i).getNO()+" ";
			}
			
		}
		for(int i=0;i<all11.size();i++){
			if(all11.get(i).getFormstate()==FormState.SUBMITTED){
				str += "中转单"+all11.get(i).getRelayFormNumber()+" ";
			}
			
		}
		
		listData = str.split(" ");
		
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to find System Look and Feel");
        }
//		DefaultListModel listModel = new DefaultListModel();
//		listModel.addElement(buildCheckBoxItems(listData));
		listCheckBox = new JList(buildCheckBoxItems(listData));
		listDescription = new JList(listData);
        listDescription.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listDescription.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() != 2) {
                    return;
                }
                int selectedIndex = listDescription.locationToIndex(me.getPoint());
                if (selectedIndex < 0) {
                    return;
                }
                CheckBoxItem item = (CheckBoxItem) listCheckBox.getModel().getElementAt(selectedIndex);
                item.setChecked(!item.isChecked());
                listCheckBox.repaint();

            }
        });
        cbr = new CheckBoxRenderer();
        listCheckBox.setCellRenderer(cbr);
        listCheckBox.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listCheckBox.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me) {
                int selectedIndex = listCheckBox.locationToIndex(me.getPoint());
                if (selectedIndex < 0) {
                    return;
                }
                CheckBoxItem item = (CheckBoxItem) listCheckBox.getModel().getElementAt(selectedIndex);
                item.setChecked(!item.isChecked());
                listDescription.setSelectedIndex(selectedIndex);
                listCheckBox.repaint();
            }
        });
        
        
        JScrollPane scrollPane = new JScrollPane(); 
        scrollPane.setRowHeaderView(listCheckBox);
        scrollPane.setViewportView(listDescription);
        listDescription.setFixedCellHeight(20);
        listCheckBox.setFixedCellHeight(listDescription.getFixedCellHeight());
        listCheckBox.setFixedCellWidth(20);
//        row = new Vector<Object>();
//        row.add(0,jcbox);
//        row.add(1,"寄件单");
//        row.add(2, "01");
//        model.addRow(row);
        //TODO 请具体添加数据
        scrollPane.setBounds(10, 35, 550, 330);
        jpanel3.add(b);
        jpanel3.add(scrollPane);
		
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startjudge.jpg");
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
	
	class CheckBoxItem {

        private boolean isChecked = false;
        private String NO;

        public void setNO(String NO) {
            this.NO = NO;
        }
        
        public String getNO(){
        	return NO;
        }
        
        public CheckBoxItem() {
            isChecked = false;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean value) {
            isChecked = value;
        }
    }
	
	@SuppressWarnings({ "serial", "rawtypes" })
	class CheckBoxRenderer extends JCheckBox implements ListCellRenderer {

        public CheckBoxRenderer() {
            setBackground(UIManager.getColor("List.textBackground"));
            setForeground(UIManager.getColor("List.textForeground"));
        }

        public Component getListCellRendererComponent(JList listBox, Object obj, int currentindex,
                boolean isChecked, boolean hasFocus) {
            setSelected(((CheckBoxItem) obj).isChecked());
            return this;
        }
    }

	private CheckBoxItem[] buildCheckBoxItems(String[] listData) {
        CheckBoxItem[] checkboxItems = new CheckBoxItem[listData.length];
        for (int counter = 0; counter < listData.length; counter++) {
            checkboxItems[counter] = new CheckBoxItem();
            checkboxItems[counter].setNO(listData[counter]);
        }
        return checkboxItems;
    }
	
	private ArrayList<CarInputFormPO> findCarInputForm() {
		// TODO Auto-generated method stub
		CarInputFormController controller = new CarInputFormController();
		return controller.findAll();
	}
	
	private ArrayList<CarOfficeFormPO> findCarOfficeForm() {
		// TODO Auto-generated method stub
		CarOfficeFormController controller = new CarOfficeFormController();
		return controller.findAll();
	}
	
	private ArrayList<DeliveryFormPO> findDeliveryForm() {
		// TODO Auto-generated method stub
		DeliveryFormController controller = new DeliveryFormController();
		return controller.findAll();
	}
	
	private ArrayList<OfficeArrivalFormPO> findOfficeArrivalForm() {
		// TODO Auto-generated method stub
		OfficeArrivalFormController controller = new OfficeArrivalFormController();
		return controller.findAll();
	}
	
	private ArrayList<OrderFormPO> findOrderForm() {
		// TODO Auto-generated method stub
		OrderFormController controller = new OrderFormController();
		return controller.findAll();
	}
	
	private ArrayList<PaymentFormPO> findPaymentForm() {
		// TODO Auto-generated method stub
		PaymentFormController controller = new PaymentFormController();
		return controller.findAll();
	}
	
	private ArrayList<ReceiptFormPO> findReceiptForm() {
		// TODO Auto-generated method stub
		ReceiptFormController controller = new ReceiptFormController();
		return controller.findAll();
	}
	
	private ArrayList<StorageInFormPO> findStorageInForm() {
		// TODO Auto-generated method stub
		StorageInFormController controller = new StorageInFormController();
		return controller.findAll();
	}
	
	private ArrayList<StorageOutFormPO> findStorageOutForm() {
		// TODO Auto-generated method stub
		StorageOutFormController controller = new StorageOutFormController();
		return controller.findAll();
	}
	
	private ArrayList<StoreArrivalFormPO> findStoreArrivalForm() {
		// TODO Auto-generated method stub
		StoreArrivalFormController controller = new StoreArrivalFormController();
		return controller.findAll();
	}
	
	private ArrayList<TransferFormPO> findTransferForm() {
		// TODO Auto-generated method stub
		TransferFormController controller = new TransferFormController();
		return controller.findAll();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbexit){
			new MainFrame().remove(this);
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid).setVisible(true);
		}
//		if(e.getSource() == jbstart){
//			int ok = JOptionPane.showConfirmDialog(this, "请确认审批！", "确认", JOptionPane.YES_NO_OPTION,
//					JOptionPane.INFORMATION_MESSAGE);
//			if(ok == JOptionPane.YES_OPTION){
////				flag = true;
//			}
//		}
		if(e.getSource() == jbstart){
			//TODO
			
				int ok = JOptionPane.showConfirmDialog(this, "请确认审批！", "确认", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if(ok == JOptionPane.YES_OPTION){
					//TODO 修改单据状态
//					if((CheckBoxItem[])listCheckBox.getSelectedValues()){
//						String str = cbr.getText();
//						System.out.println(str);
//					}
//					CheckBoxItem[] 
					FormapprovalController controller = new FormapprovalController();
					CheckBoxItem[] check = new CheckBoxItem[listData.length];
					for(int i=0;i<check.length;i++){
						check[i] = (CheckBoxItem)listCheckBox.getModel().getElementAt(i);
					}
//					System.out.println(a.getNO());
					for(int i=0;i<check.length;i++){
						if(check[i].isChecked){
//							System.out.println(check[i].getNO().substring(0,3));
							String tag = null;
							String NO = null;
							if(check[i].getNO().length()==13){
								tag = check[i].getNO().substring(0,3);
								NO = check[i].getNO().substring(3);
							}
							if(check[i].getNO().length()==16){
								tag = check[i].getNO().substring(0,6);
								NO = check[i].getNO().substring(6);
							}
							if(check[i].getNO().length()==17){
								tag = check[i].getNO().substring(0,7);
								NO = check[i].getNO().substring(7);
							}
							
							try {
								switch (tag) {
									case "付款单":
										PaymentFormController paymentFormController = new PaymentFormController();
										controller.judgePaymentForm(paymentFormController.findDriver(NO));
										break;
									case "中转中心装车单":
										CarInputFormController carInputFormController = new CarInputFormController();
										controller.judgeCarInputForm(carInputFormController.findDriver(NO));
										break;
									case "营业厅装车单":
										CarOfficeFormController carOfficeFormController = new CarOfficeFormController();
										controller.judgeCarOfficeForm(carOfficeFormController.findDriver(NO));
										break;
									case "派件单":
										DeliveryFormController deliveryFormController = new DeliveryFormController();
										controller.judgeDeliveryForm(deliveryFormController.findDriver(NO));
										break;
									case "营业厅到达单":
										OfficeArrivalFormController officeArrivalFormController = new OfficeArrivalFormController();
										controller.judgeOfficeArrivalForm(officeArrivalFormController.findDriver(NO));
										break;
									case "寄件单":
										OrderFormController orderFormController = new OrderFormController();
										controller.judgeOrderForm(orderFormController.findDriver(NO));
										break;
									case "收款单":
										ReceiptFormController receiptFormController = new ReceiptFormController();
										System.out.println("NO: "+NO);
										controller.judgeReceiptForm(receiptFormController.findDriver(NO));
										break;
									case "入库单":
										StorageInFormController storageInFormController = new StorageInFormController();
										controller.judgeStorageInForm(storageInFormController.findDriver(NO));
										break;
									case "出库单":
										StorageOutFormController storageOutFormController = new StorageOutFormController();
										controller.judgeStorageOutForm(storageOutFormController.findDriver(NO));
										break;
									case "中转中心到达单":
										StoreArrivalFormController storeArrivalFormController = new StoreArrivalFormController();
										controller.judgeStoreArrivalForm(storeArrivalFormController.findDriver(NO));
										break;
									case "中转单":
										TransferFormController transferFormController = new TransferFormController();
										controller.judgeTransferForm(transferFormController.findDriver(NO));
										break;

									default:
										break;
								}
							} catch (RemoteException | IllegalArgumentException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			
			
		}
	}

	public static JButton getJbPrice() {
		return jbPrice;
	}

	public static void setJbPrice(JButton jbPrice) {
		JudgeNavigation.jbPrice = jbPrice;
	}

	public static JButton getJbSalary() {
		return jbSalary;
	}

	public static void setJbSalary(JButton jbSalary) {
		JudgeNavigation.jbSalary = jbSalary;
	}

	public static JButton getJbJudge() {
		return jbJudge;
	}

	public static void setJbJudge(JButton jbJudge) {
		JudgeNavigation.jbJudge = jbJudge;
	}

	public static JButton getJbAccountID() {
		return jbAccountID;
	}

	public static void setJbAccountID(JButton jbAccountID) {
		JudgeNavigation.jbAccountID = jbAccountID;
	}

	public static JButton getJbCheckCostPayChart() {
		return jbCheckCostPayChart;
	}

	public static void setJbCheckCostPayChart(JButton jbCheckCostPayChart) {
		JudgeNavigation.jbCheckCostPayChart = jbCheckCostPayChart;
	}

	public static JButton getJbCheckProfitChart() {
		return jbCheckProfitChart;
	}

	public static void setJbCheckProfitChart(JButton jbCheckProfitChart) {
		JudgeNavigation.jbCheckProfitChart = jbCheckProfitChart;
	}

	public static JButton getJbCheckDiary() {
		return jbCheckDiary;
	}

	public static void setJbCheckDiary(JButton jbCheckDiary) {
		JudgeNavigation.jbCheckDiary = jbCheckDiary;
	}

	public static JButton getJbInstitutionsManage() {
		return jbInstitutionsManage;
	}

	public static void setJbInstitutionsManage(JButton jbInstitutionsManage) {
		JudgeNavigation.jbInstitutionsManage = jbInstitutionsManage;
	}

	
	
}
