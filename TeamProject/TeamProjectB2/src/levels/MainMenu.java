/*This function is the main menu for the entire game. It displays the right screen with the right media.
 * This class is quintessential in the success of this app. It extends level. It also uses the buttons that 
 * were created in other classes. It is responsible for the home screen of the game that displays the start, 
 * scores buttons as well as the logo for the game, the background for the game, and every other component 
 * that is displayed on the home screen. Also, we use sorted maps and tree maps to implement the player
 * and scores.*/
package levels;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import application.Validator;
import buttons.MathButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class MainMenu extends Level{
	//declare/initialize necessary variables.
	private final String ERROR_PATH = "media/background/not-found-512.png";
	private final String BACKGROUND_PATH = "media/background/1.png";
	private final String LOGO_PATH = "media/font/logo.png";
	private final String FONT_PATH = "src/media/font/PressStart2P-Regular.ttf";
	MathButton start;
	MathButton scores;
	ImageView logo;
	TextField name;
	Validator validator = new Validator();
	MathSubScene errorScene;
	MathSubScene scoresScene;
	boolean scoreVisible = false;
	
	
	//default constructor
	public MainMenu(){
		super();
		createBackground(BACKGROUND_PATH);
		createButtons();
		createLogo();
		createInputDialogue();
	}
	
	//this will take in the player name and use that text field and set it to the name of the player.
	private void createInputDialogue() {
		// TODO Auto-generated method stub
		name = new TextField("Player Name");
		name.setStyle("    -fx-text-fill: -fx-text-inner-color;\r\n" + 
				"    -fx-highlight-fill: derive(-fx-control-inner-background,-20%);\r\n" + 
				"    -fx-highlight-text-fill: -fx-text-inner-color;\r\n" + 
				"    -fx-prompt-text-fill: derive(-fx-control-inner-background,-30%);\r\n" + 
				"    -fx-background-color: linear-gradient(to bottom, derive(-fx-text-box-border, -10%), -fx-text-box-border),\r\n" + 
				"        linear-gradient(from 0px 0px to 0px 5px, derive(-fx-control-inner-background, -9%), -fx-control-inner-background);\r\n" + 
				"    -fx-background-insets: 0, 1;\r\n" + 
				"    -fx-background-radius: 3, 2;\r\n" + 
				"    -fx-cursor: text;\r\n" + 
				"    -fx-padding: 0.333333em 0.583em 0.333333em 0.583em;"
				);
		name.setBlendMode(BlendMode.OVERLAY);
		try {
			name.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 20));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			name.setFont(Font.font("Arial", 18));
		}
		//set height and width of everything
		name.setPrefWidth(250);
		name.setPrefHeight(50);
		name.setLayoutX((WIDTH - name.getPrefWidth())/2.0);
		name.setLayoutY((HEIGHT - 3*name.getPrefHeight())/2.0);
		pane.getChildren().add(name);
	}

	//this function creates and displays the logo on the home screen
	private void createLogo() {
		// TODO Auto-generated method stub
		
		try {
			logo = new ImageView(LOGO_PATH);			
		} catch (Exception e) {
			logo = new ImageView(ERROR_PATH);
		}
		//set the width and height functions
		logo.setFitWidth(666);
		logo.setFitHeight(217);
		logo.setLayoutX(WIDTH/2.0 - logo.getFitWidth()/2.0);
		logo.setLayoutY(HEIGHT/8.0);
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			//override to add effect on the logo
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				logo.setEffect(new DropShadow());
			}
			
		});
		//override to remove effect on the logo
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				logo.setEffect(null);
			}
			
		});
		pane.getChildren().add(logo);
	}

	@Override
	//this will call the createStart and scores buttons so that they are displayed on the menu
	protected void createButtons() {
		// TODO Auto-generated method stub
		creatStartButton();
		creatScoresButton();
	}

	//this will create the scores button
	private void creatScoresButton() {
		// TODO Auto-generated method stub
		scores = new MathButton("Scores");
		scores.setLayoutX(WIDTH/2.0 - start.getPrefWidth()/2.0);
		scores.setLayoutY(3*HEIGHT/4.0);
		scores.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			//this public handle overridden function is responsible to reading the user's name input
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(scoreVisible == false) {
				String scoresString = "";
				String pname = "";
				int pscore = 0;
				SortedMap<Integer,String> highScores = new TreeMap<Integer,String>(Collections.reverseOrder());
				try {
					String line;
					BufferedReader input = new BufferedReader(new FileReader("src/application/scores.txt"));
					line = input.readLine();
					while(line != null) {
						pname = line.substring(0, line.indexOf(":"));
						pscore = Integer.parseInt(line.substring(line.indexOf(":") + 1));
						highScores.put(pscore, pname);
						line = input.readLine();
					}
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
				}
				
				int i = 0;
				for(Entry<Integer, String> e: highScores.entrySet()) {
					scoresString += e.getValue() + "   " + e.getKey() + "\n\n";
					i++;
					if(i >= 5)
						break;
				}
				//System.out.println(scoresString);
				createScoresSubScene(scoresString);
			}
		}
		});		
		pane.getChildren().add(scores);
	}

	/*This function is required to properly created the scores subscene when the user selects to view
	 * the scores*/
	protected void createScoresSubScene(String scoresString) {
		// TODO Auto-generated method stub
		scoresScene = new MathSubScene(scoresString, 0.8*WIDTH, 0.8*HEIGHT);
		scoresScene.setLayoutX((WIDTH - scoresScene.getWidth())/2.0);
		scoresScene.setLayoutY((HEIGHT - scoresScene.getHeight())/2.0);
		pane.getChildren().add(scoresScene);
		scoresScene.showSubSceneTransition();
		addOkayInitializer(scoresScene);
		scoreVisible = true;	
	}

	/*This function is responsible for created the start button so that the game starts when the buttons is
	 * clicked*/
	private void creatStartButton() {
		// TODO Auto-generated method stub
		start = new MathButton("Start");
		start.setLayoutX(WIDTH/2.0 - start.getPrefWidth()/2.0);
		start.setLayoutY(3*HEIGHT/4.0 - 11*start.getPrefHeight()/10.0 );
		start.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				//System.out.println(name.getText());
				if(validator.valid(name.getText()) == true) {
					Gameplay game = new Gameplay(name.getText());
					game.nextLevel(stage);
				}else {
					showErrorSubScene();
				}
			}
		});
		pane.getChildren().add(start);
	}

	/*This function is responsible for showing the error subscene incase there is an error*/
	protected void showErrorSubScene() {
		// TODO Auto-generated method stub
		errorScene = new MathSubScene("Error: Invalid Text Input");
		errorScene.setLayoutX((WIDTH - errorScene.getWidth())/2.0);
		errorScene.setLayoutY((HEIGHT - errorScene.getHeight())/2.0);
		errorScene.showSubSceneTransition();
		pane.getChildren().add(errorScene);
		addOkayInitializer(errorScene);
	}

	/*This funciton is responsible to add the Okay initializer, whihc will high the subscene transition for
	 * pane*/
	protected void addOkayInitializer(MathSubScene mss) {
		mss.okay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
				mss.hideSubSceneTransition(pane);		
				scoreVisible = false;
			}
		});
	}		
}
