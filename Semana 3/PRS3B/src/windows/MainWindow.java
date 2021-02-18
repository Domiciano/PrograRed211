package windows;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Stage {
	private Scene scene;
	private VBox vbox;
	private TextArea area;
	private Button addPerson;
	private Button removePerson;
	
	public MainWindow() {
		vbox = new VBox();
		area = new TextArea();
		addPerson = new Button("Agregar");
		removePerson = new Button("Remover");
		
		vbox.getChildren().add(area);
		vbox.getChildren().add(addPerson);
		vbox.getChildren().add(removePerson);
		
		scene = new Scene(vbox);
		this.setScene(scene);
		
		addPerson.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		
		removePerson.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
	}
}
