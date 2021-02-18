package main;

import data.UserStorage;
import events.OnWindowOpenedListener;
import javafx.application.Application;
import javafx.stage.Stage;
import windows.AddWindow;
import windows.MainWindow;
import windows.RemoveWindow;

public class App extends Application implements OnWindowOpenedListener{

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
		
		main.setOnWindowOpenedListener(this);
		addwindow.setListener(storage);
		removeWindow.setListener(storage);
		storage.setOnDataChanged(main);
		
		main.show();
	}

	@Override
	public void openWindow(Class stage) {
		if(stage == AddWindow.class) {
			addwindow.show();
		}else if(stage == RemoveWindow.class) {
			removeWindow.show();
		}
	}
	
	
	
}
