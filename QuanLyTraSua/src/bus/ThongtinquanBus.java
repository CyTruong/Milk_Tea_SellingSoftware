package bus;

import dto.ThongtinquanDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

import dal.*;

public class ThongtinquanBus {
	public ThongtinquanDTO info;
	
	private static ThongtinquanBus _instance = null;
	
	private ThongtinquanBus() {
		this.info = new ThongtinquanDTO();
		this.info.tenquan = "n";
		this.info.header = "h";
		this.info.footer = "f";
	}
	
	public static ThongtinquanBus getInstance() {
		if(_instance==null) {
			_instance = new ThongtinquanBus();
		}
		return _instance;
	}
	
	public void getInfoFromDb() throws SQLException {
		ResultSet resultSet= QLTS_DatabaseControler.getInstance().getProcedures().selectThongtinquan();
		while(resultSet.next()) {
			this.info.mapping(resultSet);
		}
		System.out.println(info.tenquan+" "+info.header+" "+info.footer);
	}
}
