import java.sql.*;


public abstract class QLTS_DB {
	protected Connection connection;
	protected String reportError;

	public abstract void CreatConnection();
	public abstract void Disconnect();
}
