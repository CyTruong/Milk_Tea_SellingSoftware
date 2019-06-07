package bus.printer.report;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import bus.DoUongBus;
import bus.HoadonBus;
import bus.NhanvienBus;
import bus.ThongtinquanBus;
import dal.QLTS_DatabaseControler;
import dto.ChitiethoadonDto;
import dto.Douongdto;
import dto.HoadonDto;
import dto.NhanvienDto;
import li.netcat.print.Print;
import li.netcat.print.table.TableDataModel;
import li.netcat.print.table.TablePrint;
import li.netcat.print.table.TextTableCellDrawer;
import li.netcat.print.util.GridPrint;
import li.netcat.print.util.GridPrintConstraints;
import li.netcat.print.util.ScalePrint;
import li.netcat.print.util.TextPrint;

public abstract class ReportCat_Business {
	
	protected Object[] _arg;
	protected int _tongthu = 0;
	
	public ReportCat_Business(Object[] arg) {
		this._arg = arg;
	}
	
	public Print getPrint() {
		try {
			ThongtinquanBus.getInstance().getInfoFromDb();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GridPrintConstraints c = GridPrintConstraints.DEFAULT.hAlignCenter();
		GridPrint gp1 = new GridPrint(20, 20);
		gp1.add(getTenquan(),c.hAlignCenter());
		gp1.add(new ScalePrint(getTittle(),1.5,ScalePrint.MODE_AUTO_WIDTH),c);
		Print tb = new ScalePrint(getTable(),1.2,ScalePrint.MODE_AUTO_WIDTH);
		gp1.add(new ScalePrint(getTotal(),1.3,ScalePrint.MODE_AUTO_WIDTH),c);
		gp1.add(new ScalePrint(getTable(),1.2,ScalePrint.MODE_AUTO_WIDTH),c);
		return gp1;
		
	}
	private Print getTenquan() {
		GridPrint gpTenquan =  new GridPrint(0,20);
		TextPrint TPtenquan = new TextPrint(ThongtinquanBus.getInstance().info.tenquan);
		TPtenquan.setFont(new Font("VIVALDI", Font.BOLD, 30));
		TPtenquan.setHorizontalAlignment(JLabel.CENTER);
		TextPrint Tphorizontallie = new TextPrint("________________________");
		Tphorizontallie.setHorizontalAlignment(JLabel.CENTER);
		gpTenquan.add(TPtenquan);
		gpTenquan.add(Tphorizontallie);
		return gpTenquan;
	}
	
	private Print getTotal() {
		TextPrint tp = new TextPrint("Tổng thu: "+_tongthu+" vnđ");
		tp.setHorizontalAlignment(JLabel.RIGHT);
		return tp;
	}
	
	private TablePrint getTable() {
		RpTableModel table = new RpTableModel();
		TablePrint tp = new TablePrint(table);
		ResultSet orderResult = QLTS_DatabaseControler.getInstance().getProcedures().selectHoadon();
		ArrayList<HoadonDto> orderList = getFillterResult(orderResult);
		RpTableModel model = new RpTableModel();
	    for (HoadonDto hoadon : orderList) {
	    	_tongthu += hoadon.tongtien;
	    	ArrayList<ChitiethoadonDto> cthd_arr = HoadonBus.getInstance().getChitiethoadon(hoadon.mahoadon);
	    	for (ChitiethoadonDto chitiethoadonDto : cthd_arr) {
				Douongdto douongdto = DoUongBus.getInstance().getDto(chitiethoadonDto.madouong);
				NhanvienDto nhanviendto = NhanvienBus.getInstance().getDto(hoadon.manhanvien);
	    		table.add(hoadon.ngaymua,douongdto.tendouong+"+"+chitiethoadonDto.topping, nhanviendto.hoten, chitiethoadonDto.giatien);
			}
	    }
	    tp.setFitWidth(true);
	    tp.setColumnWeight(0, 1);
	    tp.setColumnWeight(1, 3);
	    tp.setColumnWeight(2, 2);
	    tp.setColumnWeight(3, 2);	
	    tp.setCellDrawer(String.class, new TextTableCellDrawer());

		return tp;
	}
	
	protected abstract Print getTittle() ;
	protected abstract ArrayList<HoadonDto> getFillterResult(ResultSet resultSet);
	
}

class RpTableModel implements TableDataModel{
	private String[] _header;
	private List _rows;
	
	public  RpTableModel() {
		_header =new String[]{"Thời gian","Món","Nhân viên","Giá"};
		_rows = new ArrayList();
	}
	
	public void add(Timestamp time,String tenmon,String tennv,int gia) {
		_rows.add(new String[] {new SimpleDateFormat("dd/MM HH:mm").format(time),tenmon,tennv,gia+""});
	}
	
	private Object getTypeAt(int columnIndex) {
		if (columnIndex == 3) {
			return Number.class;
		}
		return String.class;
	}
	
	@Override
	public int getColumnCount() {
		return _header.length;
	}

	@Override
	public Object getFooterAt(int arg0) {
		if (arg0 == 0) {
			return "Tổng";
		}
		if (arg0 == 2) {

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
		return false;
	}

	@Override
	public boolean hasHeader() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
