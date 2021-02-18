package main;

import data.UserStorage;
import javafx.application.Application;
import javafx.stage.Stage;
import windows.AddWindow;
import windows.MainWindow;
import windows.RemoveWindow;

public class App extends Application{

	public static void main(String... args) {
		launch(args);
	}
	
	private MainWindow main;
	
	private AddWindow addwindow;
	private RemoveWindow removeWindow;
	private UserStorage storage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		storage = new UserStorage();
		main = new MainWindow();
		addwindow = new AddWindow();
		removeWindow = new RemoveWindow();
	}
	
	
	
}
