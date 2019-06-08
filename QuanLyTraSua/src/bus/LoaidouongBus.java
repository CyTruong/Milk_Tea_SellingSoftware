package bus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dal.QLTS_DatabaseControler;
import dto.LoaidouongDto;

public class LoaidouongBus {
	private static LoaidouongBus _instance;
	public static LoaidouongBus getInstance() {
		if(_instance== null) {
			_instance = new LoaidouongBus();
		}
		return _instance;
	}
	public LoaidouongBus() {
		
	}
	
	public ArrayList<LoaidouongDto> getListDto(){
		ArrayList<LoaidouongDto> arr = new ArrayList<>();
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectLoaiDoUong();
		try {
			while(rs.next()) {
				LoaidouongDto dto = new LoaidouongDto();
				dto.mapping(rs);
				if(!dto.isdeleted) {
					arr.add(dto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	
	public LoaidouongDto getDto(int maLoaidouong) {
		LoaidouongDto dto = new LoaidouongDto();
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectLoaiDoUong(maLoaidouong);
		try {
			while(rs.next()) {
				dto.mapping(rs);
				if(!dto.isdeleted) {
					return dto;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
}
