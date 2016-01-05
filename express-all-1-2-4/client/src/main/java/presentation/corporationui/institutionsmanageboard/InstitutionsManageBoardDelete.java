/**
 * @author 陶子涵
 * 2015年12月12日
 */
package presentation.corporationui.institutionsmanageboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.UserID;
import controller.corporationcontroller.LogController;
import controller.corporationcontroller.OfficeInfoController;
import controller.corporationcontroller.TransferOfficeInfoController;
import controller.inventorycontroller.InventoryController;
import state.Operation;
import state.OperationObject;
import state.UserRole;
import vo.InventoryInfoVO;
import vo.LogVO;
import vo.OfficeVO;
import vo.TransferOfficeVO;

public class InstitutionsManageBoardDelete extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField jtfCity,jtfDistrict, jtfNumber;
	JButton jbDelete;
	OfficeInfoController officeinfocontroller;
	TransferOfficeInfoController transferOfficeInfocontroller;
	LogController logController;

	public InstitutionsManageBoardDelete(){
		officeinfocontroller = new OfficeInfoController();
		transferOfficeInfocontroller = new TransferOfficeInfoController();
		logController = new LogController();
		//初始化文本框、按钮等组件
		jtfCity = new JTextField(10);
		jbDelete = new JButton("删除");
		jbDelete.setContentAreaFilled(false);
		//监听carNumber文本框和删除按钮
		jtfCity.addActionListener(this);
		jbDelete.addActionListener(this);
		jtfDistrict = new JTextField(10);
		jtfDistrict.setEditable(false);
		jtfNumber = new JTextField(10);
		jtfNumber.addActionListener(this);
		jtfCity.setEditable(false);
		
		//水平显示组件
		Box box = Box.createHorizontalBox();
		box.add(new JLabel("输入要删除的营业厅或是中转中心编号:", JLabel.CENTER));
		Box box1 = Box.createHorizontalBox();
		box1.add(jtfNumber);
		box1.add(jbDelete);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("城市:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(25));
		box2.add(jtfCity);
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("区名:", JLabel.CENTER));
		box3.add(Box.createHorizontalStrut(25));
		box3.add(jtfDistrict);
		//垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		
		JPanel pCenter;
		//JScrollPane处理滚动
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);
		setLayout(new BorderLayout());
		//主要的信息界面显示在中央
		add(scrollPane, BorderLayout.CENTER);
		validate();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbDelete || e.getSource() == jtfNumber) {
			//点击了删除或按enter确认编号输入完成
			String ID = jtfNumber.getText();
			if(ID.length() > 0) {//填写了机构编号
				//从中转中心中找
				@SuppressWarnings("unused")
				boolean isTransfer = false;
				TransferOfficeVO transferOfficeVO = transferOfficeInfocontroller.findTransferOffice(ID);
				if(transferOfficeVO!=null){//找到对应此编号的中转中心
					isTransfer = true;
					//显示基本信息
					jtfCity.setText(transferOfficeVO.getCity().toString());
					jtfDistrict.setText("----");
					String m = "确定要删除该中转中心吗?";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION){
						transferOfficeInfocontroller.deleteTransferOffice(transferOfficeVO);
						InventoryController inventoryController = new InventoryController();
						inventoryController.deleteInventory(new InventoryInfoVO(ID));
						//添加一条日志
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.DELETE);
						logToAdd.setOperationObject(OperationObject.TransferOffice);
						logToAdd.setOperationTime(new GregorianCalendar());
						logToAdd.setOperatorID(UserID.userid);
						logToAdd.setOperatorRole(UserRole.MANAGER);
						logController.addLog(logToAdd);
						 textClear();
					}
					else if (ok == JOptionPane.NO_OPTION) {//1.1.1.2 取消删除，清空面板
						textClear();
					}
					return;
				}
				//从营业厅中找
				@SuppressWarnings("unused")
				boolean isOffice = false;
				OfficeVO officeVO = officeinfocontroller.findOffice(ID);
				if(officeVO != null) {//找到对应此编号的营业厅
					isOffice = true;
					//显示基本信息
					jtfCity.setText(officeVO.getCity().toString());
					switch(officeVO.getCity()) {
					case BEIJING:
						jtfDistrict.setText(officeVO.getBeiJingDistrict().toString());
						break;
					case GUANGZHOU:
						jtfDistrict.setText(officeVO.getGuangZhouDistrict().toString());
						break;
					case SHANGHAI:
						jtfDistrict.setText(officeVO.getShangHaiDistrict().toString());
						break;
					default:
						jtfDistrict.setText(officeVO.getNanJingDistrict().toString());
					}
					String m = "确定要删除该营业厅吗?";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION){
						officeinfocontroller.deleteOffice(officeVO);
						//添加一条日志
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.DELETE);
						logToAdd.setOperationObject(OperationObject.Office);
						logToAdd.setOperationTime(new GregorianCalendar());
						logToAdd.setOperatorID(UserID.userid);
						logToAdd.setOperatorRole(UserRole.MANAGER);
						logController.addLog(logToAdd);
						 textClear();
					} else if(ok == JOptionPane.NO_OPTION) {
						 textClear();
					}
					return;
				}
				//既不是中转中心的编号也不是营业厅的编号
				String warning = "该编号不存在!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
			
		}

	}
	public void textClear(){
		jtfCity.setText(null);
		jtfDistrict.setText(null);
		jtfNumber.setText(null);
		
	}

}
