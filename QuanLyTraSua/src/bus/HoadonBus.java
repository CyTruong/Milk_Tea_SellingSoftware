package bus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import dal.QLTS_DatabaseControler;
import dal.QLTS_SQL_Procedure;
import dal.iQLTS_Procedure;
import dto.HoadonDto;

public class HoadonBus {
	public static int currentCard = 0 ;
	public static int currentType = 0;
	public static int nextMangveid = 0;
	public static int curId = 0;
	public TreeMap<Integer, HoadonDto> drinkingTable ;
	
	private static HoadonBus _instance = null;

	public static HoadonBus getInstance() {
		if(_instance == null) {
			_instance = new HoadonBus();
		}
		return _instance;
	}
	
	public HoadonBus() {
			drinkingTable = new TreeMap<>();
			initIdThread init = new initIdThread(QLTS_DatabaseControler.getInstance().getProcedures());
			init.start();
	}
	
	public void reGet() {
		curId = 0;
		nextMangveid = 0;
		initIdThread init = new initIdThread(QLTS_DatabaseControler.getInstance().getProcedures());
		try {
			init.join();
		} catch (InterruptedException e) {
			init.start();
			e.printStackTrace();
		}
	}
	
}

class initIdThread extends Thread{

	private iQLTS_Procedure database_access;
	
	public  initIdThread(iQLTS_Procedure dal) {
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
					HoadonBus.getInstance().nextMangveid=Math.max(HoadonBus.getInstance().nextMangveid, hoadon.mathe); 					
					HoadonBus.getInstance().curId = Math.max(HoadonBus.getInstance().curId, hoadon.mahoadon);
				}
				HoadonBus.getInstance().nextMangveid++;
				System.out.println("Id mang ve tiep theo theo "+HoadonBus.getInstance().nextMangveid);
				System.out.println("Id  "+HoadonBus.getInstance().curId);
			}   catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
