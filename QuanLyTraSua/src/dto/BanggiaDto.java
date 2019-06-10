package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BanggiaDto extends baseDto{
	
	public int size=0;
	public int madouong=0;
	public int giatien=0;

	public BanggiaDto() {
	}
	
	@Override
	public void mapping(ResultSet sqlResult) throws SQLException {
			this.size = sqlResult.getInt(1);
			this.madouong = sqlResult.getInt(2);
			this.giatien = sqlResult.getInt(3);
			this.isdeleted = sqlResult.getBoolean(4);
		
	}

}
