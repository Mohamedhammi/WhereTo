/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ousse
 */
public class DataSource {
 static String url="jdbc:mysql://127.0.0.1:3306/wereto";
    static String login="root";
    static String passwd="";
 static Connection cnx;
 static DataSource instance;

    private DataSource() {
   
             try {
            // TODO code application logic here
            cnx=DriverManager.getConnection(url,login, passwd);
        } catch (SQLException ex) {
            System.out.println("erreur");
        }
    }
   
    public Connection getConnection(){
        if (cnx == null)
              new DataSource();
            return cnx;
    }
    
    public static DataSource getInstance() {
        if(instance == null) {
            instance = new DataSource();
        }
        return instance;
    } 
}
