package gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.LoginBus;
import bus.LoginBus.Login_result;
import bus.HoadonBus;
import mdlaf.MaterialLookAndFeel;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class loginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JPasswordField tfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame() {
		setResizable(false);
		setTitle("Login");
		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel ());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(131, 84, 143, 23);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		JButton btLogin = new JButton("\u0110\u0103ng nh\u1EADp");
		btLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btLogin.setForeground(Color.BLACK);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginBus login = new LoginBus(tfUsername.getText(),new String(tfPass.getPassword()));
				System.out.println(tfUsername.getText()+" "+new String(tfPass.getPassword()));
				LoginBus.Login_result login_result = Login_result.ERROR;
				try {
					login_result= login.doLogin();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(login_result == Login_result.LOGIN_COMPLETE) {
					JOptionPane.showMessageDialog((JPanel)getContentPane(),"Login success","login", JOptionPane.INFORMATION_MESSAGE);
					MenuFrame menuframe = new MenuFrame();
					menuframe.setVisible(true);
					menuframe.setFocusable(true);
					dispose();
				}
		
			}
		});
		btLogin.setBounds(90, 187, 126, 40);
		contentPane.add(btLogin);
		
		JLabel lblTiKhon = new JLabel("T\u00E0i kho\u1EA3n");
		lblTiKhon.setBounds(20, 84, 79, 23);
		contentPane.add(lblTiKhon);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u");
		lblMtKhu.setBounds(20, 137, 79, 19);
		contentPane.add(lblMtKhu);
		
		tfPass = new JPasswordField();
		tfPass.setEchoChar('*');
		tfPass.setBounds(131, 136, 143, 20);
		contentPane.add(tfPass);
		
		loadDrinkingTableContent();
	}
	
	private void loadDrinkingTableContent() {
		HoadonBus.getInstance();
	}
}
