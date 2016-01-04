package presentation.outfindui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.transitController.OrderFormController;
import state.Transportation;
import vo.OrderFormVO;

public class OutfindPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel outfindPanel;
	JLabel IDLabel,StateLabel;
	JTextField IDText,StateText;
	JButton cancelbutton,findbutton;
	private JTable table;

	private Vector<String> columnNames;

	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	public OutfindPanel(){
		outfindPanel=new JPanel();
		cancelbutton=new JButton("取消");
		findbutton=new JButton("查找");
		cancelbutton.addActionListener(this);
		findbutton.addActionListener(this);
		cancelbutton.setContentAreaFilled(false);
		findbutton.setContentAreaFilled(false);
		
		IDLabel=new JLabel("输入订单号");
		StateLabel=new JLabel("    ");
		IDText=new JTextField(20);
		StateText=new JTextField(20);
		
		
		columnNames = new Vector<String>();
		columnNames.add("货运状态");
		columnNames.add("日期");
		tableValues = new Vector<String>();
//		initmodel = new DefaultTableModel();
		
        model = new DefaultTableModel(tableValues,columnNames){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        table = new JTable(30,30);
        
        table.getTableHeader().setReorderingAllowed(false);
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        
//        table = new JTable(tableValues, columnNames);  
//        table.setEnabled(false);
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBackground(Color.WHITE);
        
       
        
		
		Box box1 = Box.createHorizontalBox();
		box1.add(IDLabel);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(IDText);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(findbutton);
		box1.add(Box.createHorizontalStrut(12));
		box1.add(cancelbutton);
		Box box2 = Box.createHorizontalBox();
		box2.add(StateLabel);
		box2.add(Box.createHorizontalStrut(12));
		box2.add(sp);
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box2);
		
		boxH.add(Box.createVerticalGlue());
		JPanel pCenter;
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancelbutton){
			textClear();
		}
if(e.getSource()==findbutton){
			
			String number = "";
			number = IDText.getText();
			
			if(number.length()>0){
				OrderFormVO vo = null;
				OrderFormController orderFormController = new OrderFormController();
				try {
					vo = orderFormController.findDriver(number);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(vo!= null) { //1.1.1 输入的订单号存在
					IDText.setText(vo.getID());
					ArrayList<Transportation> allTransportation=vo.getTransportation();
					ArrayList<String> alldates=vo.getAlldates();
					if(allTransportation!=null){
						for(int i = 0;i<allTransportation.size();i++){
			            	row = new Vector<String>();
			            	
			            	row.add(0,allTransportation.get(i).toString());
			            	row.add(1,alldates.get(i));
			            	model.addRow(row);
			            	
			            }
					}else{
						System.out.println("暂无信息！");
					}
					
					
				}
					
				} else {//1.1.2 输出的订单号不存在
							String warning = "信息不存在,请修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);	
					}//录入结束
				}
	}
	private void textClear() {
		// TODO Auto-generated method stub
		
		IDText.setText(null);
		table.setModel(model);
	}

}
