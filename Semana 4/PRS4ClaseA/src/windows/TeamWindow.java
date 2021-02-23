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

public class TeamWindow extends Stage{
	
	private Scene scene;
	private VBox vbox;
	
	private TextField teamName;
	private TextField teamNationality;
	
	private Button okBtn;
	private Button backBtn;
	
	private OnNavigateListener listener;
	
	
	public TeamWindow() {
		vbox = new VBox();
		
		teamName = new TextField();
		teamName.setPromptText("Nombre");
		teamNationality = new TextField();
		teamNationality.setPromptText("Nacionalidad");
		
		
		okBtn = new Button("Finalizar");
		backBtn = new Button("Atrás");
		
		vbox.getChildren().add(new Label("Escriba la información del equipo del jugador"));
		vbox.getChildren().add(teamName);
		vbox.getChildren().add(teamNationality);
		
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
