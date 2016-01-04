package presentation.inventoryui.boards;
import java.awt.CardLayout;
import java.awt.Font;
/**
 * 库存盘点面板，中转中心仓库管理人员按区盘点库存，导出excel
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import state.Zone;

public class StorageCountingBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private JLabel jlMessage;
	@SuppressWarnings("rawtypes")
	private JComboBox jcbZone;
	private CardLayout card;
	private JPanel jptables;
	private JTable tablecar,tabletrain,tableplane,tableempty;
	private JButton jbExcel;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StorageCountingBoard(){
		this.setLayout(null);
		this.setTitle("库存盘点");
		this.setBounds(560, 250, 520, 400);
		card = new CardLayout();
		
		jlMessage = new JLabel("请选择需要盘点的仓库：");
		jlMessage.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jlMessage.setBounds(30, 30, 180, 20);
		this.add(jlMessage);
		
		jcbZone = new JComboBox();
		jcbZone.addItem(Zone.CAR.toString());
		jcbZone.addItem(Zone.PLANE.toString());
		jcbZone.addItem(Zone.TRAIN.toString());
		jcbZone.addItem(Zone.EMPTY.toString());
		jcbZone.setSelectedItem(Zone.EMPTY.toString());
		jcbZone.setBounds(200, 30, 100, 25);
		jcbZone.addActionListener(this);
			
		
		this.add(jcbZone);
		
		jptables = new JPanel();
		jptables.setLayout(card);
		/*
		 * 汽车区列表
		 */
		String[] columnNamescar = { "0订单号","入库日期","目的地","区号","排号","架号","位号"};  
        String[][] tableValuescar = { { "A1", "B1","C1","D1","E1","F1","G1"}, { "A2", "B2","C1","D1","E1","F1","G1"},  
                { "A3", "B3","C3","D3","E3","F3","G3"}, { "A4", "B4","C4","D4","E4","F4","G4"}, 
                { "A5", "B5","C5","D5","E5","F5","G5"}, { "A6", "B6","C6","D6","E6","F6","G6"}};  
        DefaultTableModel modelcar = new DefaultTableModel(tableValuescar,columnNamescar){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        tablecar = new JTable();
        tablecar.setModel(modelcar);
        
        JScrollPane scrollPanecar = new JScrollPane(tablecar); 
//		scrollPane.setBounds(3, 70, 500, 150);
        /*
         * 火车区列表
         */
        String[] columnNamestrain = { "2订单号","入库日期","目的地","区号","排号","架号","位号"};  
        String[][] tableValuestrain = { { "A1", "B1","C1","D1","E1","F1","G1"}, { "A2", "B2","C1","D1","E1","F1","G1"},  
                { "A3", "B3","C3","D3","E3","F3","G3"}, { "A4", "B4","C4","D4","E4","F4","G4"}, 
                { "A5", "B5","C5","D5","E5","F5","G5"}, { "A6", "B6","C6","D6","E6","F6","G6"}};  
        DefaultTableModel modeltrain = new DefaultTableModel(tableValuestrain,columnNamestrain){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        tabletrain = new JTable();
        tabletrain.setModel(modeltrain);
        
        JScrollPane scrollPanetrain = new JScrollPane(tabletrain); 
        
        /*
         * 飞机区列表
         */
        String[] columnNamesplane = { "1订单号","入库日期","目的地","区号","排号","架号","位号"};  
        String[][] tableValuesplane = { { "A1", "B1","C1","D1","E1","F1","G1"}, { "A2", "B2","C1","D1","E1","F1","G1"},  
                { "A3", "B3","C3","D3","E3","F3","G3"}, { "A4", "B4","C4","D4","E4","F4","G4"}, 
                { "A5", "B5","C5","D5","E5","F5","G5"}, { "A6", "B6","C6","D6","E6","F6","G6"}};  
        DefaultTableModel modelplane = new DefaultTableModel(tableValuesplane,columnNamesplane){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        tableplane = new JTable();
        tableplane.setModel(modelplane);
        
        JScrollPane scrollPaneplane = new JScrollPane(tableplane); 
        
        /*
         * 机动区列表
         */
        String[] columnNamesempty = { "3订单号","入库日期","目的地","区号","排号","架号","位号"};  
        String[][] tableValuesempty = { { "A1", "B1","C1","D1","E1","F1","G1"}, { "A2", "B2","C1","D1","E1","F1","G1"},  
                { "A3", "B3","C3","D3","E3","F3","G3"}, { "A4", "B4","C4","D4","E4","F4","G4"}, 
                { "A5", "B5","C5","D5","E5","F5","G5"}, { "A6", "B6","C6","D6","E6","F6","G6"}};  
        DefaultTableModel modelempty = new DefaultTableModel(tableValuesempty,columnNamesempty){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        tableempty = new JTable();
        tableempty.setModel(modelempty);
        
        JScrollPane scrollPaneempty = new JScrollPane(tableempty); 
        
		jptables.add("汽车区列表", scrollPanecar);
		jptables.add("飞机区列表", scrollPaneplane);
		jptables.add("火车区列表", scrollPanetrain);
		jptables.add("机动区列表", scrollPaneempty);
		jptables.setBounds(5, 70, 500, 220);
		
		this.add(jptables);
		
		jbExcel = new JButton();
		jbExcel.setText("导出Excel");
		jbExcel.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jbExcel.setBounds(380, 320, 120, 25);
		this.add(jbExcel);
		
		jbExcel.addActionListener(this);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == jcbZone){
			int i = jcbZone.getSelectedIndex();
			switch(i){
			case 0:card.show(jptables, "汽车区列表");break;
			case 1:card.show(jptables, "飞机区列表");break;
			case 2:card.show(jptables, "火车区列表");break;
			case 3:card.show(jptables, "机动区列表");break;
			}
		}
		if(e.getSource() == jbExcel){
			//ToDo导出为Excel报表
		}
		
	}

	public static void main(String[] args) {
		new StorageCountingBoard();
	}
}
