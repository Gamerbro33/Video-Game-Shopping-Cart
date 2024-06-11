package personalprogram.view;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

import javafx.scene.control.Button;

import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import personalprogram.model.Game;
import personalprogram.model.Store;
import personalprogram.model.Transaction;

public class StartupWindow implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Transaction t;
	private Store store;
	private Button addBtn = new Button("Add Selected Item");
	private Button cartBtn = new Button("show Cart");
	private Button cancelBtn = new Button("Cancel Order");
	private ListView<String> storeCB = new ListView<String>();
	
	public StartupWindow(Stage stage) {
		// TODO Auto-generated constructor stub
		this.stage = stage;
		HBox buttonPanel = new HBox();
		VBox pane = new VBox();
		stage.setTitle("Games Selection");
		pane.getChildren().add(storeCB);
		pane.getChildren().add(buttonPanel);
		Scene scene = new Scene(pane, 150, 100);
		this.stage.setScene(scene);
		buttonPanel.getChildren().add(addBtn);
		addBtn.setOnAction(this);
		buttonPanel.getChildren().add(cartBtn);
		cartBtn.setOnAction(this);
		pane.getChildren().add(cancelBtn);
		buttonPanel.getChildren().add(cancelBtn);
		cancelBtn.setOnAction(this);
	}

	public void show(Store s) {
		// TODO Auto-generated method stub
		store = s;
		List<String> gameList = store.getGameNames();
		storeCB.getItems().setAll(gameList);
		stage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if(addBtn == event.getSource())
		{
		AddGameWindow addPurchase = new AddGameWindow();
		String gameName = storeCB.getSelectionModel().getSelectedItem();
		Game order = store.getGameItemByName(gameName);
		addPurchase.show(store, order);
		
		}
		else if(cartBtn == event.getSource())
		{
			
			//store.displayCart();
			CheckoutWindow cartPurchase = new CheckoutWindow();
			cartPurchase.show(store);
			
		}
		else
		{
			stage.close();
		}
	}

}
