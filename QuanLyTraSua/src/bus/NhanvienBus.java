package bus;

import java.sql.ResultSet;
import java.sql.SQLException;

import dal.QLTS_DatabaseControler;
import dto.NhanvienDto;

public class NhanvienBus {
	private static NhanvienBus _instance = null;
	
	public static NhanvienBus getInstance() {
		if(_instance == null) {
			_instance = new NhanvienBus();
		}
		return _instance;
	}
	public NhanvienBus() {
		
	}
	
	public NhanvienDto getDto(int manhanvien) {
		ResultSet rs = QLTS_DatabaseControler.getInstance().getProcedures().selectNhanvien(manhanvien);
		NhanvienDto nhanviendto = new NhanvienDto();
		nhanviendto.isdeleted = true;
		try {
			while(rs.next()&&!nhanviendto.isdeleted) {
				nhanviendto.mapping(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nhanviendto;
	}
}
