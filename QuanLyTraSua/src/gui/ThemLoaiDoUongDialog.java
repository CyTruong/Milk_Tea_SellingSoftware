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
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 384);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 651, 409);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblThmLoi = new JLabel("Th\u00EAm lo\u1EA1i \u0111\u1ED3 u\u1ED1ng");
			lblThmLoi.setBounds(10, 10, 631, 37);
			lblThmLoi.setHorizontalTextPosition(SwingConstants.CENTER);
			lblThmLoi.setHorizontalAlignment(SwingConstants.CENTER);
			lblThmLoi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			contentPanel.add(lblThmLoi);
		}
		{
			JLabel lblTnLoi = new JLabel("Tên loại đồ uống");
			lblTnLoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblTnLoi.setBounds(10, 75, 176, 22);
			contentPanel.add(lblTnLoi);
		}
		{
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(10, 120, 614, 41);
			contentPanel.add(textField);
		}
		{
			JButton button = new JButton("close");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button.setBounds(438, 185, 186, 133);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("clear");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText("");
				}
			});
			button.setBounds(238, 188, 186, 133);
			contentPanel.add(button);
		}
		{
			JButton button = new JButton("Thêm");
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
