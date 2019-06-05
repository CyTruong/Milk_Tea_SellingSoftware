package bus.printer;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import bus.DoUongBus;
import bus.ThongtinquanBus;
import dal.QLTS_DatabaseControler;
import dto.ChitiethoadonDto;
import dto.Douongdto;
import dto.HoadonDto;
import li.netcat.print.Print;
import li.netcat.print.table.TableDataModel;
import li.netcat.print.table.TablePrint;
import li.netcat.print.util.GridPrint;
import li.netcat.print.util.GridPrintConstraints;
import li.netcat.print.util.TextPrint;

public abstract class ReportCat_Business {
	
	private int _type;
	private Object[] _arg;
	
	public ReportCat_Business(int type,Object[] arg) {
		this._type = type;
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
		gp1.add(getTittle());
		gp1.add(getTable());
		return gp1;
		
	}
	private Print getTenquan() {
		GridPrint gpTenquan = new GridPrint(0,20);
		TextPrint TPtenquan = new TextPrint(ThongtinquanBus.getInstance().info.tenquan);
		TPtenquan.setFont(new Font("VIVALDI", Font.BOLD, 30));
		TPtenquan.setHorizontalAlignment(JLabel.CENTER);
		TextPrint Tphorizontallie = new TextPrint("________________________");
		Tphorizontallie.setHorizontalAlignment(JLabel.CENTER);
		gpTenquan.add(TPtenquan);
		gpTenquan.add(Tphorizontallie);
		return gpTenquan;
	}
	
	private TablePrint getTable() {
		RpTableModel table = new RpTableModel();
		TablePrint tp = new TablePrint(table);
		ResultSet orderResult = QLTS_DatabaseControler.getInstance().getProcedures().selectChitiethoadon();
		ArrayList<ChitiethoadonDto> orderList = getFillterResult(orderResult);
		RpTableModel model = new RpTableModel();
	    for (ChitiethoadonDto chitiethoadon : orderList) {
	    	HoadonDto hoadondto = new HoadonDto();
	    	hoadondto.isdeleted=true;
	    	ResultSet hoadonRs = QLTS_DatabaseControler.getInstance().getProcedures().selectHoadon(chitiethoadon.mahoadon);
	    	while(hoadonRs.next()&&!hoadondto.isdeleted) {
	    		hoadondto.mapping(hoadonRs);
	    	}
	    	Douongdto douongdto = DoUongBus.getInstance().getDto(chitiethoadon.madouong);
			model.add(hoadondto.ngaymua,douongdto.tendouong+"+"+chitiethoadon.topping , tennv, gia);

		}
		return tp;
	}
	
	protected abstract Print getTittle() ;
	protected abstract ArrayList<ChitiethoadonDto> getFillterResult(ResultSet resultSet);
	
}

class RpTableModel implements TableDataModel{
	private String[] _header;
	private List _rows;
	
	public  RpTableModel() {
		_header =new String[]{"Thời gian","Món","Nhân viên","Giá"};
		_rows = new ArrayList();
	}
	
	public void add(Timestamp time,String tenmon,String tennv,int gia) {
		_rows.add(new String[] {time.toString(),tenmon,tennv,gia+""});
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
		return true;
	}

	@Override
	public boolean hasHeader() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
