package Clase;

import java.sql.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

/**
 *
 * @author Hoyu
 */
public class Metodos {

    static final String DB_URL = "jdbc:mysql://localhost:3306/jcvd";
    static final String USER = "GM";
    static final String PASS = "1234";

    public void mostrar() throws SQLException {
        String QUERY = "SELECT * FROM videojuegos";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

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

    public boolean buscarNombre(String nombre) throws SQLException {
        String QUERY = "SELECT * FROM  videojuegos where nombre = '" + nombre + "';";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                System.out.println("El juego existe");
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

    public videojuego datosJuego(videojuego newGame) throws ParseException {

        Scanner sc = new Scanner(System.in);
        String Nombre, Genero, Compañia, FechaLanzamiento;
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
        System.out.print("Introduce la fecha de lanzamiento yyyy-MM-dd");
        FechaLanzamiento = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
        java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());
        newGame.setFechaLanzamiento(sqlFechaLanzamiento);
        System.out.println("-------------------------------");
        // </editor-fold>
        System.out.print("Introduce el precio: ");
        Precio = sc.nextDouble();
        newGame.setPrecio(Precio);

        return newGame;
    }

    public void Insert() throws ParseException {
        videojuego ng = new videojuego();
        datosJuego(ng);
//        String insert=" INSERT INTO `videojuegos`( `Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`)" +
//         "VALUES ('[+value-2]','[value-3]','[value-4]','[value-5]','[value-6]')'";

//         String insert=" INSERT INTO `videojuegos`( `"+ng.getNombre()+"`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`)" +
//         "VALUES ('[+value-2]','[value-3]','[value-4]','[value-5]','[value-6]')'";
//         ng.getNombre();
//         ng.getGenero();
//         ng.getFechaLanzamiento();
//         ng.getCompañia();
//         ng.getPrecio();
        String insert = "INSERT INTO `videojuegos`(`Nombre`, `Genero`, `FechaLanzamiento`, `Compañia`, `Precio`) "
                + "VALUES ('" + ng.getNombre() + "','" + ng.getGenero() + "','" + ng.getFechaLanzamiento() + "','"
                + ng.getCompañia() + "'," + ng.getPrecio() + ")";

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
    
     public void Insert_param(String nombre,String genero, Date fechaLanzamiento, String Compañia, int Precio) throws ParseException {
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
