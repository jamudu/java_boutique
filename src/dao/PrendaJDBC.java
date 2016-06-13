//

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.ListaPrendas;
import modelo.Prendas;

/**
 *
 * @author usu21
 */
public class PrendaJDBC {
private Connection conexion;

    //funcio eliminar prenda
    public boolean bajaPrenda(Prendas p){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "delete from prendas where codigo="+ p.getCodigo()+";";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(PrendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return ok;
    }


    //funcio modificar prenda
    public boolean modificarPrenda(Prendas p){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "UPDATE prendas SET descripcion='"+ p.getDescripcion()+ 
                        "',  color='"+p.getColor()+ "', talla='"+p.getTalla()+
                        "', precioCoste="+p.getPrecioCoste()+ ", precioVenta="+p.getPrecioVenta()+
                        ", stock="+p.getStock()+ " WHERE codigo="+ p.getCodigo()+";";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(PrendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return true;
    }

    //funcio modificar stock
    public boolean modificarStock(Prendas p){
        boolean ok=false;
        conectar();
        if (conexion != null){
            try {
                String query = "UPDATE prendas SET stock="+ p.getStock()+ " WHERE codigo="+ p.getCodigo()+";";
                Statement st=conexion.createStatement();
                st.executeUpdate(query);
                //si ResultSet tiene algo (si tiene next)
                
                st.close();   
                ok=true;
            } catch (SQLException ex) {
                //Logger.getLogger(PrendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return ok;
    }

    //funcion que da el valor de coste
    public double valorCoste(){
        double valor=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select sum(stock*precioCoste) as valor from prendas";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    valor = rs.getDouble(1);
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(PrendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return valor;
    }

    //funcion contar stock
    public int contarStock(){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select sum(stock) as stockT from prendas";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    cont = rs.getInt("stockT");
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(PrendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return cont;
    }
    
    //funcion selecionar prenda
    public Prendas selectPrenda(String codigo){
        conectar();
        Prendas pe=new Prendas();
        if (conexion !=null){
            try {
                String query ="select * from prendas where codigo='" + codigo + "'";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    
                    pe.setCodigo(rs.getString("codigo"));  // =  rs.getString(1)
                    pe.setDescripcion(rs.getString("descripcion"));
                    pe.setColor(rs.getString("color"));
                    pe.setTalla(rs.getString("talla"));
                    pe.setPrecioCoste(rs.getDouble("precioCoste"));
                    pe.setPrecioVenta(rs.getDouble("precioVenta"));
                    pe.setStock(rs.getInt("stock"));
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error en la consulta "+ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return pe;
    }
    
    //funcion para obtener todas las prendas
    public ListaPrendas selectAllprendas(){
        ListaPrendas ListaP=new ListaPrendas();
        conectar();
        if (conexion !=null){
            try {
                String query ="select * from prendas order by descripcion, color, talla";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Prendas pe=new Prendas();
                    pe.setCodigo(rs.getString("codigo"));  // =  rs.getString(1)
                    pe.setDescripcion(rs.getString("descripcion"));
                    pe.setColor(rs.getString("color"));
                    pe.setTalla(rs.getString("talla"));
                    pe.setPrecioCoste(rs.getDouble("precioCoste"));
                    pe.setPrecioVenta(rs.getDouble("precioVenta"));
                    pe.setStock(rs.getInt("stock"));
                    ListaP.altaPrenda(pe);
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error en la consulta "+ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return ListaP;
    }
    
    //funcion que obtiene todos los colores
    public ArrayList<String> selectColores(){
        ArrayList<String> colores=new ArrayList<>();
        conectar();
        if (conexion !=null){
            try {
                String query ="select distinct color from prendas order by color";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    colores.add(rs.getString(1));
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error en la consulta "+ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return colores;
    }
    
    //funcion para obtener las prendas de un color
    public ListaPrendas selectPrendasColor(String color){
        ListaPrendas ListaP=new ListaPrendas();
        conectar();
        if (conexion !=null){
            try {
                String query ="select * from prendas where color='" + color + "' order by descripcion, talla";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                while (rs.next()){
                    Prendas pe=new Prendas();
                    pe.setCodigo(rs.getString("codigo"));  // =  rs.getString(1)
                    pe.setDescripcion(rs.getString("descripcion"));
                    pe.setColor(rs.getString("color"));
                    pe.setTalla(rs.getString("talla"));
                    pe.setPrecioCoste(rs.getDouble("precioCoste"));
                    pe.setPrecioVenta(rs.getDouble("precioVenta"));
                    pe.setStock(rs.getInt("stock"));
                    ListaP.altaPrenda(pe);
                }
                rs.close();
                st.close();
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error en la consulta "+ex.getMessage());
            }finally{
                desconectar();
            }
        }
        return ListaP;
    }
    
    //funcion que comprueba si una pelicula existe, no recogemos el resultado de la busqueda
    public boolean existePrenda(String codigo){
        conectar();
        if (conexion !=null){
            try {
                String query = "select *from prendas where codigo='" + codigo + "'";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                boolean existe=false;
                if (rs.next()){
                    existe= true;
                }
                rs.close();
                st.close();
                return existe;
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al consultar"+ex.getMessage());
                return false;
            }finally {
                desconectar();
            }
        }else{
            return false;
        }
    }
    
    //funcion insertar pelicula
    public boolean insertarPrenda(Prendas p){
        conectar();
        if (conexion != null){
            try {
                String insertar = "insert into prendas values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = (PreparedStatement) conexion.prepareStatement(insertar);
                ps.setString(1, p.getCodigo());
                ps.setString(2, p.getDescripcion());
                ps.setString(3, p.getColor());
                ps.setString(4, p.getTalla());
                ps.setDouble(5, p.getPrecioCoste());
                ps.setDouble(6, p.getPrecioVenta());
                ps.setInt(7, p.getStock());
                ps.executeUpdate();     //ejecuta la consulta
                ps.close();             //liberamos recursos
                return true;
            } catch (SQLException ex) {
                //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al insertar: " +ex.getMessage());
                return false;
            }finally{
                desconectar();
            }
        }else{
            return false;
        }
    }
    
    //funcion contar prendas
    public int contarPrenda(){
        int cont=0;
        conectar();
        if (conexion != null){
            try {
                String query = "select count(*) as total from prendas";
                Statement st=conexion.createStatement();
                ResultSet rs=st.executeQuery(query);
                //si ResultSet tiene algo (si tiene next)
                
                if (rs.next()){
                    cont = rs.getInt(1);
                }
                rs.close();
                st.close();                
            } catch (SQLException ex) {
                //Logger.getLogger(PrendaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                desconectar();
            }        
        }
        return cont;
    }
    
    //funcion abrir conexion SQL
    private void conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/boutique";
            String user="root";
            String password = "jeveris";
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar" + ex.getMessage());
            conexion = null;
        }
    }
    
   //funcion para desconectar conexion SQL
    private void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            //Logger.getLogger(PeliculaJDBC.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al desconectar " + ex.getMessage());
        }
    }
}