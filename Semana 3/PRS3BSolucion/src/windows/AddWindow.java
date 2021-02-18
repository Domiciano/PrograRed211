package windows;

import events.OnUserAddedListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddWindow extends Stage{
	
	private Scene scene;
	private VBox vbox;
	
	private TextField idTF;
	private TextField nameTF;
	
	private Button okBtn;
	
	
	private OnUserAddedListener listener;
	
	public AddWindow() {
		vbox = new VBox();
		
		idTF = new TextField();
		nameTF = new TextField();
		okBtn = new Button("Agregar");
		
		vbox.getChildren().add(new Label("Introduzca una nueva persona indicando su ID o cédula y el nombre"));
		vbox.getChildren().add(new Label("ID o cédula"));
		vbox.getChildren().add(idTF);
		vbox.getChildren().add(new Label("Nombre"));	
		vbox.getChildren().add(nameTF);
		vbox.getChildren().add(okBtn);
		
		scene = new Scene(vbox);
		this.setScene(scene);
		
		
		okBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String id = idTF.getText();
				String name = nameTF.getText();
				if(listener != null) listener.onUserAdded(id, name);
				close();
			}
		});
		
	}
	
	public void setListener(OnUserAddedListener listener) {
		this.listener = listener;
	}
	
	
}
