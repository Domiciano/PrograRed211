package windows;

import java.awt.Window;
import java.util.HashMap;

import data.User;
import events.OnDataChanged;
import events.OnWindowOpenedListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow extends Stage implements OnDataChanged {
	private Scene scene;
	private VBox vbox;
	private TextArea area;
	private Button addPerson;
	private Button removePerson;

	private OnWindowOpenedListener onWindowOpened;

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
				onWindowOpened.openWindow(AddWindow.class);
			}
		});

		removePerson.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				onWindowOpened.openWindow(RemoveWindow.class);
			}
		});
	}

	public void setOnWindowOpenedListener(OnWindowOpenedListener manager) {
		this.onWindowOpened = manager;
	}

	public void set(OnWindowOpenedListener manager) {
		this.onWindowOpened = manager;
	}

	@Override
	public void onData(HashMap<String, User> data) {
		area.setText("");
		for (String key : data.keySet()) {
			User user = data.get(key);
			area.appendText(user.getId() + " :: " + user.getName() + "\n");
		}
	}
}
