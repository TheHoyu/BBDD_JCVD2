

package xml_jakarta.conexionbd_jorgejara;

import Clase.Metodos;
import Clase.videojuego;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ConexionBD_JorgeJara {

    public static void main(String[] args) throws SQLException, ParseException {
           Metodos met = new Metodos();
//           met.buscarNombre("CarlosDuty");
//           met.mostrar();
//           met.buscarNombre("Carlos Duty");
//           videojuego ng = new videojuego();
//           met.datosJuego(ng);
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Introduce nombre : ");
//            String nombre = sc.nextLine();
//            met.buscarNombre(nombre);

//            met.Insert();
              String nombre="El Retorno del vaquilla";
              String genero="Drama social";
              String FechaLanzamiento = "1994-04-19";
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
              Date fechaLanzamiento = dateFormat.parse(FechaLanzamiento);
              java.sql.Date sqlFechaLanzamiento = new java.sql.Date(fechaLanzamiento.getTime());
              String Compañia="El torete SL";
              int Precio = 10;
              
   
              met.Insert_param(nombre, genero, sqlFechaLanzamiento, Compañia, 0);


            
                    
            
    }
}
