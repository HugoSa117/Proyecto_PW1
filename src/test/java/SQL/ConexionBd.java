package SQL;


import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class ConexionBd {
    private static String url = "jdbc:mysql://127.0.0.1:3306/bd_login";
    private static String usuario = "root";
    private static String contrasena = "root";
    
//    private static Connection conexion;
//    private static PreparedStatement sentenciaPreparada;
//    private static ResultSet resultado;
    
    public static Connection conectar(){
        Connection conexion = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e);
        }
        
        return conexion;
    }
    
    
//    public static void main(String [] args){ //Este codigo se uso para comprobar el funcionamiento de la base de datos, se deja solo para el recuerdo
//        
//        try {
//            conexion = conectar();
//            String consulta = "INSERT INTO usuarios (usuario, contrasena, nombre, apellido, fdn, correo) VALUES ('owo', 'uwu', 'diego', 'espinosa', '2', 'diego78041@gmail.com')";
//            sentenciaPreparada = conexion.prepareStatement(consulta);
//            int i = sentenciaPreparada.executeUpdate();
//            
//            if(i > 0){
//                System.out.println("Se guardaron los datos");
//            }else{
//                System.out.println("a");
//            }
//            conexion.close();
//        } catch (SQLException e) {
//            System.out.println("Error: " + e);
//        }
//    }
}