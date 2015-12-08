/**
 * @author 谭琼
 * 2015年12月5日
 */
package presentation.corporationui.bankaccountboard;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class NewClass {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
//		JComboBox bar = new JComboBox();
		final JTextField textField = new JTextField();
//		Component com = bar.getEditor().getEditorComponent();
		final String[] datas = new String[] { "123123", "234123", "345123", "456123", "567123", "678123", "677123" };
//		final JTextComponent component = (JTextComponent) com;
		final JList p = new JList(datas);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (textField.getText() == null || textField.getText().length() == 0) {
					return;
				}
				for (int i = 0; i < datas.length; i++) {
					if (datas[i].toLowerCase().startsWith(textField.getText())) {
						p.setSelectedValue(datas[i], true);
						String str = textField.getText();
						textField.setText(datas[i]);
						textField.setSelectionStart(str.length());
						textField.setSelectionEnd(datas[i].length());
					}
				}
			}
		});
		textField.setEditable(true);
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		frame.getContentPane().add(new JScrollPane(p), BorderLayout.CENTER);
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
	}

}
