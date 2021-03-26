package chess;

public class Knight extends Piece
{
    public Knight(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        //Get the row difference between the current location and target location.
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);

        if((Math.abs(colDistance) == 1 && Math.abs(rowDistance) ==2)
           || (Math.abs(colDistance) == 2 && Math.abs(rowDistance) ==1)){
            if(targetLocation.isEmpty() || targetLocation.getPiece().getColor() != this.color ){
                validMove = true;
            }
        }
        return validMove;
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "N" : "n";
    }
}
