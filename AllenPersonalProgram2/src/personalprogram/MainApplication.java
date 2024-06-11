package personalprogram;


import javafx.application.Application;
import javafx.stage.Stage;
import personalprogram.model.Store;
import personalprogram.view.StartupWindow;

public class MainApplication extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Store store = new Store("game_inventory.txt");
		StartupWindow window = new StartupWindow(primaryStage);
		window.show(store);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
