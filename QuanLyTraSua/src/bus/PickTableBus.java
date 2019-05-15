package bus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import dal.QLTS_SQLDatabaseService;
import dto.HoadonDto;

public class PickTableBus {
	public static int currentCard = 0 ;
	public static int currentType = 0;
	public static int nextMangveid = 0;
	public TreeMap<Integer, HoadonDto> drinkingTable ;
	
	private static PickTableBus _instance = null;

	public static PickTableBus getInstance() {
		if(_instance == null) {
			_instance = new PickTableBus();
		}
		return _instance;
	}
	
	public PickTableBus() {
			drinkingTable = new TreeMap<>();
			initIdThread init = new initIdThread(QLTS_SQLDatabaseService.getInstance());
			init.start();
	}
	
}

class initIdThread extends Thread{

	private QLTS_SQLDatabaseService database_access;
	
	public  initIdThread(QLTS_SQLDatabaseService dal) {
		this.database_access  = dal;
	} 
	@Override
	public void run() {
		synchronized (database_access) {
			 ResultSet resultset  =	database_access.selectHoadon();
			 try {
				while(resultset.next()) {
					HoadonDto hoadon = new HoadonDto();
					hoadon.mapping(resultset);
					if(hoadon.hinhthucmua==1) {
						if(hoadon.tongtien==0) {
							PickTableBus.getInstance().drinkingTable.put(hoadon.mathe, hoadon);
							System.out.println("Hoa don chua thanh toan "+hoadon.mathe);
						}
					}
					else {
						PickTableBus.getInstance().nextMangveid=Math.max(PickTableBus.getInstance().nextMangveid, hoadon.mathe);
					}
					
				 }
				PickTableBus.getInstance().nextMangveid++;
				
				System.out.println("Id mang về hiện tại "+PickTableBus.getInstance().nextMangveid);
			} catch (SQLException e) {
				database_access.writeError(e.toString());
				e.printStackTrace();
			}
		}
	}
	
}
