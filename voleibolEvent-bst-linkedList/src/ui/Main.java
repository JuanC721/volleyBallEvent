package ui;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Participant;
import model.VoleibolEvent;

public class Main extends Application{

	
	
	public static void main(String[]args) throws IOException {
//	
		launch(args);
//		VoleibolEvent po = new VoleibolEvent();
////		po.loadParticipants("data//MOCK_DATA (2).csv",",");
////		System.out.println(po.preOrder());
//		try {
//			po.loadParticipants("data//MOCK_DATA (2).csv",",");
//			Participant newOne = po.searchInBTS(7);
//			System.out.println(newOne.getLastName());
//		}catch(IOException oe){
//			oe.printStackTrace();
//		}

	}


	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("voleibal2019.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		
	}
}
