package bus.printer.report;

import java.sql.Timestamp;

import bus.printer.Printer_Controler;
import bus.printer.Printer_Controler.PrinterModule;

public class testBussinessprinter {

	public static void main(String[] args) {
		Printer_Controler.getInstance().setModule(PrinterModule.REPORTCART);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		Object[] arg = {time};
		Printer_Controler.getInstance().getModule().createBussinessReport(new ReportCat_Bussinness_Byday(arg));
		Printer_Controler.getInstance().getModule().showReport();
	}

}
