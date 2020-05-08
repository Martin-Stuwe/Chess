# Schach

**figures:**


    Bishop.java
    
    
    
    public Bishop(int pos1, int pos2, String color) erstellt ein Bishop Objekt.
    
    Bsp.: Bishop bishop1 = new Bishop (1,1,w);
    
    
    
    public getBoardVisual() gibt das boardVisual zurück.
    
    Bsp.: board.Positionen[x][y].getBoardVisual();
    
    
    
    public void setPos(int Pos1, int Pos2)
    
    
    public String getColor()
    
    
    
    public boolean validMove(Board board, int x, int y)
    
    
    
    
    King.java
    
    public King(int pos1, int pos2, String color)
    
    
    public String getBoardVisual()
    
    
    public boolean getHasMoved()
    
    public void setHasMoved(boolean hasMoved)
    
    public void setPos(int Pos1, int Pos2)
    
    public String getColor()
    
    public boolean validMove(Board board, int x, int y)
    
    
    
    Pawn.java:
    
    
    
    
    
    
    Queen.java:
    
    
    Rook.java:
    
    
    
**game**
    
        Board.java
    
    
        Figures.java
    
        Player.java
    
        StartGame.java
    
        Zug.java
    
    
    
**schach**
    
        Console.java
        
            Mithilfe von Console.open() können Konsoleneingaben gelesen werden und als Console Objekt verwendet werden.
            
            Console Input1 = new Console.open();
            System.out.println(Input1.input);
        
        
        Example.java
        
        GuiMain.java
        
        Main.java
        
        