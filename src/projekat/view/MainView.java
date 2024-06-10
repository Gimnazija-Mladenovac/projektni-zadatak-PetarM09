package projekat.view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import projekat.model.Database;
import projekat.model.Kategorija;
import projekat.model.Numera;
import projekat.model.Tip;

import java.util.ArrayList;
import java.util.List;

public class MainView extends VBox {
    private ComboBox comboBox;
    private RadioButton vinyl;
    private RadioButton cD;
    private RadioButton vinylICD;
    private ComboBox cena;
    private TextField cenaTF;
    private Button prikaziSve;
    private Button filtriraj;
    private TableView tableView;
    private ListView listView;
    private Button izaberi;
    private TextField ukupnoKosta;
    private Button kupi;
    private Button mojaKolekcija;

    private HBox hBox1;
    private HBox hBox2;
    private HBox hBox3;
    private VBox vBox1;
    private HBox hBox4;
    private HBox hBox5;
    private ToggleGroup toggleGroup;

    public MainView() {
        init();
        initGUI();
    }

    private void init(){

        vinyl = new RadioButton();
        cD = new RadioButton();
        vinylICD = new RadioButton();
        toggleGroup = new ToggleGroup();
        vinyl.setToggleGroup(toggleGroup);
        cD.setToggleGroup(toggleGroup);
        vinylICD.setToggleGroup(toggleGroup);



        cenaTF = new TextField();
        prikaziSve = new Button("Prikazi sve");
        filtriraj = new Button("Filtriraj");
        kupi = new Button("Kupi");
        mojaKolekcija = new Button("Moja kolekcija");
        izaberi = new Button("Izaberi");

        cena = new ComboBox();
        cena.getItems().addAll(
                ">",
                "<",
                "="
        );
        cena.setValue(cena.getItems().get(0));
        comboBox = new ComboBox(FXCollections.observableArrayList(Database.getInstance().getIzvodjaci()));
        comboBox.setValue(comboBox.getItems().get(0));

        List<Numera> sveNumere = new ArrayList<>();
        for(var x : Database.getInstance().getNumere().entrySet())
            sveNumere.add(x.getKey());

        tableView = new TableView(FXCollections.observableList(sveNumere));

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
                col1,col2,col3,col4,col5,col6,col7,col8
        );

        tableView.getSelectionModel().setSelectionMode(
                SelectionMode.MULTIPLE
        );



        listView = new ListView();
        ukupnoKosta = new TextField();


        hBox1 = new HBox();
        hBox2 = new HBox();
        hBox3 = new HBox();
        hBox4 = new HBox();
        hBox5 = new HBox();
        vBox1 = new VBox();
    }

    private void initGUI(){
        hBox1.getChildren().addAll(new Label("Izvodjac"), comboBox, vinyl, new Label("Vinyl"), cD, new Label("CD"),  vinylICD, new Label("vinyl i CD"));
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setPadding(new Insets(15,15,15,15));
        hBox1.setSpacing(15);

        hBox2.getChildren().addAll(new Label("Cena"), cena, cenaTF, prikaziSve, filtriraj);
        hBox2.setPadding(new Insets(15));
        hBox2.setSpacing(30);
        hBox2.setAlignment(Pos.CENTER);

        hBox3.getChildren().addAll(new Label("Ukupno kosta: "), ukupnoKosta);
        hBox3.setSpacing(15);
        hBox3.setAlignment(Pos.CENTER);

        hBox4.getChildren().addAll(kupi, mojaKolekcija);
        hBox4.setSpacing(75);

        vBox1.getChildren().addAll(hBox3, hBox4);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(20);

        hBox5.getChildren().addAll(listView, vBox1);
        hBox5.setAlignment(Pos.CENTER);
        hBox5.setSpacing(50);

        this.getChildren().addAll(hBox1, hBox2,tableView, izaberi,hBox5);
        this.setSpacing(15);
        this.setPadding(new Insets(15,15,15,15));
        this.setAlignment(Pos.CENTER);
    }
}
