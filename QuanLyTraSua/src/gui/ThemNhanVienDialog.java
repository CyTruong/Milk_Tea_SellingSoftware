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
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		setBounds(100, 100, 879, 691);
		getContentPane().setLayout(null);
		panel.setBounds(0, 0, 853, 641);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lbThemnhanvien = new JLabel("Th\u00EAm nh\u00E2n vi\u00EAn");
		lbThemnhanvien.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lbThemnhanvien.setHorizontalTextPosition(SwingConstants.CENTER);
		lbThemnhanvien.setHorizontalAlignment(SwingConstants.CENTER);
		lbThemnhanvien.setBounds(10, 11, 846, 62);
		panel.add(lbThemnhanvien);
		
		JLabel lblTnNhnVin = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnNhnVin.setBounds(10, 110, 176, 22);
		panel.add(lblTnNhnVin);
		
		tfTennhanvien = new JTextField();
		tfTennhanvien.setBounds(10, 143, 566, 41);
		panel.add(tfTennhanvien);
		tfTennhanvien.setColumns(10);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSinThoi.setBounds(10, 206, 176, 22);
		panel.add(lblSinThoi);
		
		tfSodienthoai = new JTextField();
		tfSodienthoai.setBounds(10, 249, 566, 41);
		panel.add(tfSodienthoai);
		tfSodienthoai.setColumns(10);
		
		JLabel lblTnngNhp = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblTnngNhp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnngNhp.setBounds(10, 315, 146, 22);
		panel.add(lblTnngNhp);
		
		tfUsername = new JTextField();
		tfUsername.setBounds(12, 348, 564, 41);
		panel.add(tfUsername);
		tfUsername.setColumns(10);
		
		JLabel lblMtKhu = new JLabel("M\u1EADt kh\u1EA9u");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMtKhu.setBounds(10, 415, 146, 22);
		panel.add(lblMtKhu);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 459, 566, 41);
		panel.add(passwordField);
		
		JLabel lblNhpLiMt = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNhpLiMt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNhpLiMt.setBounds(10, 525, 146, 22);
		panel.add(lblNhpLiMt);
		
		repasswordField = new JPasswordField();
		repasswordField.setBounds(10, 570, 566, 41);
		panel.add(repasswordField);
		
		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createNhanvien();
			}
		});
		btnThem.setBounds(639, 143, 186, 126);
		panel.add(btnThem);
		
		JButton btnXoa = new JButton("clear");
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
		
		JButton btnExit = new JButton("close");
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
