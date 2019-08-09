package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.MonHoc;

public class MonhocDAO {
	
	ConnectDB cdb=  new ConnectDB();
	
	public  ArrayList<MonHoc> hienthi() throws ClassNotFoundException, SQLException{
		ArrayList<MonHoc> list= new ArrayList<MonHoc>();
		
		Connection conn=cdb.connect();
		
		java.sql.Statement st= conn.createStatement();
		String sql="select* from monhoc";
		ResultSet r=st.executeQuery(sql);
		
		while(r.next()) {
			int id=r.getInt("id");
			String tenmh=r.getString("tenmh");
			int sotc=r.getInt("sotinchi");
			
			MonHoc mh= new MonHoc(id,tenmh,sotc);
			list.add(mh);
		}
		System.out.println("get all success");
		return list;
		
         
	}
	
	public int add(String tenmh, int sotinchi) throws ClassNotFoundException, SQLException {
		Connection conn=cdb.connect();
		
		String sql="insert into monhoc(tenmh,sotinchi) values(?,?)";
		PreparedStatement st= conn.prepareStatement(sql);
		st.setString(1, tenmh);
		st.setInt(2, sotinchi);
		
		int so= st.executeUpdate();
		return so;
	}
	
	public int deleteByID( int id) throws SQLException, ClassNotFoundException {
		Connection conn=cdb.connect();
		
		String sql="delete from monhoc where id=? ";
		PreparedStatement st= conn.prepareStatement(sql);
		st.setInt(1, id);
		int s=st.executeUpdate();
		return s;
	}
	
	public int updateByID(int id, String tenmh, int sotinchi) throws SQLException, ClassNotFoundException {
		Connection conn=cdb.connect();
		
		String sql="update monhoc set tenmh=?, sotinchi=? where id=? ";
		PreparedStatement st= conn.prepareStatement(sql);
		st.setString(1, tenmh);
		st.setInt(2, sotinchi);
		st.setInt(3, id);
		
		int so= st.executeUpdate();
		return so;
	}
	public ArrayList<MonHoc> serchByName(String tenmh) throws ClassNotFoundException, SQLException {
		ArrayList<MonHoc> list= new ArrayList<MonHoc>();
		Connection conn=cdb.connect();
		
		String sql="select* from monhoc  where tenmh=?";
		PreparedStatement st= conn.prepareStatement(sql);
		st.setString(1, tenmh);
		ResultSet r=st.executeQuery();
		while(r.next()) {
		MonHoc mh= new MonHoc();
		mh.setId(r.getInt("id"));
		mh.setTenmh(r.getString("tenmh"));
		mh.setSotc(r.getInt("sotinchi"));
		
		list.add(mh);
		}
		return list;
	}
	public MonHoc serchByID(int id) throws ClassNotFoundException, SQLException {
		ArrayList<MonHoc> list= new ArrayList<MonHoc>();
		Connection conn=cdb.connect();
		
		String sql="select* from monhoc  where id=?";
		PreparedStatement st= conn.prepareStatement(sql);
		st.setInt(1, id);
		ResultSet r=st.executeQuery();
		while(r.next()) {
		MonHoc mh= new MonHoc();
		mh.setId(r.getInt("id"));
		mh.setTenmh(r.getString("tenmh"));
		mh.setSotc(r.getInt("sotinchi"));
		
		list.add(mh);
		}
		return list.get(0);
	}
}
