import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MAINMENU {
	private static double balance = 0;
	private JFrame f2;
	private JFrame WITHDRAW;
	private JPanel p;
	private JButton b0;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b5;
	private JLabel lab;
	private JLabel lab2;

	private JTextField t;
	private JTextField W;
	ArrayList<String> trans= new ArrayList<String>();
	int counter;

	public MAINMENU() { // constructor
		gui();
	}

	public void gui() {
		//FRAME OF MAINMENU
		f2 = new JFrame("ATM MACHINE ");
		f2.setVisible(true);
		f2.setSize(600, 300);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p = new JPanel();
		p.setBackground(Color.CYAN);
		
		//withdraw button
		b1 = new JButton("WITHDRAW");
		b1.addActionListener(new ActionListener() {

			private double withdraw;

			public void actionPerformed(ActionEvent e) {
				double withdraw;
				String amountstring = JOptionPane.showInputDialog("enter amount");

				withdraw = Double.parseDouble(amountstring);
				if (balance < withdraw) {
					JOptionPane.showMessageDialog(W, "your balance is insufficient, please try again ");

				} else {
					balance = balance - withdraw;
    trans.add("withdrawl="+ Double.parseDouble(amountstring));
    counter++;
				}

			}
		}
       );
		
		//deposit button
		
        b2 = new JButton("DEPOSIT");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double deposit;
				String amountstring = JOptionPane.showInputDialog("enter amount");

				deposit = Double.parseDouble(amountstring);
				balance = deposit + balance;
			    trans.add("deposit="+ Double.parseDouble(amountstring));
         counter++;
			}
		});
		
		//balance inquiry button
		b3 = new JButton("BALANCEINQUIRY");
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lab2.setText("Your balance is " + balance + "\n");
			}
		});
		//previous button
		b4 = new JButton("PREVIOUS");
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(counter==0)
					lab2.setText("No previous Transactions ");
				else
					lab2.setText(trans.get(--counter));
				
			}
		});
		//next button
		b5 = new JButton("NEXT");
		b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(counter==trans.size()-1)
					lab2.setText("No more Transactions ");
				else
					lab2.setText(trans.get(++counter));
				
			}
		});
		//labels,frames&pins
		lab = new JLabel();
		lab2 = new JLabel("");

		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);
		p.add(lab);
		p.add(lab2);
		f2.add(p);

	}

}
