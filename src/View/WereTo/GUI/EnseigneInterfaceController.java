/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.WereTo.GUI;

import Entity.Enseigne;
import Entity.SignalEnseigne;
import Service.CRUD_Enseigne;
import Service.CRUD_Signal;
import Service.CRUD_Note;
import Entity.NoteEnseigne;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mohamed El Hammi
 */
public class EnseigneInterfaceController implements Initializable {
    public static Enseigne en=null;
    @FXML
    private ImageView photo1;
    @FXML
    private ImageView photo2;
    @FXML
    private ImageView photo3;
    @FXML
    private Label nomEnseigne;
    @FXML
    private Label descriptionEnseigne;
    @FXML
    private Label adresseEnseigne;
    @FXML
    private Label specialiteEnseigne;
    @FXML
    private Label horaireEnseigne;
    @FXML
    private Label numTelEnseigne;
    @FXML
    private Label noteEnseigne;
    
    private Enseigne e1 = new Enseigne();
    @FXML
    private Button btSignal;
    @FXML
    private ComboBox<Number> noteField;
        ObservableList<Number> myData = FXCollections
            .observableArrayList(1, 2, 3, 4, 5);
    /**
     * Initializes the controller class.
     */
    public void setNom(Enseigne e){
        nomEnseigne.setText(e.getNom());        
    }
    
    public void setDescription(Enseigne e){
        descriptionEnseigne.setText(e.getDescription());        
    }
    public void setAdresse(Enseigne e){
        adresseEnseigne.setText(e.getAdresse());        
    }
    public void setSpecialite(Enseigne e){
        specialiteEnseigne.setText(e.getSpecialite());        
    }
    public void setHoraire(Enseigne e){
        horaireEnseigne.setText(e.getHoraire());        
    }
    public void setNumTel(Enseigne e){
        numTelEnseigne.setText(e.getNumTel());        
    }
    public void setPhoto1(Enseigne e) {
                Image img = new Image(e.getPhoto1());                
                photo1.setImage(img);
                photo1.setFitWidth(200);
                photo1.setFitHeight(150);       
    }
    public void setPhoto2(Enseigne e) {
                Image img = new Image(e.getPhoto2());                
                photo2.setImage(img);
                photo2.setFitWidth(200);
                photo2.setFitHeight(150);
    }
    public void setPhoto3(Enseigne e) {
                Image img = new Image(e.getPhoto3());                
                photo3.setImage(img);
                photo3.setFitWidth(200);
                photo3.setFitHeight(150);
    }
    
    
    public void setSignal(Enseigne e) throws SQLException{
            e1 = e;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
                   // System.out.println(en);
        //System.out.println();
        noteField.setItems(myData);

    }    

    @FXML
    private void accueilbt(ActionEvent event) throws IOException {
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("AccueilProprio.fxml"));
            Parent root = myLoader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Formulaire");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
    }
        @FXML
    private void afficheRestaurant(ActionEvent event) throws IOException{
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Restaurant.fxml"));
            Parent root = myLoader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Formulaire");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
    } 
    
    @FXML
    private void afficheBar(ActionEvent event) throws IOException{
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Bar.fxml"));
            Parent root = myLoader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Formulaire");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    @FXML
    private void afficheCinema(ActionEvent event) throws IOException{
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Cinema.fxml"));
            Parent root = myLoader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Formulaire");
            stage.setScene(new Scene(root));
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
    } 


    @FXML
    private void signalerEnseigne(ActionEvent event) throws SQLException {
                        System.out.println(e1.getIdEnseigne()); 
        CRUD_Signal crS = new CRUD_Signal();
        
        Alert alert = new Alert(AlertType.INFORMATION);

                 int nbrSignalActuel = crS.displayNbr2(1,e1.getIdEnseigne());

                 if(nbrSignalActuel == 1) {
                     
                     alert.setTitle("Alerte !");
                     alert.setHeaderText("Look, an Information Dialog");
                     alert.setContentText("Vous avez deja signalé cette Enseigne !!");
                     alert.showAndWait();
                      return ;
                    }       
                         nbrSignalActuel = nbrSignalActuel + 1;
                                          crS.insertSt(e1.getIdEnseigne(), 1, nbrSignalActuel);
                                            System.out.println(nbrSignalActuel);

        CRUD_Enseigne crE = new CRUD_Enseigne();
                System.out.println(e1.getIdEnseigne()); 
        crE.addSignal(e1.getIdEnseigne());
        

    }

    @FXML
    private void noterEnseigne(ActionEvent event) throws SQLException {
        
        CRUD_Enseigne crE = new CRUD_Enseigne();
        //System.out.println(noteField.getValue());
        int noteNbr = (int)noteField.getValue();
        CRUD_Note crN = new CRUD_Note();
        int a = crN.displayNote(2, e1.getIdEnseigne()) ;
        System.out.println(a);
        if ( a != 0) {
            crN.updateNote(2, e1.getIdEnseigne(), noteNbr);
        }
        else {
            crN.insertSt(e1.getIdEnseigne(),2 , noteNbr);

        }
    }

    
}
