/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Participante;
import conexion.Conectar;
import Servicios.ParticipantesServlet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ulrick
 */
public class Participantes extends Conectar{
    
    static private PreparedStatement pst;

    public Participantes() {
    }
    
    public boolean registraParticipante(String clave, String nombre, String email, String tipo, String carrera, String puesto){
        boolean result=false;
        
        try{
            String sql = "insert into participante values('"+clave+"','"+nombre+"','"+email+"','"+tipo+"','"+carrera+"','"+puesto+"')";
            pst = cone().prepareStatement(sql);
            result= pst.execute();
            
        }catch (SQLException ex) {
            Logger.getLogger(ParticipantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public int actualizaParticipante(String clave, String nombre, String email, String tipo, String carrera, String puesto){
        int result = 0;
        
        try{
            String sql = "update participante set nombre='"+nombre+"', email='"+email+"', tipo='"+tipo+"', carrera='"+carrera+"', puesto='"+puesto+"' where clave='"+clave+"';";
            pst = cone().prepareStatement(sql);
            result= pst.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ParticipantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public boolean eliminarParticipante(String clave){
        boolean result=false;
        
        try{
            String sql = "Delete from participante where clave='"+clave+"';";
            pst = cone().prepareStatement(sql);
            result= pst.execute();
        }catch (SQLException ex) {
            Logger.getLogger(ParticipantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    
    public int getParticipantes(){
        ResultSet rs = null;
        int i=0;
        
        try{
            String sql = "Select * from Participante";
            pst = cone().prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
                i++;
            }
        }catch (SQLException ex) {
            Logger.getLogger(ParticipantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
        
    }
    
    public Participante obtenParticipante(String clave){
        ResultSet rs = null;
        Participante participante=null;
        try{
            participante= new Participante();
            String sql = "Select * from Participante where clave="+"'"+clave+"';";
            pst = cone().prepareStatement(sql);
            rs=pst.executeQuery();
            
            while(rs.next()){
               participante.setClave(rs.getString(1));
               participante.setNombre(rs.getString(2));
               participante.setEmail(rs.getString(3));
               participante.setTipo(rs.getString(4));
               participante.setCarrera(rs.getString(5));
               participante.setPuesto(rs.getString(6));
            }
        }catch (SQLException ex) {
            Logger.getLogger(ParticipantesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return participante;
        
    }
}
