package chess;

public class Queen extends Piece {
    public Queen(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);

        if (this.location.isAtSameColumn(targetLocation)){

            Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
            boolean allEmpty = true;
            if (between != null){
                for (Square sq : between){
                    if (!sq.isEmpty()){
                        allEmpty = false;
                    }
                }
            }
            validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != this.color) && allEmpty;

        }
        if (this.location.isAtSameRow(targetLocation)){
            Square[] between = location.getBoard().getSquaresBetween(location,targetLocation);
            boolean allEmpty = true;
            if (between != null){
                for (Square sq : between){
                    if (!sq.isEmpty()){
                        allEmpty = false;
                    }
                }
            }
            validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != this.color) && allEmpty;
        }

        if (location.isDiagonal(targetLocation)) {

            Square[] between = location.getBoard().getSquaresBetween(location, targetLocation);
            boolean allEmpty = true;
            if (between != null) {
                for (Square sq : between) {
                    if (!sq.isEmpty()) {
                        allEmpty = false;
                    }
                }
            }
            validMove = (targetLocation.isEmpty() || targetLocation.getPiece().getColor() != this.color) && allEmpty;
        }

        return validMove;
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "Q" : "q";
    }
}
