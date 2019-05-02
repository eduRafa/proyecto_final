/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author amgal
 */
public class Connect {

	
	//Atributo que gestiona la conexión con la BBDD
	private Connection miConexion;
	
	private String host; //Host que contiene la BBDD
	private String bbdd; //Nombre de la BBDD
	private String login; //Login 
	private String password; //Password
	private boolean state=false;//Estado de la conexión
	
	
	public Connect(String host, String bbdd, String login, String password) 
	{
		this.host=host;
		this.bbdd=bbdd;
		this.login=login;
		this.password=password;		
			
		
	}
	
	/*Método: conectar()
	Tipo: boolean
	Parámetros: ninguno
	Devuelve: booleano que indica el estado de la conexión
	Funcionalidad: Realiza la conexión a la base de datos y si se realiza con exito
        pone el indicador de estado a true
	*/
	
	public boolean startConnection() throws Exception
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
         // Setup the connection with the DB
         
		//conexion nomral
		
		//miConexion= DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd+"?user="+this.login+"&password="+this.password);
		
		//conexión completa para evitar errores de sincronizacion con el servidor
		miConexion= DriverManager.getConnection("jdbc:mysql://"+this.host+"/"+this.bbdd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&user="+this.login+"&password="+this.password);
		
        
		this.state=true;
		} 
		catch (Exception e) {
			e.printStackTrace();
           }
         
		return this.state;
	}
	
	/*Método: getConexion()
	Tipo: Connection
	Parámetros: ninguno
	Devuelve: Connection
	Funcionalidad: Devuelve la conexión a la base de datos para poder realizar las sentencias
	*/
	
	public Connection getConect()
	{
		return miConexion;
	}
	
	/*Método: getEstado()
	Tipo: boolean
	Parámetros: ninguno
	Devuelve: boolean
	Funcionalidad: Devuelve si la conexión está establecida o no
        */
	
	public boolean getState()
	{
		return state;
		
	}
	
	/*Método: cerrarConexion()
	Tipo: boolean
	Parámetros: ninguno
	Devuelve: boolean
	Funcionalidad: Devuelve true si ha cerrado la conexión a la BBDD y false en caso contrario
        */
	
	public boolean closeConnection() throws Exception
	{
		boolean seCerro=false;
		try
		{
			this.miConexion.close();
			seCerro=true;
			
		}catch(SQLException se){
			se.printStackTrace();
		}
		return seCerro;
		
	}
	
	

}

