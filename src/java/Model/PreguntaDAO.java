/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import static Model.UsuarioDAO.closeConexion;
import static Model.UsuarioDAO.openConexion;
import static Model.UsuarioDAO.recuperaUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class PreguntaDAO {
    
    private static Connection cnx;
    private static String coonPoolName = "autoescuela";
    
    public static Connection openConexion() {
        cnx = null;
        try {
            
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("jdbc/" + coonPoolName);
            cnx = ds.getConnection();
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        return cnx;
    }
    
    public static void closeConexion() {
        try {
            cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
    
    public static Pregunta recuperaPregunta(ResultSet rs) {
        Pregunta p = null;
        try {
            //String _enunciado, String _respuesta1, String _respuesta2, String _respuesta3, int _respuestaCorrecta, int _tema, String _imagen, int _id
            p = new Pregunta(rs.getString("enunciado"), rs.getString("respuesta1"), rs.getString("respuesta2"), rs.getString("respuesta3"), rs.getInt("respuestaCorrecta"), rs.getInt("tema"), rs.getString("imagen"), rs.getInt("id"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return p;
    }
    
    public static Usuario buscaID(int id) {
        Usuario c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM preguntas WHERE id=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setInt(1, id);
                ResultSet rs = stmn.executeQuery();
                rs.next();
                c = recuperaUsuario(rs);
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return c;
    }
    
    public static boolean insertaPregunta(Pregunta p) {
        boolean salida = false;
        if (openConexion() != null) {
            try {
                
                /* Orden para crear la tabla:
                 
                 CREATE TABLE "PREGUNTAS"(
                    "ENUNCIADO" VARCHAR(500) NOT NULL,
                    "RESPUESTA1" VARCHAR(500) NOT NULL,
                    "RESPUESTA2" VARCHAR(500) NOT NULL,
                    "RESPUESTA3" VARCHAR(500) NOT NULL,
                    "RESPUESTACORRECTA" INTEGER NOT NULL,  
                    "TEMA" INTEGER NOT NULL,  
                    "IMAGEN" VARCHAR(40),
                    "ID" INT not null primary key
                            GENERATED ALWAYS AS IDENTITY
                            (START WITH 1, INCREMENT BY 1)
                  );
                  
                 */                
                String qry = "INSERT INTO preguntas(enunciado, respuesta1, respuesta2, respuesta3, respuestacorrecta, tema) VALUES(?, ?, ?, ?, ?, ?)";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, p.getEnunciado());
                stmn.setString(2, p.getRespuesta1());
                stmn.setString(3, p.getRespuesta2());
                stmn.setString(4, p.getRespuesta3());
                stmn.setInt(5, p.getRespuestaCorrecta());
                stmn.setInt(6, p.getTema());
                //stmn.setString(7, "hola");
                //stmn.setInt(8, lastId+1); // autoincremento
                if (stmn.executeUpdate() > 0) {
                    salida = true;
                }

                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return salida;
    }
    
    public static List<Pregunta> buscaTodas() {
        List<Pregunta> c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM prenguntas";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                ResultSet rs = stmn.executeQuery();
                c = new ArrayList<Pregunta>();
                while (rs.next()) {
                    Pregunta aux = recuperaPregunta(rs);
                    c.add(aux);
                }
                rs.close();
                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return c;
    }

}
