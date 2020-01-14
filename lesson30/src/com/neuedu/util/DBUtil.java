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
			
	  //��̬�����
	  static{
		  try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
		     System.out.println("��������ʧ�ܣ�"+e.getMessage());
		}
	  }
      //�������ݿ�
    public static Connection getConnection(){
    	Connection con=null;
    	try {
    		con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.out.println("����ʧ�ܣ�"+e.getMessage());
		}
    	return con;
    }
	  //�ر����ݿ�
      public static void closeAll(Connection con,Statement st, ResultSet rs){
    	  //�п�
    	  if(con!=null){
    		  try {
				con.close();
			} catch (SQLException e) {
				System.out.println("���ӹر�ʧ��:"+e.getMessage());
			}
    	  }
    	  
    	  if(st!=null){
    		  try {
				st.close();
			} catch (SQLException e) {
				System.out.println("statement����ر�ʧ��:"+e.getMessage());
			}
    	  }
    	 
    	  if(rs!=null){
    		  try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("������ر�ʧ��:"+e.getMessage());
				e.printStackTrace();
			}
    	  }
      }
}
