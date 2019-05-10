package test;
import java.sql.ResultSet;
import java.sql.SQLException;

import bus.Permission;
import dal.*;

public class test {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QUANLITRASUA;"
            + "integratedSecurity=true";
	public static void main(String[] args) {
		QLTS_SQLDatabaseService.setConncectionString(DB_URL);
		QLTS_SQLDatabaseService.getInstance().setErrorReportListener(new iErrorReport() {
			
			@Override
			public void weHaveError(String errmess) {
				System.out.println("Lỗi "+ errmess);
			}
		});
		QLTS_SQLDatabaseService.getInstance().CreatConnection();
		System.out.println("connect ok");
		//qlts.insertLoaiDoUong("Trà");
		QLTS_SQLDatabaseService.getInstance().insertNhanvien("Phạm Nhật Trường", "0563683819", "cylasion", "012121",Permission.FULL_PER);
		ResultSet rs = QLTS_SQLDatabaseService.getInstance().selectLoaiDoUong();
		try {
			while(rs.next()) 
			{
				System.out.println(rs.getString(2));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
