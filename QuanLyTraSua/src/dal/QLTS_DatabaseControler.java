package dal;

public class QLTS_DatabaseControler {

	public enum TYPE_DB{
		SQL,
		ORACLE
	}
	private iQLTS_Procedure procedures ;
	private static QLTS_DatabaseControler _instance;
	private iErrorReport iErrorReport;

	
	
	
	public static  QLTS_DatabaseControler getInstance(){
		if(_instance==null) {
			_instance = new QLTS_DatabaseControler();
		}
		return _instance;
		
	}
	
	public iQLTS_Procedure getProcedures() {
		if(procedures == null) {
			setType(TYPE_DB.SQL);
		}
		return procedures;
	}
	
	
	public void setType (TYPE_DB type) {
		if(type==TYPE_DB.SQL) {
			procedures = new QLTS_SQL_Procedure();
		}
	}
	
}
