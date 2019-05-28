/*This class is a class that extends Level and is responsible for create the path and the random numbers 
  for the game. It will create many protected and private attributes that we are using in the functions. */
package levels;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import buttons.AnswerButton;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Gameplay extends Level{

	//declare menu, next, etc. objects as well as initialize different variables.
	MainMenu menu;
	Gameplay next;
	protected final String playerName;
	private final static String BACKGROUND_PATH = "media/background/1.png";
	private final String ERROR_PATH = "media/background/not-found-512.png";
	private final String QUESTION_PATH = "media/font/question.png";
	protected final int N1 = new Random().nextInt(100);
	protected int N2 = new Random().nextInt(100);
	protected final int ANSWER = N1 > N2 ? N1 : N2;
	protected int SCORE = 0;
	ScaleTransition showTransition;
	ScaleTransition hideTransition;
	MathSubScene mss;
	MathText score;
	AnswerButton left;
	AnswerButton right;
	TranslateTransition rightTransition;
	TranslateTransition leftTransition;
	boolean gameOver = false;
	ImageView question;
	
	/*This function is responsible for creating the numbers that are going to be displayed on the buttons 
	 * that the user must select between. It calls the many functions that have to do with animations
	 * and visuals.*/
	Gameplay(String name){
		super();
		N2 = N1 == N2 ? (N2 + 1): N2;
		playerName = name;
		createBackground(BACKGROUND_PATH);
		createButtons();
		createLogo();
		createScoreLabel();
		makeRightTransition();
		makeLeftTransition();
		leftTransition.play();
		rightTransition.play();
		initializeButtonListener();
	}
	
	/*This is another constructor that initializes the constructor with two parameters that include the 
	 * previous stage. Nothing else has changed.*/
	Gameplay(String name, int score, Stage prevStage){
		super(BACKGROUND_PATH, prevStage);
		playerName = name;
		this.SCORE = score;
		createBackground(BACKGROUND_PATH);
		createButtons();
		createScoreLabel();
		createLogo();
		makeRightTransition();
		makeLeftTransition();
		leftTransition.play();
		rightTransition.play();
		initializeButtonListener();
	}
	
	/*This function created te score label that will display the top scores of the players.*/
	public void createScoreLabel() {
		score = new MathText(SCORE);
		score.setLayoutX(WIDTH - 1.25*score.getPrefWidth());
		pane.getChildren().add(score);
	}
	
	@Override
	/*This function overrides the createButtons function and calls the createLeft and right button functions 
	 * so that both buttons are created together.*/
	protected void createButtons() {
		// TODO Auto-generated method stub
		createLeftButton();
		createRightButton();
	}

	/*This function is essential for the animation of the right button*/
	private void makeRightTransition() {
		// TODO Auto-generated method stub
		rightTransition = new TranslateTransition(Duration.millis(500), right);
		rightTransition.setToX(-(WIDTH/2 - 0.5*right.getPrefWidth()));
		rightTransition.play();
	}
	
	/*This function creates the animation for the left button*/
	private void makeLeftTransition() {
		// TODO Auto-generated method stub
		leftTransition = new TranslateTransition(Duration.millis(500), left);
		leftTransition.setToX(WIDTH/2 - 0.5*left.getPrefWidth());
		leftTransition.play();
	}
	
	/*This function actually created the right button and sets the width and height*/
	private void createRightButton() {
		// TODO Auto-generated method stub
		right = new AnswerButton(N1);
		right.setLayoutX(WIDTH);
		right.setLayoutY(HEIGHT/2.0);
		pane.getChildren().add(right);
	}
	/*This function creates the left button, including the height and width.*/
	private void createLeftButton() {
		// TODO Auto-generated method stub
		left = new AnswerButton(N2);
		left.setLayoutX(0 - left.getPrefWidth());
		left.setLayoutY(HEIGHT/2.0);
		pane.getChildren().add(left);
	}
	
	/*this function initializes the button listener. If the answer is correct, it increases the score by 
	 * 5 and shows the subscene for correct. */
	private void initializeButtonListener(){
		if(right.getNum() == ANSWER) {
			right.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
					//System.out.println("Correct");
					SCORE += 5;
					showSubscene("Correct");
					
				}
			});
			//if incorrect answer is selected, display game score and GAME OVER message
			left.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
					//System.out.println("Incorrect");
					showSubscene("GAME OVER\nScore: " + SCORE);
					gameOver = true;
				}
			});
		}
		//if the correct answer is on the left, do the opposite from above
		else {
			left.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
					//System.out.println("Correct");
					SCORE += 5;
					showSubscene("Correct");
				}
			});
			right.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
					//System.out.println("Incorrect");
					showSubscene("GAME OVER\nScore: " + SCORE);		
					gameOver = true;
				}

			});
		}
	}

	/*If the correct answer is chosen, a message will show. After "Okay" is clicked, it hides the subScene 
	 * transition*/
	protected void addOkayInitializer() {
		mss.okay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
				hideSubSceneTransition();				
			}
		});
	}
	
	/*When returning to menu, changes the stages and call the write scores function*/
	private void returnToMenu() {
		// TODO Auto-generated method stub
		writeScores();
		menu = new MainMenu();
		menu.prevStage = stage;
		menu.prevStage.close();
		menu.stage.show();
	}
	
	/*This function is responsible for writing the scores to be displayed on the scoreboard.*/
	private void writeScores() {
		// TODO Auto-generated method stub
		BufferedWriter output;
		if(!(new File("src/application/scores.txt").exists()))
			try {
				boolean newfile = new File("src/application/scores.txt").createNewFile();
				System.out.println(newfile);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		try {
			 output = new BufferedWriter(new FileWriter("src/application/scores.txt", true));
			 output.write(playerName + ":" + SCORE + "\n");
			 output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}

	/*This function is responsible for creating and displaying the subscene with the height width and 
	 * calling the transition function*/
	protected void showSubscene(String message) {
		// TODO Auto-generated method stub
		mss = new MathSubScene(message);
		mss.setLayoutX((WIDTH - mss.getWidth())/2.0);
		mss.setLayoutY((HEIGHT - mss.getHeight())/2.0);
		showSubSceneTransition();
		pane.getChildren().add(mss);
		addOkayInitializer();
	}
	
	/*This function is created to make a transition to hide the subscene that is meant to either display the 
	 * score of display the "correct" or "game over" messages.*/
	protected void hideSubSceneTransition() {
		// TODO Auto-generated method stub
		hideTransition = new ScaleTransition(Duration.millis(500), mss);
		hideTransition.setFromX(1);
		hideTransition.setToX(0);
		hideTransition.setFromY(1);
		hideTransition.setToY(0.0000001);
		hideTransition.play();
		hideTransition.setOnFinished(event -> {
			this.prevStage.close();
			if(gameOver) {
				returnToMenu();
			}
			else {
				next = new Gameplay(playerName, SCORE, stage);				
			}
		});
	}

	/*This is the function that is responsible for creating a transition for when trying to show a subscene*/
	private void showSubSceneTransition() {
		// TODO Auto-generated method stub
		showTransition = new ScaleTransition(Duration.millis(500), mss);
		showTransition.setFromX(0.01);
		showTransition.setToX(1);
		showTransition.setFromY(0.01);
		showTransition.setToY(1);
		showTransition.play();
	}
	
	/*This private function creates the logo of the app and sets it to a specific width and height.*/
	private void createLogo() {
		// TODO Auto-generated method stub
		try {
			question = new ImageView(QUESTION_PATH);			
		} catch (Exception e) {
			question = new ImageView(ERROR_PATH);
		}
		question.setFitWidth(600);
		question.setFitHeight(107);
		question.setLayoutX(WIDTH/2.0 - question.getFitWidth()/2.0);
		question.setLayoutY(HEIGHT/8.0);
		question.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				question.setEffect(new DropShadow());
			}
			
		});
		question.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				question.setEffect(null);
			}
			
		});
		pane.getChildren().add(question);
	}
}
