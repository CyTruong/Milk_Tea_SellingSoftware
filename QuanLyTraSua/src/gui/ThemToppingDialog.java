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

public class ThemToppingDialog extends JDialog {
	private JTextField tften;
	private JTextField tfgia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThemToppingDialog dialog = new ThemToppingDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThemToppingDialog() {
		getContentPane().setBackground(new Color(244,164,96));
		setBounds(100, 100, 593, 432);
		getContentPane().setLayout(null);
		
		JLabel lblThmTopping = new JLabel("Th\u00EAm topping");
		lblThmTopping.setForeground(new Color(204, 0, 0));
		lblThmTopping.setBackground(Color.WHITE);
		lblThmTopping.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThmTopping.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmTopping.setFont(new Font("Segoe UI", Font.BOLD, 34));
		lblThmTopping.setBounds(10, 11, 538, 62);
		getContentPane().add(lblThmTopping);
		
		JLabel lblTnTopping = new JLabel("Tên topping:");
		lblTnTopping.setForeground(new Color(204, 0, 0));
		lblTnTopping.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTnTopping.setBounds(30, 97, 176, 30);
		getContentPane().add(lblTnTopping);
		
		tften = new JTextField();
		tften.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tften.setColumns(10);
		tften.setBounds(30, 128, 501, 37);
		getContentPane().add(tften);
		
		JLabel lblGi = new JLabel("Giá: ");
		lblGi.setForeground(new Color(204, 0, 0));
		lblGi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblGi.setBounds(219, 201, 49, 22);
		getContentPane().add(lblGi);
		
		tfgia = new JTextField();
		tfgia.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfgia.setColumns(10);
		tfgia.setBounds(262, 198, 269, 37);
		getContentPane().add(tfgia);
		
		JButton btthem = new JButton("Thêm");
		btthem.setBackground(new Color(204, 0, 0));
		btthem.setForeground(Color.WHITE);
		btthem.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creatnew();
			}
		});
		btthem.setBounds(40, 267, 151, 105);
		getContentPane().add(btthem);
		
		JButton btclear = new JButton("Xóa");
		btclear.setBackground(new Color(204, 0, 0));
		btclear.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btclear.setForeground(Color.WHITE);
		btclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfgia.setText("");
				tften.setText("");
			}
		});
		btclear.setBounds(203, 266, 157, 107);
		getContentPane().add(btclear);
		
		JButton btclose = new JButton("Đóng");
		btclose.setBackground(new Color(204, 0, 0));
		btclose.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btclose.setForeground(Color.WHITE);
		btclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btclose.setBounds(372, 265, 159, 108);
		getContentPane().add(btclose);
	}
	private void creatnew() {
		new Thread(){
            public void run() {
            	int giatien = 0;
            	if(!tfgia.getText().trim().equals("")) {
            		giatien = Integer.parseInt(tfgia.getText().trim());
            	}
            	QLTS_DatabaseControler.getInstance().getProcedures().insertTopping(tften.getText(), giatien);
            }
        }.start();
        ToastMessage toast = new ToastMessage("Th�m topping th�nh c�ng", 3000);
        toast.setVisible(true);
        dispose();
	}
}
