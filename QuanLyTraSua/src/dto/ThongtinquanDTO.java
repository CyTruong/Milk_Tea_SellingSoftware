package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThongtinquanDTO extends baseDto {
	public String tenquan;
	public String header;
	public String footer;

	public ThongtinquanDTO() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void mapping(ResultSet sqlResult) throws SQLException {
		this.tenquan = sqlResult.getString(1).trim().replace("-", "\n");
		this.header = sqlResult.getString(2).trim().replace("-", "\n");
		this.footer = sqlResult.getString(3).trim();
	}

}
