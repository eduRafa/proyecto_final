/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author amgal
 */
public class Connect {

	
	//Atributo que gestiona la conexión con la BBDD
	static private Connection myConnection;
	static private boolean state=false;//Estado de la conexión
	static private final String HOST_DE="127.0.0.1"; //Host de la BBDD
       	static private final String BBDD_DE="POLICE_STATION"; //Nombre de la BBDD
        static private final String LOGIN_DE="root"; //Login 
        static private final String PASSWORD_DE=""; //Password

	
	
	
	/*Método: startConnection()
	Tipo: boolean
	Parámetros: ninguno
	Devuelve: booleano que indica el estado de la conexión
	Funcionalidad: Realiza la conexión a la base de datos y si se realiza con exito
        pone el indicador de estado a true
	*/
	
	static public boolean startConnection() throws Exception
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
         // Setup the connection with the DB
         
		//conexion nomral
		
		//miConexion= DriverManager.getConnection("jdbc:mysql://"+HOST_DE+"/"+BBDD_DE+"?user="+LOGIN_DE+"&password="+PASSWORD_DE);
		
		//conexión completa para evitar errores de sincronizacion con el servidor
		myConnection= DriverManager.getConnection("jdbc:mysql://"+HOST_DE+"/"+BBDD_DE+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user="+LOGIN_DE+"&password="+PASSWORD_DE);
		
        
		generateStructure();
		} 
		catch (Exception e) {
			e.printStackTrace();
           }
         
		return Connect.state;
	}
	
	
	
	/*Método: getState()
	Tipo: boolean
	Parámetros: ninguno
	Devuelve: boolean
	Funcionalidad: Devuelve si la conexión está establecida o no
        */
	
	static public boolean getState()
	{
		return state;
		
	}
	
	/*Método: closeConnection()
	Tipo: boolean
	Parámetros: ninguno
	Devuelve: boolean
	Funcionalidad: Devuelve true si ha cerrado la conexión a la BBDD y false en caso contrario
        */
	
	static public boolean closeConnection() throws Exception
	{
		boolean closed=false;
		try
		{
			Connect.myConnection.close();
			closed=true;
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		return closed;
		
	}

    private static void generateStructure() {
        boolean generated=true;
		
		String lineSQL;
		
		Statement sentence;
                try{
                    lineSQL="CREATE TABLE IF NOT EXISTS SUSPECT"
                    +"(CodeSuspect         int zerofill autoincrement PRIMARY KEY,"
                    +"name                 varchar(20),"
                    +"lastname1            varchar(20),"
                    +"lastname2            varchar(20),"
                    +"CCompanions          int,"
                    +"Record               blob,"
                    +"Facts                blob,"
                    + "FOREIGN KEY (CCompanios) REFERENCES SUSPECT (CodeSuspect)";
                    
                    //conectamos la sentencia a la base de datos
                    sentence = myConnection.createStatement();
                    //ejecutamos la sentencia;
                    sentence.executeUpdate(lineSQL);
                    
                    lineSQL="CREATE TABLE IF NOT EXISTS COMPANIONS"
                    + "(CodeSuspect1        int,"
                    + "CodeSuspect2         int,"
                    + "PRIMARY KEY (CodeSuspect1,CodeSuspect2),"
                    + "FOREIGN KEY (CodeSuspect1) REFERENCES SUSPECT(CodeSuspect),"
                    + "FOREIGN KEY (CodeSuspect2) REFERENCES SUSPECT(CodeSuspect))";
                    
                            
                    sentence = myConnection.createStatement();
                    
                    sentence.executeUpdate(lineSQL);
                    
                    lineSQL="CREATE TABLE IF NOT EXISTS PHONE"
                    + "(CodeSuspect          int,"
                    + "CodePhone             int zerofill autoincrement PRIMARY KEY,"
                    + "PhoneNumber           int,"
                    + "FOREIGN KEY (CodeSuspect) references SUSPECT(CodeSuspect))";
                    
                    sentence = myConnection.createStatement();
                    sentence.executeUpdate(lineSQL);
                    
                    lineSQL="CREATE TABLE IF NOT EXISTS E-MAIL"
                    + "(CodeE-mail          int zerofill autoincrement PRIMARY KEY,"
                    + "CodeSuspect          int,"
                    + "Email                varchar(20),"
                    + "FOREIGN KEY (CodeSuspect) REFERENCES SUSPECT (CodeSuspect))";
                    
                    sentence = myConnection.createStatement();
                    sentence.executeUpdate(lineSQL);
                    
                    lineSQL="CREATE TABLE IF NOT EXISTS ADDRESS"
                    + "(CodeAddress          int zerofill autoincrement PRIMARY KEY,"
                    + "CodeSuspect           int,"
                    + "Address               varchar(100),"
                    + "FOREIGN KEY (CodeSuspect) REFERENCES SUSPECT (CodeSuspect))";
                    
                    sentence = myConnection.createStatement();
                    sentence.executeUpdate(lineSQL);
                    
                    lineSQL="CREATE TABLE IF NOT EXISTS CAR_REGISTRATION"
                    + "(Resgistration_number int PRIMARY KEY,"
                    + "CodeSuspect           int,"
                    + "FOREIGN KEY (CodeSuspect) REFERENCES SUSPECT (CodeSuspect))";
                    
                    sentence = myConnection.createStatement();
                    sentence.executeUpdate(lineSQL);
                    
                    lineSQL="CREATE TABLE IF NOT EXISTS IMAGES"
                    + "(Image                blob,"
                    + "CodeImage             int zerofill autoincrement PRIMARY KEY,"
                    + "Description           blob"
                    + "CodeSuspect           int,"
                    + "FOREIGN KEY (CodeSuspect) REFERENCES SUSPECT (CodeSuspect))";
                    
                    sentence = myConnection.createStatement();
                    sentence.executeUpdate(lineSQL);
                    
                }catch(SQLException se){
			generated=false;
			se.printStackTrace();
		}
    }
	
	

}

