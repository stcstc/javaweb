package com.neuedu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static String driverName="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/hello";
	private static String user="root";
	private static String password="root";
			
	  //静态代码块
	  static{
		  try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
		     System.out.println("加载驱动失败："+e.getMessage());
		}
	  }
      //连接数据库
    public static Connection getConnection(){
    	Connection con=null;
    	try {
    		con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("连接失败："+e.getMessage());
		}
    	return con;
    }
	  //关闭数据库
      public static void closeAll(Connection con,Statement st, ResultSet rs){
    	  //判空
    	  if(con!=null){
    		  try {
				con.close();
			} catch (SQLException e) {
				System.out.println("连接关闭失败:"+e.getMessage());
			}
    	  }
    	  
    	  if(st!=null){
    		  try {
				st.close();
			} catch (SQLException e) {
				System.out.println("statement对象关闭失败:"+e.getMessage());
			}
    	  }
    	 
    	  if(rs!=null){
    		  try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("结果集关闭失败:"+e.getMessage());
				e.printStackTrace();
			}
    	  }
      }
}
