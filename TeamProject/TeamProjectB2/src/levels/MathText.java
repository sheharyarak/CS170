/*This class is important because it displays the math text on each of the math buttons. This is important 
 * because it is responsible of the font, height, and width that is displayed on left and right button. 
 * It will pass different parameters for each of these conditions and use them to create the right buttons 
 * and math texts.*/
package levels;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class MathText extends Label{
private final String FONT_PATH = "src/media/font/PressStart2P-Regular.ttf";
protected double fontSize = 18;
	//constructor that passes score as the parameter. Also has default for height and width
	public MathText(int score) {
		setPrefWidth(190);
		setPrefHeight(50);
		setPadding(new Insets(12,12,12,12));
		setText("Score: " + score);
		setWrapText(true);
		setLabelFont();
	}
	
	//constructor that passes width, height, and fontSize conditions as parameters
	public MathText(String text, double width, double height, double fontSize) {
		this.fontSize = fontSize;
		setPrefWidth(width);
		setPrefHeight(height);
		setPadding(new Insets(12,12,12,12));
		setTextAlignment(TextAlignment.CENTER);
		setText(text);
		setWrapText(true);
		setLabelFont();
	}
	
	//function sets the label of each font from the fileinputstream.
	//
	public void setLabelFont() {
		try {
			setFont(Font.loadFont(new FileInputStream(FONT_PATH), fontSize));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//if doesn't work, catch and set font to arial size 18
			setFont(Font.font("Arial", 18));
		}
	}
}
