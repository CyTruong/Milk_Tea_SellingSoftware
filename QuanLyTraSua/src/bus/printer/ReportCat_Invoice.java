package bus.printer;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import bus.Size;
import bus.ThongtinquanBus;
import dal.QLTS_DatabaseControler;
import dto.ChitiethoadonDto;
import dto.Douongdto;
import dto.HoadonDto;
import dto.NhanvienDto;
import li.netcat.print.Print;
import li.netcat.print.PrintConstants;
import li.netcat.print.table.DefaultTableCellDrawer;
import li.netcat.print.table.TableDataModel;
import li.netcat.print.table.TablePrint;
import li.netcat.print.table.TextTableCellDrawer;
import li.netcat.print.util.BorderPrint;
import li.netcat.print.util.GridPrint;
import li.netcat.print.util.GridPrintConstraints;
import li.netcat.print.util.ImagePrint;
import li.netcat.print.util.LinePrintBorder;
import li.netcat.print.util.ScalePrint;
import li.netcat.print.util.TextPrint;

public class ReportCat_Invoice {
	public static Image FLOWER = ImageLoader.loadImage("./res/Flower.gif");
	private int _mahoadon = 6;
	private HoadonDto _hoadondto;

	public ReportCat_Invoice(int mahoadon) throws SQLException {
		this._mahoadon = mahoadon;
		HoadonDto hoadon = new HoadonDto();
		ResultSet result = QLTS_DatabaseControler.getInstance().getProcedures().selectHoadon(_mahoadon);
		while (result.next()) {
			hoadon.mapping(result);
			_hoadondto = hoadon;
		}
	}

	public Print getPrint() throws SQLException {
		try {
			ThongtinquanBus.getInstance().getInfoFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		GridPrintConstraints c = GridPrintConstraints.DEFAULT.hAlignCenter();
		GridPrint inner = new GridPrint(20, 20);
		inner.add(Tenquan(), c.hAlignCenter().colWidth(120).colSpan(2));
		GridPrint Gp = new GridPrint(10, 10);
		Gp.add(getIcon(), c);
		Gp.add(Header(), c);
		inner.add(Gp);
		inner.add(tfHoadon(), c);
		inner.add(new ScalePrint(getThongtinHoadon(), 1.2, ScalePrint.MODE_AUTO_WIDTH), c);
		inner.add(new ScalePrint(gettabel(), 1.3, ScalePrint.MODE_AUTO_WIDTH), c);
		inner.add(new ScalePrint(gettienthoi(),1.2,ScalePrint.MODE_AUTO_WIDTH),c);
		inner.add(getFooter());
		return inner;
	}

	private Print Tenquan() {
		TextPrint TPtenquan = new TextPrint(ThongtinquanBus.getInstance().info.tenquan);
		TPtenquan.setFont(new Font("VIVALDI", Font.BOLD, 30));

		return TPtenquan;
	}

	private Print tfHoadon() {
		TextPrint TPhoadon = new TextPrint("Hóa đơn");
		TPhoadon.setFont(new Font("ARIAL", Font.BOLD, 25));
		TPhoadon.setHorizontalAlignment(JLabel.CENTER);
		return TPhoadon;

	}

	private Print Header() {
		TextPrint TPHeader = new TextPrint(ThongtinquanBus.getInstance().info.header);
		return TPHeader;
	}

	private Print getIcon() {
		Image LOGO = ImageLoader.loadImage("./res/icon.png");
		ImagePrint imagePrint = new ImagePrint(LOGO, 45, 45);
		return imagePrint;
	}

	private TablePrint gettabel() throws SQLException {
		invoiceModel reportmodel = new invoiceModel(_hoadondto);
		ResultSet chitiethoadonrsset = QLTS_DatabaseControler.getInstance().getProcedures().selectChitiethoadon();
		while (chitiethoadonrsset.next()) {
			ChitiethoadonDto cthd = new ChitiethoadonDto();
			cthd.mapping(chitiethoadonrsset);
			if (cthd.mahoadon == _mahoadon) {
				reportmodel.add(cthd);
			}
		}
		TablePrint TP = new TablePrint(reportmodel);
		TP.setMinimumColumnWidth(0, 100);
		TP.setMinimumColumnWidth(2, 80);
		TP.setFitWidth(true);
		TP.setCellDrawer(String.class, new TextTableCellDrawer());

		// TP.setFitWidth(true);
		/*
		 * DefaultTableCellDrawer cellDrawer =
		 * TP.createDefaultHeaderDrawer(PrintConstants.CENTER);
		 * cellDrawer.getDrawer().setFont(new Font("ARIAL", Font.BOLD | Font.ITALIC,
		 * 15)); TP.setDefaultHeaderDrawer(cellDrawer);
		 */
		return TP;
	}

	private Print getThongtinHoadon() throws SQLException {
		GridPrintConstraints c = GridPrintConstraints.DEFAULT;
		GridPrint GpHoadon = new GridPrint(2, 2);
		if(_hoadondto.hinhthucmua==1) {
			GpHoadon.add(new TextPrint("Mang về"));
		}else {
			GpHoadon.add(new TextPrint("Uống tại chổ"));
		}
		GridPrint gpleft = new GridPrint(2, 2);
		gpleft.add(new TextPrint("Mã hóa đơn : " + _hoadondto.mahoadon	));
		gpleft.add(new TextPrint("Nhân viên  : " + gettennhanvien(_hoadondto.manhanvien)));
		GpHoadon.add(gpleft, c.colSpan(2).colWidth(30));
		GridPrint gpRight = new GridPrint(2, 2);
		gpRight.add(
				new TextPrint("Thời gian  : " + new SimpleDateFormat("dd/MM/yyy HH:mm").format(_hoadondto.ngaymua)));
		gpRight.add(new TextPrint("Mã giảm giá: " + _hoadondto.magiamgia));
		GpHoadon.add(gpRight);

		return GpHoadon;
	}

	private String gettennhanvien(int manv) throws SQLException {
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectNhanvien(manv);
		while (rs.next()) {
			NhanvienDto nhanviendto = new NhanvienDto();
			nhanviendto.mapping(rs);
			return nhanviendto.hoten;
		}
		return "";
	}
	
	private Print gettienthoi() {
		GridPrint gp = new GridPrint();
		gp.add(new TextPrint("Tổng tiền      : "+_hoadondto.tongtien));
		gp.add(new TextPrint("Tiền nhận      : "+_hoadondto.tiennhan));
		gp.add(new TextPrint("Tiền thối      : "+(-_hoadondto.tongtien + _hoadondto.tiennhan)));
		return gp;
	}
	private Print getFooter() {
		TextPrint TPFooter = new TextPrint(ThongtinquanBus.getInstance().info.footer);
		TPFooter.setHorizontalAlignment(JLabel.CENTER);
		TPFooter.setFont(new Font("ARIAL", Font.ITALIC, 14));
		return TPFooter;
	}
}


class invoiceModel implements TableDataModel {

	private String[] _header;
	private List _rows;
	private HoadonDto _hoadon;

	public invoiceModel(HoadonDto hoadon) {
		_rows = new ArrayList();
		_header = new String[] { "Tên món", "Topping", "Giá" };
		_hoadon = hoadon;

	}

	public void add(ChitiethoadonDto dto) throws SQLException {
		Douongdto douong = new Douongdto();
		ResultSet result = QLTS_DatabaseControler.getInstance().getProcedures().selectDouong(dto.madouong);
		while (result.next()) {
			douong.mapping(result);
			_rows.add(new String[] { douong.tendouong + "(" + Size.getSize(dto.size) + ")", dto.topping,
					dto.giatien + "" });

		}
	}

	
	
	private static DecimalFormat format = new DecimalFormat("0.00");

	private String format(double value) {
		return format.format(value);
	}

	@Override
	public int getColumnCount() {
		return _header.length;

	}

	@Override
	public Object getFooterAt(int arg0) {
		if (arg0 == 0) {
			return "Tá»•ng";
		}
		if (arg0 == 2) {
			return format(_hoadon.tongtien);
		}
		return null;
	}

	@Override
	public Object getFooterTypeAt(int arg0) {
		return getTypeAt(arg0);
	}

	@Override
	public Object getHeaderAt(int arg0) {
		return _header[arg0];
	}

	@Override
	public Object getHeaderTypeAt(int arg0) {
		return String.class;

	}

	@Override
	public int getRowCount() {
		return _rows.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return ((String[]) _rows.get(arg0))[arg1];

	}

	@Override
	public Object getValueTypeAt(int arg0, int columnIndex) {
		return getTypeAt(columnIndex);
	}

	@Override
	public boolean hasFooter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean hasHeader() {
		// TODO Auto-generated method stub
		return true;
	}

	private Object getTypeAt(int columnIndex) {
		if (columnIndex == 2) {
			return Number.class;
		}
		return String.class;
	}
}
