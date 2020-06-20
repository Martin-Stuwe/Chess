package game;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.scene.control.ListView;
import schach.GuiMain;

/**
 * Class for the Gui calculations
 * @author Martin Stuwe 676421
 * @author Zeyi Sun
 * @author Richard Tank
 * @author Fin Niklas Tiedemann
 * group 23
 * it2
 */
public class GuiCalcs {

    /**
     * method to change the board visual to a real figure picture
     * @param visual the board visual of the figure
     * @return white the white symbol of the figure
     */
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
    
    /**
     * method to change the board visual to a real figure picture
     * @param visual the board visual of the figure
     * @return black the black symbol of the figure
     */
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
    
    /**
     * method to add beaten figures to a list
     * @param brett board on which the game is on
     * @param screenHeight height of screen
     * @return beaten the list of the beaten figures
     */
    public ListView<String> addBeaten(Board brett, double screenHeight) {
  	  ListView <String>beaten = new ListView<String>();
        beaten.minHeight(screenHeight/4);
        for(int i=0; i<brett.beaten.size();i++) {
      		  beaten.getItems().add(checkWhiteSymbols(brett.beaten.get(i))+checkBlackSymbols(brett.beaten.get(i)));
      	  

        }
        return beaten;

    }
    
    /**
     * method to convert the array number into the real board number
     * for example top left array spot 0,0 would be the 8 of a8
     * @param a number that has to be converted
     * @return b the converted number
     */
    public int numberToNumber(int a) {
    	int b = 0;
    	if(a == 0) {
    		b = 8;
    	}
    	else if (a == 1) {
    		b = 7;
    	}
    	else if (a == 2) {
    		b = 6;
    	}
    	else if (a == 3) {
    		b = 5;
    	}
    	else if (a == 4) {
    		b = 4;
    	}
    	else if (a == 5) {
    		b = 3;
    	}
    	else if (a == 6) {
    		b = 2;
    	}
    	else if (a == 7) {
    		b = 1;
    	}
    	return b;
    }
    
    /**
     * method to convert the array number into the real board letter
     * for example top left array spot 0,0 would be the a of a8
     * @param a number that has to be converted
     * @return b the converted letter
     */
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
    
    public int backToNumber(char i) {
    	int b = 0;
    	if(i == 'a' || i == '8') {
    		b = 0;
    	}
    	else if(i == 'b' || i == '7') {
    		b = 1;
    	}
    	else if(i == 'c' || i == '6') {
    		b = 2;
    	}
    	else if(i == 'd' || i == '5') {
    		b = 3;
    	}
    	else if(i == 'e' || i == '4') {
    		b = 4;
    	}
    	else if(i == 'f' || i == '3') {
    		b = 5;
    	}
    	else if(i == 'g' || i == '2') {
    		b = 6;
    	}
    	else if(i == 'h' || i == '1') {
    		b = 7;
    	}
    	
    	return b;
    }
      
    
    
    
    public void makeSaveGui(ListView<String> historie){
    	File file = new File("save.txt");
    	
    	
    	try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	ArrayList<String> test = new ArrayList<String>();
    	test.add(java.time.LocalDate.now().toString());
    	test.add("---");
    	for(int i = 0; i < historie.getItems().size(); i++) {
    		test.add(historie.getItems().get(i).toString());
    	}
    	
    	
    	try {
			Files.write(Paths.get("save.txt"), test, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	
    }
    
    public void loadGuiSave(Board board) {
    	File test = new File("save.txt");
    	if(test.exists()) {
    		List<String> allLines = new ArrayList<String>();
    		List<String> justMoves = new ArrayList<String>();
    	
    		try {
    			allLines = Files.readAllLines(Paths.get("save.txt"), StandardCharsets.UTF_8);
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	
    		for(int i = 0; i < allLines.size() ; i++) {
    			justMoves.add(allLines.get(i));
    			if(allLines.get(i).equals("---")) {
    				justMoves.clear();
    			}
    		}
    		System.out.println(justMoves);
    		
    		for(int i = 0; i < justMoves.size(); i++) {
    			int from1 = backToNumber(justMoves.get(i).charAt(0));
    			int from2 = backToNumber(justMoves.get(i).charAt(1));
    			int to1 = backToNumber(justMoves.get(i).charAt(3));
    			int to2 = backToNumber(justMoves.get(i).charAt(4));
    			String to = "" + to1 + to2;
    			board.getField(from1, from2).move(board, from1, from2, to);
    			GuiMain.getHistorie().getItems().add(justMoves.get(i));
    			
       		}
    		
    	}
    }
}
