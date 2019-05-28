/*This class is responsible fro creating the levels. Since there is one simple questions asked multiple times
 * in this game, we still need different levels scenes to display the information.*/
package levels;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class Level {
	//protected and private initialization and declarations
	protected final int WIDTH = 800;
	protected final int HEIGHT = 600;
	protected AnchorPane pane;
	private Scene scene;
	protected Stage stage;
	protected Stage prevStage;
	
	//default constructor 
	Level(){
		pane = new AnchorPane();
		setScene(new Scene(pane, WIDTH, HEIGHT));
		stage = new Stage();
		stage.setScene(getScene());
	}
	
	//constructor that uses the prevStage as the the next level
	Level(Stage prevStage){
		pane = new AnchorPane();
		setScene(new Scene(pane, WIDTH, HEIGHT));
		stage = new Stage();
		stage.setScene(getScene());
		createButtons();
		createBackground("");
		nextLevel(prevStage);
	}
	
	//constructor that uses a string and prevstage as parameters
	Level(String bg, Stage prevStage){
		pane = new AnchorPane();
		setScene(new Scene(pane, WIDTH, HEIGHT));
		stage = new Stage();
		stage.setScene(getScene());
		createButtons();
		createBackground(bg);
		nextLevel(prevStage);
	}

	//protected class declarations
	protected abstract void createButtons();
	
	
	//This function is used to set the background for each "stage"
	protected void createBackground(String path) {
		// TODO Auto-generated method stub
		try {
		Image image = new Image(path, WIDTH, HEIGHT, false, true);
		BackgroundImage background = new BackgroundImage(image, 
				BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER,
				new BackgroundSize(100, 100, true, true, true, false));
		pane.setBackground(new Background(background));
		}catch (Exception e) {
			pane.setBackground(new Background(new BackgroundFill(Color.TURQUOISE, null, null)));
		}
	}	
	
	//public function that returns the stage
	public Stage getStage() {
		return stage;
	}
	
	//public function that returns scene
	public Scene getScene() {
		return scene;
	}

	//setter function that sets scene
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	//this function sets previous stage to previous stage and hides it to show the stage.
	protected void nextLevel(Stage prevStage) {
		this.prevStage = prevStage;
		prevStage.hide();
		stage.show();
	}
}
