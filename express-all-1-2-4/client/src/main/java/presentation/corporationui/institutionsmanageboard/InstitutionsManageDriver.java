/**
 * @author 陶子涵
 * 2015/12/11
 */
package presentation.corporationui.institutionsmanageboard;

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

public class InstitutionsManageDriver extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	InstitutionsManageBoardAdd institutionsManageBoardAdd = null;
	InstitutionsManageBoardDelete institutionsManageBoardDelete = null;
	JMenuBar bar;
	JMenu fileMenu;
	JMenuItem addmi, deletemi;
	Container con = null;
	CardLayout card = null;
	JLabel label = null;
	JPanel pCenter;
	
	public InstitutionsManageDriver(){
		//建立菜单栏
		addmi = new JMenuItem("增加新的机构信息");
		deletemi = new JMenuItem("删除机构基本信息");
		bar = new JMenuBar();
		fileMenu = new JMenu("菜单选项");
		fileMenu.add(addmi);
		fileMenu.add(deletemi);
		bar.add(fileMenu);
		setJMenuBar(bar);
		label = new JLabel("维护机构基本信息", JLabel.CENTER);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 24));
		label.setForeground(Color.DARK_GRAY);
		//对菜单项进行监听
		addmi.addActionListener(this);
		deletemi.addActionListener(this);
		card = new CardLayout();
		con = getContentPane();
		pCenter = new JPanel();
		pCenter.setLayout(card);
		
		institutionsManageBoardAdd = new InstitutionsManageBoardAdd();
		institutionsManageBoardDelete = new InstitutionsManageBoardDelete();
				
		pCenter.add("欢迎语界面", label);
		pCenter.add("录入界面", institutionsManageBoardAdd);
		pCenter.add("删除界面", institutionsManageBoardDelete);
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
		} else if (e.getSource() == deletemi) {
			card.show(pCenter, "删除界面");
		}
	}
	public static void main(String args[]) {
		new InstitutionsManageDriver();
	}
}
	

