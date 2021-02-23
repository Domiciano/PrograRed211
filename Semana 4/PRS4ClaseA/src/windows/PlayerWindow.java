package windows;

import event.OnNavigateListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerWindow extends Stage {

	private Scene scene;
	private VBox vbox;

	private TextField nameTF;
	private TextField nacionalityTF;
	private TextField positionTF;

	private TextField speedTF;
	private TextField attackTF;
	private TextField defenseTF;

	private Button okBtn, backBtn;
	
	private OnNavigateListener listener;

	public PlayerWindow() {
		vbox = new VBox();

		nameTF = new TextField();
		nameTF.setPromptText("Nombre");
		nacionalityTF = new TextField();
		nacionalityTF.setPromptText("Nacionalidad");
		positionTF = new TextField();
		positionTF.setPromptText("Posición");
		speedTF = new TextField();
		speedTF.setPromptText("Velocidad");
		attackTF = new TextField();
		attackTF.setPromptText("Ataque");
		defenseTF = new TextField();
		defenseTF.setPromptText("Defensa");

		backBtn = new Button("Atrás");
		okBtn = new Button("Siguiente");

		vbox.getChildren().add(new Label("Registre los datos del nuevo jugador"));
		vbox.getChildren().add(new Label("Información básica"));

		vbox.getChildren().add(nameTF);
		vbox.getChildren().add(nacionalityTF);
		vbox.getChildren().add(positionTF);
		
		vbox.getChildren().add(new Label("Stats"));

		vbox.getChildren().add(speedTF);
		vbox.getChildren().add(attackTF);
		vbox.getChildren().add(defenseTF);

		HBox hbox = new HBox();
		hbox.getChildren().add(backBtn);
		hbox.getChildren().add(okBtn);
		vbox.getChildren().add(hbox);

		scene = new Scene(vbox);
		this.setScene(scene);

		okBtn.setOnAction(event -> {
			listener.onForward(this);
		});
		
		backBtn.setOnAction(event -> {
			listener.onBack(this);
		});

	}
	
	public void setListener(OnNavigateListener listener) {
		this.listener = listener;
	}

}
