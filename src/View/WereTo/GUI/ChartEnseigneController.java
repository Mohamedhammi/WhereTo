/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.WereTo.GUI;

import Entity.Enseigne;
import Service.CRUD_Enseigne;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;


/**
 * FXML Controller class
 *
 * @author Mohamed El Hammi
 */
public class ChartEnseigneController implements Initializable {

    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private CategoryAxis xAxis;
    final ObservableList<String> enseigneType = FXCollections.observableArrayList();
    @FXML
    private NumberAxis yAxis;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       xAxis.setLabel("Enseigne");
 
       yAxis.setLabel("Nombre d'Enseigne");
        
        
        List<String> lEnseigne2 = new ArrayList<>();
        lEnseigne2.add("Bar");
        lEnseigne2.add("Cafe");
        lEnseigne2.add("Restaurant");
        

        enseigneType.addAll(lEnseigne2);

        xAxis.setCategories(enseigneType);
        try {
            setNombreType();
        } catch (SQLException ex) {
            Logger.getLogger(ChartEnseigneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setNombreType() throws SQLException  {

        CRUD_Enseigne cr = new CRUD_Enseigne();

       Number nombreType1 = cr.nombreEnseigne("Bar");;
       Number nombreType2 = cr.nombreEnseigne("Cafe");;
       Number nombreType3 = cr.nombreEnseigne("Restaurant");

       
        XYChart.Series<String,Number> set1 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> set2 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> set3 = new XYChart.Series<String,Number>();


            set1.getData().add(new XYChart.Data<String,Number>("Bar", nombreType1));
            set1.setName("Bar");
            
            set2.getData().add(new XYChart.Data<String,Number>("Cafe",nombreType2 ));
            set2.setName("Cafe");

            set3.getData().add(new XYChart.Data<String,Number>("Restaurant",nombreType3 ));
            set3.setName("Restaurant");




        barChart.getData().add(set1);
        barChart.getData().add(set2);
        barChart.getData().add(set3);

    }
    
}
