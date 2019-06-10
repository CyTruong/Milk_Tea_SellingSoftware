package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dal.QLTS_DatabaseControler;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ThemLoaiDoUongDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThemLoaiDoUongDialog dialog = new ThemLoaiDoUongDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThemLoaiDoUongDialog() {
		getContentPane().setBackground(new Color(255, 164, 96));
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 384);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(244, 164, 96));
		contentPanel.setBounds(0, 0, 651, 409);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblThmLoi = new JLabel("Th\u00EAm lo\u1EA1i \u0111\u1ED3 u\u1ED1ng");
			lblThmLoi.setForeground(new Color(204, 0, 0));
			lblThmLoi.setBounds(10, 10, 631, 37);
			lblThmLoi.setHorizontalTextPosition(SwingConstants.CENTER);
			lblThmLoi.setHorizontalAlignment(SwingConstants.CENTER);
			lblThmLoi.setFont(new Font("Segoe UI", Font.BOLD, 34));
			contentPanel.add(lblThmLoi);
		}
		{
			JLabel lblTnLoi = new JLabel("Tên loại đồ uống");
			lblTnLoi.setForeground(new Color(204, 0, 0));
			lblTnLoi.setFont(new Font("Segoe UI", Font.BOLD, 20));
			lblTnLoi.setBounds(10, 75, 176, 32);
			contentPanel.add(lblTnLoi);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Segoe UI", Font.BOLD, 18));
			textField.setColumns(10);
			textField.setBounds(10, 120, 614, 41);
			contentPanel.add(textField);
		}
		{
			JButton btnng = new JButton("Đóng");
			btnng.setBackground(new Color(204,0 , 0));
			btnng.setFont(new Font("Segoe UI", Font.BOLD, 28));
			btnng.setForeground(Color.WHITE);
			btnng.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnng.setBounds(438, 185, 186, 133);
			contentPanel.add(btnng);
		}
		{
			JButton btnXa = new JButton("Xóa");
			btnXa.setBackground(new Color(204,0, 0));
			btnXa.setFont(new Font("Segoe UI", Font.BOLD, 28));
			btnXa.setForeground(Color.WHITE);
			btnXa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText("");
				}
			});
			btnXa.setBounds(238, 188, 186, 133);
			contentPanel.add(btnXa);
		}
		{
			JButton button = new JButton("Thêm");
			button.setBackground(new Color(204, 0, 0));
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Segoe UI", Font.BOLD, 28));
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					creatnewLoaidouong();
				}
			});
			button.setBounds(30, 191, 186, 127);
			contentPanel.add(button);
		}
	}
	
	private void creatnewLoaidouong() {
		String tenloai = textField.getText();
		new Thread(){
            public void run() {
        		QLTS_DatabaseControler.getInstance().getProcedures().insertLoaiDoUong(tenloai);
            }
        }.start();
		ToastMessage toast = new ToastMessage("Thêm loại đồ uống thành công", 3000);
		toast.setVisible(true);
		dispose();
	}

}
