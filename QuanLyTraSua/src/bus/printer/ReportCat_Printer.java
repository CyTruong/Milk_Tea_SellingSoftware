package bus.printer;

import java.awt.print.PrinterException;
import java.sql.SQLException;

import javax.swing.JFrame;

import dal.iErrorReport;
import li.netcat.print.Print;
import li.netcat.print.PrintManager;
import li.netcat.print.util.TextPrint;

public class ReportCat_Printer implements iPrinterModule {

	private Print _currentPrint;
	private iErrorReport _ierrReport;

	@Override
	public void setErrorReportListener(iErrorReport _ireport) {
		_ierrReport = _ireport;
	}

	@Override
	public void writeError(String error) {
		if (_ierrReport != null) {
			this._ierrReport.weHaveError(error);
		}

	}

	@Override
	public PrinterResult creatPrinter() {
		// TODO Auto-generated method stub
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult creatInvoice(int mahoadon) {
		try {
			ReportCat_Invoice invoice = new ReportCat_Invoice(mahoadon);
			_currentPrint = invoice.getPrint();
		} catch (SQLException e) {
			e.printStackTrace();
			writeError(e.toString());
			return PrinterResult.FAIL;
		}
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult showReport() {
		JFrame jframe = new PrintPreview(_currentPrint).open();
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult printReport() {
		try {
			new PrintManager(_currentPrint).print(true);
		} catch (PrinterException e) {
			e.printStackTrace();
			writeError(e.toString());
			return PrinterResult.FAIL;
		}
		return PrinterResult.SUCCESS;
	}

}
