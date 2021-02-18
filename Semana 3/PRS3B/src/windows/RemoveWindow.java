package windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RemoveWindow extends Stage{
	
	private Scene scene;
	private VBox vbox;
	
	private TextField idTF;
	
	private Button okBtn;
	
	public RemoveWindow() {
		vbox = new VBox();
		
		idTF = new TextField();
		okBtn = new Button("Eliminar");
		
		vbox.getChildren().add(new Label("Digite el número de ID o cédula de la persona que desea eliminar"));
		vbox.getChildren().add(new Label("Escriba el ID de la persona a eliminar"));
		vbox.getChildren().add(idTF);
		vbox.getChildren().add(okBtn);
		
		scene = new Scene(vbox);
		this.setScene(scene);
		
		
		okBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				close();
			}
		});
	}
	
	
}
