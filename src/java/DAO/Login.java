/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kathya
 */
public class Login {

    public static String contrasenia(String name){
                  
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String contra=null;
        
        String url = "jdbc:mysql://localhost:3306/";
        String dbName="congresoweb";
        String driver= "com.mysql.jdbc.Driver";
        String userName="root";
        String password = "volave2";
          try{
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(url+dbName,userName,password);
            pst=conn.prepareStatement("select password from usuario " +" where nombreU=?");
            pst.setString(1, name);
            rs=pst.executeQuery();
            while ( rs.next() ) {
               contra = rs.getString("password");
            }
            
        } catch(Exception e){
         System.out.println(e);
        }finally {
            if(conn != null){
                try{
                    conn.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(pst !=null){
                try{
                    pst.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(rs !=null){
                try{
                    rs.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return contra;
    }
    public static String tipoUsuario(String name){
           
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String tipo=null;
        
        String url = "jdbc:mysql://localhost:3306/";
        String dbName="congresoweb";
        String driver= "com.mysql.jdbc.Driver";
        String userName="root";
        String password = "volave2";
          try{
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(url+dbName,userName,password);
            pst=conn.prepareStatement("select tipoUsuario from usuario " +" where nombreU=?");
            pst.setString(1, name);
            rs=pst.executeQuery();
            while ( rs.next() ) {
               tipo = rs.getString("tipoUsuario");
            }
            
        } catch(Exception e){
         System.out.println(e);
        }finally {
            if(conn != null){
                try{
                    conn.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(pst !=null){
                try{
                    pst.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(rs !=null){
                try{
                    rs.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return tipo;
    }
    /**
     * 
     * @param name
     * @param pass
     * @return 
     */
    public static boolean validate(String name, String pass){
        
        boolean status = false;
        Connection conn =null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        String url = "jdbc:mysql://localhost:3306/";
        String dbName="congresoweb";
        String driver= "com.mysql.jdbc.Driver";
        String userName="root";
        String password = "volave2";
        
        try{
            Class.forName(driver).newInstance();
            conn= DriverManager.getConnection(url+dbName,userName,password);
            pst=conn.prepareStatement("select * from usuario " +" where nombreU=? and password=?");
            pst.setString(1, name);
            pst.setString(2, pass);
            rs=pst.executeQuery();
            status = rs.next();
            
        } catch(Exception e){
         System.out.println(e);
        }finally {
            if(conn != null){
                try{
                    conn.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(pst !=null){
                try{
                    pst.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(rs !=null){
                try{
                    rs.close();
                } catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return status;
    } 
}
