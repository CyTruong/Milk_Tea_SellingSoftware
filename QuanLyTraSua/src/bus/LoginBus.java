package bus;

import java.sql.ResultSet;
import java.sql.SQLException;

import dal.QLTS_DatabaseControler;
import dal.QLTS_SQL_Procedure;
import dal.iErrorReport;
import dto.NhanvienDto;

public class LoginBus {
	
	public static enum Login_result{
		LOGIN_COMPLETE,
		WRONG_USERNAME_OR_PASSWORD,
		USER_HAVE_BEEN_DELETED,
		ERROR
	};
	
	private String user;
	private String pass;
	
	public static NhanvienDto loginUser =null;
	
	public LoginBus(String username,String pass) {
		this.user = username;
		this.pass = pass;
	}
	
	public Login_result doLogin() throws SQLException {
	QLTS_DatabaseControler.getInstance().getProcedures().setErrorReportListener(new iErrorReport() {
			
			@Override
			public void weHaveError(String errmess) {
				System.out.println(errmess);
				
			}
		});
		ResultSet nhanviens=QLTS_DatabaseControler.getInstance().getProcedures().selectNhanVien();      
		while(nhanviens.next()) {
			NhanvienDto nhanvien = new NhanvienDto();
			nhanvien.mapping(nhanviens);
			if(nhanvien.username.equals(user) && nhanvien.password.equals(pass)) {
				if(nhanvien.isdeleted) {
					LoginBus.loginUser = nhanvien;
					return Login_result.LOGIN_COMPLETE;
					
				}
				LoginBus.loginUser = nhanvien;
				return Login_result.LOGIN_COMPLETE;
			}
		}
		return Login_result.WRONG_USERNAME_OR_PASSWORD;
	}
}
