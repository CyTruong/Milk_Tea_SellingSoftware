import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class QLTS_SQLDatabaseService extends QLTS_DB implements iQLTS_Procedure {

	private String connectionString ;
	private iErrorReport iErrorReport;
	private CallableStatement callableStatement;
	
	public QLTS_SQLDatabaseService(String _connectionString) {
		this.connectionString = _connectionString;
		// TODO Auto-generated constructor stub
	}
	
	public void setErrorReportListener(iErrorReport _ireport ) {
		this.iErrorReport = _ireport;
	}
	private void writeError(String error) {
		this.reportError = error;
		if(iErrorReport!=null) {
			this.iErrorReport.weHaveError(this.reportError);
		}
	}
	
	@Override
	public void CreatConnection() {
		try {
			this.connection = DriverManager.getConnection(connectionString);
		} catch (SQLException e) {
			writeError(e.toString());
		}
	}

	@Override
	public void Disconnect() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public ResultSet selectLoaiDoUong() {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call LOAI_DO_UONG_INSERTPROCEDURE(?, ?)}");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}
		return null;
	}

	@Override
	public ResultSet selectLoaiDoUong(int maloai) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertLoaiDoUong(String tenloai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLoaiDoUong(int maloai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLoaiDoUong(int maloai, String tenloai) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBanggia(String size, int madouong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertBanggia(String size, int madouong, int giatien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet selectBanggia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectBanggia(String size, int madouong) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateLoaiDoUong(String size, int madouong, int giatien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteChitiethoadon(int macthd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertChitiethoadon(int mahoadon, int madouong, String size, String topping) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet selectChitiethoadon(int machititethoadon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectChitiethoadon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateChitiethoadon(int machitiethoadon, int mahoadon, int madouong, String size, String topping) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertHoadon(int tongtien, Timestamp thoigianmua, int hinhthucmua, int mathe, int string) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet selectHodon(int mahoadon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectHodon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateHoadon(int tongtien, Timestamp thoigianmua, int hinhthucmua, int mathe, int string) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHoadon(int mahoadon) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertNhanvien(String hoten, String sdt, String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet selectNhanvien(int manhanvien) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectNhanVien() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateNhanvien(String hoten, String sdt, String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteNhanvien(int manhanvien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertTopping(String tentopping, int giatien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet selectTopping(int matopping) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectTopping() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTopping(String tentopping, int giatien) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTopping(int matopping) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertDouong(String tendouong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDouong(String tedouong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteDouong(int madouong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet selectDouong() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectDouong(int madouong) {
		// TODO Auto-generated method stub
		return null;
	}

}
