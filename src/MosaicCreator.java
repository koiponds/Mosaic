
import java.awt.Color;

public class MosaicCreator {

    public static void main(String[] args) {
        System.out.println("Welcome to the Mosaic Creator!");

        System.out.print("How many rows do you want? ");
        int rows = TextIO.getlnInt();
        System.out.print("How many columns do you want? ");
        int columns = TextIO.getlnInt();

        // Color Table
        System.out.println("R: Red     C: Cyan     	Y: Yellow");
        System.out.println("W: White   G: Green     B: Blue");
        System.out.println("M: Magenta");
        System.out.println();

        //Opens the mosaic
        Mosaic.open(rows, columns, 40, 40);

        //Asks for colors and draws in for each row
        for (int currentRow = 0; currentRow < rows; currentRow++) {
            System.out.print("Row #" + (currentRow + 1) + " ");
            String colors = TextIO.getlnString();
            drawColumn(colors, columns, currentRow);
        }
        Mosaic.delay(1000);

        //Rotate colors while mosaic is open
        while (Mosaic.isOpen()) {
            colorRotator(rows, columns);
            Mosaic.delay(1000);
        }
    }

    public static void drawColumn(String colors, int columns, int currentRow) {
        for (int currentColumn = 0; currentColumn < columns; currentColumn++) {

            //Adds Spaces to the end if the string isn't long enough for the column
            for (int i = 0; i != columns; i++) {
                colors += " ";
            }
            char currentColor = colors.charAt(currentColumn);

            //Draws color based on current char corresponding to column
            switch (currentColor) {
                case 'r':
                    Mosaic.setColor(currentRow, currentColumn, Color.RED);
                    break;
                case 'c':
                    Mosaic.setColor(currentRow, currentColumn, Color.CYAN);
                    break;
                case 'y':
                    Mosaic.setColor(currentRow, currentColumn, Color.YELLOW);
                    break;
                case 'w':
                    Mosaic.setColor(currentRow, currentColumn, Color.WHITE);
                    break;
                case 'g':
                    Mosaic.setColor(currentRow, currentColumn, Color.GREEN);
                    break;
                case 'b':
                    Mosaic.setColor(currentRow, currentColumn, Color.BLUE);
                    break;
                case 'm':
                    Mosaic.setColor(currentRow, currentColumn, Color.MAGENTA);
                    break;
                default:
                    Mosaic.setColor(currentRow, currentColumn, Color.BLACK);
                    break;
            }
        }
    }

    public static void colorRotator(int rows, int columns) {
        for (int c = 0; c < columns; c++) {
            for (int r = 0; r < rows; r++) {
                if (Mosaic.getColor(r, c) == Color.RED) {
                    Mosaic.setColor(r, c, Color.CYAN);
                }
                else if (Mosaic.getColor(r, c) == Color.CYAN) {
                    Mosaic.setColor(r, c, Color.YELLOW);
                }
                else if (Mosaic.getColor(r, c) == Color.YELLOW) {
                    Mosaic.setColor(r, c, Color.WHITE);
                }
                else if (Mosaic.getColor(r, c) == Color.WHITE) {
                    Mosaic.setColor(r, c, Color.GREEN);
                }
                else if (Mosaic.getColor(r, c) == Color.GREEN) {
                    Mosaic.setColor(r, c, Color.BLUE);
                }
                else if (Mosaic.getColor(r, c) == Color.BLUE) {
                    Mosaic.setColor(r, c, Color.MAGENTA);
                }
                else {
                    Mosaic.setColor(r, c, Color.RED);
                }
            }
        }
    }
}