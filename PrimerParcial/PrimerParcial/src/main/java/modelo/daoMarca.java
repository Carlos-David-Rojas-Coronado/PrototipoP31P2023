/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import controlador.clsMarca;
import modelo.daoMarca;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMarca {

    private static final String SQL_SELECT = "SELECT marcaid, marcanombre, marcaestatus FROM tbl_usuario";
    private static final String SQL_INSERT = "INSERT INTO tbl_usuario(marcanombre, marcaestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_usuario SET marcanombre=?, marcaestatus=? WHERE marcaid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_usuario WHERE marcaid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT marcaid, marcanombre, marca FROM tbl_usuario WHERE marcanombre = ?";
    private static final String SQL_SELECT_ID = "SELECT marcaid, marcanombre, marcaestatus FROM tbl_usuario WHERE marcaid = ?";    

    public List<clsMarca> consultaMarcas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMarca> marcas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marcaid");
                String nombre = rs.getString("marcanombre");
                String estatus = rs.getString("marcaestatus");
                clsMarca marca = new clsMarca();
                marcas.setIdMarca(id);
                marcas.setNombreMarca(nombre);
                marcas.setEstatusMarca(estatus);
                marcas.add(marca);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return marcas;
    }

    public int ingresaMarcas(clsMarca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, marca.getNombreMarca());
            stmt.setString(2, marca.getEstatusMarca());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaMarcas(clsMarca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, marca.getNombreMarca());
            stmt.setString(2, marca.getEstatusMarca());
            stmt.setInt(3, marca.getIdMarca());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int borrarMarcas(clsMarca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, marca.getIdMarca());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsMarca consultaMarcasPorNombre(clsMarca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + marca);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, marca.getIdMarca());            
            stmt.setString(1, marca.getNombreMarca());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marcaid");
                String nombre = rs.getString("marcanombre");
                String estatus = rs.getString("marcaestatus");

                //marca = new clsMarca();
                marca.setIdMarca(id);
                marca.setNombreMarca(nombre);
                marca.setEstatusMarca(estatus);
                System.out.println(" registro consultado: " + marca);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return marca;
    }
    public clsMarca consultaMarcasPorId(clsMarca marca) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + marca);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, marca.getIdMarca());            
            //stmt.setString(1, marca.getNombreMarca());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("marcaid");
                String nombre = rs.getString("marcanombre");
                String estatus = rs.getString("marcaestatus");

                //marca = new clsMarca();
                marca.setIdMarca(id);
                marca.setNombreMarca(nombre);
                marca.setEstatusMarca(estatus);
                System.out.println(" registro consultado: " + marca);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return marca;
    }    
}
