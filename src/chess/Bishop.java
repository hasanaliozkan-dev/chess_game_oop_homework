package chess;

public class Bishop extends Piece {
    public Bishop(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);

        if (!location.isDiagonal(targetLocation)) {
            validMove = false;
        } else {
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
        return color == ChessBoard.WHITE ? "B" : "b";
    }
}
