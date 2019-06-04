package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Douongdto extends baseDto{

	public int madouong;
	public String tendouong;
	public int maloaidouong;
	public boolean isdeleted;
	
	public Douongdto() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mapping(ResultSet sqlResult) throws SQLException {
		// TODO Auto-generated method stub
		this.madouong = sqlResult.getInt(1);
		this.tendouong = sqlResult.getString(2).trim();
		this.maloaidouong = sqlResult.getInt(3);
		this.isdeleted = sqlResult.getBoolean(4);
	}

}
