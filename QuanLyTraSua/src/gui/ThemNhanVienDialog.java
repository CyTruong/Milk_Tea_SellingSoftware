/*
 * Set lại cỡ chữ trong textfied
 * thay chữ = icon
 * chỉnh về giữa màn hình
 * */


package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.Permission;
import dal.QLTS_DatabaseControler;
import mdlaf.MaterialLookAndFeel;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ThemNhanVienDialog extends JDialog {

	private final JPanel panel = new JPanel();
	private JTextField tfTennhanvien;
	private JTextField tfSodienthoai;
	private JTextField tfUsername;
	private JPasswordField passwordField;
	private JPasswordField repasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThemNhanVienDialog dialog = new ThemNhanVienDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThemNhanVienDialog() {
		getContentPane().setBackground(new Color(255, 154, 15));
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		setBounds(100, 100, 879, 691);
		getContentPane().setLayout(null);
		panel.setBackground(new Color(255, 154, 15));
		panel.setBounds(0, 13, 853, 641);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbThemnhanvien = new JLabel("Th\u00EAm nh\u00E2n vi\u00EAn");
		lbThemnhanvien.setForeground(new Color(204, 0, 0));
		lbThemnhanvien.setBackground(Color.WHITE);
		lbThemnhanvien.setFont(new Font("Segoe UI", Font.BOLD, 34));
		lbThemnhanvien.setHorizontalTextPosition(SwingConstants.CENTER);
		lbThemnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lbThemnhanvien.setBounds(10, 11, 846, 62);
		panel.add(lbThemnhanvien);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên: ");
		lblTnNhnVin.setForeground(new Color(204, 0, 0));
		lblTnNhnVin.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTnNhnVin.setBounds(40, 116, 176, 30);
		panel.add(lblTnNhnVin);
		
		tfTennhanvien = new JTextField();
		tfTennhanvien.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfTennhanvien.setBounds(40, 145, 566, 41);
		panel.add(tfTennhanvien);
		tfTennhanvien.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setForeground(new Color(204, 0, 0));
		lblSinThoi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblSinThoi.setBounds(40, 223, 176, 30);
		panel.add(lblSinThoi);
		
		tfSodienthoai = new JTextField();
		tfSodienthoai.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfSodienthoai.setBounds(40, 253, 566, 41);
		panel.add(tfSodienthoai);
		tfSodienthoai.setColumns(10);
		
		JLabel lblTnngNhp = new JLabel("Tên đăng nhập:");
		lblTnngNhp.setForeground(new Color(204, 0, 0));
		lblTnngNhp.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTnngNhp.setBounds(40, 316, 176, 34);
		panel.add(lblTnngNhp);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfUsername.setBounds(42, 350, 564, 41);
		panel.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setForeground(new Color(204, 0, 0));
		lblMtKhu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblMtKhu.setBounds(40, 426, 146, 31);
		panel.add(lblMtKhu);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		passwordField.setBounds(40, 459, 566, 41);
		panel.add(passwordField);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu:");
		lblNhpLiMt.setForeground(new Color(204, 0, 0));
		lblNhpLiMt.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNhpLiMt.setBounds(40, 537, 186, 32);
		panel.add(lblNhpLiMt);
		
		repasswordField = new JPasswordField();
		repasswordField.setFont(new Font("Segoe UI", Font.BOLD, 18));
		repasswordField.setBounds(40, 570, 566, 41);
		panel.add(repasswordField);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.setBackground(new Color(204, 0, 0));
		btnThem.setForeground(Color.WHITE);
		btnThem.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNhanvien();
			}
		});
		btnThem.setBounds(639, 143, 186, 126);
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(204, 0, 0));
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfTennhanvien.setText("");
				tfSodienthoai.setText("");
				tfUsername.setText("");
				passwordField.setText("");
				repasswordField.setText("");	
			}
		});
		btnXoa.setBounds(639, 294, 186, 126);
		panel.add(btnXoa);
		
		JButton btnExit = new JButton("Đóng");
		btnExit.setBackground(new Color(204, 0, 0));
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(639, 453, 186, 139);
		panel.add(btnExit);
		}
	
	private void createNhanvien() {
		String pass = new String(passwordField.getPassword());
		String rePass = new String(repasswordField.getPassword());
		if(pass.equals(rePass)) {
			String hoten = tfTennhanvien.getText();
			String username = tfUsername.getText();
			String sdt = tfSodienthoai.getText();
			int quyen = Permission.SALE_PERMISSION;
			 new Thread(){
		            public void run() {
		             QLTS_DatabaseControler.getInstance().getProcedures().insertNhanvien(hoten, sdt, username, pass,quyen);
		            }
		        }.start();
			ToastMessage toast = new ToastMessage("Thêm nhân viên thành công", 3000);
			toast.setVisible(true);	
			dispose();

			}
		else {
			ToastMessage toast = new ToastMessage("Mật khẩu nhập vào không trùng khớp", 3000);
			toast.setVisible(true);
		}
	}
}
