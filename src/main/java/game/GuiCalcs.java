package game;
import game.Board;
import game.StartGame;
import game.Zug;
import figures.*;
/**
 * no changes made yet
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import game.AI;
public class GuiCalcs {

    
    public String checkWhiteSymbols(String visual) {
    	String white = "";
    	if(visual=="P") {
    		white="♙" ;
    	}
    	if(visual=="N") {
    		white="♘" ;
    	}
    	if(visual=="B") {
    		white="♗" ;
    	}
    	if(visual=="R") {
    		white="♖" ;
    	}
    	if(visual=="Q") {
    		white="♕" ;
    	}
    	if(visual=="K") {
    		white="♔" ;
    	}
    	return white;
    }
    public String checkBlackSymbols(String visual) {
    	String black = "";
     	if(visual=="p") {
    		black="♟" ;
    	}
    	if(visual=="n") {
    		black="♞" ;
    	}
    	if(visual=="b") {
    		black="♝" ;
    	}
    	if(visual=="r") {
    		black="♜" ;
    	}
    	if(visual=="q") {
    		black="♛" ;
    	}
    	if(visual=="k") {
    		black="♚" ;
    	}
    	return black;
    }
    public ListView<String> addBeaten(Board brett, double screenHeight) {
  	  ListView <String>beaten = new ListView<String>();
        beaten.minHeight(screenHeight/4);
        for(int i=0; i<brett.beaten.size();i++) {
      		  beaten.getItems().add(checkWhiteSymbols(brett.beaten.get(i))+checkBlackSymbols(brett.beaten.get(i)));
      	  

        }
        return beaten;

  }
    public int numberToNumber(int a) {
    	if(a == 0) {
    		a = 8;
    	}
    	else if (a == 1) {
    		a = 7;
    	}
    	else if (a == 2) {
    		a = 6;
    	}
    	else if (a == 3) {
    		a = 5;
    	}
    	else if (a == 4) {
    		a = 4;
    	}
    	else if (a == 5) {
    		a = 3;
    	}
    	else if (a == 6) {
    		a = 2;
    	}
    	else if (a == 7) {
    		a = 1;
    	}
    	return a;
    }
    
    public String numberToString(int a) {
    	String b ="";
    	if(a == 0) {
    		b = "a";
    	}
    	else if (a == 1) {
    		b = "b";
    	}
    	else if (a == 2) {
    		b = "c";
    	}
    	else if (a == 3) {
    		b = "d";
    	}
    	else if (a == 4) {
    		b = "e";
    	}
    	else if (a == 5) {
    		b = "f";
    	}
    	else if (a == 6) {
    		b = "g";
    	}
    	else if (a == 7) {
    		b = "h";
    	}
    	return b;
    }
    
}
