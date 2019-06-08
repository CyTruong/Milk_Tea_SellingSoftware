package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.Icon;

public class OrderFrame extends JFrame{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTable table;
	private JTextField textField;
	public OrderFrame() {
		getContentPane().setBackground(new Color(244, 164, 96));
		setUndecorated(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 106, 1021, 404);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		ImageIcon icon = new ImageIcon("images/mtlen.png");
		JLabel lbmtl = new JLabel(icon);
		lbmtl.setForeground(Color.WHITE);
		lbmtl.setBackground(new Color(244,164,96));
		lbmtl.setLocation(376, 588);
		lbmtl.setSize(135, 70);
		getContentPane().add(lbmtl);
		
		ImageIcon icon1 = new ImageIcon("images/mtxuong.png");
		JLabel lbmtx = new JLabel(icon1);
		lbmtx.setForeground(Color.WHITE);
		lbmtx.setBackground(new Color(204,0,0));
		lbmtx.setLocation(376, 960);
		lbmtx.setSize(135, 70);
		getContentPane().add(lbmtx);
		
		
		DefaultListModel<String> defaultListModel = new DefaultListModel<>();
	    defaultListModel.addElement("Trà sữa");
	    defaultListModel.addElement("Sinh tố");
	    defaultListModel.addElement("Cà phê");
	    defaultListModel.addElement("Trà");
		
	    ImageIcon home = new ImageIcon("images/home.png");
		JButton btnTrangCh = new JButton("  " + "Trang chủ");
		btnTrangCh.setIcon(home);
		btnTrangCh.setForeground(Color.WHITE);
		btnTrangCh.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnTrangCh.setBackground(new Color(204, 0, 0));
		btnTrangCh.setBounds(1579, 47, 297, 70);
		getContentPane().add(btnTrangCh);
		
		JLabel lblThLoi = new JLabel("Thể loại");
		lblThLoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblThLoi.setForeground(new Color(204,0,0));
		lblThLoi.setBackground(new Color(204,0,0));
		lblThLoi.setFont(new Font("Segoe UI", Font.BOLD, 34));
		lblThLoi.setBounds(176, 529, 148, 46);
		getContentPane().add(lblThLoi);
		
		JLabel lblDanhSch = new JLabel("Danh sách đồ uống");
		lblDanhSch.setHorizontalAlignment(SwingConstants.LEFT);
		lblDanhSch.setForeground(new Color(204, 0, 0));
		lblDanhSch.setFont(new Font("Segoe UI", Font.BOLD, 34));
		lblDanhSch.setBackground(new Color(204, 0, 0));
		lblDanhSch.setBounds(544, 529, 327, 46);
		getContentPane().add(lblDanhSch);
		
		JLabel lblTngTin = new JLabel("Tổng tiền");
		lblTngTin.setHorizontalAlignment(SwingConstants.LEFT);
		lblTngTin.setForeground(new Color(204, 0, 0));
		lblTngTin.setFont(new Font("Segoe UI", Font.BOLD, 34));
		lblTngTin.setBackground(new Color(204, 0, 0));
		lblTngTin.setBounds(93, 47, 187, 46);
		getContentPane().add(lblTngTin);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 30));
		textField.setBounds(277, 47, 254, 42);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		ImageIcon dele = new ImageIcon("images/delete.png");
		JButton btnNewButton = new JButton("  "+ "Xóa món");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(dele);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnNewButton.setBackground(new Color(204,0,0));
		btnNewButton.setBounds(1180, 205, 297, 80);
		getContentPane().add(btnNewButton);
		
		JButton btnTrSa = new JButton("Trà sữa");
		btnTrSa.setForeground(Color.WHITE);
		btnTrSa.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnTrSa.setBackground(new Color(204, 0, 0));
		btnTrSa.setBounds(93, 588, 300, 100);
		getContentPane().add(btnTrSa);
		
		JButton btnSinhT = new JButton("Sinh tố");
		btnSinhT.setForeground(Color.WHITE);
		btnSinhT.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnSinhT.setBackground(new Color(204, 0, 0));
		btnSinhT.setBounds(93, 702, 300, 100);
		getContentPane().add(btnSinhT);
		
		JButton btnCPh = new JButton("Cà phê");
		btnCPh.setForeground(Color.WHITE);
		btnCPh.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnCPh.setBackground(new Color(204, 0, 0));
		btnCPh.setBounds(93, 817, 300, 100);
		getContentPane().add(btnCPh);
		
		JButton btnTr = new JButton("Trà");
		btnTr.setForeground(Color.WHITE);
		btnTr.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnTr.setBackground(new Color(204, 0, 0));
		btnTr.setBounds(93, 930, 300, 100);
		getContentPane().add(btnTr);
		
		JPanel panel = new JPanel();
		panel.setBounds(554, 588, 805, 441);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		ImageIcon print = new ImageIcon("images/printer.png");
		JButton button = new JButton("  " + "In hóa đơn");
		button.setForeground(Color.WHITE);
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setIcon(print);
		button.setFont(new Font("Segoe UI", Font.BOLD, 30));
		button.setBackground(new Color(204, 0, 0));
		button.setBounds(1180, 319, 297, 80);
		getContentPane().add(button);
		
		ImageIcon cup = new ImageIcon("images/cup.png");
		JLabel lblNewLabel = new JLabel(cup);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(1543, 152, 329, 239);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel(icon);
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(244, 164, 96));
		label.setBounds(1337, 588, 135, 70);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel(icon1);
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(new Color(204, 0, 0));
		label_1.setBounds(1337, 960, 135, 70);
		getContentPane().add(label_1);
		
		ImageIcon menu = new ImageIcon("images/menu.png");
		JLabel lblNewLabel_1 = new JLabel(menu);
		lblNewLabel_1.setBounds(1522, 588, 354, 386);
		getContentPane().add(lblNewLabel_1);
		
		
	}
}
