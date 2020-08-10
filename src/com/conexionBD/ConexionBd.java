
package com.conexionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ConexionBd {

    private static ConexionBd instance = null;
    //Instancia de la interfaz
    private static Connection con = null;
    //Cadena de conexion
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SyC";
    //Clase driver
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //Usuario del servidor de base datos
    private static final String USER = "sa";
    //Contraseña del usuario
    private static final String PASS = "Jjoossee9.9";
    public  Statement st;
    public  ResultSet rs;

    //VAMOS A DEFINIR UN CONSTRUCTOR
    public ConexionBd() {

        try {
            //Generamos una isntancia de la clase driver 
            Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection(URL, USER, PASS);

        } catch (Exception e) {
            System.out.println("Error al conectar la base de datos"+e.getMessage());
            e.printStackTrace();
        }

    }

    public static synchronized ConexionBd getInstance() {
        if (instance == null) {
            instance = new ConexionBd();
        }
     return instance;
    }
    
    public Connection getCon(){
     return con;
    }
    
    public void closeConnectionBd(){
         instance=null;
    }

}
