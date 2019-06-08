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
		
	
		Timestamp timefrom = Timestamp.valueOf("2019-06-06 10:10:10.0");
		
		Object[] arg = {timefrom,time};
		
		Printer_Controler.getInstance().getModule().createBussinessReport(new ReportCat_Business_FromTo(arg));
		Printer_Controler.getInstance().getModule().showReport();
	}

}
