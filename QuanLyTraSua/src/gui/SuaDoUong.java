package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bus.DoUongBus;
import bus.LoaidouongBus;
import dal.QLTS_DatabaseControler;
import dto.BanggiaDto;
import dto.Douongdto;
import dto.LoaidouongDto;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;

public class SuaDoUong extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfTendouong;
	private JTextField tfS;
	private JTextField tfM;
	private JTextField tfL;
	ArrayList<LoaidouongDto> arrLoaidouong;
	ArrayList<Douongdto> arrDouong;
	private JComboBox cbloaicansua;
	private JComboBox cbtendouongcansua;
	private JComboBox cbloaidpuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SuaDoUong dialog = new SuaDoUong();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SuaDoUong() {
		getContentPane().setBackground(new Color(244, 164, 96));
		setResizable(false);
		setAlwaysOnTop(true);
		setBounds(100, 100, 696, 700);
		getContentPane().setLayout(null);
		contentPanel.setBackground(new Color(244, 164, 96));
		contentPanel.setBounds(12, 13, 674, 676);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblThmUng = new JLabel("Sửa đồ uống");
			lblThmUng.setForeground(new Color(204, 0, 0));
			lblThmUng.setHorizontalTextPosition(SwingConstants.CENTER);
			lblThmUng.setHorizontalAlignment(SwingConstants.CENTER);
			lblThmUng.setFont(new Font("Segoe UI", Font.BOLD, 34));
			lblThmUng.setBounds(0, 0, 623, 58);
			contentPanel.add(lblThmUng);
		}

		JLabel lblTnUng = new JLabel("T\u00EAn \u0111\u1ED3 u\u1ED1ng");
		lblTnUng.setForeground(new Color(204, 0, 0));
		lblTnUng.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTnUng.setBounds(20, 373, 176, 31);
		contentPanel.add(lblTnUng);

		tfTendouong = new JTextField();
		tfTendouong.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfTendouong.setBounds(20, 417, 434, 37);
		contentPanel.add(tfTendouong);
		tfTendouong.setColumns(10);

		JLabel lblGi = new JLabel("Gi\u00E1 ");
		lblGi.setForeground(new Color(204, 0, 0));
		lblGi.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblGi.setBounds(20, 476, 176, 22);
		contentPanel.add(lblGi);

		JLabel lblSizeSmc = new JLabel("Size S (M\u1EB7c \u0111\u1ECBnh) :");
		lblSizeSmc.setForeground(new Color(204, 0, 0));
		lblSizeSmc.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSizeSmc.setBounds(44, 509, 176, 22);
		contentPanel.add(lblSizeSmc);

		JLabel lblSizeS = new JLabel("Size M                   :");
		lblSizeS.setForeground(new Color(204, 0, 0));
		lblSizeS.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSizeS.setBounds(44, 572, 176, 22);
		contentPanel.add(lblSizeS);

		JLabel lblSizeL = new JLabel("Size L                     :");
		lblSizeL.setForeground(new Color(204, 0, 0));
		lblSizeL.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblSizeL.setBounds(44, 632, 176, 22);
		contentPanel.add(lblSizeL);

		tfS = new JTextField();
		tfS.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfS.setBounds(204, 505, 245, 37);
		contentPanel.add(tfS);
		tfS.setColumns(10);

		tfM = new JTextField();
		tfM.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfM.setColumns(10);
		tfM.setBounds(204, 568, 245, 37);
		contentPanel.add(tfM);

		tfL = new JTextField();
		tfL.setFont(new Font("Segoe UI", Font.BOLD, 18));
		tfL.setColumns(10);
		tfL.setBounds(204, 628, 245, 37);
		contentPanel.add(tfL);

		JButton btThem = new JButton("Sửa");
		btThem.setForeground(Color.WHITE);
		btThem.setBackground(new Color(204, 0, 0));
		btThem.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creatnew();
			}
		});
		btThem.setBounds(484, 320, 176, 96);
		contentPanel.add(btThem);

		JButton btClear = new JButton("Xóa");
		btClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btClear.setForeground(Color.WHITE);
		btClear.setBackground(new Color(204, 0, 0));
		btClear.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btClear.setBounds(484, 446, 176, 96);
		contentPanel.add(btClear);

		JButton btClose = new JButton("Đóng");
		btClose.setForeground(Color.WHITE);
		btClose.setBackground(new Color(204, 0, 0));
		btClose.setFont(new Font("Segoe UI", Font.BOLD, 28));
		btClose.setBounds(484, 565, 176, 96);
		contentPanel.add(btClose);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 99, 674, 175);
		panel.setBackground(new Color(244, 176, 96));
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Loại đồ uống");
		label.setForeground(new Color(204, 0, 0));
		label.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label.setBounds(10, 53, 176, 37);
		panel.add(label);

		cbloaicansua = new JComboBox(new Object[] {});
		cbtendouongcansua = new JComboBox(new Object[] {});
		cbloaidpuong = new JComboBox(new Object[] {});

		loadLoaiDoUongcombobox();

		cbloaicansua.setFont(new Font("Segoe UI", Font.BOLD, 18));
		cbloaicansua.setBounds(10, 102, 316, 37);
		panel.add(cbloaicansua);

		JLabel label_1 = new JLabel("Tên đồ uống");
		label_1.setForeground(new Color(204, 0, 0));
		label_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_1.setBounds(329, 56, 176, 31);
		panel.add(label_1);

		cbtendouongcansua.setBounds(329, 102, 335, 37);
		panel.add(cbtendouongcansua);

		JLabel label_2 = new JLabel("Đồ uống cần sửa");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(new Color(204, 0, 0));
		label_2.setFont(new Font("Segoe UI", Font.BOLD, 22));
		label_2.setBounds(10, 11, 423, 31);
		panel.add(label_2);

		cbloaidpuong.setFont(new Font("Segoe UI", Font.BOLD, 18));
		cbloaidpuong.setBounds(20, 334, 434, 37);
		contentPanel.add(cbloaidpuong);

		JLabel label_3 = new JLabel("Loại đồ uống");
		label_3.setForeground(new Color(204, 0, 0));
		label_3.setFont(new Font("Segoe UI", Font.BOLD, 20));
		label_3.setBounds(20, 285, 434, 37);
		contentPanel.add(label_3);
	}

	private void loadLoaiDoUongcombobox() {
		arrLoaidouong = LoaidouongBus.getInstance().getListDto();
		String[] arr = new String[arrLoaidouong.size()];
		for (int i = 0; i < arrLoaidouong.size(); i++) {
			arr[i] = arrLoaidouong.get(i).tenloai;
		}
		cbloaicansua = new JComboBox(arr);
		cbloaicansua.setSelectedIndex(0);
		cbloaicansua.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loadDoUongcombobox();
			}
		});

		cbloaidpuong = new JComboBox(arr);
		cbloaidpuong.setSelectedIndex(0);

		loadDoUongcombobox();
	}

	private void loadDoUongcombobox() {
		int index = cbloaicansua.getSelectedIndex();
		cbloaidpuong.setSelectedIndex(index);
		
		LoaidouongDto loaidouong = arrLoaidouong.get(index);
		arrDouong = DoUongBus.getInstance().getList(loaidouong.maloai);
		String[] arr = new String[arrDouong.size()];
		for (int i = 0; i < arrDouong.size(); i++) {
			arr[i] = arrDouong.get(i).tendouong;
		}
		cbtendouongcansua.setModel(new DefaultComboBoxModel<>(arr));
		if (arrDouong.size() != 0) {
			cbtendouongcansua.setSelectedIndex(0);
		}
		cbtendouongcansua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					loadContent();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
	}

	private void loadContent() throws SQLException {
		int index = cbtendouongcansua.getSelectedIndex();
		Douongdto dto = arrDouong.get(index);
		tfTendouong.setText(dto.tendouong);
		int s,m,l;
		ResultSet rss =
		QLTS_DatabaseControler.getInstance().getProcedures().selectBanggia(1, dto.madouong);
		ResultSet rsm =
		QLTS_DatabaseControler.getInstance().getProcedures().selectBanggia(2, dto.madouong);
		ResultSet rsl =
		QLTS_DatabaseControler.getInstance().getProcedures().selectBanggia(3, dto.madouong);
		
		BanggiaDto bgdto = new BanggiaDto();
		while(rss.next()) {
			bgdto.mapping(rss);
			if(!bgdto.isdeleted) {
				break;
			}
		}
		tfS.setText(bgdto.giatien+"");
		
		bgdto = new BanggiaDto();
		while(rsm.next()) {
			bgdto.mapping(rsm);
			if(!bgdto.isdeleted) {
				break;
			}
		}
		tfM.setText(bgdto.giatien+"");
		
		bgdto = new BanggiaDto();
		while(rsl.next()) {
			bgdto.mapping(rsl);
			if(!bgdto.isdeleted) {
				break;
			}
		}
		tfL.setText(bgdto.giatien+"");
	}
	private void creatnew() {
		String tendouong = tfTendouong.getText();
		String giaS = tfS.getText().trim();
		String giaM = tfM.getText().trim();
		String giaL = tfL.getText().trim();
		int index = cbtendouongcansua.getSelectedIndex();
		Douongdto dto = arrDouong.get(index);
		int loaiindex = cbloaicansua.getSelectedIndex();
		LoaidouongDto loaiDto = arrLoaidouong.get(loaiindex);
		new Thread() {
			public void run() {
				QLTS_DatabaseControler.getInstance().getProcedures().updateDouong(dto.madouong, tendouong,
						loaiDto.maloai);
				if (!giaS.equals("")) {
					int S = Integer.parseInt(giaS);
					QLTS_DatabaseControler.getInstance().getProcedures().updateBanggia(1, dto.madouong, S);
				}
				if (!giaM.equals("")) {
					int M = Integer.parseInt(giaM);
					QLTS_DatabaseControler.getInstance().getProcedures().updateBanggia(2, dto.madouong, M);
				}
				if (!giaL.equals("")) {
					int L = Integer.parseInt(giaL);
					QLTS_DatabaseControler.getInstance().getProcedures().updateBanggia(3, dto.madouong, L);
				}
			}
		}.start();
		ToastMessage toast = new ToastMessage("Sửa đồ uống thành công", 3000);
		toast.setVisible(true);
		dispose();
	}

	private void delete() {
		String tendouong = tfTendouong.getText();
		String giaS = tfS.getText().trim();
		String giaM = tfM.getText().trim();
		String giaL = tfL.getText().trim();
		int index = cbtendouongcansua.getSelectedIndex();
		Douongdto dto = arrDouong.get(index);
		int loaiindex = cbloaicansua.getSelectedIndex();
		LoaidouongDto loaiDto = arrLoaidouong.get(loaiindex);
		new Thread() {
			public void run() {
				QLTS_DatabaseControler.getInstance().getProcedures().deleteDouong(dto.madouong);
				if (!giaS.equals("")) {
					int S = Integer.parseInt(giaS);
					QLTS_DatabaseControler.getInstance().getProcedures().deleteBanggia(1, dto.madouong);
				}
				if (!giaM.equals("")) {
					int M = Integer.parseInt(giaM);
					QLTS_DatabaseControler.getInstance().getProcedures().deleteBanggia(2, dto.madouong);
				}
				if (!giaL.equals("")) {
					int L = Integer.parseInt(giaL);
					QLTS_DatabaseControler.getInstance().getProcedures().deleteBanggia(3, dto.madouong);
				}
			}
		}.start();
		ToastMessage toast = new ToastMessage("Sửa đồ uống thành công", 3000);
		toast.setVisible(true);
		dispose();
	}
	private int maxIndex() {
		Douongdto dto = new Douongdto();
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectDouong();
		int max = -1;
		try {
			while (rs.next()) {
				dto.mapping(rs);
				max = Math.max(max, dto.madouong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
}
