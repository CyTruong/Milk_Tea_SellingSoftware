package dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class HoadonDto extends baseDto {
	
	public int mahoadon;
	public int tongtien;
	public Timestamp ngaymua;
	public int hinhthucmua;
	public int mathe;
	public String magiamgia;
	public int manhanvien;
	public int tiennhan;
	
	public HoadonDto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mapping(ResultSet sqlResult) throws SQLException {
		this.mahoadon = sqlResult.getInt(1);
		this.tongtien = sqlResult.getInt(2);
		this.ngaymua = sqlResult.getTimestamp(3);
		this.hinhthucmua = sqlResult.getInt(4);
		this.mathe = sqlResult.getInt(5);
		this.magiamgia = sqlResult.getString(6);
		this.manhanvien = sqlResult.getInt(7);
		this.tiennhan = sqlResult.getInt(8);
		this.isdeleted = sqlResult.getBoolean(9);
	}

}
