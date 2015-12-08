package presentation.transitui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import presentation.mainui.MainFrame;

public class RelayFormNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	private JButton jbTransfer,jbCarInput,
					jbArrival;
	private ImageIcon imagelogo,imageTransfer,imageArrival,
					  imageCarInput;
	private ImageIcon imageStart,imageRecall;
	private JTable table;
	private JButton jbstart,jbrecall,jbexit,jbmodify;
	private Box b,b1;
	
	public RelayFormNavigation(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		

		jpanel2 = new JPanel();
		jpanel2 = new JPanel(new GridLayout(7, 1,5,10));
		
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
		
		jbTransfer = new JButton();//中转单
		imageTransfer = new ImageIcon("image/transfer.jpg");
		jbTransfer.setIcon(imageTransfer);
		jbTransfer.setPreferredSize(new Dimension(imageTransfer.getIconWidth(),
				imageTransfer.getIconHeight()));
		jbTransfer.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbTransfer){
					new MainFrame().setContentPane(new RelayFormNavigation());
				}
			}
			
		});
		jbArrival = new JButton();//中转中心到达单
		imageArrival = new ImageIcon("image/arrival.jpg");
		jbArrival.setIcon(imageArrival);
		jbArrival.setPreferredSize(new Dimension(imageArrival.getIconWidth(),
				imageArrival.getIconHeight()));
		jbArrival.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbArrival){
					new MainFrame().setContentPane(new RelayArrivalFormNavigation());
				}
			}
			
		});
		jbCarInput = new JButton();//中转中心装车单
		imageCarInput = new ImageIcon("image/carInput.jpg");
		jbCarInput.setIcon(imageCarInput);
		jbCarInput.setPreferredSize(new Dimension(imageCarInput.getIconWidth(),
				imageCarInput.getIconHeight()));
		jbCarInput.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCarInput){
					new MainFrame().setContentPane(new RelayCarInputFormNavigation());
				}
			}
			
		});
		
		jpanel2.add(jbTransfer);
		jpanel2.add(jbArrival);
		jpanel2.add(jbCarInput);
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：中转中心业务员      当前任务：中转单");
		jlcurrentID.setFont(new Font("当前身份：中转中心业务员       当前任务：中转单",Font.PLAIN,15));

		jbmodify = new JButton("修改密码");
		jbmodify.setFont(new Font("修改密码",Font.PLAIN,12));
		jbmodify.setContentAreaFilled(false);
		
		jbexit = new JButton("退出登录");
		jbexit.setFont(new Font("退出登录",Font.PLAIN,12));
		jbexit.setContentAreaFilled(false);
		
		b = Box.createHorizontalBox();
		b.add(jlcurrentID);
		b.add(Box.createHorizontalGlue());
		b.add(jbmodify);
		b.add(Box.createHorizontalStrut(13));
		b.add(jbexit);
		b.add(Box.createHorizontalStrut(3));
		
		String[] columnNames = { "中转单编号", "创建日期"};  
        String[][] tableValues = { { "A1", "B1" }, { "A2", "B2" },  
                { "A3", "B3" }, { "A4", "B4"}, { "A5", "B5"},
                { "A6", "B6" }};  
        DefaultTableModel model = new DefaultTableModel(tableValues,columnNames){

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        table = new JTable();
        table.setModel(model);
        
//        table = new JTable(tableValues, columnNames); 
//        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				jbstart.setEnabled(false);
				jbrecall.setEnabled(true);
			}
        	
        });
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startform.jpg");
		jbstart.setIcon(imageStart);
		jbstart.setPreferredSize(new Dimension(imageStart.getIconWidth(),
				imageStart.getIconHeight()));
		
		jbrecall = new JButton();
		imageRecall = new ImageIcon("image/startrecall.jpg");
		jbrecall.setIcon(imageRecall);
		jbrecall.setPreferredSize(new Dimension(imageRecall.getIconWidth(),
				imageRecall.getIconHeight()));
		jbrecall.setEnabled(false);
		
		
		jpanel4.add(Box.createHorizontalStrut(520));
		jpanel4.add(jbstart);
		jpanel4.add(Box.createHorizontalStrut(10));
		jpanel4.add(jbrecall);
		jpanel4.add(Box.createHorizontalGlue());

		this.add(jpanel4,BorderLayout.SOUTH);
		this.add(jpanel3,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);

		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
