# Schach

This Projected is a Project hosted by Universität zu Lübeck (CS2301) and written by

* Martin Stuwe

* Zeyi Sun

* Richard Tank

* Fin Niklas Tiedemann

You can start the game in two ways, either in the console or as a program.


the game will normally start as a program:

To start the game press on start game.

In the options screen you can decide if you want to play either white or black (this has no impact if you play player vs player).

Then you can decide if you want to play against an AI or not, if you chose to play vs an AI you can decide the depth of the calculations of the AI by entering a number in the text field next to the RadioButton (we recommened 3 to have decent calculation times). 
If you play vs an AI and dont choose a depth, it will automatically have the depth of 1.

Next you can decide if you want to play with time and enter the amount of time in seconds for white and black if so. If you decide to play with time and don‘t enter a time, both white and black will get 10min each.

Press start game to start a new game or press load game to load a previously saved save file. 
If no save file can be found, a new game will start.

To make a move press on a figure of your color and press then on the field you want it to move to.

If you enable rotate board, the player whose turn it is will be at the bottom.

If you enable showMoves, if you press on a figure, it will show all possible Moves of this figure.

If you enable show being in check, it will show if a player is in check.

If you enable touch-move rule, you will only be able to do a move with the first figure you click on, you won’t be able to change the figure you want to move for this turn.

Press save to make a save file oft he current state that you can then load later in the options.

Press back to menu to go back to start screen.

You can press on your moves in the historie on the right site of the programm to go back to this turn and play from then, if you press undo you will go back one turn, press redo to go back to the state before undo or press on the grayed moves to go back to before you pressed undo or before you clicked on the historie.

If a pawn reaches the last row, you can choose in a popup which figure to promote this pawn to.

If the game ends due to no time left, you can still continue the game if you want. 




to play the game in the console, add –no-gui to the program arguments

to start the game you have to execute the main.java and interact with the stdout

choose between white and black

choose between a new game or loading a save file

choose if you want to play with time, if so enter numbers in seconds for each color , if you don’t enter a number the default time will be 10min

choose if you want to play vs an AI or not and decide the depth of the calculation (standard 3 if wrong input)

to move a chess figure: a2-a3

only small letters from a to h for the letter region are valid.
and numbers from 1 to 8 for the numbers region.

to promote a pawn add the wanted figure name to end of your input: for example a7- a8N or a2-b1Q

to show all beaten figures: beaten

to go back to the start: exit

to save the game: save

to undo a move: undo

to redo the turn you undid: redo




