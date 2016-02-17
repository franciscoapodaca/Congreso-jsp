/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Kathya
 */
public class participante {
     public static void agregarParticipante(String clave, String nombre, String email, String tipo, String carrera, String puesto) {
        Conexion conectar = new Conexion();
        conectar.conectar("insert into Participante values('" + clave + "','" + nombre + "','" + email + "','" + tipo + "','" + carrera + "','" + puesto + "')");
    }
     public static void eliminaParticipante(String clave) {
        Conexion conectar = new Conexion();
        conectar.conectar("delete from Participante " + " where clave= " + "'" + clave + "'");
    }
       public static void actualizaParticipante(String clave, String nombre, String email, String tipo, String carrera, String puesto) {

        Conexion conectar = new Conexion();
        conectar.conectar("update Participante set nombre= " + "'" + nombre + "'" 
                + ", email= " + "'" + email + "'"  + ", tipoParticipante= " + "'" + tipo 
                + "'" + ", carrera= " + "'" + carrera + "'" + ", puesto= " + "'" + puesto 
                + "'" + " where clave= " + "'" + clave + "'");
    }

       public static boolean verificarParticipantePresentaciones(String id){
            boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "congresoweb";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "volave2";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            pst = conn.prepareStatement("select * from Presentacion " + " where clave=?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
       }
     public static boolean validaExistencia(String clave) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "congresoweb";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "volave2";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            pst = conn.prepareStatement("select * from Participante " + " where clave=?");
            pst.setString(1, clave);
            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
}
