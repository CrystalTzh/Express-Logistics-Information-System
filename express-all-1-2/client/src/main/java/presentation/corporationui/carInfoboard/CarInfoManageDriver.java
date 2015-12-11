package presentation.corporationui.carInfoboard;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
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

public class CarInfoManageDriver extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CarBoardAdd carBoardAdd = null;
	CarBoardModify carBoardModify = null;
	CarBoardInquire carBoardInquire = null;
	CarBoardDelete carBoardDelete = null;
	JMenuBar bar;
	JMenu fileMenu;
	JMenuItem addmi, modifymi, inquiremi, deletemi;
	Container con = null;
	CardLayout card = null;
	JLabel label = null;
	JPanel pCenter;

	public CarInfoManageDriver() {
		//建立菜单栏
		addmi = new JMenuItem("录入车辆基本信息");
		modifymi = new JMenuItem("修改车辆基本信息");
		inquiremi = new JMenuItem("查询车辆基本信息");
		deletemi = new JMenuItem("删除车辆基本信息");
		bar = new JMenuBar();
		fileMenu = new JMenu("菜单选项");
		fileMenu.add(addmi);
		fileMenu.add(modifymi);
		fileMenu.add(inquiremi);
		fileMenu.add(deletemi);
		bar.add(fileMenu);
		setJMenuBar(bar);
		label = new JLabel("维护车辆基本信息", JLabel.CENTER);
		label.setFont(new Font("TimesRoman", Font.BOLD, 24));
		label.setForeground(Color.red);
		//对菜单项进行监听
		addmi.addActionListener(this);
		modifymi.addActionListener(this);
		inquiremi.addActionListener(this);
		deletemi.addActionListener(this);
		card = new CardLayout();
		con = getContentPane();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		
		carBoardAdd = new CarBoardAdd();
		carBoardModify = new CarBoardModify();
		carBoardInquire = new CarBoardInquire(this);
		carBoardDelete = new CarBoardDelete();
		
		pCenter.add("欢迎语界面", label);
		pCenter.add("录入界面", carBoardAdd);
		pCenter.add("修改界面", carBoardModify);
		pCenter.add("删除界面", carBoardDelete);
		con.add(pCenter, BorderLayout.CENTER);
		con.validate();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				System.exit(0);
			}
		});
		setVisible(true);
		setBounds(560, 250, 420, 380);
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		//卡片布局能够让多个组件共享同一个显示空间
		if (e.getSource() == addmi) {
			card.show(pCenter, "录入界面");
		} else if (e.getSource() == modifymi) {
			card.show(pCenter, "修改界面");
		} else if (e.getSource() == inquiremi) {
			carBoardInquire.setVisible(true);
		} else if (e.getSource() == deletemi) {
			card.show(pCenter, "删除界面");
		}
	}

	public static void main(String args[]) {
		new CarInfoManageDriver();
	}
}
