package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class PickTableFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PickTableFrame frame = new PickTableFrame();
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
	public PickTableFrame() {
		setUndecorated(true);
		setResizable(false);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel top_panel = new JPanel();
		getContentPane().add(top_panel, BorderLayout.NORTH);
		top_panel.setLayout(new BorderLayout(0, 0));
		
		JButton btBack = new JButton("Quay l\u1EA1i");
		top_panel.add(btBack, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u1ECDn b\u00E0n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		top_panel.add(lblNewLabel_1, BorderLayout.CENTER);
		
		JPanel center_panel = new JPanel();
		getContentPane().add(center_panel, BorderLayout.CENTER);
		GridBagLayout gbl_center_panel = new GridBagLayout();
		int h = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 5);
		//w = 45;
 		gbl_center_panel.columnWidths = new int[]{h/2, h, h, h, h, h, 0};
		gbl_center_panel.rowHeights = new int[]{h/2, h, h, h, h, 0};
		gbl_center_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_center_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		center_panel.setLayout(gbl_center_panel);
		
		JButton btHere = new JButton("Mang \u0111i");
		btHere.setMargin(new Insets(0, 0, 0, 0));
		btHere.setMinimumSize(new Dimension(50, 50));
		btHere.setMaximumSize(new Dimension(70, 70));
		GridBagConstraints gbc_btHere = new GridBagConstraints();
		gbc_btHere.fill = GridBagConstraints.BOTH;
		gbc_btHere.insets = new Insets(0, 0, 5, 5);
		gbc_btHere.gridx = 1;
		gbc_btHere.gridy = 1;
		center_panel.add(btHere, gbc_btHere);
		
		JButton bt1 = new JButton("1");
		GridBagConstraints gbc_bt1 = new GridBagConstraints();
		gbc_bt1.insets = new Insets(0, 0, 5, 5);
		gbc_bt1.fill = GridBagConstraints.BOTH;
		gbc_bt1.gridx = 2;
		gbc_bt1.gridy = 1;
		center_panel.add(bt1, gbc_bt1);
		
		JButton bt2 = new JButton("2");
		GridBagConstraints gbc_bt2 = new GridBagConstraints();
		gbc_bt2.insets = new Insets(0, 0, 5, 5);
		gbc_bt2.fill = GridBagConstraints.BOTH;
		gbc_bt2.gridx = 3;
		gbc_bt2.gridy = 1;
		center_panel.add(bt2, gbc_bt2);
		
		JButton bt3 = new JButton("3");
		GridBagConstraints gbc_bt3 = new GridBagConstraints();
		gbc_bt3.insets = new Insets(0, 0, 5, 5);
		gbc_bt3.fill = GridBagConstraints.BOTH;
		gbc_bt3.gridx = 4;
		gbc_bt3.gridy = 1;
		center_panel.add(bt3, gbc_bt3);
		
		JButton bt4 = new JButton("4");
		GridBagConstraints gbc_bt4 = new GridBagConstraints();
		gbc_bt4.fill = GridBagConstraints.BOTH;
		gbc_bt4.insets = new Insets(0, 0, 5, 0);
		gbc_bt4.gridx = 5;
		gbc_bt4.gridy = 1;
		center_panel.add(bt4, gbc_bt4);
		
		JButton bt5 = new JButton("5");
		GridBagConstraints gbc_bt5 = new GridBagConstraints();
		gbc_bt5.fill = GridBagConstraints.BOTH;
		gbc_bt5.insets = new Insets(0, 0, 5, 5);
		gbc_bt5.gridx = 1;
		gbc_bt5.gridy = 2;
		center_panel.add(bt5, gbc_bt5);
		
		JButton bt6 = new JButton("6");
		GridBagConstraints gbc_bt6 = new GridBagConstraints();
		gbc_bt6.fill = GridBagConstraints.BOTH;
		gbc_bt6.insets = new Insets(0, 0, 5, 5);
		gbc_bt6.gridx = 2;
		gbc_bt6.gridy = 2;
		center_panel.add(bt6, gbc_bt6);
		
		JButton bt7 = new JButton("7");
		GridBagConstraints gbc_bt7 = new GridBagConstraints();
		gbc_bt7.fill = GridBagConstraints.BOTH;
		gbc_bt7.insets = new Insets(0, 0, 5, 5);
		gbc_bt7.gridx = 3;
		gbc_bt7.gridy = 2;
		center_panel.add(bt7, gbc_bt7);
		
		JButton bt8 = new JButton("8");
		GridBagConstraints gbc_bt8 = new GridBagConstraints();
		gbc_bt8.fill = GridBagConstraints.BOTH;
		gbc_bt8.insets = new Insets(0, 0, 5, 5);
		gbc_bt8.gridx = 4;
		gbc_bt8.gridy = 2;
		center_panel.add(bt8, gbc_bt8);
		
		JButton bt9 = new JButton("9");
		GridBagConstraints gbc_bt9 = new GridBagConstraints();
		gbc_bt9.fill = GridBagConstraints.BOTH;
		gbc_bt9.insets = new Insets(0, 0, 5, 0);
		gbc_bt9.gridx = 5;
		gbc_bt9.gridy = 2;
		center_panel.add(bt9, gbc_bt9);
		
		JButton bt10 = new JButton("10");
		GridBagConstraints gbc_bt10 = new GridBagConstraints();
		gbc_bt10.fill = GridBagConstraints.BOTH;
		gbc_bt10.insets = new Insets(0, 0, 5, 5);
		gbc_bt10.gridx = 1;
		gbc_bt10.gridy = 3;
		center_panel.add(bt10, gbc_bt10);
		
		JButton bt11 = new JButton("11");
		GridBagConstraints gbc_bt11 = new GridBagConstraints();
		gbc_bt11.fill = GridBagConstraints.BOTH;
		gbc_bt11.insets = new Insets(0, 0, 5, 5);
		gbc_bt11.gridx = 2;
		gbc_bt11.gridy = 3;
		center_panel.add(bt11, gbc_bt11);
		
		JButton bt12 = new JButton("12");
		GridBagConstraints gbc_bt12 = new GridBagConstraints();
		gbc_bt12.fill = GridBagConstraints.BOTH;
		gbc_bt12.insets = new Insets(0, 0, 5, 5);
		gbc_bt12.gridx = 3;
		gbc_bt12.gridy = 3;
		center_panel.add(bt12, gbc_bt12);
		
		JButton bt13 = new JButton("13");
		GridBagConstraints gbc_bt13 = new GridBagConstraints();
		gbc_bt13.insets = new Insets(0, 0, 5, 5);
		gbc_bt13.fill = GridBagConstraints.BOTH;
		gbc_bt13.gridx = 4;
		gbc_bt13.gridy = 3;
		center_panel.add(bt13, gbc_bt13);
		
		JButton bt14 = new JButton("14");
		GridBagConstraints gbc_bt14 = new GridBagConstraints();
		gbc_bt14.insets = new Insets(0, 0, 5, 0);
		gbc_bt14.fill = GridBagConstraints.BOTH;
		gbc_bt14.gridx = 5;
		gbc_bt14.gridy = 3;
		center_panel.add(bt14, gbc_bt14);
		
		JButton bt16 = new JButton("16");
		GridBagConstraints gbc_bt16 = new GridBagConstraints();
		gbc_bt16.fill = GridBagConstraints.BOTH;
		gbc_bt16.insets = new Insets(0, 0, 0, 5);
		gbc_bt16.gridx = 1;
		gbc_bt16.gridy = 4;
		center_panel.add(bt16, gbc_bt16);
		
		JButton bt17 = new JButton("17");
		GridBagConstraints gbc_bt17 = new GridBagConstraints();
		gbc_bt17.fill = GridBagConstraints.BOTH;
		gbc_bt17.insets = new Insets(0, 0, 0, 5);
		gbc_bt17.gridx = 2;
		gbc_bt17.gridy = 4;
		center_panel.add(bt17, gbc_bt17);
		
		JButton bt18 = new JButton("18");
		GridBagConstraints gbc_bt18 = new GridBagConstraints();
		gbc_bt18.fill = GridBagConstraints.BOTH;
		gbc_bt18.insets = new Insets(0, 0, 0, 5);
		gbc_bt18.gridx = 3;
		gbc_bt18.gridy = 4;
		center_panel.add(bt18, gbc_bt18);
		
		JButton bt19 = new JButton("19");
		GridBagConstraints gbc_bt19 = new GridBagConstraints();
		gbc_bt19.fill = GridBagConstraints.BOTH;
		gbc_bt19.insets = new Insets(0, 0, 0, 5);
		gbc_bt19.gridx = 4;
		gbc_bt19.gridy = 4;
		center_panel.add(bt19, gbc_bt19);
		
		JButton bt20 = new JButton("20");
		GridBagConstraints gbc_bt20 = new GridBagConstraints();
		gbc_bt20.fill = GridBagConstraints.BOTH;
		gbc_bt20.gridx = 5;
		gbc_bt20.gridy = 4;
		center_panel.add(bt20, gbc_bt20);
		
		JPanel right_panel = new JPanel();
		getContentPane().add(right_panel, BorderLayout.EAST);
		right_panel.setLayout(new BorderLayout(0, 0));
		
		JButton btUp = new JButton("UP");
		right_panel.add(btUp, BorderLayout.NORTH);
		
		JButton btDown = new JButton("DOWN");
		right_panel.add(btDown, BorderLayout.SOUTH);
		
		JList itemList = new JList();
		itemList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		right_panel.add(itemList, BorderLayout.CENTER);
		
		JPanel bot_panel = new JPanel();
		getContentPane().add(bot_panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		bot_panel.add(lblNewLabel);
		
	}

}
