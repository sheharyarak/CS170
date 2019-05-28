/*This java class is responsible for the Buttons for the actually game. The previous button class, AnswerButton
  was responsible for the all the buttons except for the buttons that are responsible for the actual gameplay. 
  This game will ask the user to select the larger of two numbers, allowing for an infinite number of questions. 
  Because of this, we need to buttons that will display two different numbers and the user must select the bigger 
  of the two. In order for this to work, the number buttons that are actually relevant to the math that 1st graders 
  do in their curriculum and thus extremely important component of this lab. */
package buttons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class MathButton extends Button{
	//private final String ERROR_PATH = "-fx-background-color: transparent; -fx-background-image: url('/media/background/not-found-512.png');";
	
	//private varibles defined and initialized for info about the 
	private final String ERROR_PATH = "-fx-background-color: transparent; -fx-background-size: 100% 100%; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-image: url('/media/background/not-found-512.png');";
	private final String PREFIX = "-fx-background-color: transparent; -fx-background-size: 100% 100%; -fx-background-repeat: no-repeat; -fx-background-position: center; -fx-background-image: url('/media/button/";
	private final String SUFFIX = ".png');";
	
	private final String FONT_PATH = "src/media/font/PressStart2P-Regular.ttf";
	//200 x 120
	protected final String[] PRESSED = {"pressed", "yellow_pressed"};
	//200 x 136
	protected final String[] RELEASED = {"released", "yellow_released"};
	
	protected int buttonIndex = 0;
	
	/*Math button is responsible for setting the text/font/width and height of the first button.*/
	public MathButton(String text){
		//System.out.println("In MathButton");
		setText(text);
		setButtonFont();
		setPrefWidth(200);
		setPrefHeight(136);
		try {
			setStyle(PREFIX + RELEASED[buttonIndex] + SUFFIX);
		}catch (Exception e) {
			setStyle(ERROR_PATH);
		}
		InitializeButtonListeners();
	}
	
	/*Math button is responsible for setting the text/font/width and height of the second button.*/
	public MathButton(String text, double width, double height, int color){
		//System.out.println("In MathButton");
		buttonIndex = color;
		setText(text);
		setButtonFont();
		setPrefWidth(width);
		setPrefHeight(height);
		try {
			setStyle(PREFIX + RELEASED[buttonIndex] + SUFFIX);
		}catch (Exception e) {
			System.out.println(e);
			setStyle(ERROR_PATH);
		}
		InitializeButtonListeners();
	}
	
	//responsible for setting the button font. If font not found, try Arial.
	private void setButtonFont() {
		//System.out.println("In setButtonFont");
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 20));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			setFont(Font.font("Arial", 23));
		}
	}
	
	//sets the pressed style for button for when the user presses the button. 
	private void setButtonPressedStyle() {
		//System.out.println("In setButtonPressedStyle");
		setStyle(PREFIX + PRESSED[buttonIndex] + SUFFIX);
		setPrefHeight(0.88235*getPrefHeight());
		setLayoutY(getLayoutY() + 0.117647*getPrefHeight());
	}
	
	//sets the style for the button for when the user releases the button
	private void setButtonReleasedStyle() {
		//System.out.println("In setButtonReleasedStyle");
		setStyle(PREFIX + RELEASED[buttonIndex] + SUFFIX);
		setPrefHeight(1.13333*getPrefHeight());
		setLayoutY(getLayoutY() - 0.117647*getPrefHeight());
	}
	
	//this handles the event of each mouse action
	private void InitializeButtonListeners() {
		//System.out.println("In InitializeButtonListeners()");
		//if mouse is pressed
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//System.out.println("In press handler");
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					//call function for the style of the pressed button
					setButtonPressedStyle();
				}
			}
			
		});
		//when mouse is released
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//System.out.println("In release handler");
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					//call release button function
					setButtonReleasedStyle();
				}
			}
			
		});
		//sets glow effect for when the mouse enters a button
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//System.out.println("In enter handler");
				// TODO Auto-generated method stub
				setEffect(new Glow());
			}
			
		});
		//sets effect for when the mouse exits a button
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//System.out.println("In exit handler");
				// TODO Auto-generated method stub
				setEffect(null);
			}
			
		});
	}
}
