package bus.printer;

public interface iPrinterModule {
	
	enum PrinterResult{
		SUCCESS,
		FAIL
	}
	PrinterResult creatPrinter();
	PrinterResult creatInvoice();
	PrinterResult showReport();
	PrinterResult printReport();
}
