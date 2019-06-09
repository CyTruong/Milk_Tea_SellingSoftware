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
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 696, 542);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 670, 492);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblThmUng = new JLabel("Th\u00EAm \u0111\u1ED3 u\u1ED1ng");
			lblThmUng.setHorizontalTextPosition(SwingConstants.CENTER);
			lblThmUng.setHorizontalAlignment(SwingConstants.CENTER);
			lblThmUng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			lblThmUng.setBounds(0, 0, 623, 37);
			contentPanel.add(lblThmUng);
		}
		{
			JLabel lblLoiUng = new JLabel("Lo\u1EA1i \u0111\u1ED3 u\u1ED1ng");
			lblLoiUng.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblLoiUng.setBounds(10, 71, 176, 22);
			contentPanel.add(lblLoiUng);
		}
		loadcombobox();

		cbLoai.setBounds(10, 111, 434, 41);
		cbLoai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPanel.add(cbLoai);
		
		JLabel lblTnUng = new JLabel("T\u00EAn \u0111\u1ED3 u\u1ED1ng");
		lblTnUng.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTnUng.setBounds(10, 176, 176, 22);
		contentPanel.add(lblTnUng);
		
		tfTendouong = new JTextField();
		tfTendouong.setBounds(10, 220, 434, 37);
		contentPanel.add(tfTendouong);
		tfTendouong.setColumns(10);
		
		JLabel lblGi = new JLabel("Gi\u00E1 ");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGi.setBounds(10, 279, 176, 22);
		contentPanel.add(lblGi);
		
		JLabel lblSizeSmc = new JLabel("Size S (M\u1EB7c \u0111\u1ECBnh) :");
		lblSizeSmc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSizeSmc.setBounds(34, 312, 176, 22);
		contentPanel.add(lblSizeSmc);
		
		JLabel lblSizeS = new JLabel("Size M               :");
		lblSizeS.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSizeS.setBounds(34, 375, 176, 22);
		contentPanel.add(lblSizeS);
		
		JLabel lblSizeL = new JLabel("Size L                :");
		lblSizeL.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSizeL.setBounds(34, 435, 176, 22);
		contentPanel.add(lblSizeL);
		
		tfS = new JTextField();
		tfS.setBounds(194, 308, 245, 37);
		contentPanel.add(tfS);
		tfS.setColumns(10);
		
		tfM = new JTextField();
		tfM.setColumns(10);
		tfM.setBounds(194, 371, 245, 37);
		contentPanel.add(tfM);
		
		tfL = new JTextField();
		tfL.setColumns(10);
		tfL.setBounds(194, 431, 245, 37);
		contentPanel.add(tfL);
		
		JButton btThem = new JButton("Thêm");
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 creatnew();	
			}
		});
		btThem.setBounds(474, 102, 176, 96);
		contentPanel.add(btThem);
		
		JButton btClear = new JButton("clear");
		btClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btClear.setBounds(474, 238, 176, 96);
		contentPanel.add(btClear);
		
		JButton btClose = new JButton("close");
		btClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
