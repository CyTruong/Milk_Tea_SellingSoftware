package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import bus.LoginBus;
import dto.NhanvienDto;
import mdlaf.MaterialLookAndFeel;

import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Color;

public class MenuFrame extends JFrame {

		/**
	 * Create the frame.
	 */
	public MenuFrame() {
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
		//h = 50;
		//w = 45;
		gridBagLayout.columnWidths = new int[]{w, w, w, w, w, w, w, w, w, 0};
		gridBagLayout.rowHeights = new int[]{h, h, h, h, h, h, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JButton btnBanhang = new JButton("B\u00E1n h\u00E0ng");
		btnBanhang.setForeground(Color.BLACK);
		btnBanhang.setBackground(Color.GREEN);
		GridBagConstraints gbc_btnBanhang = new GridBagConstraints();
		gbc_btnBanhang.fill = GridBagConstraints.BOTH;
		gbc_btnBanhang.gridwidth = 3;
		gbc_btnBanhang.gridheight = 3;
		gbc_btnBanhang.insets = new Insets(5, 5, 5, 5);
		gbc_btnBanhang.gridx = 0;
		gbc_btnBanhang.gridy = 0;
		getContentPane().add(btnBanhang, gbc_btnBanhang);
		
		JLabel lbNhanvien = new JLabel("New label");
		lbNhanvien.setText(LoginBus.loginUser.hoten);
		GridBagConstraints gbc_lbNhanvien = new GridBagConstraints();
		gbc_lbNhanvien.fill = GridBagConstraints.BOTH;
		gbc_lbNhanvien.gridwidth = 3;
		gbc_lbNhanvien.insets =new Insets(5, 5, 5, 5);
		gbc_lbNhanvien.gridx = 5;
		gbc_lbNhanvien.gridy = 0;
		getContentPane().add(lbNhanvien, gbc_lbNhanvien);
		
		JButton btDongca = new JButton("\u0110\u00F3ng ca");
		GridBagConstraints gbc_btDongca = new GridBagConstraints();
		gbc_btDongca.fill = GridBagConstraints.HORIZONTAL;
		gbc_btDongca.insets =new Insets(5, 5, 5, 5);
		gbc_btDongca.gridx = 8;
		gbc_btDongca.gridy = 0;
		getContentPane().add(btDongca, gbc_btDongca);
		
		JButton btThongke = new JButton("Th\u1ED1ng k\u00EA");
		btThongke.setForeground(Color.ORANGE);
		btThongke.setBackground(Color.BLUE);
		GridBagConstraints gbc_btThongke = new GridBagConstraints();
		gbc_btThongke.fill = GridBagConstraints.BOTH;
		gbc_btThongke.gridheight = 2;
		gbc_btThongke.gridwidth = 2;
		gbc_btThongke.insets = new Insets(5, 5, 5, 5);
		gbc_btThongke.gridx = 3;
		gbc_btThongke.gridy = 2;
		getContentPane().add(btThongke, gbc_btThongke);
		
		JButton btQuanlymon = new JButton("Qu\u1EA3n l\u00FD m\u00F3n");
		btQuanlymon.setForeground(Color.ORANGE);
		btQuanlymon.setBackground(Color.BLUE);
		GridBagConstraints gbc_btQuanlymon = new GridBagConstraints();
		gbc_btQuanlymon.fill = GridBagConstraints.BOTH;
		gbc_btQuanlymon.gridwidth = 2;
		gbc_btQuanlymon.gridheight = 2;
		gbc_btQuanlymon.insets = new Insets(5, 5, 5, 5);
		gbc_btQuanlymon.gridx = 5;
		gbc_btQuanlymon.gridy = 2;
		getContentPane().add(btQuanlymon, gbc_btQuanlymon);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.setBackground(Color.BLUE);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_4.gridheight = 2;
		gbc_btnNewButton_4.gridwidth = 2;
		gbc_btnNewButton_4.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton_4.gridx = 7;
		gbc_btnNewButton_4.gridy = 2;
		getContentPane().add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btCaidat = new JButton("C\u00E0i \u0111\u1EB7t");
		btCaidat.setForeground(Color.ORANGE);
		btCaidat.setBackground(Color.BLUE);
		GridBagConstraints gbc_btCaidat = new GridBagConstraints();
		gbc_btCaidat.fill = GridBagConstraints.BOTH;
		gbc_btCaidat.gridheight = 2;
		gbc_btCaidat.gridwidth = 2;
		gbc_btCaidat.insets =new Insets(5, 5, 5, 5);
		gbc_btCaidat.gridx = 3;
		gbc_btCaidat.gridy = 4;
		getContentPane().add(btCaidat, gbc_btCaidat);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setBackground(Color.BLUE);
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_6.gridheight = 2;
		gbc_btnNewButton_6.gridwidth = 2;
		gbc_btnNewButton_6.insets = new Insets(5, 5, 5, 5);
		gbc_btnNewButton_6.gridx = 5;
		gbc_btnNewButton_6.gridy = 4;
		getContentPane().add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.setBackground(Color.BLUE);
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_7.gridwidth = 2;
		gbc_btnNewButton_7.gridheight = 2;
		gbc_btnNewButton_7.insets = new Insets(5, 5, 5, 05);
		gbc_btnNewButton_7.gridx = 7;
		gbc_btnNewButton_7.gridy = 4;
		getContentPane().add(btnNewButton_7, gbc_btnNewButton_7);
	}
}
