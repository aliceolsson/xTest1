package Views;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import se.chalmers.cse.dat216.project.IMatDataHandler;
import se.chalmers.cse.dat216.project.Product;
import se.chalmers.cse.dat216.project.ProductCategory;
import se.chalmers.cse.dat216.project.ShoppingItem;
import Controller.Controller;
import javafx.scene.control.Label;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

public class startsida extends AnchorPane{
    //fxid TILL startsidan

    @FXML AnchorPane HomePageAnchorPane;
    @FXML private FlowPane productFlow;             //denna används längst ner för att placera varorna på startsidan


    @FXML private ImageView ImatImageView;
    @FXML private Button homePageButton;
    @FXML private Button myListPageButton;
    @FXML private Button favoritePageButton;
    @FXML private Button historyPageButton;
    @FXML private Button helpPageButton;
    @FXML private Button fruitButton;
    @FXML private Button vegetableButton;
    @FXML private Button meatButton;
    @FXML private Button fishButton;
    @FXML private Button  charkButton;
    @FXML private Button dairyCookingButton;
    @FXML private Button lactoseFreeButton;
    @FXML private Button bakingButton;
    @FXML private Button cannedFoodButton;
    @FXML private Button pastaRiceButton;

    @FXML private Accordion homepageAccordion;

    @FXML private TitledPane homepageCathegorysTitledPane, fruitVegetableButton, meatFishButton, dairyProductsButton, pantryButton ;

    private Controller parentController;
    private ShoppingItem product;
    public IMatDataHandler dataHandler;

    public startsida(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML.filer/HomPage1.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        dataHandler = IMatDataHandler.getInstance();
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        //addProducts();
        myListPageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            MyListAnchorPane.toFront();
        });
        homePageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            ArrayList<Product> pl = new ArrayList<>();
            pl.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.FISH));
            pl.addAll(IMatDataHandler.getInstance().getProducts(ProductCategory.MEAT));
            addProducts(pl);
        });
        favoritePageButton.setOnAction(e -> {
            HomePageAnchorPane.toFront();
            favoriteAnchorPane.toFront();
        });
    }


    public startsida(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML.filer/HomPage1.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.product = new ShoppingItem(product);
        this.parentController = controller;

    }
    private void addProducts(List<Product> pl){
        productFlow.getChildren().clear();
       try {
           for(Product p : pl) {

               productFlow.getChildren().add(new product(p));
               productFlow.getChildren().add(new javafx.scene.control.Label("   "));
           }


       }
       catch (Exception e){
            e.printStackTrace();
       }
       }

   // @FXML AnchorPane HomePageAnchorPane;
    @FXML AnchorPane MyListAnchorPane;
    @FXML AnchorPane favoriteAnchorPane;






}
