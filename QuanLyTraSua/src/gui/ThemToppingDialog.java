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
		setBounds(100, 100, 593, 432);
		getContentPane().setLayout(null);
		
		JLabel lblThmTopping = new JLabel("Th\u00EAm topping");
		lblThmTopping.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThmTopping.setHorizontalAlignment(SwingConstants.CENTER);
		lblThmTopping.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblThmTopping.setBounds(10, 11, 538, 62);
		getContentPane().add(lblThmTopping);
		
		JLabel lblTnTopping = new JLabel("T\u00EAn topping");
		lblTnTopping.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnTopping.setBounds(20, 85, 176, 22);
		getContentPane().add(lblTnTopping);
		
		tften = new JTextField();
		tften.setColumns(10);
		tften.setBounds(30, 128, 501, 37);
		getContentPane().add(tften);
		
		JLabel lblGi = new JLabel("Gi\u00E1");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGi.setBounds(221, 201, 49, 22);
		getContentPane().add(lblGi);
		
		tfgia = new JTextField();
		tfgia.setColumns(10);
		tfgia.setBounds(280, 186, 251, 37);
		getContentPane().add(tfgia);
		
		JButton btthem = new JButton("Thêm");
		btthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				creatnew();
			}
		});
		btthem.setBounds(22, 267, 159, 119);
		getContentPane().add(btthem);
		
		JButton btclear = new JButton("clear");
		btclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfgia.setText("");
				tften.setText("");
			}
		});
		btclear.setBounds(205, 265, 171, 122);
		getContentPane().add(btclear);
		
		JButton btclose = new JButton("close");
		btclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btclose.setBounds(396, 264, 171, 125);
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
        ToastMessage toast = new ToastMessage("Thêm topping thành công", 3000);
        toast.setVisible(true);
        dispose();
	}
}
