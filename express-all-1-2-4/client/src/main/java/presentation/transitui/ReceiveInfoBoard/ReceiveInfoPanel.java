package presentation.transitui.ReceiveInfoBoard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.transitController.OrderFormController;
import vo.OrderFormVO;

public class ReceiveInfoPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel receiveInfoPanel;
	JLabel rRealLabel,rTimeLabel,IDLabel;
	
	JTextField rRealText,rTimeText,IDText;
	JButton cancelbutton,savebutton,submitbutton;
	
	
	public ReceiveInfoPanel(){
		this.setBorder(new TitledBorder("收件信息录入"));
		receiveInfoPanel=new JPanel();
		rRealLabel=new JLabel("签收人姓名");
		rTimeLabel=new JLabel("收件时间");
		IDLabel=new JLabel("订单号");	
		
		rRealText=new JTextField(20);
		rTimeText=new JTextField(20);
		IDText=new JTextField(20);
		
		rTimeText.setText(getCurrenTime());
		
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
		
		Box box1 = Box.createHorizontalBox();
		box1.add(rRealLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(rRealText);
		
		Box box2 = Box.createHorizontalBox();
		box2.add(rTimeLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(rTimeText);
		
		Box box3 = Box.createHorizontalBox();
		box3.add(IDLabel);
		box3.add(Box.createHorizontalStrut(12));
		box3.add(IDText);
		
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		
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
		OrderFormVO vo = null;
		OrderFormController orderFormController = new OrderFormController();
		
		if(e.getSource()==cancelbutton){
			textClear();
		}
		if(e.getSource()==savebutton){
			
			String NO = "";
			NO = IDText.getText();
			if(NO.length()>0){
				
				try {
					vo = orderFormController.findDriver(NO);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(vo!= null) { //1.1.1 输入的车辆代号存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//确认录入
						//包装OrderFormVO
						String realreceiver=rRealText.getText();
						String receivetime=rTimeText.getText();
					
						@SuppressWarnings("unused")
						String ID=IDText.getText(); //快递订单号
				//		String date; //寄件日期
					//	String realReceiver; //实际收件人
				//		String realReceiveDate;//实际收件日期
						OrderFormVO voToAdd;
						try {
							voToAdd = orderFormController.findDriver(IDText.getText());
							voToAdd.setRealReceiveDate(receivetime);
							voToAdd.setRealReceiver(realreceiver);
			
							orderFormController.saveDriver(voToAdd);//添加车辆
						} catch (RemoteException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IllegalArgumentException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
				} else {//1.1.2 输出的车辆代号不存在
					
						String warning = "信息不存在,请到修改页面修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					}//录入结束
				}
				submitbutton.setEnabled(true);
			}else {//1.2 未输入司机编号
				String warning = "必须要输入信息!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
			
		}
		if(e.getSource()==submitbutton){
			String realreceiver=rRealText.getText();
			String receivetime=rTimeText.getText();
		
			@SuppressWarnings("unused")
			String ID=IDText.getText(); //快递订单号
	//		String date; //寄件日期
		//	String realReceiver; //实际收件人
	//		String realReceiveDate;//实际收件日期
			OrderFormVO voToAdd;
			try {
				voToAdd = orderFormController.findDriver(IDText.getText());
				voToAdd.setRealReceiveDate(receivetime);
				voToAdd.setRealReceiver(realreceiver);

				orderFormController.submitDriver(voToAdd);	//添加车辆
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	private void textClear() {
		// TODO Auto-generated method stub
	
		IDText.setText(null);
		rRealText.setText(null);
		rTimeText.setText(null);
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
