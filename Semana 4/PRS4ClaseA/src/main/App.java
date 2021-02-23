package main;

import event.OnNavigateListener;
import javafx.application.Application;
import javafx.stage.Stage;
import windows.PlayerWindow;
import windows.MainWindow;
import windows.TeamWindow;

public class App extends Application implements OnNavigateListener {

	public static void main(String... args) {
		launch(args);
	}

	private MainWindow main;

	private PlayerWindow playerwindow;
	private TeamWindow teamwindow;

	@Override
	public void start(Stage primaryStage) throws Exception {
		main = new MainWindow();
		playerwindow = new PlayerWindow();
		teamwindow = new TeamWindow();
		
		main.setListener(this);
		playerwindow.setListener(this);
		teamwindow.setListener(this);

		main.show();
	}

	@Override
	public void onBack(Stage stage) {
		if (stage == main) {
			//Nada
		} else if (stage == playerwindow) {
			showStage(stage, main);
		} else if (stage == teamwindow) {
			showStage(stage, playerwindow);
		}
	}

	@Override
	public void onForward(Stage stage) {
		if (stage == main) {
			showStage(stage, playerwindow);
		} else if (stage == playerwindow) {
			showStage(stage, teamwindow);
		} else if (stage == teamwindow) {
			showStage(stage, main);
		}
	}
	
	public void showStage(Stage current, Stage next) {
		current.hide();
		next.show();
	}
}
