package dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class baseDto {
	public boolean isdeleted;
	
	public abstract void mapping(ResultSet sqlResult)throws SQLException  ;
	
}
