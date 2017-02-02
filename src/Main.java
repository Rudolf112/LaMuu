import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

    public class Main extends Application {
        @Override
        public void start(Stage primaryStage) throws Exception {
            String firma = "Lamuu";
            Pane pane = new Pane();
            Scene scene = new Scene(pane, 500, 500);

            Andmebaas a = new Andmebaas(firma);

            Label juhis = new Label("Sisesta hommikune saabunud kogus");

            TextField laduSisse = new TextField();
            laduSisse.setTranslateY(30);

            Button salvestaPäevaAlgus = new Button("Alusta päeva");
            salvestaPäevaAlgus.setTranslateY(60);

            Label juhis2 = new Label("Sisesta esimesse lahtrisse müügihind täna ja teise müüdud kogus");
            juhis2.setTranslateY(90);

            TextField müügiHind = new TextField();
            müügiHind.setTranslateY(120);
            TextField kogus = new TextField();
            kogus.setTranslateY(150);

            Button lõpetaPäev = new Button("Lõpeta päev");
            lõpetaPäev.setTranslateY(180);

            Label info = new Label();
            info.setTranslateY(210);

            Label statistika = new Label();
            statistika.setTranslateY(240);

            Label statistika2 = new Label();
            statistika2.setTranslateY(330);

            pane.getChildren().addAll(juhis, juhis2, laduSisse, salvestaPäevaAlgus, müügiHind, kogus, lõpetaPäev, statistika, statistika2, info);
            primaryStage.setScene(scene);
            primaryStage.show();

            salvestaPäevaAlgus.setOnMouseClicked(event -> {
                a.alustaPäeva(Integer.parseInt(laduSisse.getText()));
                info.setText("Päev alustatud!");
                statistika.setText("");
            });

            lõpetaPäev.setOnMouseClicked(event -> {
                a.lõpetaPäev(Integer.parseInt(kogus.getText()),Integer.parseInt(müügiHind.getText()));
                statistika.setText(a.kuvaStatistika());
                statistika2.setText("Kogukasum: "+Integer.toString(a.kasum())+"\nEfektiivseim hind: "+a.efektiivseimHind());
                info.setText("Päev lõpetatud");
                laduSisse.clear();
                müügiHind.clear();
                kogus.clear();
            });

        }
    }