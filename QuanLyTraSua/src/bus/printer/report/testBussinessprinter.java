package bus.printer.report;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import bus.printer.Printer_Controler;
import bus.printer.Printer_Controler.PrinterModule;

public class testBussinessprinter {

	public static void main(String[] args) {
		Printer_Controler.getInstance().setModule(PrinterModule.REPORTCART);
		Timestamp time = new Timestamp(System.currentTimeMillis());
		
	
		Timestamp timefrom = Timestamp.valueOf("2019-06-09 10:10:10.0");
		
		Object[] arg = {timefrom};
		
		Printer_Controler.getInstance().getModule().createBussinessReport(new ReportCat_Businness_Byday(arg));
		Printer_Controler.getInstance().getModule().showReport();
	}

}
