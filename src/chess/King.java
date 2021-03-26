package chess;

public class King extends Piece{
    public King(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);

        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);

        if (this.location.isAtSameColumn(targetLocation)){
            if (color == ChessBoard.WHITE && rowDistance == 1){
                validMove = targetLocation.isEmpty() || targetLocation.getPiece().getColor() != this.color;
            }
            if (color == ChessBoard.BLACK && rowDistance == -1){
                validMove = targetLocation.isEmpty() || targetLocation.getPiece().getColor() != this.color;
            }
        }

        if (this.location.isAtSameRow(targetLocation)){
            if (colDistance == 1 ||colDistance == -1) {
                validMove = targetLocation.isEmpty() || targetLocation.getPiece().getColor() != this.color;
            }
        }

        if (this.location.isDiagonal(targetLocation)){
            if ((Math.abs(targetLocation.getRow() - location.getRow()) == 1) && (Math.abs(targetLocation.getColumn() - location.getColumn()) == 1)){
                validMove = (targetLocation.isEmpty() || (targetLocation.getPiece().getColor() != this.color));
            }

        }


        return validMove;
    }

    @Override
    public String toString() {
        return color == ChessBoard.WHITE ? "K" : "k";
    }
}
