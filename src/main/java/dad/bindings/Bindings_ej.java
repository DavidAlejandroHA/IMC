package dad.bindings;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

// David Alejandro Hernández Alonso 2º DAM A

public class Bindings_ej extends Application {
//	TextField insertTexto = new TextField();
	Label cuadroLabel1 = new Label();
	Label cuadroLabel2 = new Label();
	Label cuadroLabel3 = new Label();

	Label Kg = new Label();
	Label cm = new Label();

	@Override
	public void start(Stage primaryStage) throws Exception {

		TextField nombreTexto1 = new TextField();
		TextField nombreTexto2 = new TextField();

		HBox rootPanelH1 = new HBox();
		rootPanelH1.setSpacing(5);
		rootPanelH1.setFillHeight(false); // el cuadro de texto no se estira tanto
		rootPanelH1.setAlignment(Pos.CENTER); // alinea todo en el centro
		nombreTexto1.setPrefWidth(80); // asigna un tamaño predeterminado al cuadro de texto
		cuadroLabel1.setText("Peso:"); // le asigna el texto al cuadroLabel1
		Kg.setText("kg"); // le asigna el texto al label kg
		rootPanelH1.getChildren().addAll(cuadroLabel1, nombreTexto1, Kg); // se añaden todos los elementos al HBox

		HBox rootPanelH2 = new HBox();
		rootPanelH2.setSpacing(5);
		rootPanelH2.setFillHeight(false);
		rootPanelH2.setAlignment(Pos.CENTER);
		nombreTexto2.setPrefWidth(80);
		cuadroLabel2.setText("Altura:");
		cm.setText("cm");
		rootPanelH2.getChildren().addAll(cuadroLabel2, nombreTexto2, cm);

		HBox rootPanelH3 = new HBox();
		rootPanelH3.setSpacing(5);
		rootPanelH3.setFillHeight(false);
		rootPanelH3.setAlignment(Pos.CENTER);
		rootPanelH3.getChildren().addAll(cuadroLabel3);

		// Creamos el panel con disposicion vertical
		VBox rootPanel = new VBox();
		rootPanel.setSpacing(5);
		rootPanel.setFillWidth(false); // el cuadro de texto no se estira tanto
		rootPanel.setAlignment(Pos.CENTER); // alinea todo en el centro
		rootPanel.getChildren().addAll(rootPanelH1, rootPanelH2, rootPanelH3); // se añaden todos los elementos al panel

		cuadroLabel3.setTextAlignment(TextAlignment.CENTER); // Se centra el texto hacia el centro

		Scene scene = new Scene(rootPanel, 480, 200);

		StringProperty P = new SimpleStringProperty(nombreTexto1.textProperty().toString());

		StringProperty A = new SimpleStringProperty(nombreTexto2.textProperty().toString());

//		DoubleProperty IMC = new SimpleDoubleProperty();

		P.bind(nombreTexto1.textProperty());

		A.bind(nombreTexto2.textProperty());

		cuadroLabel3.textProperty().bind(Bindings.concat("Inserta dos numeros."));

		P.addListener((o, ov, nv) -> {
			try {
				double numTexto1 = Double.parseDouble(nombreTexto1.textProperty().getValue().toString());
				double numTexto2 = Double.parseDouble(nombreTexto2.textProperty().getValue().toString());
//				IMC.set(numTexto1);
//				IMC.multiply(numTexto2);
				double imc = Math.round((numTexto1 / ((numTexto2 / 100) * (numTexto2 / 100))) * 100.0) / 100.0;
				String estado_imc = "";
				if (imc < 18.5) {
					estado_imc = "Bajo peso";
				} else if (imc >= 18.5 && imc < 25) {
					estado_imc = "Peso normal";
				} else if (imc >= 25 && imc < 30) {
					estado_imc = "Sobrepeso";
				} else {
					estado_imc = "Obeso";
				}
				cuadroLabel3.textProperty().bind(Bindings.concat("IMC: " + imc + "\n\n" + estado_imc));
			} catch (Exception e) {
				cuadroLabel3.textProperty().bind(Bindings.concat("Inserta dos numeros."));
			}
		});

		A.addListener((o, ov, nv) -> {
			try {
				double numTexto1 = Double.parseDouble(nombreTexto1.textProperty().getValue().toString());
				double numTexto2 = Double.parseDouble(nombreTexto2.textProperty().getValue().toString());
//				IMC.set(numTexto1);
//				IMC.multiply(numTexto2);
				double imc = Math.round((numTexto1 / ((numTexto2 / 100) * (numTexto2 / 100))) * 100.0) / 100.0;
				String estado_imc = "";
				if (imc < 18.5) {
					estado_imc = "Bajo peso";
				} else if (imc >= 18.5 && imc < 25) {
					estado_imc = "Peso normal";
				} else if (imc >= 25 && imc < 30) {
					estado_imc = "Sobrepeso";
				} else {
					estado_imc = "Obeso";
				}
				cuadroLabel3.textProperty().bind(Bindings.concat("IMC: " + imc + "\n\n" + estado_imc));
			} catch (Exception e) {
				cuadroLabel3.textProperty().bind(Bindings.concat("Inserta dos numeros."));
			}
		});

		primaryStage.setTitle("IMC.fxml David Alejandro Hernández Alonso 2º DAM A");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
}
