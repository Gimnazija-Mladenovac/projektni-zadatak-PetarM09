package projekat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import projekat.model.Database;
import projekat.model.Kombinacija;
import projekat.model.Numera;

import java.util.List;

public class SecondView extends VBox {
    private TextField vinylTf;
    private TextField cdTf;
    private TextField polovnihTf;
    private TextField novihTf;
    private TextField ukupnoTf;
    private TextField vrednostTf;

    private TableView tableView;
    private ObservableList<Kombinacija> numere;

    public SecondView(){
        init();
        pos();
    }

    private void pos(){
        this.getChildren().addAll(
                tableView
        );
    }
    private void init(){
        vinylTf = new TextField();
        cdTf = new TextField();
        polovnihTf = new TextField();
        novihTf = new TextField();
        ukupnoTf = new TextField();
        vrednostTf = new TextField();

        numere = FXCollections.observableList(Database.getInstance().getMojaKolekcija());

        tableView = new TableView(numere);
        TableColumn<Kombinacija, String> col1 = new TableColumn<>("Naziv izvodjaca");
        TableColumn<Kombinacija, List<Numera>> col2 = new TableColumn<>("Albumi");
        col1.setCellValueFactory(new PropertyValueFactory<>("izvodjac"));
        col2.setCellValueFactory(new PropertyValueFactory<>("numere"));
        tableView.getColumns().addAll(col1, col2);
    }
}
