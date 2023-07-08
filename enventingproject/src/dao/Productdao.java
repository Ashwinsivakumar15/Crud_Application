package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connectionmanager.ConnectionManager;
import module.Product;
public class Productdao {
	public void addProduct(Product product) throws ClassNotFoundException, SQLException
	{
		ConnectionManager conm = new ConnectionManager();
		Connection con= conm.establishConnection();
		String sql_query = "insert into product(productid,productname,minsellquantity,price,quantity) values(?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql_query);
		ps.setInt(1,product.getProductid());
		ps.setString(2, product.getProductname());
		ps.setInt(3, product.getMinsellquantity());
		ps.setInt(4,product.getPrice());
		ps.setInt(5, product.getQuantity());
		
		ps.executeUpdate();
		conm.closeConnection();
	}

	public static void display() throws ClassNotFoundException, SQLException 
	{
		ConnectionManager conm = new ConnectionManager();
		Connection con= conm.establishConnection();
		Statement st=con.createStatement();
		//result class
		ResultSet rt=st.executeQuery("select*from Product");
		while(rt.next())
		{
		System.out.println(rt.getInt("productid")+" | "+rt.getString("productname")+" | "+rt.getInt("minsellquantity")+" | "+rt.getInt("price")+" | "+rt.getInt("quantity"));
		}

	}

}
