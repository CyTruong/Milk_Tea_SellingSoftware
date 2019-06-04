package bus;

import java.sql.Timestamp;
import java.util.ArrayList;

import dal.QLTS_DatabaseControler;
import dto.ChitiethoadonDto;

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
	
	public boolean Themmon(int madouong,int size,String topping) {
		ChitiethoadonDto chitiethoadon = new ChitiethoadonDto();
		chitiethoadon.madouong = madouong;
		chitiethoadon.size = size;
		chitiethoadon.topping = topping;
		chitiethoadon.mahoadon = 0;
		chitiethoadon.giatien = DoUongBus.getInstance().getGiatien(madouong, size);
		orderlist.add(chitiethoadon);
		return true;
	}
	
	public boolean removeOrder(int index) {
		orderlist.remove(index);
		return true;
	}
	
	public void creatnewOrder() {
		orderlist = new ArrayList<>();
	}
	
	public boolean finnishOrder(int Hinhthucmua,int mathe,String magiamgia,int tiennhan) {
		int tongtien = 0;
		for (ChitiethoadonDto chitiethoadonDto : orderlist) {
			tongtien+= chitiethoadonDto.giatien;
		}
		QLTS_DatabaseControler.getInstance().getProcedures().insertHoadon(tongtien,new Timestamp(System.currentTimeMillis()), Hinhthucmua, mathe, magiamgia,1, tiennhan, false);

	//	QLTS_DatabaseControler.getInstance().getProcedures().insertHoadon(tongtien,new Timestamp(System.currentTimeMillis()), Hinhthucmua, mathe, magiamgia,LoginBus.loginUser.manhanvien, tiennhan, false);
		HoadonBus.getInstance().reGet();
		HoadonBus.getInstance().curId++;

		for (ChitiethoadonDto chitiethoadonDto : orderlist) {
			QLTS_DatabaseControler.getInstance().getProcedures().insertChitiethoadon(HoadonBus.getInstance().curId, chitiethoadonDto.madouong, chitiethoadonDto.size, chitiethoadonDto.topping, chitiethoadonDto.giatien);	
		}
		return true;
	}
}