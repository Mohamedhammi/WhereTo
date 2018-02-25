/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wereto;

import Utile.DataSource;
import Service.CRUD_Enseigne;
import Entity.Enseigne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed El Hammi
 */
public class WereTo {
     public static void main(String[] args) throws SQLException{
        // TODO code application logic here
        System.out.println(DataSource.getInstance().getConnection());
        CRUD_Enseigne crEnseigne = new CRUD_Enseigne();
        
        //crEnseigne.insertSt(e);
        crEnseigne.delete(1);
        
    }
}
