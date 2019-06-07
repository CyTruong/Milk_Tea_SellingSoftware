package bus.printer;

import java.awt.print.PrinterException;
import java.sql.SQLException;

import javax.swing.JFrame;

import bus.printer.report.ReportCat_Business;
import dal.iErrorReport;
import li.netcat.print.Print;
import li.netcat.print.PrintConstants;
import li.netcat.print.PrintManager;
import li.netcat.print.util.TextPrint;

public class ReportCat_Printer implements iPrinterModule {

	private Print _currentPrint;
	private iErrorReport _ierrReport;
	private int _orientation;
	
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
	public PrinterResult createPrinter() {
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult createInvoice(int mahoadon) {
		try {
			ReportCat_Invoice invoice = new ReportCat_Invoice(mahoadon);
			_currentPrint = invoice.getPrint();
		} catch (SQLException e) {
			e.printStackTrace();
			writeError(e.toString());
			return PrinterResult.FAIL;
		}
		_orientation = PrintConstants.PORTRAIT;
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult showReport() {
		PrintPreview preview = new PrintPreview(_currentPrint);
		preview.getPreviewPanel().getPrintManager().setOrientation(_orientation);
		preview.open();
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult printReport() {
		try {
			PrintManager manager = new PrintManager(_currentPrint);
			manager.setOrientation(_orientation);
			manager.print(true);
		} catch (PrinterException e) {
			e.printStackTrace();
			writeError(e.toString());
			return PrinterResult.FAIL;
		}
		return PrinterResult.SUCCESS;
	}

	@Override
	public PrinterResult createBussinessReport(ReportCat_Business rp) {
		_currentPrint = rp.getPrint();
		_orientation = PrintConstants.LANDSCAPE;
		return PrinterResult.SUCCESS;
	}
	

}
