package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bus.printer.Printer_Controler;
import bus.printer.report.*;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class MenuReportFrame extends JFrame {

	private JPanel contentPane;
	private Timestamp tuanchon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuReportFrame frame = new MenuReportFrame();
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
	public MenuReportFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1445, 877);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1920, 1080);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel leftpanel = new JPanel();
		leftpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		leftpanel.setBounds(0, 0, 960, 1080);
		panel.add(leftpanel);
		leftpanel.setLayout(null);

		JLabel lblThngKDoanh = new JLabel("Th\u1ED1ng k\u00EA doanh thu theo th\u1EDDi gian");
		lblThngKDoanh.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblThngKDoanh.setFont(new Font("Arial", Font.BOLD, 22));
		lblThngKDoanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKDoanh.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThngKDoanh.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblThngKDoanh.setBounds(10, 11, 940, 53);
		leftpanel.add(lblThngKDoanh);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(28, 107, 481, 285);
		leftpanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblThngKTheo = new JLabel("Th\u1ED1ng k\u00EA theo ng\u00E0y");
		lblThngKTheo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngKTheo.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKTheo.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThngKTheo.setBounds(0, 11, 471, 36);
		panel_1.add(lblThngKTheo);

		JButton btnNgyHmNay = new JButton("Ng\u00E0y h\u00F4m nay");
		btnNgyHmNay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Timestamp time = new Timestamp(System.currentTimeMillis());
				Object[] arg = { time };
				Printer_Controler.getInstance().getModule().createBussinessReport(new ReportCat_Businness_Byday(arg));
				Printer_Controler.getInstance().getModule().showReport();
			}
		});
		btnNgyHmNay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNgyHmNay.setBounds(32, 91, 173, 158);
		panel_1.add(btnNgyHmNay);

		JButton btChooseNgay = new JButton("Ch\u1ECDn ng\u00E0y");
		btChooseNgay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Component component = (Component) e.getSource();
				DatePicker dp = new DatePicker((JFrame) SwingUtilities.getRoot(component));
				Point bP = btChooseNgay.getLocationOnScreen();
				dp.d.setLocation(bP.x, bP.y + btChooseNgay.getHeight());
				dp.d.setVisible(true);
				Timestamp time = dp.setPickedDateTimetamp();
				Object[] arg = { time };
				Printer_Controler.getInstance().getModule().createBussinessReport(new ReportCat_Businness_Byday(arg));
				Printer_Controler.getInstance().getModule().showReport();
			}
		});

		btChooseNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btChooseNgay.setBounds(264, 91, 173, 158);
		panel_1.add(btChooseNgay);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(519, 263, 431, 292);
		leftpanel.add(panel_2);
		panel_2.setLayout(null);

		JLabel label = new JLabel("Th\u1ED1ng k\u00EA theo th\u00E1ng");
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(10, 11, 389, 30);
		panel_2.add(label);

		JSpinner SpMonth = new JSpinner();
		SpMonth.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		SpMonth.setBounds(102, 108, 319, 50);
		SpMonth.getComponent(0).setPreferredSize(new Dimension(50, 25));
		SpMonth.getComponent(1).setPreferredSize(new Dimension(50, 25));
		SpMonth.getComponent(2).setFont(new Font("Tahoma", Font.PLAIN, 15));

		panel_2.add(SpMonth);

		JLabel lblChnThnag = new JLabel("Th\u00E1ng");
		lblChnThnag.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChnThnag.setBounds(10, 118, 64, 27);
		panel_2.add(lblChnThnag);

		JButton btnbymonth = new JButton("Xem");
		btnbymonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int month = (int) SpMonth.getValue();
				Timestamp time = Timestamp.valueOf("2019-"+month+"-09 10:10:10.0");
				Object[] arg = { time };
				Printer_Controler.getInstance().getModule().createBussinessReport(new ReportCat_Business_Bymonth(arg));
				Printer_Controler.getInstance().getModule().showReport();
			}
		});
		btnbymonth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnbymonth.setBounds(23, 206, 376, 59);
		panel_2.add(btnbymonth);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(28, 463, 466, 297);
		leftpanel.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblThngKTheo_1 = new JLabel("Th\u1ED1ng k\u00EA theo tu\u1EA7n");
		lblThngKTheo_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThngKTheo_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThngKTheo_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblThngKTheo_1.setBounds(10, 11, 450, 40);
		panel_3.add(lblThngKTheo_1);

		JLabel label_1 = new JLabel("Ch\u1ECDn ng\u00E0y trong tu\u1EA7n");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(23, 85, 172, 40);
		panel_3.add(label_1);

		JLabel lbngaychon = new JLabel("Ng\u00E0y ch\u1ECDn :");
		lbngaychon.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbngaychon.setBounds(25, 159, 416, 40);
		panel_3.add(lbngaychon);

		JButton btnChontuan = new JButton("Ch\u1ECDn tu\u1EA7n");
		btnChontuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Component component = (Component) arg0.getSource();
				DatePicker dp = new DatePicker((JFrame) SwingUtilities.getRoot(component));
				Point bP = btChooseNgay.getLocationOnScreen();
				dp.d.setLocation(bP.x, bP.y + btChooseNgay.getHeight());
				dp.d.setVisible(true);
				tuanchon = dp.setPickedDateTimetamp();
				lbngaychon.setText("Ngày chọn " + (new SimpleDateFormat("dd/MM/yyy").format(tuanchon)));
			}
		});
		btnChontuan.setBounds(235, 86, 134, 43);
		panel_3.add(btnChontuan);

		JButton btbyweek = new JButton("Xem báo cáo");
		btbyweek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] arg = { tuanchon };
				Printer_Controler.getInstance().getModule().createBussinessReport(new ReportCat_Business_Byweek(arg));
				Printer_Controler.getInstance().getModule().showReport();
			}
		});
		btbyweek.setFont(new Font("Arial", Font.PLAIN, 20));
		btbyweek.setBounds(106, 222, 192, 64);
		panel_3.add(btbyweek);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(508, 589, 431, 285);
		leftpanel.add(panel_4);

		JLabel label_2 = new JLabel("Th\u1ED1ng k\u00EA theo n\u0103m");
		label_2.setHorizontalTextPosition(SwingConstants.CENTER);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_2.setBounds(10, 11, 411, 30);
		panel_4.add(label_2);

		JLabel label_3 = new JLabel("N\u0103m");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(10, 95, 64, 27);
		panel_4.add(label_3);

		JSpinner Spyear = new JSpinner();
		Spyear.setModel(new SpinnerNumberModel(2019, 1990, 2200, 1));
		Spyear.setBounds(102, 82, 319, 50);
		panel_4.add(Spyear);

		JButton btxemtheonam = new JButton("Xem");
		btxemtheonam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btxemtheonam.setBounds(10, 178, 411, 59);
		btxemtheonam.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int year = (int) Spyear.getValue();
				Timestamp time = Timestamp.valueOf(year+"-1-09 10:10:10.0");
				Object[] arg = { time };
				Printer_Controler.getInstance().getModule().createBussinessReport(new ReportCat_Business_Bymonth(arg));
				Printer_Controler.getInstance().getModule().showReport();				
			}
		});
		panel_4.add(btxemtheonam);

		JPanel rightpanel = new JPanel();
		rightpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		rightpanel.setBounds(960, 0, 960, 595);
		panel.add(rightpanel);
		rightpanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Th\u1ED1ng k\u00EA theo nh\u00E2n vi\u00EAn");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBounds(10, 11, 940, 53);
		rightpanel.add(lblNewLabel);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(56, 103, 315, 429);
		rightpanel.add(panel_5);
		panel_5.setLayout(null);

		JLabel label_4 = new JLabel("Th\u1ED1ng k\u00EA theo t\u1ED5ng doanh thu");
		label_4.setHorizontalTextPosition(SwingConstants.CENTER);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_4.setBounds(10, 23, 295, 30);
		panel_5.add(label_4);

		JList list = new JList();
		list.setBounds(10, 114, 295, 202);
		panel_5.add(list);

		JButton btnNewButton = new JButton("Xem");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 343, 295, 64);
		panel_5.add(btnNewButton);

		JLabel lblChnNhnVin = new JLabel("Ch\u1ECDn nh\u00E2n vi\u00EAn");
		lblChnNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblChnNhnVin.setBounds(10, 73, 123, 30);
		panel_5.add(lblChnNhnVin);
		
		JButton btnBack = new JButton("Quay lại");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBack.setBounds(1062, 630, 256, 79);
		panel.add(btnBack);
	}

	@Override
	public void dispose() {
		MenuReportFrame menu = new MenuReportFrame();
		menu.setVisible(true);
		super.dispose();
	}
	
	
	
}

class DatePicker {

	int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
	int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
	JLabel l = new JLabel("", JLabel.CENTER);
	String day = "";
	JDialog d;
	JButton[] button = new JButton[49];

	public DatePicker(JFrame parent) {
		System.out.println("time picker");
		d = new JDialog();
		d.setModal(true);
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		String[] header = { "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat" };
		JPanel p1 = new JPanel(new GridLayout(7, 7));
		p1.setPreferredSize(new Dimension(430, 120));
		for (int x = 0; x < button.length; x++) {
			final int selection = x;
			button[x] = new JButton();
			button[x].setFocusPainted(false);
			button[x].setBackground(Color.white);
			if (x > 6)
				button[x].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						day = button[selection].getActionCommand();
						d.setVisible(false);
						d.dispose();
					}
				});
			if (x < 7) {
				button[x].setText(header[x]);
				button[x].setForeground(Color.red);
			}
			p1.add(button[x]);
		}
		JPanel p2 = new JPanel(new GridLayout(1, 3));
		JButton previous = new JButton("<< Previous");
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month--;
				displayDate();
			}
		});
		p2.add(previous);
		p2.add(l);
		JButton next = new JButton("Next >>");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				month++;
				displayDate();
			}
		});
		p2.add(next);
		d.add(p1, BorderLayout.CENTER);
		d.add(p2, BorderLayout.SOUTH);
		d.pack();
		d.setLocationRelativeTo(parent);
		displayDate();
		d.setVisible(true);

	}

	public void displayDate() {
		for (int x = 7; x < button.length; x++)
			button[x].setText("");
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, 1);
		int dayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK);
		int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
		for (int x = 6 + dayOfWeek, day = 1; day <= daysInMonth; x++, day++)
			button[x].setText("" + day);
		l.setText(sdf.format(cal.getTime()));
		d.setTitle("Date Picker");

	}

	public String setPickedDateString() {
		if (day.equals(""))
			return day;
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
		java.util.Calendar cal = java.util.Calendar.getInstance();
		cal.set(year, month, Integer.parseInt(day));
		return sdf.format(cal.getTime());
	}

	public Timestamp setPickedDateTimetamp() {
		if (day.equals(""))
			return null;

		Timestamp time = Timestamp.valueOf(year + "-" + (month + 1) + "-" + Integer.parseInt(day) + " 10:10:10.0");
		return time;
	}
	
	

}
