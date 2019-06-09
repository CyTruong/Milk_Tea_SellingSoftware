package bus;

import java.util.ArrayList;

import bus.printer.Printer_Controler;
import bus.printer.Printer_Controler.PrinterModule;
import dto.ToppingDto;

public class testorder {

	public static void main(String[] args) {
		HoadonBus.getInstance();
		//tạo 1 đơn hàng mới
		PurchaseBus.getInstance().creatnewOrder();
		// thêm từng móm
		
		ToppingDto topping = ToppingBus.getInstance().getDto(1);
		ArrayList<ToppingDto> tp = new ArrayList<>();
		tp.add(topping);
		PurchaseBus.getInstance().Themmon(1, 1, tp);
		PurchaseBus.getInstance().Themmon(1, 1, tp);
		PurchaseBus.getInstance().Themmon(1, 1, tp);

		// xóa món với index là thứ tự món dc thêm
		//PurchaseBus.getInstance().XoaMon(index)
		// xác nhận đơn
		PurchaseBus.getInstance().finnishOrder(1,0,"ko có mã", 500000);
		//lấy mã đơn hàng vừa tạo
		int index = PurchaseBus.getInstance().getorderIndex();
		
		//set module cho module in
		Printer_Controler.getInstance().setModule(PrinterModule.REPORTCART);
		//tạo 1 bản in hóa đơn vs index là mã hóa đơn
		Printer_Controler.getInstance().getModule().createInvoice(index);
		//show hóa đơn
		Printer_Controler.getInstance().getModule().showReport();
		//in hóa đơn vừa tạo
		Printer_Controler.getInstance().getModule().printReport();


	}

}
