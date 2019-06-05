package bus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import dal.QLTS_DatabaseControler;
import dto.ChitiethoadonDto;
import dto.HoadonDto;

public class PurchaseBus{
	private static PurchaseBus _instance;
	public static PurchaseBus getInstance() {
		if(_instance == null) {
			_instance = new PurchaseBus();
		}
		return _instance;
	}
	public PurchaseBus() {
		
	}
	
	private ArrayList<ChitiethoadonDto> orderlist = new ArrayList<>();
	private int orderIndex = 0;
	
	
	public boolean Themmon(int madouong,int size,String topping) {
		ChitiethoadonDto chitiethoadon = new ChitiethoadonDto();
		chitiethoadon.madouong = madouong;
		chitiethoadon.size = size;
		chitiethoadon.topping = topping;
		chitiethoadon.mahoadon = 0;
		chitiethoadon.giatien = DoUongBus.getInstance().getGiatien(size, madouong);
		orderlist.add(chitiethoadon);
		return true;
	}
	
	public boolean XoaMon(int index) {
		orderlist.remove(index);
		return true;
	}
	
	public void creatnewOrder() {
		orderlist = new ArrayList<>();
	}
	
	public int getorderIndex() {
		return orderIndex;
	}
	
	public boolean finnishOrder(int Hinhthucmua,int mathe,String magiamgia,int tiennhan) {
		int tongtien = 0;
		for (ChitiethoadonDto chitiethoadonDto : orderlist) {
			tongtien+= chitiethoadonDto.giatien;
		}
		QLTS_DatabaseControler.getInstance().getProcedures().insertHoadon(tongtien,new Timestamp(System.currentTimeMillis()), Hinhthucmua, mathe, magiamgia,1, tiennhan, false);

	//	QLTS_DatabaseControler.getInstance().getProcedures().insertHoadon(tongtien,new Timestamp(System.currentTimeMillis()), Hinhthucmua, mathe, magiamgia,LoginBus.loginUser.manhanvien, tiennhan, false);
		ResultSet resultset = QLTS_DatabaseControler.getInstance().getProcedures().selectHoadon();
		int lastInsert = 0;
		try {
			while(resultset.next()) {
				HoadonDto hoadon = new HoadonDto();
				hoadon.mapping(resultset);
				lastInsert=Math.max(lastInsert, hoadon.mahoadon); 					
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("last "+lastInsert);
		
		for (ChitiethoadonDto chitiethoadonDto : orderlist) {
			QLTS_DatabaseControler.getInstance().getProcedures().insertChitiethoadon(lastInsert, chitiethoadonDto.madouong, chitiethoadonDto.size, chitiethoadonDto.topping, chitiethoadonDto.giatien);	
		}
		orderIndex = lastInsert;
		return true;
	}
}