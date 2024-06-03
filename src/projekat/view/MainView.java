package projekat.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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

    public MainView() {
        init();
        initGUI();
    }

    private void init(){
        comboBox = new ComboBox();
        vinyl = new RadioButton();
        cD = new RadioButton();
        vinylICD = new RadioButton();
        cena = new ComboBox();
        cenaTF = new TextField();
        prikaziSve = new Button("Prikazi sve");
        filtriraj = new Button("Filtriraj");
        tableView = new TableView();
        izaberi = new Button("Izaberi");
        listView = new ListView();
        ukupnoKosta = new TextField();
        kupi = new Button("Kupi");
        mojaKolekcija = new Button("Moja kolekcija");

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
