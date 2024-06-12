package projekat.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projekat.model.Database;
import projekat.model.Kategorija;
import projekat.model.Numera;
import projekat.model.Tip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class MainView extends VBox {

    private Label izvodjacLbl;
    private Label vinylLbl;
    private Label cdLbl;
    private Label obaLbl;
    private Label cenaLbl;
    private Label ukupnoLbl;

    private ComboBox<String> izvodjacCb;
    private ComboBox<String> cenaCb;

    private RadioButton vinylRb;
    private RadioButton cdRb;
    private RadioButton obaRb;

    private Button prikaziSveBttn;
    private Button filtrirajBttn;
    private Button izaberiBttn;
    private Button kupiBttn;
    private Button mojaKolekcijaBttn;

    private TextField filterTf;
    private TextField ukupnoTf;

    private TableView<Numera> tableView;
    private ListView<Numera> listView;

    private ObservableList<Numera> tableOl;
    private ObservableList<Numera> selektovaneOl;

    public MainView(){
        init();
        pos();
        actions();
    }

    private void actions(){

        mojaKolekcijaBttn.setOnAction(e->{
            Stage stage = new Stage();
            Scene scene = new Scene(new SecondView());
            stage.setScene(scene);
            stage.show();
        });
        izaberiBttn.setOnAction(e->{
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setContentText("Dugme izaberi");
        });

        kupiBttn.setOnAction(e->{
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setContentText("Dugme kupi");
        });

        filtrirajBttn.setOnAction(e->{
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setContentText("Dugme filtriraj");
        });

        prikaziSveBttn.setOnAction(e->{
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setContentText("Dugme prikazi");
        });
    }

    private void pos(){
        HBox hbox1 = new HBox();
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.getChildren().addAll(
                izvodjacLbl, izvodjacCb, vinylRb, vinylLbl, cdRb, cdLbl, obaRb, obaLbl
        );

        HBox hbox2 = new HBox();
        hbox2.setSpacing(10);
        hbox2.setAlignment(Pos.CENTER);
        hbox2.getChildren().addAll(
                cenaLbl, cenaCb, filterTf, prikaziSveBttn, filtrirajBttn
        );

        HBox hbox3 = new HBox();
        hbox3.setSpacing(10);
        hbox3.setAlignment(Pos.CENTER);
        GridPane gp = new GridPane();
        gp.addRow(0, ukupnoLbl, ukupnoTf);
        gp.addRow(1, kupiBttn, mojaKolekcijaBttn);
        gp.setHgap(8);
        gp.setVgap(8);

        hbox3.getChildren().addAll(
                listView, gp
        );

        gp.setAlignment(Pos.CENTER);

        this.getChildren().addAll(
                hbox1, hbox2, tableView, izaberiBttn, hbox3
        );
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10));
        this.setSpacing(15);
    }

    private void init(){
        izvodjacLbl = new Label("Izvodjac");
        vinylLbl = new Label("Vinyl");
        cdLbl = new Label("CD");
        obaLbl = new Label("Vinyl i CD");
        cenaLbl = new Label("Cena");
        ukupnoLbl = new Label("Ukupno kosta");

        izvodjacCb = new ComboBox<>(FXCollections.observableArrayList(Database.getInstance().getIzvodjaci()));
        cenaCb = new ComboBox<>();
        cenaCb.getItems().addAll(
                "=",
                ">",
                "<"
        );

        ToggleGroup tg = new ToggleGroup();
        vinylRb = new RadioButton();
        cdRb = new RadioButton();
        obaRb  = new RadioButton();

        vinylRb.setToggleGroup(tg);
        cdRb.setToggleGroup(tg);
        obaRb.setToggleGroup(tg);

        prikaziSveBttn = new Button("Prikazi sve");
        filtrirajBttn = new Button("Filtriraj");
        izaberiBttn = new Button("Izaberi");
        kupiBttn = new Button("Kupi");
        mojaKolekcijaBttn = new Button("Moja kolekcija");

        filterTf = new TextField();
        ukupnoTf = new TextField();

        List<Numera> sveNumere = new ArrayList<>();
        for(Map.Entry<Numera, Integer> entry : Database.getInstance().getNumere().entrySet()){
            sveNumere.add(entry.getKey());
        }
        tableOl = FXCollections.observableList(sveNumere);
        tableView = new TableView<>(tableOl);
        TableColumn<Numera, String> col1 = new TableColumn<>("Izvodjac");
        TableColumn<Numera, String> col2 = new TableColumn<>("Naziv");
        TableColumn<Numera, Integer> col3 = new TableColumn<>("Godina");
        TableColumn<Numera, String> col4 = new TableColumn<>("Zanr");
        TableColumn<Numera, Tip> col5 = new TableColumn<>("Tip");
        TableColumn<Numera, Integer> col6 = new TableColumn<>("Komad");
        TableColumn<Numera, Integer> col7 = new TableColumn<>("Cena");
        TableColumn<Numera, Kategorija> col8 = new TableColumn<>("Kategorija");

        col1.setCellValueFactory(new PropertyValueFactory<>("izvodjac"));
        col2.setCellValueFactory(new PropertyValueFactory<>("naziv"));
        col3.setCellValueFactory(new PropertyValueFactory<>("godina"));
        col4.setCellValueFactory(new PropertyValueFactory<>("zanr"));
        col5.setCellValueFactory(new PropertyValueFactory<>("tip"));
        col6.setCellValueFactory(new PropertyValueFactory<>("komad"));
        col7.setCellValueFactory(new PropertyValueFactory<>("cena"));
        col8.setCellValueFactory(new PropertyValueFactory<>("kategorija"));

        tableView.getColumns().addAll(
                col1, col2, col3, col4, col5, col6, col7, col8
        );

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        selektovaneOl = FXCollections.observableArrayList();
        listView = new ListView<>(selektovaneOl);

        // default values
        cenaCb.setValue(cenaCb.getItems().get(0));
        izvodjacCb.setValue(izvodjacCb.getItems().get(0));
    }
}
