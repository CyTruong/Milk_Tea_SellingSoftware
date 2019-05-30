package bus.printer;

import bus.printer.Printer_Controler.PrinterModule;
import dal.iErrorReport;

public class testprint {
	
	public static void main(String args[]) {
		//các thao tác để in 1 report
		Printer_Controler.getInstance().setModule(PrinterModule.REPORTCART);
		Printer_Controler.getInstance().getModule().creatInvoice(6);
		Printer_Controler.getInstance().getModule().showReport();
		Printer_Controler.getInstance().getModule().printReport();

		
		//bắt sự in lỗi khi in report
		Printer_Controler.getInstance().getModule().setErrorReportListener(new iErrorReport() {
			
			@Override
			public void weHaveError(String errmess) {
				System.out.println("Lỗi khi in report "+errmess);
			}
		});
	}
}
