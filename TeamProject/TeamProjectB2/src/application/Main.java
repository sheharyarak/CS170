package application;

import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import levels.MainMenu;

/*
This file is responsible for creating the media for the project. It creates the menu that will be used 
by the user and it will also launch the actual game. It will be interactive so the student can input 
their player name. The createMediaPlayer function will create a new media object. The start function will 
actually start the game. The main function's only purpose is the launch the game. This class is auto generated
for when you create a new javaFX project. 
*/

public class Main extends Application {
	//initialize media player objects
	Media media;
	MediaPlayer player;
	//InputStream in;
	
	/*
	 * This function just creates a media player and loads the " Menu.mp3" file from the directory 
	 * the final string argument passed to Paths.get(String, ...more) is src/media/music/ Menu.mp3. (There is a space at the start of the mp3 file name)
	 */
	public void createMediaPlayer() {
		try {
			 media = new Media(Paths.get("src","media", "music", " Menu.mp3").toUri().toString());
			 player = new MediaPlayer(media);
		}
		catch(Exception e) {
			System.out.println("Could not find file at path: \n" + Paths.get("src","media", "music", " Menu.mp3").toUri().toString());		
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * 
	 * this overrides the start function in the JavaFx application class. We create a media player
	 * and start playing the audio that we have taken from the internet. 
	 */
	
	@Override
	public void start(Stage primaryStage) {
		createMediaPlayer();
		try {
		    //create menu object and then play the audio
			player.play();
			MainMenu menu = new MainMenu();
			primaryStage = menu.getStage();
			primaryStage.setScene(menu.getScene());
			primaryStage.show();
		} catch(Exception e) {
			//e.printStackTrace();
			System.out.println(e);
		}
	}
	
	//main purpose of main is to launch the app with the launch function
	public static void main(String[] args) {
		launch(args);
	}
}
