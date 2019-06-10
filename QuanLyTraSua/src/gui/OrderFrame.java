package gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import bus.DoUongBus;
import bus.LoaidouongBus;
import bus.PurchaseBus;
import bus.Size;
import bus.ToppingBus;
import dto.Douongdto;
import dto.LoaidouongDto;
import dto.ToppingDto;
import gui.chooseSizeDialog.iChooseSizeFinish;
import java.awt.SystemColor;

public class OrderFrame extends JFrame {

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

	private JTable ChiTietOrder;
	private JTextField tfTongTien;
	private JButton btnTrangChu;
	private JButton btnXoaMon;
	private JButton btnInHoaDon;
	private JButton btnLoai1;
	private JButton btnLoai2;
	private JButton btnLoai3;
	private JButton btnTopping;
	private JButton btnLen1;
	private JButton btnXuong1;
	private JButton btnLen;
	private JButton btnXuong;
	private int LoaiDUIndex = 0;
	ArrayList<LoaidouongDto> arrLoaidouongDto;
	ArrayList<Douongdto> arrDouongDto;
	private LoaidouongDto LoaiDU;
	private JPanel pnDanhSachDoUong;
	private JButton btn1;
	ArrayList<Order> arrOrder;
	DefaultTableModel model;
	int Tongtien = 0;

	@SuppressWarnings("serial")
	public OrderFrame() {
		setUndecorated(true);
		arrLoaidouongDto = new ArrayList<LoaidouongDto>();
		arrLoaidouongDto = LoaidouongBus.getInstance().getListDto();
		arrOrder = new ArrayList<>();
		arrDouongDto = new ArrayList<Douongdto>();
		LoaiDU = arrLoaidouongDto.get(LoaiDUIndex + 0);
		arrDouongDto = DoUongBus.getInstance().getList(LoaiDU.maloai);
		getContentPane().setBackground(new Color(255, 154, 15));
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(93, 106, 1021, 404);
		getContentPane().add(scrollPane);

		model = new DefaultTableModel();
		ChiTietOrder = new JTable(model);
		model.addColumn("STT");
		model.addColumn("Tên món");
		model.addColumn("Số lượng");
		model.addColumn("Giá");
		ChiTietOrder.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
		ChiTietOrder.setFont(new Font("Segoe UI", Font.BOLD, 18));
		ChiTietOrder.setRowHeight(45);
		ChiTietOrder.getColumnModel().getColumn(0).setMinWidth(50);
		ChiTietOrder.getColumnModel().getColumn(1).setMinWidth(500);
		ChiTietOrder.getColumnModel().getColumn(2).setMinWidth(120);
		ChiTietOrder.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		ChiTietOrder.setBackground(new Color(191, 134, 56));
		ChiTietOrder.setForeground(new Color(81, 165, 236));

		scrollPane.setViewportView(ChiTietOrder);

		ImageIcon icon = new ImageIcon("images/mtlen.png");
		btnLen1 = new JButton(icon);
		btnLen1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiDUIndex += 3;
				LoadLoaiDoUong();
				if ((LoaiDUIndex + 3 >= arrLoaidouongDto.size())) {
					btnXuong1.setEnabled(true);
					btnLen1.setEnabled(false);
				}

			}
		});
		btnLen1.setForeground(Color.WHITE);
		btnLen1.setBackground(new Color(255, 154, 15));
		btnLen1.setLocation(393, 588);
		btnLen1.setSize(135, 70);
		getContentPane().add(btnLen1);

		ImageIcon icon1 = new ImageIcon("images/mtxuong.png");
		btnXuong1 = new JButton(icon1);
		btnXuong1.setEnabled(false);
		btnXuong1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiDUIndex -= 3;
				LoadLoaiDoUong();
				if (LoaiDUIndex + 3 <= arrLoaidouongDto.size()) {
					btnXuong1.setEnabled(false);
					btnLen1.setEnabled(true);
				}

			}
		});
		btnXuong1.setForeground(Color.WHITE);
		btnXuong1.setBackground(new Color(255, 154, 15));
		btnXuong1.setLocation(396, 960);
		btnXuong1.setSize(135, 70);
		getContentPane().add(btnXuong1);

		ImageIcon home = new ImageIcon("images/home.png");
		btnTrangChu = new JButton("  " + "Trang chủ");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame menuframe = new MenuFrame();
				menuframe.setVisible(true);
				menuframe.setFocusable(true);
				dispose();
			}
		});
		btnTrangChu.setIcon(home);
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setFont(new Font("Segoe UI", Font.BOLD, 24));
		btnTrangChu.setBackground(new Color(204, 0, 0));
		btnTrangChu.setBounds(1579, 47, 297, 70);
		getContentPane().add(btnTrangChu);

		JLabel lblTheLoai = new JLabel("Thể loại");
		lblTheLoai.setHorizontalAlignment(SwingConstants.LEFT);
		lblTheLoai.setForeground(new Color(204, 0, 0));
		lblTheLoai.setBackground(new Color(255,154, 15));
		lblTheLoai.setFont(new Font("Segoe UI", Font.BOLD, 34));
		lblTheLoai.setBounds(176, 529, 148, 46);
		getContentPane().add(lblTheLoai);

		JLabel lblDanhSch = new JLabel("Danh sách đồ uống");
		lblDanhSch.setHorizontalAlignment(SwingConstants.LEFT);
		lblDanhSch.setForeground(new Color(204, 0, 0));
		lblDanhSch.setFont(new Font("Segoe UI", Font.BOLD, 34));
		lblDanhSch.setBackground(new Color(255,154, 15));
		lblDanhSch.setBounds(554, 529, 327, 46);
		getContentPane().add(lblDanhSch);

		JLabel lbTongTien = new JLabel("Tổng tiền");
		lbTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		lbTongTien.setForeground(new Color(204, 0, 0));
		lbTongTien.setFont(new Font("Segoe UI", Font.BOLD, 34));
		lbTongTien.setBackground(new Color(255,154, 15));
		lbTongTien.setBounds(93, 47, 187, 46);
		getContentPane().add(lbTongTien);

		tfTongTien = new JTextField();
		tfTongTien.setFont(new Font("Segoe UI", Font.BOLD, 30));
		tfTongTien.setBounds(277, 47, 254, 42);
		getContentPane().add(tfTongTien);

		ImageIcon dele = new ImageIcon("images/delete.png");
		btnXoaMon = new JButton("  " + "Xóa món");
		btnXoaMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (arrOrder.size() >= 0) {
					arrOrder.remove(arrOrder.size() - 1);
					loadTable();
				}

			}
		});
		btnXoaMon.setForeground(Color.WHITE);
		btnXoaMon.setHorizontalAlignment(SwingConstants.LEFT);
		btnXoaMon.setIcon(dele);
		btnXoaMon.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnXoaMon.setBackground(new Color(204, 0, 0));
		btnXoaMon.setBounds(1180, 205, 297, 80);
		getContentPane().add(btnXoaMon);

		btnLoai1 = new JButton("");
		btnLoai1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoaiDU = arrLoaidouongDto.get(LoaiDUIndex + 0);
				LoadDoUong();
			}
		});
		btnLoai1.setForeground(Color.WHITE);
		btnLoai1.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLoai1.setBackground(new Color(204, 0, 0));
		btnLoai1.setBounds(93, 588, 300, 100);
		getContentPane().add(btnLoai1);

		btnLoai2 = new JButton("Sinh tố");
		btnLoai2.setForeground(Color.WHITE);
		btnLoai2.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLoai2.setBackground(new Color(204, 0, 0));
		btnLoai2.setBounds(93, 702, 300, 100);
		btnLoai2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTopping.doClick();
			}
		});
		getContentPane().add(btnLoai2);

		btnLoai3 = new JButton("Cà phê");
		btnLoai3.setForeground(Color.WHITE);
		btnLoai3.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnLoai3.setBackground(new Color(204, 0, 0));
		btnLoai3.setBounds(93, 817, 300, 100);
		btnLoai3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		getContentPane().add(btnLoai3);

		btnTopping = new JButton("Topping");
		btnTopping.setForeground(Color.WHITE);
		btnTopping.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnTopping.setBackground(new Color(255, 65, 0));
		btnTopping.setBounds(93, 930, 300, 100);
		btnTopping.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				loadTopping();
			}
		});
		getContentPane().add(btnTopping);

		pnDanhSachDoUong = new JPanel();
		pnDanhSachDoUong.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		pnDanhSachDoUong.setBounds(540, 588, 789, 441);
		getContentPane().add(pnDanhSachDoUong);
		pnDanhSachDoUong.setBackground(SystemColor.control);
		pnDanhSachDoUong.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		ImageIcon print = new ImageIcon("images/printer.png");
		btnInHoaDon = new JButton("  " + "In hóa đơn");
		btnInHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*PurchaseBus.getInstance().creatnewOrder();
				for(Order order : arrOrder) {
					PurchaseBus.getInstance().Themmon(order.madouong, order.Size, order.arrTopping);
				}
				PurchaseBus.getInstance().finnishOrder(1, 1, ""	, 50000);*/
				NhantienDialog diag = new NhantienDialog(arrOrder);
				diag.setVisible(true);
			}
		});
		btnInHoaDon.setForeground(Color.WHITE);
		btnInHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnInHoaDon.setIcon(print);
		btnInHoaDon.setFont(new Font("Segoe UI", Font.BOLD, 30));
		btnInHoaDon.setBackground(new Color(204, 0, 0));
		btnInHoaDon.setBounds(1180, 319, 297, 80);
		getContentPane().add(btnInHoaDon);

		ImageIcon cup = new ImageIcon("images/cup.png");
		JLabel lbHinhAnh1 = new JLabel(cup);
		lbHinhAnh1.setForeground(Color.WHITE);
		lbHinhAnh1.setBounds(1543, 152, 329, 239);
		getContentPane().add(lbHinhAnh1);

		btnLen = new JButton(icon);
		btnLen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLen.setForeground(Color.WHITE);
		btnLen.setBackground(new Color(255, 154, 15));
		btnLen.setBounds(1364, 588, 135, 70);
		getContentPane().add(btnLen);

		btnXuong = new JButton(icon1);
		btnXuong.setForeground(Color.WHITE);
		btnXuong.setBackground(new Color(255, 154, 15));
		btnXuong.setBounds(1364, 960, 135, 70);
		getContentPane().add(btnXuong);

		ImageIcon menu = new ImageIcon("images/menu.png");
		JLabel lbHinhAnh2 = new JLabel(menu);
		lbHinhAnh2.setBounds(1522, 588, 354, 386);
		getContentPane().add(lbHinhAnh2);
		LoadLoaiDoUong();
		LoadDoUong();
		loadTable();
	}

	public void LoadLoaiDoUong() {

		if (LoaiDUIndex + 0 < arrLoaidouongDto.size()) {
			btnLoai1.setText(arrLoaidouongDto.get(LoaiDUIndex).tenloai);
			btnLoai1.setEnabled(true);
		} else {
			btnLoai1.setText("");
			btnLoai1.setEnabled(false);
		}

		if (LoaiDUIndex + 1 < arrLoaidouongDto.size()) {
			btnLoai2.setText(arrLoaidouongDto.get(LoaiDUIndex + 1).tenloai);
			btnLoai2.setEnabled(true);
		} else {
			btnLoai2.setText("");
			btnLoai2.setEnabled(false);
		}

		if (LoaiDUIndex + 2 < arrLoaidouongDto.size()) {
			btnLoai3.setText(arrLoaidouongDto.get(LoaiDUIndex + 2).tenloai);
			btnLoai3.setEnabled(true);
		} else {
			btnLoai3.setText("");
			btnLoai3.setEnabled(false);
		}
		/*
		 * if (LoaiDUIndex + 3 < arrLoaidouongDto.size()) {
		 * btnTopping.setText(arrLoaidouongDto.get(LoaiDUIndex + 3).tenloai);
		 * btnTopping.setEnabled(true); } else { btnTopping.setText("");
		 * btnTopping.setEnabled(false); }
		 */
	}

	public void LoadDoUong() {
		pnDanhSachDoUong.removeAll();
		pnDanhSachDoUong.repaint();

		arrDouongDto = DoUongBus.getInstance().getList(LoaiDU.maloai);
		for (Douongdto douongdto : arrDouongDto) {
			DoUongButton bt = new DoUongButton();
			bt.setDto(douongdto);
			bt.setonActionDouongDtoListener(new iDuonuongDtoActionListener() {

				@Override
				public void onActionDouongDtoListener(Douongdto dto) {
					chooseSizeDialog chossesize = new chooseSizeDialog();
					chossesize.setOnFinishChooseSizeListener(new iChooseSizeFinish() {
						
						@Override
						public void ChoosesizeFinish(int i) {
							arrOrder.add(new Order(dto, i));
							System.out.println("Click " + dto.tendouong+" size "+i);
							loadTable();							
						}
					});
					chossesize.setVisible(true);
				}
			});

			pnDanhSachDoUong.add(bt);
			pnDanhSachDoUong.revalidate();
		}
	}

	private void loadTopping() {
		pnDanhSachDoUong.removeAll();
		pnDanhSachDoUong.repaint();

		ArrayList<ToppingDto> arrTopping = ToppingBus.getInstance().getList();
		for (ToppingDto toppingDto : arrTopping) {
			ToppingButton bt = new ToppingButton();
			bt.setDto(toppingDto);
			bt.setonActionToppingDtoListener(new iToppingDtoActionListener() {

				@Override
				public void onActionToppingDtoListener(ToppingDto dto) {
					arrOrder.get(arrOrder.size() - 1).arrTopping.add(dto);
					loadTable();
				}
			});
			pnDanhSachDoUong.add(bt);
			pnDanhSachDoUong.revalidate();
		}
	}

	public void loadTable() {
		while (model.getRowCount() != 0) {
			model.removeRow(0);
		}
		Tongtien = 0;
		
		for (int i = 0; i < arrOrder.size(); i++) {
			Order order = arrOrder.get(i);
			String size = Size.getSize(order.Size);
			model.addRow(new String[] { i + "", order.tendouong+" ("+size+")", "1", order.Giatien + "" });
			for (ToppingDto toppingdto : order.arrTopping) {
				model.addRow(new String[] { "", "   +" + toppingdto.tentopping, "", toppingdto.giatien + "" });
				Tongtien += toppingdto.giatien;
			}
			Tongtien += order.Giatien;
		}
		tfTongTien.setText(Tongtien + "");
		ChiTietOrder.revalidate();
		ChiTietOrder.repaint();
	}

}

/////////////////////////////////////////Do uong button///////////////////////////
interface iDuonuongDtoActionListener {
	public void onActionDouongDtoListener(Douongdto dto);
}

class DoUongButton extends JButton implements ActionListener {
	private iDuonuongDtoActionListener _action = null;
	private Douongdto _dto;

	public DoUongButton() {
		this.setFont(new Font("Segoe UI", Font.BOLD, 18));
		this.setBackground(new Color(204, 0, 0));
		this.setPreferredSize(new Dimension(255, 90));
		this.setForeground(Color.white);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (_action != null) {
			_action.onActionDouongDtoListener(_dto);
		}
	}

	public void setDto(Douongdto dto) {
		_dto = dto;
		this.setText(_dto.tendouong);
	}

	public void setonActionDouongDtoListener(iDuonuongDtoActionListener ilistener) {
		_action = ilistener;
	}
}
///////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////Topping Button///////////////////////////////
interface iToppingDtoActionListener {
	public void onActionToppingDtoListener(ToppingDto dto);
}

class ToppingButton extends JButton implements ActionListener {
	private iToppingDtoActionListener _action = null;
	private ToppingDto _dto;

	public ToppingButton() {
		this.setFont(new Font("Segoe UI", Font.BOLD, 18));
		this.setBackground(new Color(204, 0, 0));
		this.setPreferredSize(new Dimension(255, 90));
		this.setForeground(Color.white);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (_action != null) {
			_action.onActionToppingDtoListener(_dto);
		}
	}

	public void setDto(ToppingDto dto) {
		_dto = dto;
		this.setText(_dto.tentopping);
	}

	public void setonActionToppingDtoListener(iToppingDtoActionListener ilistener) {
		_action = ilistener;
	}
}

///////////////////////////////////////////Order class /////////////////////////////
