package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import bus.LoginBus;
import mdlaf.MaterialLookAndFeel;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class MenuFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\UIT\\Môn java\\Milk_Tea_SellingSoftware-master\\Milk_Tea_SellingSoftware-master\\QuanLyTraSua\\res\\bg.jpg"));
		getContentPane().setBackground(new Color(255, 154, 15));
		setResizable(false);
		setUndecorated(true);
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBackground(new Color(255, 154, 15));
		panel.setBounds(0, 0, 685, 1077);
		getContentPane().add(panel);
		panel.setLayout(null);
		JLabel lbNhanvien = new JLabel("New label");
		lbNhanvien.setBounds(0, 0, 0, 0);
		panel.add(lbNhanvien);
		lbNhanvien.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lbNhanvien.setForeground(SystemColor.textHighlightText);
		lbNhanvien.setBackground(new Color(255, 154, 15));
		lbNhanvien.setText(LoginBus.loginUser.hoten);

		JButton btDongca = new JButton("\u0110\u00F3ng ca");
		btDongca.setBounds(171, 794, 400, 100);
		panel.add(btDongca);
		btDongca.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btDongca.setForeground(new Color(150, 0, 0));
		btDongca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btDongca.setBackground(new Color(255, 255, 0));

		JButton btnBanhang = new JButton("B\u00E1n h\u00E0ng");
		btnBanhang.setBounds(171, 277, 400, 100);
		panel.add(btnBanhang);
		btnBanhang.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnBanhang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderFrame frameorder = new OrderFrame();
				frameorder.setVisible(true);
				frameorder.setFocusable(true);
				dispose();
			}
		});
		btnBanhang.setForeground(SystemColor.textHighlightText);
		btnBanhang.setBackground(new Color(150, 0, 0));

		JButton btQuanlymon = new JButton("Qu\u1EA3n l\u00FD m\u00F3n");
		btQuanlymon.setBounds(171, 407, 400, 100);
		panel.add(btQuanlymon);
		btQuanlymon.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btQuanlymon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btQuanlymon.setForeground(SystemColor.textHighlightText);
		btQuanlymon.setBackground(new Color(150, 0, 0));

		JButton btCaidat = new JButton("C\u00E0i \u0111\u1EB7t");
		btCaidat.setBounds(171, 665, 400, 100);
		panel.add(btCaidat);
		btCaidat.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btCaidat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btCaidat.setForeground(SystemColor.textHighlightText);
		btCaidat.setBackground(new Color(150, 0, 0));

		JButton btThongke = new JButton("Th\u1ED1ng k\u00EA");
		btThongke.setBounds(171, 534, 400, 100);
		panel.add(btThongke);
		btThongke.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btThongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btThongke.setForeground(SystemColor.textHighlightText);
		btThongke.setBackground(new Color(150, 0, 0));

		JLabel lblLaSoleil = new JLabel(" La soleil");
		lblLaSoleil.setBackground(new Color(255, 154, 15));
		lblLaSoleil.setForeground(new Color(150, 0, 0));
		lblLaSoleil.setFont(new Font("Vivaldi", Font.BOLD, 86));
		lblLaSoleil.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaSoleil.setBounds(0, 0, 673, 264);
		panel.add(lblLaSoleil);
		
		ImageIcon bg = new ImageIcon("./res/cuptea.jpg");
		JLabel lblNewLabel = new JLabel(bg);
		lblNewLabel.setBackground(new Color(255, 154, 15));
		lblNewLabel.setBounds(684, 0, 1236, 1077);
		getContentPane().add(lblNewLabel);
	}
}
