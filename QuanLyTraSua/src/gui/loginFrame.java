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
import bus.ThongtinquanBus;
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
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.DropMode;

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
		contentPane.setBackground(new Color(255, 154, 15));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBackground(new Color(255,154, 15));
		tfUsername.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tfUsername.setBounds(131, 67, 143, 40);
		contentPane.add(tfUsername);
		
		JButton btLogin = new JButton("\u0110\u0103ng nh\u1EADp");
		btLogin.setBackground(new Color(204, 0, 0));
		btLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btLogin.setForeground(Color.WHITE);
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
		lblTiKhon.setForeground(new Color(204, 0, 0));
		lblTiKhon.setBackground(new Color(255, 154, 16));
		lblTiKhon.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTiKhon.setBounds(20, 84, 79, 23);
		contentPane.add(lblTiKhon);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u");
		lblMtKhu.setForeground(new Color(204, 0, 0));
		lblMtKhu.setBackground(new Color(255, 154, 15));
		lblMtKhu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblMtKhu.setBounds(20, 137, 79, 19);
		contentPane.add(lblMtKhu);
		
		tfPass = new JPasswordField();
		tfPass.setFont(new Font("Segoe UI", Font.BOLD, 14));
		tfPass.setColumns(10);
		tfPass.setBackground(SystemColor.text);
		tfPass.setEchoChar('*');
		tfPass.setBounds(131, 120, 143, 39);
		contentPane.add(tfPass);
		
		loadDrinkingTableContent();
		loadThongtinquan();
	}
	
	private void loadDrinkingTableContent() {
		HoadonBus.getInstance();
	}
	private void loadThongtinquan() {
		try {
			ThongtinquanBus.getInstance().getInfoFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
