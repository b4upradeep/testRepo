package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 frame = new Frame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFrame = new JLabel("Frame 2");
		lblFrame.setBounds(144, 83, 46, 14);
		contentPane.add(lblFrame);
		
		JButton btnGoBackTo = new JButton("Go Back to Frame 1");
		btnGoBackTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				new Frame3().setVisible(true);
				
				
				
			}
		});
		btnGoBackTo.setBounds(117, 115, 89, 23);
		contentPane.add(btnGoBackTo);
	}
}
