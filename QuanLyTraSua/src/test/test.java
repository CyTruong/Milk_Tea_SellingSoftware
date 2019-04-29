package test;
import java.sql.ResultSet;
import java.sql.SQLException;

import dal.*;

public class test {
	private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QUANLITRASUA;"
            + "integratedSecurity=true";
	public static void main(String[] args) {
		QLTS_SQLDatabaseService qlts = new QLTS_SQLDatabaseService(DB_URL);
		qlts.setErrorReportListener(new iErrorReport() {
			
			@Override
			public void weHaveError(String errmess) {
				System.out.println("Lỗi "+ errmess);
			}
		});
		qlts.CreatConnection();
		System.out.println("connect ok");
		//qlts.insertLoaiDoUong("Trà");
		qlts.insertNhanvien("Phạm Nhật Trường", "0563683819", "cylasion", "012121");
		ResultSet rs = qlts.selectLoaiDoUong();
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
