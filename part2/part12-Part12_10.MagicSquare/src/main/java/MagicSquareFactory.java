
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int number = 0;
        int maxNumber = size * size;
        int row = 0;
        int column = size / 2;
        while (number < maxNumber) {
            number++;
            square.placeValue(row, column, number);
            int newRow = row == 0 ? square.getHeight() - 1 : row - 1;
            int newColumn = column == square.getWidth() - 1 ? 0 : column + 1;
            if (square.readValue(newRow, newColumn) == 0) {
                row = newRow;
                column = newColumn;
            } else {
                row = row == square.getHeight() - 1 ? 0 : row + 1;
            }
        }


        return square;
    }


}
