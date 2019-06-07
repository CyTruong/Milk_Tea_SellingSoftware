package bus;

import bus.printer.Printer_Controler;
import bus.printer.Printer_Controler.PrinterModule;

public class testorder {

	public static void main(String[] args) {
		HoadonBus.getInstance();
		//tạo 1 đơn hàng mới
		PurchaseBus.getInstance().creatnewOrder();
		// thêm từng móm
		PurchaseBus.getInstance().Themmon(1, 1, "Trân châu đường đen");
		PurchaseBus.getInstance().Themmon(1, 1, "1 loại topping kì bí nào đó");
		PurchaseBus.getInstance().Themmon(1, 1, "đây chính là một cái topping etc nào đó mà tên nó dài vcl ra.... thằng này uống lắm topping vl ");

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
