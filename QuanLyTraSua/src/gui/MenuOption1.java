package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuOption1 extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MenuOption1 dialog = new MenuOption1();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MenuOption1() {
		setBounds(100, 100, 221, 350);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 195, 318);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JButton btThemloai = new JButton("Th\u00EAm lo\u1EA1i");
		btThemloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemLoaiDoUongDialog diag = new ThemLoaiDoUongDialog();
				diag.setVisible(true);
			}
		});
		btThemloai.setBounds(38, 25, 130, 45);
		contentPanel.add(btThemloai);
		
		JButton btEditloai = new JButton("S\u1EEDa, x\u00F3a lo\u1EA1i");
		btEditloai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ToastMessage toast = new ToastMessage("Chức năng đang cập nhật", 3000);
				toast.setVisible(true);
			}
		});
		btEditloai.setBounds(37, 81, 131, 45);
		contentPanel.add(btEditloai);
		
		JButton btThemdouong = new JButton("Th\u00EAm \u0111\u1ED3 u\u1ED1ng");
		btThemdouong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ThemLoaiDoUongDialog them = new ThemLoaiDoUongDialog();
				them.setVisible(true);
			}
		});
		btThemdouong.setBounds(38, 137, 132, 45);
		contentPanel.add(btThemdouong);
		
		JButton btEditdouong = new JButton("S\u1EEDa x\u00F3a \u0111\u1ED3 u\u1ED1ng");
		btEditdouong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SuaDoUong suaDoUong = new SuaDoUong();
				suaDoUong.setVisible(true);
			}
		});
		btEditdouong.setBounds(38, 193, 130, 45);
		contentPanel.add(btEditdouong);
		
		JButton btback = new JButton("Quay v\u1EC1");
		btback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btback.setBounds(38, 249, 130, 37);
		contentPanel.add(btback);
	}
}
