import javafx.fxml.FXMLLoader;
import se.chalmers.cse.dat216.project.Product;

import java.io.IOException;

public class LittleFoodLabelPane {
    private Product product;
    private Controller parentController;

    public LittleFoodLabelPane(Product product, Controller controller){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML.filer/LittleFoodLabelPane.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.product = product;
        this.parentController = controller;

    }
}