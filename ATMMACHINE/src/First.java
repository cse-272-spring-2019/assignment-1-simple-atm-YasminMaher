import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class First {
	private JFrame f1;
	private JPanel jp;
	private JButton b0;
	private JLabel jl;

	
	private JTextField jt;

	public First() {
		gui();
	}

	private void gui() {
		String pass = "123";

		f1 = new JFrame("Welcome To the ATM Machine  ");
		f1.setVisible(true);

		f1.setSize(600, 600);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jl = new JLabel();

		jt = new JTextField(10);
		b0 = new JButton("submit");
		jl.setText("Enter PIN :");
		jp = new JPanel();

		jp.setBackground(Color.cyan);

		jp.add(jl);
		jp.add(jt);
		jp.add(b0);
		f1.add(jp);
		f1.setVisible(true);
		b0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String get = jt.getText();

				if (get.equals(pass)) {
					JOptionPane.showMessageDialog(f1, "Access Prevailed.");
					MAINMENU f = new MAINMENU();

					f1.setVisible(false);

				} else {
					
					JOptionPane.showMessageDialog(f1, "Access Denied");
				}

			}
		});

	}
}
