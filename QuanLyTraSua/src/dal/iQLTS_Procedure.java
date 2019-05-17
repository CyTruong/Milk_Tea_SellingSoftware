package dal;
/**
 * 
 */
import java.sql.*;
/**
 * @author Admin
 *
 */
//Thêm creat by và idelete
public interface iQLTS_Procedure {
	
	public void setErrorReportListener(iErrorReport _ireport ) ;
	public void writeError(String error);
	
	public ResultSet selectLoaiDoUong();
	public ResultSet selectLoaiDoUong(int maloai);
	public boolean insertLoaiDoUong(String tenloai);
	public boolean deleteLoaiDoUong(int maloai);
	public boolean updateLoaiDoUong(int maloai,String tenloai);
	
	public boolean deleteBanggia(int size,int madouong);
	public boolean insertBanggia(int size,int madouong,int giatien);
	public ResultSet selectBanggia();
	public ResultSet selectBanggia(int size,int madouong);
	public boolean updateLoaiDoUong(int size,int madouong,int giatien);
	
	public boolean deleteChitiethoadon(int macthd);
	//topping char(256)
	public boolean insertChitiethoadon(int mahoadon,int madouong,int size,String topping,int giatien);
	public ResultSet selectChitiethoadon(int machititethoadon);
	public ResultSet selectChitiethoadon();
	public boolean updateChitiethoadon(int machitiethoadon,int mahoadon,int madouong,int size,String topping,int giatien);
	
	public boolean insertHoadon(int tongtien,Timestamp thoigianmua,int hinhthucmua,int mathe,String magiamgia,int manhanvien,int tiennhan,boolean isdeleted);
	public ResultSet selectHoadon(int mahoadon );
	public ResultSet selectHoadon();
	public boolean updateHoadon(int mahoadon,int tongtien,Timestamp thoigianmua,int hinhthucmua,int mathe,String magiamgia,int manhanvien,int tiennhan,boolean isdeleted);
	boolean deleteHoadon(int mahoadon);
	
	//đổi sdt thành string
	public boolean insertNhanvien(String hoten,String sdt,String username,String password,int quyenhan);
	public ResultSet selectNhanvien(int manhanvien);
	public ResultSet selectNhanVien();
	public boolean updateNhanvien(int manhanvien,String hoten,String sdt,String username,String password,int quyenhan);
	public boolean deleteNhanvien(int manhanvien);
	
	
	public boolean insertTopping(String tentopping,int giatien);
	public ResultSet selectTopping(int matopping);
	public ResultSet selectTopping();
	public boolean updateTopping(int matopping,String tentopping,int giatien);
	public boolean deleteTopping(int matopping);
	
	public boolean insertDouong(String tendouong,int maloaidouong);
	public boolean updateDouong(int madouong,String tedouong,int maloaidouong);
	public boolean deleteDouong(int madouong);
	public ResultSet selectDouong();
	public ResultSet selectDouong(int madouong);
	
}
