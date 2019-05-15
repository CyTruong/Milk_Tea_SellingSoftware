package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.PickTableBus;
import dto.HoadonDto;
import mdlaf.MaterialLookAndFeel;

import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.Color;
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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;

public class PickTableFrame extends JFrame implements ActionListener  {

	private JPanel contentPane;
	private ArrayList<JButton> arrTableButton = new ArrayList<>();
	private JButton selectedTable = null;
	
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
		try {
			UIManager.setLookAndFeel(new MaterialLookAndFeel ());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
 		gbl_center_panel.columnWidths = new int[]{h/2, h, h, h, h, h, h, 0};
		gbl_center_panel.rowHeights = new int[]{h/2, h, h, h, h, 0};
		gbl_center_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_center_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		center_panel.setLayout(gbl_center_panel);
		
	
		JButton btHere = new JButton("Mang \u0111i");
		GridBagConstraints gbc_btHere = new GridBagConstraints();
		gbc_btHere.fill = GridBagConstraints.BOTH;
		gbc_btHere.insets = new Insets(0, 0, 5, 5);
		gbc_btHere.gridx = 1;
		gbc_btHere.gridy = 1;
		center_panel.add(btHere, gbc_btHere);
		arrTableButton.add(btHere);
		
		JButton bt1 = new JButton("1");
		GridBagConstraints gbc_bt1 = new GridBagConstraints();
		gbc_bt1.insets = new Insets(0, 0, 5, 5);
		gbc_bt1.fill = GridBagConstraints.BOTH;
		gbc_bt1.gridx = 2;
		gbc_bt1.gridy = 1;
		center_panel.add(bt1, gbc_bt1);
		arrTableButton.add(bt1);
		
		JButton bt2 = new JButton("2");
		GridBagConstraints gbc_bt2 = new GridBagConstraints();
		gbc_bt2.insets = new Insets(0, 0, 5, 5);
		gbc_bt2.fill = GridBagConstraints.BOTH;
		gbc_bt2.gridx = 3;
		gbc_bt2.gridy = 1;
		center_panel.add(bt2, gbc_bt2);
		arrTableButton.add(bt2);
		
		JButton bt3 = new JButton("3");
		GridBagConstraints gbc_bt3 = new GridBagConstraints();
		gbc_bt3.insets = new Insets(0, 0, 5, 5);
		gbc_bt3.fill = GridBagConstraints.BOTH;
		gbc_bt3.gridx = 4;
		gbc_bt3.gridy = 1;
		center_panel.add(bt3, gbc_bt3);
		arrTableButton.add(bt3);
		
		JButton bt4 = new JButton("4");
		GridBagConstraints gbc_bt4 = new GridBagConstraints();
		gbc_bt4.fill = GridBagConstraints.BOTH;
		gbc_bt4.insets = new Insets(0, 0, 5, 5);
		gbc_bt4.gridx = 5;
		gbc_bt4.gridy = 1;
		center_panel.add(bt4, gbc_bt4);
		arrTableButton.add(bt4);
		
		///////////////////////////////////
		JButton btUp = new JButton("UP");
		GridBagConstraints gbc_btUp = new GridBagConstraints();
		gbc_btUp.fill = GridBagConstraints.HORIZONTAL;
		gbc_btUp.insets = new Insets(0, 0, 5, 0);
		gbc_btUp.gridx = 6;
		gbc_btUp.gridy = 1;
		center_panel.add(btUp, gbc_btUp);
		
		JButton bt5 = new JButton("5");
		GridBagConstraints gbc_bt5 = new GridBagConstraints();
		gbc_bt5.fill = GridBagConstraints.BOTH;
		gbc_bt5.insets = new Insets(0, 0, 5, 5);
		gbc_bt5.gridx = 1;
		gbc_bt5.gridy = 2;
		center_panel.add(bt5, gbc_bt5);
		arrTableButton.add(bt5);
		
		JButton bt6 = new JButton("6");
		GridBagConstraints gbc_bt6 = new GridBagConstraints();
		gbc_bt6.fill = GridBagConstraints.BOTH;
		gbc_bt6.insets = new Insets(0, 0, 5, 5);
		gbc_bt6.gridx = 2;
		gbc_bt6.gridy = 2;
		center_panel.add(bt6, gbc_bt6);
		arrTableButton.add(bt6);
		
		JButton bt7 = new JButton("7");
		GridBagConstraints gbc_bt7 = new GridBagConstraints();
		gbc_bt7.fill = GridBagConstraints.BOTH;
		gbc_bt7.insets = new Insets(0, 0, 5, 5);
		gbc_bt7.gridx = 3;
		gbc_bt7.gridy = 2;
		center_panel.add(bt7, gbc_bt7);
		arrTableButton.add(bt7);
		
		JButton bt8 = new JButton("8");
		GridBagConstraints gbc_bt8 = new GridBagConstraints();
		gbc_bt8.fill = GridBagConstraints.BOTH;
		gbc_bt8.insets = new Insets(0, 0, 5, 5);
		gbc_bt8.gridx = 4;
		gbc_bt8.gridy = 2;
		center_panel.add(bt8, gbc_bt8);
		arrTableButton.add(bt8);
		
		JButton bt9 = new JButton("9");
		GridBagConstraints gbc_bt9 = new GridBagConstraints();
		gbc_bt9.fill = GridBagConstraints.BOTH;
		gbc_bt9.insets = new Insets(0, 0, 5, 5);
		gbc_bt9.gridx = 5;
		gbc_bt9.gridy = 2;
		center_panel.add(bt9, gbc_bt9);
		arrTableButton.add(bt9);
		
		JList itemList = new JList();
		GridBagConstraints gbc_itemList = new GridBagConstraints();
		gbc_itemList.gridheight = 2;
		gbc_itemList.insets = new Insets(0, 0, 5, 0);
		gbc_itemList.gridx = 6;
		gbc_itemList.gridy = 2;
		center_panel.add(itemList, gbc_itemList);
		itemList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		JButton bt10 = new JButton("10");
		GridBagConstraints gbc_bt10 = new GridBagConstraints();
		gbc_bt10.fill = GridBagConstraints.BOTH;
		gbc_bt10.insets = new Insets(0, 0, 5, 5);
		gbc_bt10.gridx = 1;
		gbc_bt10.gridy = 3;
		center_panel.add(bt10, gbc_bt10);
		arrTableButton.add(bt10);
		
		JButton bt11 = new JButton("11");
		GridBagConstraints gbc_bt11 = new GridBagConstraints();
		gbc_bt11.fill = GridBagConstraints.BOTH;
		gbc_bt11.insets = new Insets(0, 0, 5, 5);
		gbc_bt11.gridx = 2;
		gbc_bt11.gridy = 3;
		center_panel.add(bt11, gbc_bt11);
		arrTableButton.add(bt11);
		
		JButton bt12 = new JButton("12");
		GridBagConstraints gbc_bt12 = new GridBagConstraints();
		gbc_bt12.fill = GridBagConstraints.BOTH;
		gbc_bt12.insets = new Insets(0, 0, 5, 5);
		gbc_bt12.gridx = 3;
		gbc_bt12.gridy = 3;
		center_panel.add(bt12, gbc_bt12);
		arrTableButton.add(bt12);
		
		JButton bt13 = new JButton("13");
		GridBagConstraints gbc_bt13 = new GridBagConstraints();
		gbc_bt13.insets = new Insets(0, 0, 5, 5);
		gbc_bt13.fill = GridBagConstraints.BOTH;
		gbc_bt13.gridx = 4;
		gbc_bt13.gridy = 3;
		center_panel.add(bt13, gbc_bt13);
		arrTableButton.add(bt13);
		
		JButton bt14 = new JButton("14");
		GridBagConstraints gbc_bt14 = new GridBagConstraints();
		gbc_bt14.insets = new Insets(0, 0, 5, 5);
		gbc_bt14.fill = GridBagConstraints.BOTH;
		gbc_bt14.gridx = 5;
		gbc_bt14.gridy = 3;
		center_panel.add(bt14, gbc_bt14);
		arrTableButton.add(bt14);
		
		JButton bt15 = new JButton("15");
		GridBagConstraints gbc_bt15 = new GridBagConstraints();
		gbc_bt15.fill = GridBagConstraints.BOTH;
		gbc_bt15.insets = new Insets(0, 0, 0, 5);
		gbc_bt15.gridx = 1;
		gbc_bt15.gridy = 4;
		center_panel.add(bt15, gbc_bt15);
		arrTableButton.add(bt15);
		
		JButton bt16 = new JButton("16");
		GridBagConstraints gbc_bt16 = new GridBagConstraints();
		gbc_bt16.fill = GridBagConstraints.BOTH;
		gbc_bt16.insets = new Insets(0, 0, 0, 5);
		gbc_bt16.gridx = 2;
		gbc_bt16.gridy = 4;
		center_panel.add(bt16, gbc_bt16);
		arrTableButton.add(bt16);
		
		JButton bt17 = new JButton("17");
		GridBagConstraints gbc_bt17 = new GridBagConstraints();
		gbc_bt17.fill = GridBagConstraints.BOTH;
		gbc_bt17.insets = new Insets(0, 0, 0, 5);
		gbc_bt17.gridx = 3;
		gbc_bt17.gridy = 4;
		center_panel.add(bt17, gbc_bt17);
		arrTableButton.add(bt17);
		
		JButton bt18 = new JButton("19");
		GridBagConstraints gbc_bt18 = new GridBagConstraints();
		gbc_bt18.fill = GridBagConstraints.BOTH;
		gbc_bt18.insets = new Insets(0, 0, 0, 5);
		gbc_bt18.gridx = 4;
		gbc_bt18.gridy = 4;
		center_panel.add(bt18, gbc_bt18);
		arrTableButton.add(bt18);
		
		JButton bt19 = new JButton("19");
		GridBagConstraints gbc_bt19 = new GridBagConstraints();
		gbc_bt19.insets = new Insets(0, 0, 0, 5);
		gbc_bt19.fill = GridBagConstraints.BOTH;
		gbc_bt19.gridx = 5;
		gbc_bt19.gridy = 4;
		center_panel.add(bt19, gbc_bt19);
		arrTableButton.add(bt19);
		
		setListener();
		
		JButton btDown = new JButton("DOWN");
		GridBagConstraints gbc_btDown = new GridBagConstraints();
		gbc_btDown.fill = GridBagConstraints.HORIZONTAL;
		gbc_btDown.gridx = 6;
		gbc_btDown.gridy = 4;
		center_panel.add(btDown, gbc_btDown);
		
		JPanel right_panel = new JPanel();
		int rightPanelWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/5;
		right_panel.setPreferredSize(new Dimension(rightPanelWidth , getContentPane().getPreferredSize().height));
		getContentPane().add(right_panel, BorderLayout.EAST);
		GridBagLayout gbl_right_panel = new GridBagLayout();
		gbl_right_panel.columnWidths = new int[]{rightPanelWidth, 0};
		gbl_right_panel.rowHeights = new int[]{rightPanelWidth, rightPanelWidth, 0};
		gbl_right_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_right_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		right_panel.setLayout(gbl_right_panel);
		
		JButton btDatmon = new JButton("\u0110\u1EB7t m\u00F3n");
		GridBagConstraints gbc_btDatmon = new GridBagConstraints();
		gbc_btDatmon.fill = GridBagConstraints.BOTH;
		gbc_btDatmon.insets = new Insets(0, 0, 5, 0);
		gbc_btDatmon.gridx = 0;
		gbc_btDatmon.gridy = 0;
		right_panel.add(btDatmon, gbc_btDatmon);
		
		JButton btThanhtoan = new JButton("Thanh to\u00E1n");
		GridBagConstraints gbc_btThanhtoan = new GridBagConstraints();
		gbc_btThanhtoan.fill = GridBagConstraints.BOTH;
		gbc_btThanhtoan.gridx = 0;
		gbc_btThanhtoan.gridy = 1;
		right_panel.add(btThanhtoan, gbc_btThanhtoan);
		
		JPanel bot_panel = new JPanel();
		getContentPane().add(bot_panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("New label");
		bot_panel.add(lblNewLabel);
		
		setCurrentDrinkingTable();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		JButton bt = (JButton)arg0.getSource();
			selectedTable = bt;
			setSelectedtable();
			System.out.println(selectedTable.getText());
			this.revalidate();
		
	}
	
	private void setSelectedtable() {
		if(selectedTable!=null) {
			setDefautColor();
			selectedTable.setBackground(new Color(160, 204, 238));
		}
	}
	
	private void setListener() {
		for (JButton jButton : arrTableButton) {
			jButton.addActionListener(this);
		}
	}
	
	private void setDefautColor() {
		for (JButton jButton : arrTableButton) {
			jButton.setBackground(new Color(230,230,230));
		}
	}
	
	private void setCurrentDrinkingTable() {
		TreeMap<Integer, HoadonDto> currentDrinking = PickTableBus.getInstance().drinkingTable;
		for (Map.Entry<Integer, HoadonDto> entry : currentDrinking.entrySet()) {
			for (JButton jButton : arrTableButton) {
				if(entry.getKey().toString().equals(jButton.getText())) {
					jButton.doClick();
				}
			}
		}
	}

}
