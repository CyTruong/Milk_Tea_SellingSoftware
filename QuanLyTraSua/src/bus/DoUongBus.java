package bus;

import java.sql.ResultSet;
import java.sql.SQLException;

import dal.QLTS_DatabaseControler;
import dto.BanggiaDto;
import dto.Douongdto;

public class DoUongBus {
	private static DoUongBus _instance;

	public static DoUongBus getInstance() {
		if (_instance == null) {
			_instance = new DoUongBus();
		}
		return _instance;
	}

	public Douongdto getDto(int madouong) {
		Douongdto dto = new Douongdto();
		try {
			ResultSet result = QLTS_DatabaseControler.getInstance().getProcedures().selectDouong(madouong);
			dto.mapping(result);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		return dto;
	}
	
	public int getGiatien(int madouong ,int size) {
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectBanggia(size, madouong);
		try {
			while(rs.next()) {
				BanggiaDto banggia = new BanggiaDto();
				return banggia.giatien;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

}
