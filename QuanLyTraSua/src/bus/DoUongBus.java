package bus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
			while(result.next()) {
				dto.mapping(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		return dto;
	}
	
	public ArrayList<Douongdto> getList(int maloaidouong){
		ArrayList<Douongdto> arr = new ArrayList<>();
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectDouong();
		try {
			while(rs.next()) {
				Douongdto dto = new Douongdto();
				dto.mapping(rs);
				if(dto.madouong==maloaidouong && !dto.isdeleted) {
					arr.add(dto);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return arr;
	}
	public int getGiatien(int size ,int madouong) {
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectBanggia(size, madouong);
		try {
			while(rs.next()) {
				BanggiaDto banggia = new BanggiaDto();
				banggia.mapping(rs);
				if(!banggia.isdeleted) {
					return banggia.giatien;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

}
