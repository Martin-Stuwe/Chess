package game;

/**
 * no changes made yet
 */

import javafx.scene.control.ListView;

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
