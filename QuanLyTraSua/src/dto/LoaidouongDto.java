package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaidouongDto extends baseDto
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
		this.isdeleted = dto.isdeleted;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public void mapping(ResultSet sqlResult) throws SQLException {
			this.maloai = sqlResult.getInt(1);
			this.tenloai = sqlResult.getString(2);
			this.isdeleted = sqlResult.getBoolean(3);
		

	}

}
