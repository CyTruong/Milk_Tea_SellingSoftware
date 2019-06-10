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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import bus.LoginBus;
import mdlaf.MaterialLookAndFeel;

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
		getContentPane().setBackground(new Color(244, 164, 96));
	setResizable(false);
	setUndecorated(true);
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	try {
		UIManager.setLookAndFeel(new MaterialLookAndFeel ());
	} catch (UnsupportedLookAndFeelException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	GridBagLayout gridBagLayout = new GridBagLayout();
	int h = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 6);
	int w = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 9);
	gridBagLayout.columnWidths = new int[]{w, w, w, w, w, w, w, w, 223, 0};
	gridBagLayout.rowHeights = new int[]{h, h, h, h, h, h, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	getContentPane().setLayout(gridBagLayout);
	
	JLabel lbNhanvien = new JLabel("New label");
	lbNhanvien.setFont(new Font("Segoe UI", Font.BOLD, 30));
	lbNhanvien.setForeground(SystemColor.textHighlightText);
	lbNhanvien.setBackground(new Color(244, 164, 96));
	lbNhanvien.setText(LoginBus.loginUser.hoten);
	GridBagConstraints gbc_lbNhanvien = new GridBagConstraints();
	gbc_lbNhanvien.fill = GridBagConstraints.BOTH;
	gbc_lbNhanvien.insets =new Insets(5, 5, 5, 5);
	gbc_lbNhanvien.gridx = 6;
	gbc_lbNhanvien.gridy = 0;
	getContentPane().add(lbNhanvien, gbc_lbNhanvien);
	
	JButton btnBanhang = new JButton("B\u00E1n h\u00E0ng");
	btnBanhang.setFont(new Font("Segoe UI", Font.BOLD, 34));
	btnBanhang.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			OrderFrame frameorder = new OrderFrame();
			frameorder.setVisible(true);
			frameorder.setFocusable(true);
			dispose();
		}
	});
	
	JButton btDongca = new JButton("\u0110\u00F3ng ca");
	btDongca.setFont(new Font("Segoe UI", Font.BOLD, 30));
	btDongca.setForeground(SystemColor.textHighlightText);
	btDongca.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btDongca.setBackground(new Color(166,42,0));
	GridBagConstraints gbc_btDongca = new GridBagConstraints();
	gbc_btDongca.gridwidth = 2;
	gbc_btDongca.fill = GridBagConstraints.BOTH;
	gbc_btDongca.insets =new Insets(5, 5, 5, 5);
	gbc_btDongca.gridx = 7;
	gbc_btDongca.gridy = 0;
	getContentPane().add(btDongca, gbc_btDongca);
	btnBanhang.setForeground(SystemColor.textHighlightText);
	btnBanhang.setBackground( new Color(255,65,0));
	GridBagConstraints gbc_btnBanhang = new GridBagConstraints();
	gbc_btnBanhang.gridheight = 2;
	gbc_btnBanhang.fill = GridBagConstraints.BOTH;
	gbc_btnBanhang.gridwidth = 2;
	gbc_btnBanhang.insets = new Insets(5, 5, 5, 5);
	gbc_btnBanhang.gridx = 1;
	gbc_btnBanhang.gridy = 2;
	getContentPane().add(btnBanhang, gbc_btnBanhang);
	
	JButton btQuanlymon = new JButton("Qu\u1EA3n l\u00FD m\u00F3n");
	btQuanlymon.setFont(new Font("Segoe UI", Font.BOLD, 34));
	btQuanlymon.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btQuanlymon.setForeground(SystemColor.textHighlightText);
	btQuanlymon.setBackground(new Color(191,84,48));
	GridBagConstraints gbc_btQuanlymon = new GridBagConstraints();
	gbc_btQuanlymon.gridwidth = 2;
	gbc_btQuanlymon.gridheight = 2;
	gbc_btQuanlymon.fill = GridBagConstraints.BOTH;
	gbc_btQuanlymon.insets = new Insets(5, 5, 5, 5);
	gbc_btQuanlymon.gridx = 3;
	gbc_btQuanlymon.gridy = 3;
	getContentPane().add(btQuanlymon, gbc_btQuanlymon);
	
	JButton btCaidat = new JButton("C\u00E0i \u0111\u1EB7t");
	btCaidat.setFont(new Font("Segoe UI", Font.BOLD, 34));
	btCaidat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	
	JLabel lbThongTin = new JLabel("New label");
	lbThongTin.setFont(new Font("Segoe UI", Font.BOLD, 20));
	lbThongTin.setBackground(new Color(244, 164, 96));
	lbThongTin.setForeground(SystemColor.textHighlightText);
	GridBagConstraints gbc_lbThongTin = new GridBagConstraints();
	gbc_lbThongTin.gridheight = 3;
	gbc_lbThongTin.insets = new Insets(0, 0, 5, 5);
	gbc_lbThongTin.gridx = 6;
	gbc_lbThongTin.gridy = 2;
	getContentPane().add(lbThongTin, gbc_lbThongTin);
	btCaidat.setForeground(SystemColor.textHighlightText);
	btCaidat.setBackground(new Color(255,113,64));
	GridBagConstraints gbc_btCaidat = new GridBagConstraints();
	gbc_btCaidat.gridwidth = 2;
	gbc_btCaidat.fill = GridBagConstraints.BOTH;
	gbc_btCaidat.insets =new Insets(5, 5, 5, 5);
	gbc_btCaidat.gridx = 3;
	gbc_btCaidat.gridy = 2;
	getContentPane().add(btCaidat, gbc_btCaidat);
	
	JButton btThongke = new JButton("Th\u1ED1ng k\u00EA");
	btThongke.setFont(new Font("Segoe UI", Font.BOLD, 34));
	btThongke.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		}
	});
	btThongke.setForeground(SystemColor.textHighlightText);
	btThongke.setBackground(new Color(166,42,0));
	GridBagConstraints gbc_btThongke = new GridBagConstraints();
	gbc_btThongke.fill = GridBagConstraints.BOTH;
	gbc_btThongke.gridwidth = 2;
	gbc_btThongke.insets = new Insets(5, 5, 5, 5);
	gbc_btThongke.gridx = 1;
	gbc_btThongke.gridy = 4;
	getContentPane().add(btThongke, gbc_btThongke);
}
}
