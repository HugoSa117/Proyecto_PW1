package SQL;


import SQL.ConexionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class MetodosSQL {

    private Connection conexion;
    private PreparedStatement sentenciaPreparada;
    private ResultSet resultado;

    public boolean registrarUsuario(String usuario, String contrasena, String nombre, String apellido, String FdN, String correo) {
        boolean registro = false;

        try {
            conexion = ConexionBd.conectar();
            String consulta = "INSERT INTO usuarios(usuario, contrasena, nombre, apellido, FdN, correo) VALUES (?,?,?,?,?,?)";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, usuario);
            sentenciaPreparada.setString(2, contrasena);
            sentenciaPreparada.setString(3, nombre);
            sentenciaPreparada.setString(4, apellido);
            sentenciaPreparada.setString(5, FdN);
            sentenciaPreparada.setString(6, correo);

            int resultadoInsercion = sentenciaPreparada.executeUpdate();

            if (resultadoInsercion > 0) {
                registro = true;
                System.out.println("Registro exitoso");
            } else {
                registro = false;
                System.out.println("El registro fallo con exito");

            }
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error" + e);
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        }

        System.out.println("Valor del registro" + registro);
        return registro;
    }
    
    public boolean inicioSesion(String usuario, String contrasena){
        boolean iniciarSesion = false;
        
        try {
            conexion = ConexionBd.conectar();
            String consulta = "SELECT usuario,contrasena FROM usuarios WHERE usuario = ? AND contrasena contrasena = ?";
            sentenciaPreparada = conexion.prepareStatement(consulta);
            sentenciaPreparada.setString(1, usuario);
            sentenciaPreparada.setString(2, contrasena);
            resultado = sentenciaPreparada.executeQuery();
            
            if(resultado.next()){
                iniciarSesion = true;
            }else{
                iniciarSesion = false;
                System.out.println("Usuario no encontrado");
            }
            conexion.close();
            
            
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }finally{
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        
        System.out.println("Valor de la sesion es " + iniciarSesion);
        return iniciarSesion;
    }
}
