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
	ResultSet selectLoaiDoUong();
	ResultSet selectLoaiDoUong(int maloai);
	boolean insertLoaiDoUong(String tenloai);
	boolean deleteLoaiDoUong(int maloai);
	boolean updateLoaiDoUong(int maloai,String tenloai);
	
	boolean deleteBanggia(String size,int madouong);
	boolean insertBanggia(String size,int madouong,int giatien);
	ResultSet selectBanggia();
	ResultSet selectBanggia(String size,int madouong);
	boolean updateLoaiDoUong(String size,int madouong,int giatien);
	
	boolean deleteChitiethoadon(int macthd);
	//topping char(256)
	boolean insertChitiethoadon(int mahoadon,int madouong,String size,String topping);
	ResultSet selectChitiethoadon(int machititethoadon);
	ResultSet selectChitiethoadon();
	boolean updateChitiethoadon(int machitiethoadon,int mahoadon,int madouong,String size,String topping);
	
	boolean insertHoadon(int tongtien,Timestamp thoigianmua,int hinhthucmua,int mathe,int string);
	ResultSet selectHodon(int mahoadon );
	ResultSet selectHodon();
	boolean updateHoadon(int tongtien,Timestamp thoigianmua,int hinhthucmua,int mathe,int string);
	boolean deleteHoadon(int mahoadon);
	
	//đổi sdt thành string
	boolean insertNhanvien(String hoten,String sdt,String username,String password);
	ResultSet selectNhanvien(int manhanvien);
	ResultSet selectNhanVien();
	boolean updateNhanvien(String hoten,String sdt,String username,String password);
	boolean deleteNhanvien(int manhanvien);
	
	
	boolean insertTopping(String tentopping,int giatien);
	ResultSet selectTopping(int matopping);
	ResultSet selectTopping();
	boolean updateTopping(String tentopping,int giatien);
	boolean deleteTopping(int matopping);
	
	boolean insertDouong(String tendouong);
	boolean updateDouong(String tedouong);
	boolean deleteDouong(int madouong);
	ResultSet selectDouong();
	ResultSet selectDouong(int madouong);
	
}
