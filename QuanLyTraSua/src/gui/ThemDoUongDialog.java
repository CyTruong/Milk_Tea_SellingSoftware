package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bus.LoaidouongBus;
import dal.QLTS_DatabaseControler;
import dto.Douongdto;
import dto.LoaidouongDto;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ThemDoUongDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfTendouong;
	private JTextField tfS;
	private JTextField tfM;
	private JTextField tfL;
	private JComboBox cbLoai;
	ArrayList<LoaidouongDto> arrLoaidouong;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThemDoUongDialog dialog = new ThemDoUongDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThemDoUongDialog() {
		getContentPane().setBackground(new Color(255,154,15));
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 696, 542);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(255,154,15));
		contentPanel.setBounds(12, 13, 670, 492);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblThmUng = new JLabel("Th\u00EAm \u0111\u1ED3 u\u1ED1ng");
			lblThmUng.setForeground(new Color(204,0,0));
			lblThmUng.setHorizontalTextPosition(SwingConstants.CENTER);
			lblThmUng.setHorizontalAlignment(SwingConstants.CENTER);
			lblThmUng.setFont(new Font("Segoe UI", Font.BOLD, 34));
			lblThmUng.setBounds(0, 0, 623, 58);
			contentPanel.add(lblThmUng);
		}
		{
			JLabel lblLoiUng = new JLabel("Lo\u1EA1i \u0111\u1ED3 u\u1ED1ng");
			lblLoiUng.setForeground(new Color(204, 0, 0));
			lblLoiUng.setFont(new Font("Segoe UI", Font.BOLD, 20));
			lblLoiUng.setBounds(10, 71, 176, 37);
			contentPanel.add(lblLoiUng);
		}
		loadcombobox();

		cbLoai.setBounds(10, 111, 434, 41);
		cbLoai.setFont(new Font("Segoe UI", Font.BOLD, 18));
		contentPanel.add(cbLoai);
		
		JLabel lblTnUng = new JLabel("T\u00EAn \u0111\u1ED3 u\u1ED1ng");
		lblTnUng.setForeground(new Color(204,0, 0));
		lblTnUng.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTnUng.setBounds(10, 176, 176, 31);
		contentPanel.add(lblTnUng);
		
		tfTendouong = new JTextField();
		tfTendouong.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfTendouong.setBounds(10, 220, 434, 37);
		contentPanel.add(tfTendouong);
		tfTendouong.setColumns(10);
		
		JLabel lblGi = new JLabel("Gi\u00E1 ");
		lblGi.setForeground(new Color(204, 0, 0));
		lblGi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblGi.setBounds(10, 279, 176, 22);
		contentPanel.add(lblGi);
		
		JLabel lblSizeSmc = new JLabel("Size S (M\u1EB7c \u0111\u1ECBnh) :");
		lblSizeSmc.setForeground(new Color(204, 0, 0));
		lblSizeSmc.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSizeSmc.setBounds(34, 312, 176, 22);
		contentPanel.add(lblSizeSmc);
		
		JLabel lblSizeS = new JLabel("Size M                   :");
		lblSizeS.setForeground(new Color(204, 0, 0));
		lblSizeS.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSizeS.setBounds(34, 375, 176, 22);
		contentPanel.add(lblSizeS);
		
		JLabel lblSizeL = new JLabel("Size L                     :");
		lblSizeL.setForeground(new Color(204, 0, 0));
		lblSizeL.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSizeL.setBounds(34, 435, 176, 22);
		contentPanel.add(lblSizeL);
		
		tfS = new JTextField();
		tfS.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfS.setBounds(194, 308, 245, 37);
		contentPanel.add(tfS);
		tfS.setColumns(10);
		
		tfM = new JTextField();
		tfM.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfM.setColumns(10);
		tfM.setBounds(194, 371, 245, 37);
		contentPanel.add(tfM);
		
		tfL = new JTextField();
		tfL.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfL.setColumns(10);
		tfL.setBounds(194, 431, 245, 37);
		contentPanel.add(tfL);
		
		JButton btThem = new JButton("Thêm");
		btThem.setForeground(Color.WHITE);
		btThem.setBackground(new Color(204, 0, 0));
		btThem.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 creatnew();	
			}
		});
		btThem.setBounds(474, 102, 176, 96);
		contentPanel.add(btThem);
		
		JButton btClear = new JButton("Xóa");
		btClear.setForeground(Color.WHITE);
		btClear.setBackground(new Color(204,0, 0));
		btClear.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btClear.setBounds(474, 238, 176, 96);
		contentPanel.add(btClear);
		
		JButton btClose = new JButton("Đóng");
		btClose.setForeground(Color.WHITE);
		btClose.setBackground(new Color(204, 0, 0));
		btClose.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btClose.setBounds(474, 368, 176, 96);
		contentPanel.add(btClose);
		
	}
	
	private void loadcombobox() {
		arrLoaidouong = LoaidouongBus.getInstance().getListDto();
		String[] arr = new String[arrLoaidouong.size()];
		for(int i = 0 ; i< arrLoaidouong.size() ; i++) {
			arr[i] = arrLoaidouong.get(i).tenloai;
		}
		cbLoai = new JComboBox(arr);
		cbLoai.setSelectedIndex(0);
		cbLoai.revalidate();
	}
	
	private void creatnew() {
		String tendouong = tfTendouong.getText();
		String giaS = tfS.getText().trim();
		String giaM = tfM.getText().trim();
		String giaL = tfL.getText().trim();
		int selectedMaLoai = arrLoaidouong.get(cbLoai.getSelectedIndex()).maloai;
		 new Thread(){
	            public void run() {
	             QLTS_DatabaseControler.getInstance().getProcedures().insertDouong(tendouong, selectedMaLoai);
	             int newsDouong = maxIndex();
	             if(!giaS.equals("")) {
	            	 int S = Integer.parseInt(giaS);
	            	 QLTS_DatabaseControler.getInstance().getProcedures().insertBanggia(1, newsDouong, S);
	             }
	             if(!giaM.equals("")) {
	            	 int M = Integer.parseInt(giaM);
	            	 QLTS_DatabaseControler.getInstance().getProcedures().insertBanggia(2, newsDouong, M);
	             }
	             if(!giaL.equals("")) {
	            	 int L = Integer.parseInt(giaL);
	            	 QLTS_DatabaseControler.getInstance().getProcedures().insertBanggia(3, newsDouong, L);
	             }
	            }
	        }.start();
	       ToastMessage toast = new ToastMessage("Thêm đồ uống mới thành công", 3000);
	       toast.setVisible(true);
	       dispose();
	}
	
	
	private int maxIndex() {
		Douongdto dto = new Douongdto();
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectDouong();
		int max = -1;
		try {
			while(rs.next()) {
				dto.mapping(rs);
				max= Math.max(max, dto.madouong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
}
