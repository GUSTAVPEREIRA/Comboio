/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estagio.dao;

import estagio.model.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pereira
 */
public class EstadoDAO {
   
    public static  Connection con;

    public Connection getConnection() {
        return con;
    }
    
    public void setConnection(Connection con) {
        this.con = con;
    }
    
    public void abreConnection()
    {
        setConnection(Conexao.abre());
    }
    
     public boolean inserir(Estado estado) {
        abreConnection();
        String sql = "INSERT INTO estado(est_nome,est_uf) VALUES(?,?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, estado.getEst_nome());
            stmt.setString(2, estado.getEst_uf());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean alterar(Estado estado) {
        abreConnection();
        String sql = "UPDATE estado SET est_nome=?, est_uf=? WHERE est_id=?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, estado.getEst_nome());
            stmt.setString(2, estado.getEst_uf());
            stmt.setInt(3, estado.getEst_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean Deletar(Estado estado) {
        abreConnection();
        String sql = "DELETE FROM estado WHERE est_id=?";
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, estado.getEst_id());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    public Estado busca(String busca) {
        abreConnection();
        Estado estado = new Estado();
        String sql ;
        sql = "SELECT * FROM estado where est_nome = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, busca);
            ResultSet resultado = stmt.executeQuery();
            
            while (resultado.next()) {
                estado.setEst_id(resultado.getInt("est_id"));
                estado.setEst_nome(resultado.getString("est_nome"));
                estado.setEst_uf(resultado.getString("est_uf"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }
    
    public Estado listar(int busca) {
        abreConnection();
        Estado estado = new Estado();
        String sql ;
        sql = "SELECT * FROM estado where est_id = ?";
        List<Estado> retorno = new ArrayList<Estado>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, busca);
            ResultSet resultado = stmt.executeQuery();
            
            while (resultado.next()) {
                estado.setEst_id(resultado.getInt("est_id"));
                estado.setEst_nome(resultado.getString("est_nome"));
                estado.setEst_uf(resultado.getString("est_uf"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estado;
    }
    
    public List<Estado> listar(String busca) {
        abreConnection();
        String sql ;
        if(busca.equals(""))
        sql = "SELECT * FROM estado";
        else
        sql = "SELECT * FROM estado where est_uf like '"+busca+"%' or est_nome like '"+busca+"%'";   
        List<Estado> retorno = new ArrayList<Estado>();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet resultado = stmt.executeQuery();
            while (resultado.next()) {
                Estado estado = new Estado();
                estado.setEst_id(resultado.getInt("est_id"));
                estado.setEst_nome(resultado.getString("est_nome"));
                estado.setEst_uf(resultado.getString("est_uf"));
                retorno.add(estado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
        
}
