package Clase;

import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * Clase donde generamos los métodos para interactuar con la bbdd 
 */
public class Metodos {
    /*
    Parámetros de conexión a la bbdd 
    */
    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "GM";
    static final String PASS = "1234";

    /*
    Método para mostrar todo el contenido de la tabla 
    */
    
    public void mostrar() throws SQLException {
        String QUERY = "SELECT * FROM videojuegos"; // consulta 

        try { // Objeto  sql connection, queusa losparámatros static final ,para acceder 
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement(); // sentencia que derivará en Resultset  
            ResultSet rs = stmt.executeQuery(QUERY); // resulset que usa , la sencia, y la query 

            /*
            bucle que nos muestra el contenido de la consulta, va extrayendo los métodos 
            get int para sacar numeros enteros, string para los strings, y para sacar fecha
            */
            
            while (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Genero: " + rs.getString("Genero"));
                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.println("Compañia: " + rs.getString("Compañia"));
                System.out.println("Precio: " + rs.getFloat("Precio"));
                System.out.println("-------------------------------------------");
            }

            stmt.close();
//            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    /*
    metodo que busca nombre  en la bbdd con parámetro  de entrada 
    */

    public boolean buscaNombre(String nombre) throws SQLException {
        String QUERY = "SELECT * FROM  videojuegos where nombre = '" + nombre + "';";

        try { // Objeto  sql connection, queusa losparámatros static final ,para acceder 
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement(); // sentencia que derivará en Resultset  
            ResultSet rs = stmt.executeQuery(QUERY); // resulset que usa , la sencia, y la query 

                 /*
            bucle que nos muestra el contenido de la consulta, va extrayendo los métodos 
            get int para sacar numeros enteros, string para los strings, y para sacar fecha
            */
            
            while (rs.next()) {
                System.out.println("Datos de busqueda");
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Genero: " + rs.getString("Genero"));
                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.println("Compañia: " + rs.getString("Compañia"));
                System.out.println("Precio: " + rs.getFloat("Precio"));
                System.out.println("-------------------------------------------");
                return true;
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("El juego no existe ");
        return false;
    }
    
    /*
    Metodo que lanza consulta por parámetros 
    */
    
    public void lanzaConsulta (String consulta) throws SQLException {
//        String QUERY = "SELECT * FROM  videojuegos where nombre = '" + nombre + "';";
            
        try { // Objeto  sql connection, queusa losparámatros static final ,para acceder 
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement(); // sentencia que derivará en Resultset  
            ResultSet rs = stmt.executeQuery(consulta); // resulset que usa , la sencia, y la query 

                 /*
            bucle que nos muestra el contenido de la consulta, va extrayendo los métodos 
            get int para sacar numeros enteros, string para los strings, y para sacar fecha
            */

            while (rs.next()) {
                System.out.println("Resultado de consulta:");
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("Nombre"));
                System.out.println("Genero: " + rs.getString("Genero"));
                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
                System.out.println("Compañia: " + rs.getString("Compañia"));
                System.out.println("Precio: " + rs.getFloat("Precio"));
                System.out.println("-------------------------------------------");
            
            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
 
      
    }
    
    
    /*
    Metodo que eliminar registro por parámetro 
    */
    
    public void eliminarRegistro (int eliminar) throws SQLException {
//        String QUERY = "SELECT * FROM  videojuegos where nombre = '" + nombre + "';";
        String QUERY = "DELETE  FROM  videojuegos where id = '" + eliminar + "';";
            
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS); // Objeto  sql connection, queusa losparámatros static final ,para acceder 
            Statement stmt = conn.createStatement();// sentencia que derivará en Resultset  
//            stmt.executeQuery(QUERY);
            stmt.executeUpdate(QUERY);// aque en lugar de usar un result, ejecutamos el update de la bbdd 
            
            System.out.println("JUEGO ELIMINADO CON EXITO");

//            while (rs.next()) {
//                System.out.println("Resultado de consulta:");
//                System.out.println("id: " + rs.getInt("id"));
//                System.out.println("Nombre: " + rs.getString("Nombre"));
//                System.out.println("Genero: " + rs.getString("Genero"));
//                System.out.println("Fecha de lanzamiento: " + rs.getDate("FechaLanzamiento"));
//                System.out.println("Compañia: " + rs.getString("Compañia"));
//                System.out.println("Precio: " + rs.getFloat("Precio"));
//                System.out.println("-------------------------------------------");
//            
//            }

            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
 
      
    }

    /*
    Método que pide los datos de juego por teclado, y nos genera un objeto videojuegos 
    */
       
    public videojuego datosJuego(videojuego newGame) throws ParseException {
        
        Scanner sc = new Scanner(System.in); // generamos el scanner 
        String Nombre, Genero, Compañia, FechaLanzamiento; // instanciamos las variables 
        double Precio; 
        
        System.out.println("Introduce Los datos del juego: ");
        System.out.println("-------------------------------");
        System.out.print("Introduce nombre del juego : ");
        Nombre = sc.nextLine();
        newGame.setNombre(Nombre);
        System.out.println("-------------------------------");
        System.out.print("Introduce Genero del juego : ");
        Genero = sc.nextLine();
        newGame.setGenero(Genero);
        System.out.println("-------------------------------");
        System.out.print("Introduce la Compañia: ");
        Compañia = sc.nextLine();
        newGame.setCompañia(Compañia);
        System.out.println("-------------------------------");

        // <editor-fold defaultstate="collapsed" desc="-Fecha-">
//        System.out.println("Introduce la fecha de lanzamiento");
//        FechaLanzamiento = sc.nextLine();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
//        newGame.setFechaLanzamiento(fechaLanzamiento);
        // </editor-fold>
//        System.out.print("Introduce la fecha de lanzamiento yyyy-MM-dd: ");
//        FechaLanzamiento = sc.nextLine();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
//        java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());
//        newGame.setFechaLanzamiento(sqlFechaLanzamiento);

        System.out.print("Introduce la fecha de lanzamiento dd-MM-yyyy: ");
        FechaLanzamiento = sc.nextLine();

        SimpleDateFormat dateFormatInput = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaLanzamiento = dateFormatInput.parse(FechaLanzamiento);

        SimpleDateFormat dateFormatOutput = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());

        newGame.setFechaLanzamiento(sqlFechaLanzamiento);
        System.out.println("-------------------------------");
                System.out.print("Introduce el precio: ");
        Precio = sc.nextDouble();
        newGame.setPrecio(Precio);

        return newGame;
        
        }
        
    public void Insert() throws ParseException {
        videojuego ng = new videojuego();
        datosJuego(ng);
        
        // <editor-fold defaultstate="collapsed" desc="-Definición-">
        //        String insert=" INSERT INTO `videojuegos`( `Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`)" +
//         "VALUES ('[+value-2]','[value-3]','[value-4]','[value-5]','[value-6]')'";

//         String insert=" INSERT INTO `videojuegos`( `"+ng.getNombre()+"`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`)" +
//         "VALUES ('[+value-2]','[value-3]','[value-4]','[value-5]','[value-6]')'";
//         ng.getNombre();
//         ng.getGenero();
//         ng.getFechaLanzamiento();
//         ng.getCompañia();
//         ng.getPrecio();
        // </editor-fold>
        

        String insert = "INSERT INTO `videojuegos`(`Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) "
                + "VALUES ('" + ng.getNombre() + "','" + ng.getGenero() + "','" + ng.getFechaLanzamiento() + "','"
                + ng.getCompañia() + "'," + ng.getPrecio() + ")";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insert);
            
            // <editor-fold defaultstate="collapsed" desc="-Definición-">
            //            while(rs.next()){
//            System.out.println("id: "+rs.getInt("id"));
//            System.out.println("Nombre: "+rs.getString("Nombre"));
//            System.out.println("Genero: "+rs.getString("Genero"));
//            System.out.println("Fecha de lanzamiento: "+rs.getDate("FechaLanzamiento"));
//            System.out.println("Compañia: "+rs.getString("Compañia"));
//            System.out.println("Precio: "+rs.getFloat("Precio"));
//            System.out.println("-------------------------------------------");
//            }
            // </editor-fold>
            
            

            stmt.close();
//            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
 
        
    public void Insert_param(String nombre,String genero, Date fechaLanzamiento, String Compañia, int Precio) throws ParseException {


// <editor-fold defaultstate="collapsed" desc="-Definición-">
//        videojuego ng = new videojuego();
//        datosJuego(ng);
//        String insert=" INSERT INTO `videojuegos`( `Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`)" +
//         "VALUES ('[+value-2]','[value-3]','[value-4]','[value-5]','[value-6]')'";

//         String insert=" INSERT INTO `videojuegos`( `"+ng.getNombre()+"`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`)" +
//         "VALUES ('[+value-2]','[value-3]','[value-4]','[value-5]','[value-6]')'";
//         ng.getNombre();
//         ng.getGenero();
//         ng.getFechaLanzamiento();
//         ng.getCompañia();
//         ng.getPrecio();
// </editor-fold>

        String insert = "INSERT INTO `videojuegos`(`Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) "
                + "VALUES ('" + nombre + "','" + genero + "','" + fechaLanzamiento + "','"
                + Compañia + "'," + Precio+ ")";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(insert);
            
//            while(rs.next()){
//            System.out.println("id: "+rs.getInt("id"));
//            System.out.println("Nombre: "+rs.getString("Nombre"));
//            System.out.println("Genero: "+rs.getString("Genero"));
//            System.out.println("Fecha de lanzamiento: "+rs.getDate("FechaLanzamiento"));
//            System.out.println("Compañia: "+rs.getString("Compañia"));
//            System.out.println("Precio: "+rs.getFloat("Precio"));
//            System.out.println("-------------------------------------------");
//            }
            stmt.close();
//            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
