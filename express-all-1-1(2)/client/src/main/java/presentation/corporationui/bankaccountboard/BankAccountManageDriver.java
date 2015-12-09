/**
 * 银行账户相关面板
 * @author 谭琼
 * 2015年12月4日
 */
package presentation.corporationui.bankaccountboard;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * 整合银行账户的增删改查面板
 */
public class BankAccountManageDriver extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	BankAccountBoardAdd bankAccountBoardAdd = null;//增加银行账户面板
	BankAccountBoardModify bankAccountBoardModify = null;//修改银行账户面板
	BankAccountBoardInquire bankAccountBoardInquire = null;//查询银行账户面板
	BankAccountBoardDelete bankAccountBoardDelete = null;//删除银行账户面板
	JMenuBar bar;
	JMenu fileMenu;
	JMenuItem addmi, modifymi, inquiremi, deletemi;//增、改、查、删菜单项
	CardLayout card = null;
	JLabel label = null;
	JPanel pCenter;

	public BankAccountManageDriver() {
		// 建立菜单栏
		addmi = new JMenuItem("录入银行账户基本信息");
		modifymi = new JMenuItem("修改银行账户基本信息");
		inquiremi = new JMenuItem("查询银行账户基本信息");
		deletemi = new JMenuItem("删除银行账户基本信息");
		bar = new JMenuBar();
		fileMenu = new JMenu("菜单选项");
		fileMenu.add(addmi);
		fileMenu.add(modifymi);
		fileMenu.add(inquiremi);
		fileMenu.add(deletemi);
		bar.add(fileMenu);
		setJMenuBar(bar);

		label = new JLabel("维护银行账户基本信息", JLabel.CENTER);
		label.setFont(new Font("TimesRoman", Font.BOLD, 24));
		label.setForeground(Color.BLUE);

		addmi.addActionListener(this);
		modifymi.addActionListener(this);
		inquiremi.addActionListener(this);
		deletemi.addActionListener(this);
		
		bankAccountBoardAdd = new BankAccountBoardAdd();
		bankAccountBoardModify = new BankAccountBoardModify();
		bankAccountBoardInquire = new BankAccountBoardInquire(this);
		bankAccountBoardDelete = new BankAccountBoardDelete();

		pCenter = new JPanel();
		card = new CardLayout();
		pCenter.setLayout(card);
		pCenter.add("欢迎语界面", label);
		pCenter.add("录入界面", bankAccountBoardAdd);
		pCenter.add("修改界面", bankAccountBoardModify);
		pCenter.add("删除界面", bankAccountBoardDelete);
		add(pCenter, BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				System.exit(0);
			}
		});

		setVisible(true);
		setBounds(560, 250, 420, 380);
		validate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addmi) {
			card.show(pCenter, "录入界面");
		} else if(e.getSource() == modifymi) {
			card.show(pCenter, "修改界面");
		} else if(e.getSource() == inquiremi) {
			bankAccountBoardInquire.setVisible(true);
		} else if(e.getSource() == deletemi) {
			card.show(pCenter, "删除界面");
		}

	}
	
//	public static void main(String[] args) {
//		new BankAccountManageDriver();
//	}

}
