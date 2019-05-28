/*This is the class that controls the pop-ups for different scenes. It is used for the "popups" such as the correct 
 * and game over panes. For this, we need multiple functions that will work together to display the subscene at 
 * the right moments.*/
package levels;

import buttons.MathButton;
import javafx.animation.ScaleTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class MathSubScene extends SubScene{
	//declarations and initializations of objects and variables.
	protected final static String FONT_PATH = "src/media/font/PressStart2P-Regular.ttf";
	protected final static String BACKGROUND_PATH = "media/button/released.png";
	public static double WIDTH = 400;
	public static double HEIGHT = 300;
	AnchorPane subPane;
	MathText message;
	MathButton okay;
	ScaleTransition showTransition;
	ScaleTransition hideTransition;
	
	//constructor that sets the height and width of the scene
	public MathSubScene(String text) {
		super(new AnchorPane(), 400, 300);
		// TODO Auto-generated constructor stub
		WIDTH = 400;
		HEIGHT = 300;
		prefWidth(400);
		prefHeight(300);
		
		//set background image
		BackgroundImage image = new BackgroundImage(new Image(BACKGROUND_PATH, WIDTH, HEIGHT, false, true), 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		subPane = (AnchorPane) this.getRoot();
		
		//set font 
		subPane.setBackground(new Background(image));
		double fontSize = 35*text.length() > 306 ? 25:30;
		double width = 35*text.length() <= 306 ? 35*text.length() : 300;
		double height = text.contains(" ") ? 200 : 100;
		message = new MathText(text, width, height, fontSize);
		message.setLayoutX((WIDTH - message.getPrefWidth())/2);
		message.setLayoutY((HEIGHT - message.getPrefHeight())/2);
		
		okay = new MathButton("Okay", 200, 50, 0);
		okay.setLayoutX((WIDTH - okay.getPrefWidth())/2.0);
		okay.setLayoutY((HEIGHT - 2*okay.getPrefHeight()));	
		
		subPane.getChildren().add(message);
		subPane.getChildren().add(okay);
	}
	
	//another constructor that will create a pane with the heights and widths that are passed as parameters
	public MathSubScene(String text, double w, double h) {
		super(new AnchorPane(), w, h);
		// TODO Auto-generated constructor stub
		WIDTH = w;
		HEIGHT = h;
		BackgroundImage image = new BackgroundImage(new Image("media/background/3.png", WIDTH, HEIGHT, false, true), 
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, null);
		subPane = (AnchorPane) this.getRoot();
		
		subPane.setBackground(new Background(image));
		message = new MathText(text, 0.8*WIDTH, 0.8*HEIGHT, 18);
		message.setLayoutX((WIDTH - message.getPrefWidth())/2);
		message.setLayoutY((HEIGHT - 0.75*message.getPrefHeight())/2);
		okay = new MathButton("Okay", 200, 50, 0);
		okay.setLayoutX((WIDTH - okay.getPrefWidth())/2.0);
		okay.setLayoutY(HEIGHT/2.0 + WIDTH*0.25);	
		
		subPane.getChildren().add(message);
		subPane.getChildren().add(okay);
	}
	
	//This function is responsible for the transition of the subscene. It controls the animation
	void showSubSceneTransition() {
		// TODO Auto-generated method stub
		showTransition = new ScaleTransition(Duration.millis(500), this);
		showTransition.setFromX(0.01);
		showTransition.setToX(1);
		showTransition.setFromY(0.01);
		showTransition.setToY(1);
		showTransition.play();
	}
	
	//this function controls the animation to hide the subscene
	void hideSubSceneTransition(Pane pane) {
		// TODO Auto-generated method stub
		hideTransition = new ScaleTransition(Duration.millis(500), this);
		hideTransition.setFromX(1);
		hideTransition.setToX(0);
		hideTransition.setFromY(1);
		hideTransition.setToY(0.0000001);
		hideTransition.play();
		hideTransition.setOnFinished(event -> {
			pane.getChildren().remove(this);
		});
	}
}
