package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NhanvienDto extends baseDto {

	public int manhanvien;
	public String hoten;
	public String sdt;
	public String username;
	public int quyenhan;
	public String password;
	
	public NhanvienDto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mapping(ResultSet sqlResult) throws SQLException {
		// TODO Auto-generated method stu
		this.manhanvien = sqlResult.getInt(1);
		this.hoten = sqlResult.getString(2).replaceAll("  ", "");;
		this.sdt = sqlResult.getString(3).replaceAll("  ", "");
		this.username = sqlResult.getString(4).replaceAll(" ", "");
		this.password = sqlResult.getString(5).replaceAll(" ", "");
		this.quyenhan = sqlResult.getInt(6);
		this.isdeleted = sqlResult.getBoolean(7);
	}

}
