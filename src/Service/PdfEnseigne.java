/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Enseigne;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.NodeTest.ELEMENT;
import static java.awt.BorderLayout.CENTER;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author Mohamed El Hammi
 */
public class PdfEnseigne {
    
    public void pdf() throws IOException, SQLException {
        CRUD_Enseigne ce = new CRUD_Enseigne();
        Enseigne c = new Enseigne() ;
                //************
                c=ce.findByName("hsin",1);

        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Mohamed El Hammi\\Desktop\\Mohamed\\Pro\\Esprit\\Semestre 2\\Projet tests\\WhereTo\\WhereTo "+c.getNom()+".pdf"));
            doc.open();
//            Image img = Image.getInstance("E:\\Projetjava\\PidevTest1\\Logo.jpg");
//            img.scaleAbsoluteWidth(80);
//            img.scaleAbsoluteHeight(92);
//            img.setAlignment(Image.ALIGN_LEFT);
////            Paragraph p = new Paragraph("Date :");
////            p.setSpacingBefore(999);
////            doc.add(p);
//            doc.add(img);

//            doc.add(new Paragraph(" "));
//            doc.add(new Paragraph(" "));
//            doc.add(new Paragraph(" "));
//            doc.add(new Paragraph("Facture Numéro : " + c.getId()));
//            doc.add(new Paragraph("Id : " + c.getId()));
//            doc.add(new Paragraph("Nom : " + c.getNom()));
//            doc.add(new Paragraph("Prenom : " + c.getPrenom()));
//            doc.add(new Paragraph("Adresse :  " + c.getAdr()));
//            doc.add(new Paragraph("E-mail : " + c.getEmail()));
//            doc.add(new Paragraph(" "));
//            doc.add(new Paragraph(" "));
//            doc.add(new Paragraph(" "));

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            PdfPCell cell;
            // Nom Produit
            cell = new PdfPCell(new Phrase("Nom ", FontFactory.getFont("Comic Sans MS", 12)));
            
            cell.setBackgroundColor(BaseColor.RED);
            table.addCell(cell);
            //Artisant
            cell = new PdfPCell(new Phrase("Type", FontFactory.getFont("Comic Sans MS", 12)));
//                    cell.setHorizontalAlignment(ELEMENT.ALIGN CENTER);
            cell.setBackgroundColor(BaseColor.RED);
            table.addCell(cell);
            //Prix U
            cell = new PdfPCell(new Phrase("Adresse ", FontFactory.getFont("Comic Sans MS", 12)));
//                    cell.setHorizontalAlignment(ELEMENT.ALIGN CENTER);
            cell.setBackgroundColor(BaseColor.RED);
            table.addCell(cell);
            //Qté
            cell = new PdfPCell(new Phrase("Note", FontFactory.getFont("Comic Sans MS", 12)));
//                    cell.setHorizontalAlignment(ELEMENT.ALIGN CENTER);
            cell.setBackgroundColor(BaseColor.RED);
            table.addCell(cell);
            //Prix
            
    

//                    
//  RECUPERATION DE LA BASE PANIER 
            cell = new PdfPCell(new Phrase(c.getNom(), FontFactory.getFont("Comic Sans MS", 11)));

            table.addCell(cell);
            //Artisant
            cell = new PdfPCell(new Phrase(c.getType(), FontFactory.getFont("Comic Sans MS", 11)));

            table.addCell(cell);
            //Prix U
            cell = new PdfPCell(new Phrase(c.getAdresse(), FontFactory.getFont("Comic Sans MS", 11)));

            table.addCell(cell);
            //Qté
            cell = new PdfPCell(new Phrase(c.getNomUtilisateur(), FontFactory.getFont("Comic Sans MS", 11)));

            table.addCell(cell);
            //Prix
            
           
            doc.add(table);
            doc.close();
            Desktop.getDesktop().open(new File("C:\\Users\\Mohamed El Hammi\\Desktop\\Mohamed\\Pro\\Esprit\\Semestre 2\\Projet tests\\WhereTo\\WhereTo " + c.getNom() + ".pdf"));

        } catch (DocumentException | FileNotFoundException e) {
        }

    }

}


