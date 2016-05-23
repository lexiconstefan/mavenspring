package com.websystique.springmvc.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.websystique.springmvc.model.User;



public class UserBo {
	
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String user = "C##admin";
	static final String password = "adminpwd";
	
	
	public List<User> getUsers(){
		System.out.println("getUsers start");
	Connection conn =	null;getConnection();
	Statement stmt = null;
	ResultSet rs = null;
	List<User> list = null;
	try{
		conn = getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery("SELECT * FROM users");
		list = new ArrayList<User>();
		while (rs.next()) {
			System.out.println(rs.toString());
			User user = new User();
			user.setFirstname(rs.getString(1));
			user.setLastname(rs.getString(2));
			user.setId(rs.getInt(3));
			user.setMunicipality(rs.getString(4));
			user.setAdress(rs.getString(5));
			list.add(user);
		}
	}catch(Exception sql){
		
	}finally{
		try{
			if(conn != null){
				conn.close();
				System.out.println("connection closed");
			}
			if(stmt != null){
				stmt.close();
			}
		if(rs != null){
			rs.close();
		}
			
		}catch(Exception e){
		System.out.println("could not close");
		}
	}
//
	System.out.println("getUsers end");
	return list;
		
	}
	public User insertUser(User user){
		System.out.println("Insert Users start");
		Connection conn = getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into users (firstname,lastname,kommun, adress) values(?,?,?,?)";
		try{
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getMunicipality());
			preparedStatement.setString(4, user.getAdress());
			preparedStatement.executeQuery();
		}catch(SQLException sqlex){
			
		}catch(Exception e) {
		
		}finally{
			if(preparedStatement != null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return user;
		
	}
	
	private Connection getConnection(){
		Connection conn = null;
		try{
			Class.forName(JDBC_DRIVER);
			try{
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLETEST",user,password);
				

			}catch(SQLException sql){
				System.out.println("Connection failed");
			}
		}catch(ClassNotFoundException cex){
			System.out.println("Class not found");
			System.out.println(cex.getMessage());
		}
		return conn;
	}


}
