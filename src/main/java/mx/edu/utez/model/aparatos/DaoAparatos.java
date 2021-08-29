package mx.edu.utez.model.aparatos;

import mx.edu.utez.model.direccion.BeanDireccion;
import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class DaoAparatos {
    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;
    final private Logger CONSOLE = LoggerFactory.getLogger(DaoAparatos.class);

    public List<BeanAparatos> findAll(){
        List<BeanAparatos> listAparatos = new ArrayList<>();
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM aparatos AS a INNER JOIN direccion AS d ON a.id = d.idDireccion;");
            rs = cstm.executeQuery();

            while(rs.next()){
                BeanDireccion beanDireccion = new BeanDireccion();
                BeanAparatos beanAparatos = new BeanAparatos();

                beanDireccion.setId(rs.getInt("idDireccion"));
                beanDireccion.setCalle(rs.getString("calle"));
                beanDireccion.setColonia(rs.getString("colonia"));
                beanDireccion.setCodigoPostal(rs.getInt("codigoPostal"));
                beanDireccion.setEstado(rs.getString("estado"));
                beanDireccion.setPais(rs.getString("pais"));

                beanAparatos.setId(rs.getInt("id"));
                beanAparatos.setNombre(rs.getString("nombre"));
                beanAparatos.setDireccion(beanDireccion);
                beanAparatos.setFechaDeRegistro(rs.getString("fechaDeRegistro"));
                beanAparatos.setEstado(rs.getInt("estado"));

                listAparatos.add(beanAparatos);
            }
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido algún error: " + e.getMessage());
        }finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listAparatos;
    }

    public BeanAparatos findById(int id){
        BeanAparatos beanAparatos = null;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM aparatos AS a INNER JOIN direccion AS d ON a.id = d.idDireccion WHERE a.id = ?;");
            cstm.setLong(1, id);
            rs = cstm.executeQuery();

            if(rs.next()){
                BeanDireccion beanDireccion = new BeanDireccion();
                beanAparatos = new BeanAparatos();

                beanDireccion.setId(rs.getInt("idDireccion"));
                beanDireccion.setCalle(rs.getString("calle"));
                beanDireccion.setColonia(rs.getString("colonia"));
                beanDireccion.setCodigoPostal(rs.getInt("codigoPostal"));
                beanDireccion.setEstado(rs.getString("estado"));
                beanDireccion.setPais(rs.getString("pais"));

                beanAparatos.setId(rs.getInt("id"));
                beanAparatos.setNombre(rs.getString("nombre"));
                beanAparatos.setDireccion(beanDireccion);
                beanAparatos.setFechaDeRegistro(rs.getString("fechaDeRegistro"));
                beanAparatos.setEstado(rs.getInt("estado"));
            }
        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return beanAparatos;
    }

    public boolean create(BeanAparatos beanAparatos){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{INSERT INTO `aparatos` (`id`, `nombre`, `direccion`, `fechaDeRegistro`, `estado`) VALUES (NULL, '?', '?', '?', '?');}");
            cstm.setString(1, beanAparatos.getNombre());
            cstm.setInt(2, beanAparatos.getDireccion().getId());
            cstm.setString(3, beanAparatos.getFechaDeRegistro());
            cstm.setInt(4, beanAparatos.getEstado());

            cstm.execute();
            flag = true;
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean update(BeanAparatos beanAparatos){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{UPDATE `aparatos` SET `nombre` = '?',`direccion` = '?', `fechaDeRegistro` = '?', `estado` = '?' WHERE `aparatos`.`id` = '?';}");
            cstm.setString(1, beanAparatos.getNombre());
            cstm.setInt(2, beanAparatos.getDireccion().getId());
            cstm.setString(3, beanAparatos.getFechaDeRegistro());
            cstm.setInt(4, beanAparatos.getEstado());
            cstm.setInt(5,beanAparatos.getId());

            cstm.execute();
            flag = true;
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }

    public boolean delete(int id){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{DELETE FROM `aparatos` WHERE `aparatos`.`id` = ?}");
            cstm.setLong(1, id);

            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return false;
    }


}
