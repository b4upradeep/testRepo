package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class FrameTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameTest window = new FrameTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(723, 471, 1, 1);
		frame.getContentPane().add(desktopPane);
		
		JInternalFrame internalFrame = new JInternalFrame("Login");
		internalFrame.setBounds(0, 0, 724, 472);
		frame.getContentPane().add(internalFrame);
		
		JMenuBar menuBar_1 = new JMenuBar();
		internalFrame.setJMenuBar(menuBar_1);
		internalFrame.getContentPane().setLayout(null);
		
		JButton btnClick = new JButton("Click");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnClick.setBounds(124, 139, 89, 23);
		internalFrame.getContentPane().add(btnClick);
		
		JMenu mnUser = new JMenu("Student");
		menuBar_1.add(mnUser);
		
		JMenuItem mntmSignUp = new JMenuItem("Sign Up");
		mntmSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.getContentPane().add(new TestInternalFrame());
				frame.getContentPane().remove(internalFrame);
//				internalFrame.getContentPane().add(btnClick);
			}
		});
		mnUser.add(mntmSignUp);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mnUser.add(mntmLogin);
		
		JMenu mnFaculty = new JMenu("Faculty");
		menuBar_1.add(mnFaculty);
		
		JMenuItem mntmSignUp_1 = new JMenuItem("Sign Up");
		mnFaculty.add(mntmSignUp_1);
		
		JMenuItem mntmLogIn = new JMenuItem("Log In");
		mnFaculty.add(mntmLogIn);
		internalFrame.setVisible(true);
	}
}
