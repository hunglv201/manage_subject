package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import entity.MonHoc;

public class ConnectDB {
	public Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system",
				"201998");
		return conn;
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		MonhocDAO dao = new MonhocDAO();
		MonHoc m= dao.serchByID(1);
		System.out.println(m.getTenmh());
		
//		
//		  for (MonHoc mo : dao.hienthi()) {
//		  System.out.println(mo.getId()+""+mo.getTenmh()); }
		  
		  //dao.add("na", 2);
		  
		 
//		dao.updateByID(11, "lvh", 3);
//		dao.deleteByID(15);
//
//		for (MonHoc m : dao.serchByName("lvh")) {
//			System.out.println(m.getId());
//		}
	}
}
