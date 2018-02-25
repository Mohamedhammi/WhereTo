/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Mohamed El Hammi
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, SQLException {
        // TODO code application logic here
        
        PdfEnseigne pdf =new PdfEnseigne();
        pdf.pdf();
    }
    
}
