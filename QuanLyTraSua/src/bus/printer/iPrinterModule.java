package bus.printer;

import dal.iErrorReport;

public interface iPrinterModule {
	
	enum PrinterResult{
		SUCCESS,
		FAIL
	}
	public void setErrorReportListener(iErrorReport _ireport ) ;
	public void writeError(String error);
	
	PrinterResult creatPrinter();
	PrinterResult creatInvoice(int mahoadon);
	PrinterResult showReport();
	PrinterResult printReport();
}
