package presentation.transitui.DeliveryBoard;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import controller.transitController.DeliveryFormController;
import vo.DeliveryFormVO;

public class DeliveryPanel extends JPanel implements ActionListener{
	JPanel deliveryInfoPanel;
		JLabel arriveDateLabel, deliveryManLabel, IDLabel;
		JTextField arriveDateText, deliveryManText, IDText;
		JButton cancelbutton,savebutton;
//	public DeliveryBoard() {}
	public DeliveryPanel() {
		
		
//		this.setBorder(new TitledBorder("派件单01"));
		//this.setLayout(null);
		
		deliveryInfoPanel = new JPanel();
		deliveryManLabel = new JLabel("派件员编号");
		IDLabel = new JLabel("订单号");
		arriveDateLabel = new JLabel("到达日期");
		arriveDateText = new JTextField(20);
		deliveryManText = new JTextField(20);
		IDText = new JTextField(20);
		cancelbutton=new JButton("取消");
		savebutton=new JButton("保存");
		
		cancelbutton.addActionListener(this);
		savebutton.addActionListener(this);
		
	//deliveryInfoPanel.setLayout(null);
	//	deliveryInfoPanel.setBorder(new TitledBorder("派件单信息"));
		
//		Font font = new Font("Times New Roman", Font.BOLD, 24);
//		arriveDateLabel.setFont(font);
		arriveDateText.setText(getCurrenTime());	
//		deliveryManLabel.setFont(font);
//		IDLabel.setFont(font);
		
		
		Box box1 = Box.createHorizontalBox();
		box1.add(deliveryManLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(deliveryManText);
		Box box2 = Box.createHorizontalBox();
		box2.add(arriveDateLabel);
		box2.add(Box.createHorizontalStrut(25));
		box2.add(arriveDateText);
		Box box3 = Box.createHorizontalBox();
		box3.add(IDLabel);
		box3.add(IDText);
	
		
		//垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		
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
		//两个按钮显示在南边
		add(pSouth, BorderLayout.SOUTH);
//		int deliveryInfoPanelX = deliveryInfoPanel.getX();
//		int deliveryInfoPanelY = deliveryInfoPanel.getY();
//		arriveDateLabel.setBounds(x+100+15, y+80+15, 130, 30);
//		arriveDateText.setBounds(x+100+160, y+80+15, 270, 30);
//		deliveryManLabel.setBounds(x+100+15, y+80+50, 130, 30);
//		deliveryManText.setBounds(x+100+160, y+80+50, 270, 30);
//		deliveryInfoPanel.setBounds(x+100, y+250, 515, 90);
//		IDLabel.setBounds(x+100+15, y+80+85, 130, 30);
//		IDText.setBounds(x+100+160, y+80+85, 130, 30);
//		savebutton.setBounds(x+115, y+200, 40, 20);
//		cancelbutton.setBounds(x+160, y+200, 40, 20);
		
//		IDLabel.setHorizontalAlignment(SwingConstants.LEFT);
//		IDText.setLayout(new GridLayout(1, 2, 5, 5));
//		IDText.setBounds(deliveryInfoPanelX+160, deliveryInfoPanelY, IDText.getWidth(), IDText.getHeight());

		
		
		//add(deliveryInfoPanel);
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
		// TODO Auto-generated method stub
		if(e.getSource()==cancelbutton){
			textClear();
		}
		if(e.getSource()==savebutton){
			String number = "";
			number = IDText.getText();
			if(number.length()>0){
				DeliveryFormVO vo = null;
				DeliveryFormController deliveryFormController = new DeliveryFormController();
				try {
					vo = deliveryFormController.findDriver(number);
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
						//包装CarInfoVO
						String arriveDate= arriveDateText.getText();
						String deliveryMan = deliveryManText.getText();
						String ID = IDText.getText();
						
						DeliveryFormVO voToAdd = new DeliveryFormVO();
						voToAdd.setArrivaeDate(arriveDate);
						voToAdd.setDeliveryMan(deliveryMan);
						voToAdd.setID(ID);
						
						deliveryFormController.saveDriver(voToAdd);//添加车辆
					}//录入结束
				}
			}else {//1.2 未输入司机编号
				String warning = "必须要输入信息!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	private void textClear() {
		// TODO Auto-generated method stub
		deliveryManText.setText(null);
		IDText.setText(null);;
	}
	
}
