package bus.printer;

public class Printer_Controler {
	public enum PrinterModule{
		REPORTCART
	}
	private static Printer_Controler _instance;
	private PrinterModule _moduleType ;
	private iPrinterModule _module;
	
	private Printer_Controler() {
		
	}
	public void setModule(PrinterModule type) {
		_moduleType = type;
		if(_instance == null ) {
			_instance = new Printer_Controler();
		}
		_moduleType = type;
		if(_moduleType == PrinterModule.REPORTCART) {
			_module = new ReportCat_Printer();
		}
	}
	
	public static Printer_Controler getInstance() {
		if(_instance == null) {
			_instance = new Printer_Controler();
			_instance.setModule(PrinterModule.REPORTCART);
		}
		return _instance;
	}
	
	public iPrinterModule getModule() {
		return _module;
	}
}
