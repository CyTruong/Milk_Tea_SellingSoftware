package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaidouongDto
{
	public int maloai;
	public String tenloai;
	
	public LoaidouongDto() {
		maloai =-1;
		tenloai = "";
	}
	
	public LoaidouongDto(LoaidouongDto dto) {
		this.maloai = dto.maloai;
		this.tenloai = dto.tenloai;
	}
	
	public LoaidouongDto(ResultSet sqlResult) {
		try {
			this.maloai = sqlResult.getInt(1);
			this.tenloai = sqlResult.getString(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
