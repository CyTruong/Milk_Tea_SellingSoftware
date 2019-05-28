package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToppingDto extends baseDto{

	public int matopping;
	public String tentopping;
	public int giatien;
	
	public  ToppingDto() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mapping(ResultSet sqlResult) throws SQLException {
		// TODO Auto-generated method stub
		this.matopping = sqlResult.getInt(1);
		this.tentopping = sqlResult.getString(2).trim();
		this.giatien = sqlResult.getInt(3);
		this.isdeleted = sqlResult.getBoolean(4);
	}

}
