package ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Participant;
import model.VoleibolEvent;

public class VoleibolEventController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loadData;

    @FXML
    private Button exploreButton;

    @FXML
    private Button loadButtom;

    @FXML
    private Button buttomSpectator;

    @FXML
    private Button buttomParticipant;

    @FXML
    private TextField spectatorTextField;

    @FXML
    private TextField ParticipantTextField;

    @FXML
    private ImageView photo;

    @FXML
    private Label informationShow;

    @FXML
    private Button graficParticipants;

    @FXML
    private Button graficSpectators;

    
    VoleibolEvent voleibalEvent = new VoleibolEvent();
    
    @FXML
    void exploreOption(ActionEvent event) {

    	FileChooser choosing = new FileChooser();
         FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a (.csv)", "*.csv");
         choosing.getExtensionFilters().add(filter);
         File file = choosing.showOpenDialog(new Stage());
         if (file !=null){
        	 loadData.setText(file.getPath().toString());
         }
    }

    @FXML
    void graficParticipantsOP(ActionEvent event) {
    	
    }

    @FXML
    void graficSpectatorsOp(ActionEvent event) {

    }

    @FXML
    void loadOption(ActionEvent event) {
    	try {
			voleibalEvent.loadParticipants(loadData.getText(), ",");
			Alert k = new Alert(AlertType.INFORMATION);
			k.setTitle("Information");
			k.setHeaderText(null);
			k.initStyle(StageStyle.UTILITY);
			k.setContentText("All the spectator were load");
			k.show();
		} catch (IOException e) {
			e.printStackTrace();
			Alert k = new Alert(AlertType.ERROR);
			k.setTitle("Error");
			k.setHeaderText(null);
			k.initStyle(StageStyle.UTILITY);
			k.setContentText("The path is not correct");
			k.show();
		} 
    }

    @FXML
    void searchParticipantOP(ActionEvent event) {
    	try {
    		Participant newOne = voleibalEvent.searchingParticipants(Integer.parseInt(ParticipantTextField.getText()));
        	System.out.println(newOne.getCountry());
        	informationShow.setText(" id:"+newOne.getId()+"\n firstName: "+newOne.getFirstName()+"\n lastName: "+newOne.getLastName()+"\n email: "+newOne.getEmail()+"\n conuntry: "+newOne.getCountry());
        	Image view; 
        	if(newOne.getGender().equals("Male")) {
        		view =new Image(new File("data\\men.jpg").toURI().toString());
        		photo.setImage(view);
        	} else {
        		view=new Image(new File("data\\woman.jpg").toURI().toString());
        		photo.setImage(view);
        	}
    	}catch (NullPointerException e) {
			// TODO: handle exception
		}
    	
    }

    @FXML
    void searchSpectadorOP(ActionEvent event) {
    	Participant newOne = voleibalEvent.searchInBTS(Integer.parseInt(spectatorTextField.getText()));
    	System.out.println(newOne.getCountry());
    	informationShow.setText(" id:"+newOne.getId()+"\n firstName: "+newOne.getFirstName()+"\n lastName: "+newOne.getLastName()+"\n email: "+newOne.getEmail()+"\n conuntry: "+newOne.getCountry());
    	Image view; 
    	if(newOne.getGender().equals("Male")) {
    		view =new Image(new File("data\\men.jpg").toURI().toString());
    		photo.setImage(view);
    	} else {
    		view=new Image(new File("data\\woman.jpg").toURI().toString());
    		photo.setImage(view);
    	}
    }
    
    
    @FXML
    void initialize() {
        assert loadData != null : "fx:id=\"loadData\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert exploreButton != null : "fx:id=\"exploreButton\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert loadButtom != null : "fx:id=\"loadButtom\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert buttomSpectator != null : "fx:id=\"buttomSpectator\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert buttomParticipant != null : "fx:id=\"buttomParticipant\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert spectatorTextField != null : "fx:id=\"spectatorTextField\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert ParticipantTextField != null : "fx:id=\"ParticipantTextField\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert photo != null : "fx:id=\"photo\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert informationShow != null : "fx:id=\"informationShow\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert graficParticipants != null : "fx:id=\"graficParticipants\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";
        assert graficSpectators != null : "fx:id=\"graficSpectators\" was not injected: check your FXML file 'VoleyBallEvente2019.fxml'.";

    }
}

