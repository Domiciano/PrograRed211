package view;

import java.util.ArrayList;

import binding.INotificationViewModel;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Person;
import model.PersonList;
import viewmodel.MainViewModel;
import viewmodel.ViewModelBase;

public class MainWindow extends Stage implements INotificationViewModel {

	//Aqui solo hay logica de Vista
	
	private TextArea area;
	private TextField id;
	private TextField name;
	private Button addBtn;
	private Button autoBtn;

	private MainViewModel viewmodel;

	public MainWindow() {
		area = new TextArea();
		id = new TextField();
		name = new TextField();
		addBtn = new Button("Agregar");
		autoBtn = new Button("Agregar automáticamente");

		VBox box = new VBox();
		box.getChildren().add(area);
		box.getChildren().add(id);
		box.getChildren().add(name);
		box.getChildren().add(addBtn);
		box.getChildren().add(autoBtn);
		
		Scene scene = new Scene(box);
		this.setScene(scene);
		viewmodel = new MainViewModel();
		viewmodel.setListener(this);

		addBtn.setOnAction(event -> {
			viewmodel.addPersonToList(id.getText(), name.getText());
		});

		autoBtn.setOnAction(event -> {
			viewmodel.runAutoAdd();
		});
	}

	@Override
	public void OnUpdateUI() {
		Platform.runLater(() -> {
			// Desempaquetar el viewmodel
			PersonList personlist = viewmodel.getData();
			ArrayList<Person> persons = personlist.getPersons();
			area.setText("");
			for (Person person : persons) {
				area.appendText(person.getName() + "\n");
			}
		});
	}

}
