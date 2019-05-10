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
	ResultSet selectLoaiDoUong();
	ResultSet selectLoaiDoUong(int maloai);
	boolean insertLoaiDoUong(String tenloai);
	boolean deleteLoaiDoUong(int maloai);
	boolean updateLoaiDoUong(int maloai,String tenloai);
	
	boolean deleteBanggia(int size,int madouong);
	boolean insertBanggia(int size,int madouong,int giatien);
	ResultSet selectBanggia();
	ResultSet selectBanggia(int size,int madouong);
	boolean updateLoaiDoUong(int size,int madouong,int giatien);
	
	boolean deleteChitiethoadon(int macthd);
	//topping char(256)
	boolean insertChitiethoadon(int mahoadon,int madouong,int size,String topping,int giatien);
	ResultSet selectChitiethoadon(int machititethoadon);
	ResultSet selectChitiethoadon();
	boolean updateChitiethoadon(int machitiethoadon,int mahoadon,int madouong,int size,String topping,int giatien);
	
	boolean insertHoadon(int tongtien,Timestamp thoigianmua,int hinhthucmua,int mathe,String magiamgia,int manhanvien,int tiennhan,boolean isdeleted);
	ResultSet selectHoadon(int mahoadon );
	ResultSet selectHoadon();
	boolean updateHoadon(int mahoadon,int tongtien,Timestamp thoigianmua,int hinhthucmua,int mathe,String magiamgia,int manhanvien,int tiennhan,boolean isdeleted);
	boolean deleteHoadon(int mahoadon);
	
	//đổi sdt thành string
	boolean insertNhanvien(String hoten,String sdt,String username,String password,int quyenhan);
	ResultSet selectNhanvien(int manhanvien);
	ResultSet selectNhanVien();
	boolean updateNhanvien(int manhanvien,String hoten,String sdt,String username,String password,int quyenhan);
	boolean deleteNhanvien(int manhanvien);
	
	
	boolean insertTopping(String tentopping,int giatien);
	ResultSet selectTopping(int matopping);
	ResultSet selectTopping();
	boolean updateTopping(int matopping,String tentopping,int giatien);
	boolean deleteTopping(int matopping);
	
	boolean insertDouong(String tendouong,int maloaidouong);
	boolean updateDouong(int madouong,String tedouong,int maloaidouong);
	boolean deleteDouong(int madouong);
	ResultSet selectDouong();
	ResultSet selectDouong(int madouong);
	
}
