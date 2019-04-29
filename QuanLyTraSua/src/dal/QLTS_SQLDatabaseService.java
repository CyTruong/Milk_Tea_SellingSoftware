package dal;
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
		} catch (Exception e) {
			writeError(e.toString());
		}
	}

	@Override
	public void Disconnect() {
		
	}

	
	@Override
	public ResultSet selectLoaiDoUong() {
		// TODO Auto-generated method stub
		try {
			ResultSet rs= connection.createStatement().executeQuery("select * from dbo.LOAI_DO_UONG");
			return rs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}
		return null;
	}

	@Override
	public ResultSet selectLoaiDoUong(int maloai) {
		try {
			callableStatement = connection.prepareCall("{call LOAI_DO_UONG_SELECTPROCEDURE(?)}");
			callableStatement.setInt(1, maloai);
			return callableStatement.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}		
		return null;
	}

	@Override
	public boolean insertLoaiDoUong(String tenloai) {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call LOAI_DO_UONG_INSERTPROCEDURE(?,?)}");
			callableStatement.setString(1, tenloai);
			callableStatement.setBoolean(2, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}		
		return false;
	}

	@Override
	public boolean deleteLoaiDoUong(int maloai) {
		return false;
	}

	@Override
	public boolean updateLoaiDoUong(int maloai, String tenloai) {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call LOAI_DO_UONG_UPDATEPROCEDURE(?,?,?)}");
			callableStatement.setInt(1, maloai);
			callableStatement.setString(2, tenloai);
			callableStatement.setBoolean(3, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writeError(e.toString());
		}
		return false;
	}

	@Override
	public boolean deleteBanggia(int size, int madouong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertBanggia(int size, int madouong, int giatien) {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call BANG_GIA_INSERTPROCEDURE(?,?,?,?)}");
			callableStatement.setInt(1, size);
			callableStatement.setInt(2, madouong);
			callableStatement.setInt(3, giatien);
			callableStatement.setBoolean(4,false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writeError(e.toString());
		}
		
		return false;
	}

	@Override
	public ResultSet selectBanggia() {
		try {
			return connection.createStatement().executeQuery("select * from BANG_GIA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}
		return null;
	}

	@Override
	public ResultSet selectBanggia(int size, int madouong) {
		try {
			callableStatement = connection.prepareCall("{call BANG_GIA_SELECTPROCEDURE (?,?)}");
			callableStatement.setInt(1, size);
			callableStatement.setInt(2, madouong);
			return callableStatement.executeQuery();
		} catch (Exception e) {
		
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateLoaiDoUong(int size, int madouong, int giatien) {
		try {
			callableStatement = connection.prepareCall("{call BANG_GIA_UPDATEPROCEDURE(?,?,?,?)}");
			callableStatement.setInt(1, size);
			callableStatement.setInt(2, madouong);
			callableStatement.setInt(3, giatien);
			callableStatement.setBoolean(4, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writeError(e.toString());
		}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteChitiethoadon(int macthd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertChitiethoadon(int mahoadon, int madouong, int size, String topping) {
		try {
			callableStatement = connection.prepareCall("{call CHI_TIET_HOA_DON_INSERTPROCEDURE(?,?,?,?,?)}");
			callableStatement.setInt(1, mahoadon);
			callableStatement.setInt(2, madouong);
			callableStatement.setInt(3, size);
			callableStatement.setString(4, topping);
			callableStatement.setBoolean(5, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet selectChitiethoadon(int machititethoadon) {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call CHI_TIET_HOA_DON_SELECTPROCEDURE(?)}");
			callableStatement.setInt(1, machititethoadon);
			return callableStatement.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet selectChitiethoadon() {
		try {
			return connection.createStatement().executeQuery("select * from CHI_TIET_HOA_DON");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}
		return null;
	}

	@Override
	public boolean updateChitiethoadon(int machitiethoadon, int mahoadon, int madouong, int size, String topping) {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call CHI_TIET_HOA_DON_UPDATEPROCEDURE(?,?,?,?,?,?)}");
			callableStatement.setInt(1, machitiethoadon);
			callableStatement.setInt(2, mahoadon);
			callableStatement.setInt(3, madouong);
			callableStatement.setInt(4, size);
			callableStatement.setString(5, topping);
			callableStatement.setBoolean(6, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean insertHoadon(int tongtien, Timestamp thoigianmua, int hinhthucmua, int mathe, String magiamgia,int manhanvien,int tiennhan,boolean isdeleted) {
		try {
			callableStatement = connection.prepareCall("{call HOA__ON_INSERTPROCEDURE(?,?,?,?,?,?,?,?)}");
			callableStatement.setInt(1, tongtien);
			callableStatement.setTimestamp(2, thoigianmua);
			callableStatement.setInt(3, hinhthucmua);
			callableStatement.setInt(4, mathe);
			callableStatement.setString(5, magiamgia);
			callableStatement.setInt(6, manhanvien);
			callableStatement.setInt(7, tiennhan);
			callableStatement.setBoolean(8, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet selectHoadon(int mahoadon) {
		try {
			callableStatement = connection.prepareCall("{call HOA__ON_SELECTPROCEDURE(?)}");
			callableStatement.setInt(1, mahoadon);
			return callableStatement.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectHoadon() {
		try {
			return connection.createStatement().executeQuery("select * from HOA_DON");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}
		return null;
	}

	@Override
	public boolean updateHoadon(int mahoadon,int tongtien, Timestamp thoigianmua, int hinhthucmua, int mathe, String magiamgia,int manhanvien,int tiennhan,boolean isdeleted) {
		try {
			callableStatement = connection.prepareCall("{call HOA__ON_UPDATEPROCEDURE(?,?,?,?,?,?,?,?,?)}");
			callableStatement.setInt(1, mahoadon);
			callableStatement.setInt(2, tongtien);
			callableStatement.setTimestamp(3, thoigianmua);
			callableStatement.setInt(4, hinhthucmua);
			callableStatement.setInt(5, mathe);
			callableStatement.setString(6, magiamgia);
			callableStatement.setInt(7, manhanvien);
			callableStatement.setInt(8, tiennhan);
			callableStatement.setBoolean(9, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
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
		try {
			callableStatement = connection.prepareCall("{call NHAN_VIEN_INSERTPROCEDURE(?,?,?,?,?)}");
			callableStatement.setString(1, hoten);
			callableStatement.setString(2, sdt);
			callableStatement.setString(3, username);
			callableStatement.setString(4, password);
			callableStatement.setBoolean(5, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet selectNhanvien(int manhanvien) {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call NHAN_VIEN_SELECTPROCEDURE(?)}");
			callableStatement.setInt(1, manhanvien);
			return callableStatement.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet selectNhanVien() {
		try {
			return connection.createStatement().executeQuery("select * from NHAN_VIEN");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}
		return null;
	}

	@Override
	public boolean updateNhanvien(int manhanvien,String hoten, String sdt, String username, String password) {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call NHAN_VIEN_UPDATEPROCEDURE(?,?,?,?,?,?)}");
			callableStatement.setInt(1, manhanvien);
			callableStatement.setString(2, hoten);
			callableStatement.setString(3, sdt);
			callableStatement.setString(4, username);
			callableStatement.setString(5, password);
			callableStatement.setBoolean(6, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			callableStatement = connection.prepareCall("{call TOPPING_INSERTPROCEDURE(?,?,?)}");
			callableStatement.setString(1, tentopping);
			callableStatement.setInt(2, giatien);
			callableStatement.setBoolean(3, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet selectTopping(int matopping) {
		try {
			callableStatement = connection.prepareCall("{call TOPPING_SELECTPROCEDURE(?)}");
			callableStatement.setInt(1, matopping);
			return callableStatement.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet selectTopping() {
		try {
			return connection.createStatement().executeQuery("select * from TOPPING");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}
		return null;
	}

	@Override
	public boolean updateTopping(int matopping,String tentopping, int giatien) {
		// TODO Auto-generated method stub
		try {
			callableStatement = connection.prepareCall("{call TOPPING_UPDATEPROCEDURE(?,?,?,?)}");
			callableStatement.setInt(1,matopping);
			callableStatement.setString(2, tentopping);
			callableStatement.setInt(3, giatien);
			callableStatement.setBoolean(4, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTopping(int matopping) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertDouong(String tendouong,int maloaidouong) {
		try {
			callableStatement = connection.prepareCall("{call _O_UONG_INSERTPROCEDURE(?,?,?)}");
			callableStatement.setString(1, tendouong);
			callableStatement.setInt(2, maloaidouong);
			callableStatement.setBoolean(3, false);
			callableStatement.executeUpdate();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateDouong(int madouong,String tedouong,int maloaidouong) {
		try {
			callableStatement = connection.prepareCall("{call _O_UONG_UPDATEPROCEDURE(?,?,?,?)}");
			callableStatement.setInt(1, maloaidouong);
			callableStatement.setString(2, tedouong);
			callableStatement.setInt(3, maloaidouong);
			callableStatement.setBoolean(4, false);
			callableStatement.executeUpdate();
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDouong(int madouong) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet selectDouong() {
		try {
			return connection.createStatement().executeQuery("select * from DO_UONG");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			writeError(e.toString());
		}
		return null;
	}

	@Override
	public ResultSet selectDouong(int madouong) {
		try {
			callableStatement = connection.prepareCall("{call _O_UONG_SELECTPROCEDURE(?)}");
			callableStatement.setInt(1, madouong);
			return callableStatement.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
