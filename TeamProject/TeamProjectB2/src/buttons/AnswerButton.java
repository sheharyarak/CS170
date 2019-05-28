/*This java file is responsible for some of the buttons that will be used in this program. Some of the buttons
  that will be used in this program are the start, score, and continue buttons as well as the buttons that the 
  user must select for the game. This class is also responsible for many of the essential display conditions 
  and program display. It will set the fonts, set the format (font size, width, etc.). With this, we can create 
  a good looking app with buttons that correctly work.*/

package buttons;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

public class AnswerButton extends Button{
	//private Strings that hold information necessary for implementing in the button functions. 
	private final String ERROR_PATH = "-fx-background-color: transparent; -fx-background-image: url('/media/background/not-found-512.png');";
	
	private final String FONT_PATH = "src/media/font/PressStart2P-Regular.ttf";
	//200 x 120
	private final String BUTTON_PRESSED = "-fx-background-color: transparent; -fx-background-image: url('/media/button/yellow_pressed.png');";
	//200 x 136
	private final String BUTTON_RELEASED = "-fx-background-color: transparent; -fx-background-image: url('/media/button/yellow_released.png');";
	
	private int num;
	
	//System.out.println("In AnswerButton");
	//set the width and height and font of the answer button
	public AnswerButton(int num){
		this.setNum(num);
		setText("" + num);
		setButtonFont();
		setPrefWidth(200);
		setPrefHeight(136);
		try {
		setStyle(BUTTON_RELEASED);
		}catch (Exception e) {
			setStyle(ERROR_PATH);
		}
		InitializeButtonListeners();
	}
	
	//responsible for checking if the font will work. If it does not work, will throw an exception that will 
	//make the font Arial.
	private void setButtonFont() {
		//System.out.println("In setButtonFont");
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), 20));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			setFont(Font.font("Arial", 23));
		}
	}
	
	//set the button style for when the button is clicked because it is separate from the one that is not
	private void setButtonPressedStyle() {
		//System.out.println("In setButtonPressedStyle");
		setStyle(BUTTON_PRESSED);
		setPrefHeight(120);
		setLayoutY(getLayoutY() + 16);
	}
	
	//set button style for when the button is released because it is different from when it is clicked
	private void setButtonReleasedStyle() {
		//System.out.println("In setButtonReleasedStyle");
		setStyle(BUTTON_RELEASED);
		setPrefHeight(136);
		setLayoutY(getLayoutY() - 16);
	}
	
	/*This is the function that actually implements what happens when the botton is pressed. It will call
	 * the fucntions mentioned aboved as the user performs different actions, such as clicking a button. */
	private void InitializeButtonListeners() {
		//System.out.println("In InitializeButtonListeners()");
		//when the mouse is pressed
		setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//System.out.println("In press handler");
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					//call function that will call the pressed button style
					setButtonPressedStyle();
				}
			}
			
		});
		/*This java file is responsible for some of the buttons that will be used in this program. Some of the buttons
		  that will be used in this program are the start, score, and continue buttons as well as the buttons that the 
		  user must select for the game. This class is also responsible for many of the essential display conditions 
		  and program display. It will set the fonts, set the format (font size, width, etc.). With this, we can create 
		  a good looking app with buttons that correctly work.*/
		setOnMouseReleased(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//System.out.println("In release handler");
				// TODO Auto-generated method stub
				if(event.getButton().equals(MouseButton.PRIMARY)) {
					//call function for when the button is released
					setButtonReleasedStyle();
				}
			}
			
		});
		//set a glow effect for mouse interactions
		setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				//System.out.println("In enter handler");
				// TODO Auto-generated method stub
				setEffect(new Glow());
			}
			
		});
		//will remove effect when the mouse is moved. 
		setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//System.out.println("In exit handler");
				// TODO Auto-generated method stub
				setEffect(null);
			}
			
		});
	}

	//will return a num
	public int getNum() {
		return num;
	}

	//will set the attribute num
	public void setNum(int num) {
		this.num = num;
	}
}
