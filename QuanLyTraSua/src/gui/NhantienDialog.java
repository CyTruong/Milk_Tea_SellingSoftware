package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.PurchaseBus;
import bus.Size;
import bus.printer.Printer_Controler;
import bus.printer.Printer_Controler.PrinterModule;
import dto.ToppingDto;

import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.AbstractListModel;

public class NhantienDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		/*	NhantienDialog dialog = new NhantienDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private JLabel lbtongcong,lbtiennhan,labtienthoi;
	private ArrayList<Order> arg;
	private int Tongtien = 0;
	private int Tiennhan = 0;
	private JPanel panel;

	
	public NhantienDialog(ArrayList<Order> arg) {
		setResizable(false);
		setUndecorated(true);
		this.arg = arg;
		setBounds(100, 100, 657, 532);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(255,199,80));
	
		JButton bt1k = new JButton("1 000");
		bt1k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tiennhan+=1000;
				updateVar();
			}
		});
		bt1k.setBounds(252, 69, 115, 88);
		getContentPane().add(bt1k);
		
		lbtongcong = new JLabel("lbtongcong");
		lbtongcong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbtongcong.setBounds(10, 362, 212, 27);
		getContentPane().add(lbtongcong);
		
		lbtiennhan = new JLabel("lbtiennhan");
		lbtiennhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbtiennhan.setBounds(10, 400, 212, 27);
		lbtiennhan.setText("Tiền nhận : "+ Tiennhan);
		getContentPane().add(lbtiennhan);
		
		JButton button = new JButton("2 000");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tiennhan+=2000;
				updateVar();
			}
		});
		button.setBounds(377, 69, 111, 88);
		getContentPane().add(button);
		
		JButton bt10k = new JButton("10 000");
		bt10k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiennhan+=10000;
				updateVar();
			}
		});
		bt10k.setBounds(252, 168, 115, 89);
		getContentPane().add(bt10k);
		
		JButton bt20k = new JButton("20 000");
		bt20k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiennhan+=20000;
				updateVar();
			}
		});
		bt20k.setBounds(377, 168, 111, 89);
		getContentPane().add(bt20k);
		
		JButton bt100k = new JButton("100 000");
		bt100k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiennhan+=100000;
				updateVar();
			}
		});
		bt100k.setBounds(252, 269, 115, 88);
		getContentPane().add(bt100k);
		
		JButton bt200k = new JButton("200 000");
		bt200k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiennhan+=200000;
				updateVar();
			}
		});
		bt200k.setBounds(377, 268, 111, 89);
		getContentPane().add(bt200k);
		
		JButton bt5k = new JButton("5 000");
		bt5k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiennhan+=5000;
				updateVar();
			}
		});
		bt5k.setBounds(498, 69, 111, 89);
		getContentPane().add(bt5k);
		
		JButton bt50k = new JButton("50 000");
		bt50k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiennhan+=50000;
				updateVar();
			}
		});
		bt50k.setBounds(498, 168, 111, 89);
		getContentPane().add(bt50k);
		
		JButton bt500k = new JButton("500 000");
		bt500k.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiennhan+=500000;
				updateVar();
			}
		});
		bt500k.setBounds(498, 268, 111, 89);
		getContentPane().add(bt500k);
		
		JButton btclear = new JButton("clear");
		btclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiennhan = 0;
				updateVar();
			}
		});
		btclear.setBounds(252, 369, 174, 100);
		getContentPane().add(btclear);
		
		JButton btconfrim = new JButton("confirm");
		btconfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread() {
				public void run() {
					PurchaseBus.getInstance().creatnewOrder();
					for(Order order : arg) {
						PurchaseBus.getInstance().Themmon(order.madouong, order.Size, order.arrTopping);
					}
					PurchaseBus.getInstance().finnishOrder(1, 1, ""	,Tiennhan);
					int index = PurchaseBus.getInstance().getorderIndex();
					Printer_Controler.getInstance().setModule(PrinterModule.REPORTCART);
					Printer_Controler.getInstance().getModule().createInvoice(index);
					Printer_Controler.getInstance().getModule().showReport();
					}
				}.start();
				
				ToastMessage toast = new ToastMessage("Thanh toán thành công", 3000);
				toast.setVisible(true);	
			}
		});
		btconfrim.setBounds(436, 368, 173, 97);
		getContentPane().add(btconfrim);
		
		labtienthoi = new JLabel("lbtongcong");
		labtienthoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labtienthoi.setBounds(10, 438, 212, 27);
		labtienthoi.setText("Tiền thối  : "+ (Tiennhan-Tongtien));
		getContentPane().add(labtienthoi);
		
		JLabel lblTinNhn = new JLabel("Ti\u1EC1n nh\u1EADn");
		lblTinNhn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTinNhn.setHorizontalAlignment(SwingConstants.CENTER);
		lblTinNhn.setBounds(252, 22, 366, 27);
		lblTinNhn.setBackground(new Color(255,199,80));
		getContentPane().add(lblTinNhn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 349, 223, -326);
		getContentPane().add(scrollPane);
		
		panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setBounds(10, 22, 223, 332);
		panel.setBackground(new Color(255,199,123));
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		loadList();
	}
	
	
	private void loadList() {
		Tongtien = 0;
		panel.removeAll();
		panel.repaint();
		for (int i = 0; i < arg.size(); i++) {
			Order order = arg.get(i);
			String size = Size.getSize(order.Size);
			String str = order.tendouong+" ("+size+") : "+order.Giatien;
		
			JLabel label = new JLabel(str);
			label.setPreferredSize(new Dimension(200, 15));
			label.setForeground(new Color(9,81,141));
			label.setBackground(new Color(255,199,123));
			label.setFont(new Font("Tahoma", Font.PLAIN, 13));
			panel.add(label);
			
			for (ToppingDto toppingdto : order.arrTopping) {
				
				JLabel labeltp = new JLabel("+"+toppingdto.tentopping+" : "+toppingdto.giatien);
				labeltp.setPreferredSize(new Dimension(200, 15));
				labeltp.setForeground(new Color(9,81,141));
				labeltp.setBackground(new Color(255,199,123));
				labeltp.setFont(new Font("Tahoma", Font.PLAIN, 13));
				panel.add(labeltp);
				Tongtien+=toppingdto.giatien;
				
			}
			
			
			
			Tongtien+=order.Giatien;
			
			
			panel.revalidate();
			panel.repaint();
			System.out.println(str);
		}
	
		lbtongcong.setText("Tổng tiền : "+Tongtien);
		
	}
	
	private void updateVar() {
		lbtiennhan.setText("Tiền nhận : "+ Tiennhan);
		labtienthoi.setText("Tiền thối  : "+ (Tiennhan-Tongtien));
	}
}
