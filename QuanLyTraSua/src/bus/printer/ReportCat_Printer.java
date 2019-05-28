package bus.printer;

import javax.swing.JFrame;

import li.netcat.print.Print;

public class ReportCat_Printer implements iPrinterModule {

	private Print _currentPrint;
	
	@Override
	public PrinterResult creatPrinter() {
		// TODO Auto-generated method stub
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult creatInvoice() {
		ReportCat_Invoice invoice = new ReportCat_Invoice();
		_currentPrint = invoice.getPrint();
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult showReport() {
		JFrame jframe = new PrintPreview(_currentPrint).open();
		return null;
	}

	@Override
	public PrinterResult printReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
