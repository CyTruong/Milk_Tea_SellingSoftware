package bus.printer;

import bus.printer.report.ReportCat_Business;
import dal.iErrorReport;

public interface iPrinterModule {
	
	enum PrinterResult{
		SUCCESS,
		FAIL
	}
	public void setErrorReportListener(iErrorReport _ireport ) ;
	public void writeError(String error);
	
	PrinterResult createPrinter();
	PrinterResult createInvoice(int mahoadon);
	PrinterResult createBussinessReport(ReportCat_Business rp);
	PrinterResult showReport();
	PrinterResult printReport();
}
