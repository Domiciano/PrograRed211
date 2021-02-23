package windows;

import event.OnNavigateListener;
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
	
	private OnNavigateListener listener;

	public MainWindow() {
		vbox = new VBox();
		area = new TextArea();
		addPerson = new Button("Agregar Jugador");

		vbox.getChildren().add(area);
		vbox.getChildren().add(addPerson);

		scene = new Scene(vbox);
		this.setScene(scene);

		addPerson.setOnAction(event -> {
			listener.onForward(this);
		});

	}
	
	public void setListener(OnNavigateListener listener) {
		this.listener = listener;
	}
}
