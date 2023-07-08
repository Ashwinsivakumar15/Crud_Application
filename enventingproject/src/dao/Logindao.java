package dao;
import module.Login;
import java.sql.*;
import connectionmanager.ConnectionManager;

public class Logindao
{
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		String username =login.getUsername();
		String password =login.getPassword();
		ConnectionManager conm=new ConnectionManager();
		Connection con =conm.establishConnection();
		//Statement class
		Statement st=con.createStatement();
		//result class
		ResultSet rt=st.executeQuery("select*from login");
		while(rt.next())
		{
		if(username.equals(rt.getString("username"))&& password.equals(rt.getString("password")))
		{
			conm.closeConnection();
			return true;
		}
		}
		conm.closeConnection();
		return false;
	}
}