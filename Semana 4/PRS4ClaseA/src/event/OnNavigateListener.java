package event;
import javafx.stage.Stage;

public interface OnNavigateListener {
	
	public void onBack(Stage stage);
	public void onForward(Stage stage);

}
