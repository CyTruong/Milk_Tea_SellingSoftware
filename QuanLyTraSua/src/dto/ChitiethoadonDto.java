package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChitiethoadonDto extends baseDto {

	public int machitiethoadon;
	public int mahoadon;
	public int madouong;
	public int size;
	public String topping;
	public int giatien;

	public ChitiethoadonDto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mapping(ResultSet sqlResult) throws SQLException {
		this.machitiethoadon = sqlResult.getInt(1);
		this.mahoadon = sqlResult.getInt(2);
		this.madouong = sqlResult.getInt(3);
		this.size = sqlResult.getInt(4);
		this.topping = sqlResult.getString(5).trim();
		this.giatien = sqlResult.getInt(6);
	}

}
