package chess;

public abstract class Piece {

    int color;
    Square location;

    public Piece(int color, Square location) {
        this.color = color;
        this.location = location;
    }

    public int getColor(){
        return this.color;
    }

    public abstract boolean canMove(String to);

    public void move(String to)
    {
        Square targetLocation = location.getBoard().getSquareAt(to);
        //clear previous location
        location.clear();
        //update current location
        targetLocation.setPiece(this);
        location = targetLocation;
        location.getBoard().nextPlayer();
    }
}
