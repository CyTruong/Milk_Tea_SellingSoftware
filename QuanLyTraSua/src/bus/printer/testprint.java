package bus.printer;

import bus.printer.Printer_Controler.PrinterModule;

public class testprint {
	
	public static void main(String args[]) {
		Printer_Controler.getInstance().setModule(PrinterModule.REPORTCART);
		Printer_Controler.getInstance().getModule().creatInvoice();
		Printer_Controler.getInstance().getModule().showReport();
	}
}
