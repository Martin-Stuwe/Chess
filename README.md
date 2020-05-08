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
    
    
    
    
    Knight.java
    
    public Knight(int pos1, int pos2, String color)
    
    public String getBoardVisual()
    
    public void setPos(int Pos1, int Pos2)
    
    public String getColor()
    
    public boolean validMove(Board board,int x , int y)
    
    
    
    Pawn.java:
    
    public Pawn(int pos1, int pos2, String color)
    
    public String getBoardVisual()
    
    public void setPos(int Pos1, int Pos2)
    
    public String getColor()
    
    public boolean validMove(Board board,int x, int y)
    
    
    
    Queen.java:
    
    public Queen(int pos1, int pos2, String color)
    
    public String getBoardVisual()
    
    public void setPos(int Pos1, int Pos2)
    
    public String getColor()
    
    public boolean validMove(Board board,int x, int y)
    
    
    Rook.java:
    
    public Rook(int pos1, int pos2, String color)
    
    public void setPos(int Pos1, int Pos2)
    
    public String getBoardVisual()
    
    public boolean getHasMoved()
    
    public void setHasMoved(boolean hasMoved)
    
    public String getColor()
    
    public boolean validMove(Board board,int x, int y)
    
    
    
**game**
    
    Board.java
        
        public boolean getGameLive()
        
        public LinkedList<String> getBeaten()
        
        public void setGameLive(boolean gameLive)
        
        public void initializeBoard()
        
        public void setStart()
        
        public Figures getField(int pos1, int pos2)
        
        public void setField(int pos1, int pos2, Figures setTo)
        
        public String ConvertMoveInput(Board board, char pos1from, int pos2from)
        
        public void setCurrentTurn(int x)
    
        public int getCurrentTurn()
        
        public void checkGameEnded()
        
        public void checkCheck()
        
        
    Figures.java
    
        public void setPos(int Pos1, int Pos2)
        
        public int getPos1()
    
        public int getPos2()
        
        public String getBoardVisual()
        
        public int getType()
        
        public String getColor()
        
        public boolean getHasMoved()
        
        public void setHasMoved(boolean hasMoved)
        
        public boolean validMove(Board board,int x, int y)
        
        public Boolean move(Board board, int pos1from, int pos2from, int pos1to, int pos2to)
        
        
        
        
    
    Player.java
        
        public Player(String name, String color)
        
        public String getColor()
        
        public String getName()
        
        
        
        
        
    
    StartGame.java
        
        public static void getAndMakeMove(Board board)
            
        public static void convertAndMove(Board board, Console console)
            
        public static void PlayerVsPlayer()
            
        public static void chooseMode()
            
        public static void StartGameCommand()
            
        
        
    
    Zug.java
        
        
        
    
    
    
**schach**
    
    Console.java
        
        Mithilfe von Console.open() können Konsoleneingaben gelesen werden und als Console Objekt verwendet werden.
            
            Console Input1 = new Console.open();
            System.out.println(Input1.input);
        
        
    Example.java
        
    GuiMain.java
        
    Main.java
        
        Mithilfe von StartGame.StartGameCommand(); wird hier das Spiel gestartet.
        
        