package test;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class TestInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestInternalFrame frame = new TestInternalFrame();
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
	public TestInternalFrame() {
		setBounds(100, 100, 450, 300);
		
		JLabel lblInternalFrame = new JLabel("Internal Frame 2");
		getContentPane().add(lblInternalFrame, BorderLayout.CENTER);

	}

}
