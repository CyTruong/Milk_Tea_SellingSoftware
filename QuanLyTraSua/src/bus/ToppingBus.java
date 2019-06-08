package bus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dal.QLTS_DatabaseControler;
import dto.ToppingDto;

public class ToppingBus {
	private static ToppingBus _instance;
	public static ToppingBus getInstance() {
		if(_instance==null) {
			 _instance = new ToppingBus();
		}
		return _instance;
	}
	
	public ToppingBus() {
		
	}
	
	public ToppingDto getDto(int matopping) {
		ToppingDto dto = new ToppingDto();
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectTopping(matopping);
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
	
	public ArrayList<ToppingDto> getList(){
		ArrayList<ToppingDto> arr = new ArrayList<>();
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectTopping();
		try {
			while(rs.next()) {
				ToppingDto dto = new ToppingDto();
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

}
