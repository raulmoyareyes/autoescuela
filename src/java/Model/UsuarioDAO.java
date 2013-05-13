/*
 * 
 */
package Model;

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

public class UsuarioDAO {

    private static Connection cnx;
    private static String coonPoolName = "autoescuela";

    public static Connection openConexion() {
        cnx = null;
        try {

            // Para realizar el pool he necesitado crear también un recurso y 
            // cambiar la url lookup por jdbc/nombredelrecurso
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("jdbc/" + coonPoolName);
            cnx = ds.getConnection();

//            String dbUri="jdbc:derby://localhost:1527/autoescuelaDB";
//            String dbUser="administrador";
//            String dbPass="123456";

//            cnx= DriverManager.getConnection(dbUri, dbUser, dbPass);

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

    public static Usuario recuperaUsuario(ResultSet rs) {
        Usuario c = null;
        try {
            //(String _nombre, String _apellidos, String _dni, String _direccion, String _tlf, String _password, int _grupo)
            c = new Usuario(rs.getString("nombre"), rs.getString("apellidos"), rs.getString("dni"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("password"), rs.getInt("grupo"));
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        return c;
    }

    public static Usuario buscaDNI(String DNI) {
        Usuario c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM Usuarios WHERE dni=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, DNI);
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

    public static boolean insertaUsuario(Usuario u) {
        boolean salida = false;
        if (openConexion() != null) {
            try {
                String qry = "INSERT INTO usuarios VALUES(?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, u.getNombre());
                stmn.setString(2, u.getApellidos());
                stmn.setString(3, u.getDni());
                stmn.setString(4, u.getDireccion());
                stmn.setString(5, u.getTelefono());
                stmn.setString(6, u.getPassword());
                stmn.setInt(7, u.getGrupo());

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

    public static Usuario compruebaLogin(String DNI, String pass) {
        Usuario c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM Usuarios WHERE dni=? AND password=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, DNI);
                stmn.setString(2, pass);
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

    public static List<Usuario> buscaTodos() {
        List<Usuario> c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM Usuarios";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                ResultSet rs = stmn.executeQuery();
                c = new ArrayList<Usuario>();
                while (rs.next()) {
                    Usuario aux = recuperaUsuario(rs);
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
    
        public static List<Usuario> preparados() {
        List<Usuario> c = null;
        if (openConexion() != null) {
            try {
                String qry = "SELECT * FROM usuarios";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                ResultSet rs = stmn.executeQuery();
                c = new ArrayList<Usuario>();
                while (rs.next()) {
                    Usuario aux = recuperaUsuario(rs);
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

    public static boolean modificaUsuario(Usuario u, String DNI) {
        boolean salida = false;
        if (openConexion() != null) {
            try {
                String qry = "UPDATE usuarios SET nombre=?, apellidos=?, dni=?, direccion=?, telefono=?, password=?, grupo=? WHERE dni=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, u.getNombre());
                stmn.setString(2, u.getApellidos());
                stmn.setString(3, u.getDni());
                stmn.setString(4, u.getDireccion());
                stmn.setString(5, u.getTelefono());
                stmn.setString(6, u.getPassword());
                stmn.setInt(7, u.getGrupo());
                stmn.setString(8, DNI);

                if (stmn.executeUpdate() > 0) {
                    salida = true;
                }

                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                return salida;
            }
        }
        return salida;
    }
    
    public static boolean eliminaUsuario(Usuario u){
        
        boolean salida = false;
        if (openConexion() != null) {
            try {
                String qry = "DELETE FROM usuarios WHERE dni=?";
                PreparedStatement stmn = cnx.prepareStatement(qry);
                stmn.setString(1, u.getDni());

                if (stmn.executeUpdate() > 0) {
                    salida = true;
                }

                stmn.close();
                closeConexion();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
                return salida;
            }
        }
        return salida;
    }
}
