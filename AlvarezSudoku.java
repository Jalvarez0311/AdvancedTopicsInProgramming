import java.util.Scanner;
/** 
 * This class is a prototype for a simplified version of Sudoku
 * @author J. Alvarez
 * 2588
 * AlvarezSudoku.java
 * 1/28/2025
 */

 public class AlvarezSudoku {
    public static void main(String[] args){
        String userResponse = "Y";
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[][]{
            {5, 3, 4, 0, 7, 8, 9, 1, 2},
            {6, 7, 0, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 0, 7},
            {8, 0, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 0, 3, 7, 9, 0},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 0, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 0, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9},
        };      
        while(userResponse.charAt(0) != 'N'){// while loop that returns to displaying the board if an error occurs or correct value is inputted
            display(board);
            System.out.println("Continue Playing (Y/N)?");
            userResponse = sc.next();
            if(userResponse.charAt(0) == 'N' || userResponse.charAt(0) == 'n'){
                break;
            }if (userResponse.charAt(0) == 'Y' || userResponse.charAt(0) == 'y') {
                System.out.println("Enter row: ");
                int row = sc.nextInt();
                if(row > 9 || row < 1){
                    System.out.println("Invalid row/column\n");
                    continue;
                }
                System.out.println("Enter column: ");
                int column = sc.nextInt();
                if(!isRowColumnValid(row, column, board)){
                    continue;
                }
                System.out.println(("Enter value: "));
                int value = sc.nextInt();
                if(!isValueValid(value)){
                    continue;
                }
                if(isEntryCorrect(row, column, board, value)){
                    board[row-1][column-1] = value;
                }else{
                    continue;
                }
                if(isSolved(board)){
                    System.out.println("You beat the puzzle!");
                    break;
                }
                continue;
            } else {
                System.out.println("Invalid Input\n");
            }
        }
        System.out.println("Thanks for Playing!");
        sc.close();
    }

    /**
     * Function displays Sudoku puzzle to be solved by the player
     * @param board -sudoku board to be presented to user
     * @return -prints an organized version of the 2d array sudoku board
     */
    public static void display(int[][] board){
        for(int i = 0; i < 9; i++){
            
            if(i % 3 == 0 && i!= 0){
                System.out.println(" ------+-------+------");
            }
            for(int j = 0; j < 9; j++){
                if(j % 3 == 0 && j != 0){
                    System.out.print(" |");
                }
                System.out.print(" " + board[i][j]);
            }
        System.out.print("\n");
        }
    }
    
    /**
     * boolean function checks whether the user's current board is completed
     * @param board -sudoku board currently worked on by the user
     * @return -returns true or false whether the user's board is completed or not
     */
    public static boolean isSolved(int[][] board){
        int[][] correctBoard = new int[][]{
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9},
        };
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != correctBoard[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * function checks whether the value is a valid input
     * @param value -user inputted value to be put into the sudoku table
     * @return -returns whether the value is between 0 and 10
     */
    public static boolean isValueValid(int value){
        if(value < 1 || value > 9){
            System.out.println("Invalid value");
            return false;
        }
        return true;
    }

    /**
     * function checks whether a provided row and column pair is valid within the puzzle's parameters and if the chosen spot has a zero
     * @param row -user inputted number for the row to be accessed
     * @param column -user inputted number for the column to be accessed
     * @param board -sudoku board currently worked on by the user
     * @return -returns false if the column/row is not between 10 and 0 or if the row/column does not point to zero. It returns true otherwise
     */
    public static boolean isRowColumnValid(int row, int column, int[][] board){
        if(column > 9 || column < 1){
            System.out.println("Invalid row/column");
            return false;
        }
        if(board[row - 1][column - 1] != 0){
            System.out.println("Wrong entry");
            return false;
        }
        return true;
    }

    /**
     * this function checks if the given value fits in the specified row and column of the sudoku puzzle
     * @param row -user inputted number for the row to be accessed
     * @param column -user inputted number for the column to be accessed
     * @param board -sudoku board currently worked on by the user
     * @param value -user inputted value to be put into the sudoku table
     * @return -returns false if the value matches another value on the same row or column. It returns true otherwise
     */
    public static boolean isEntryCorrect(int row, int column, int[][] board, int value){
        for(int i = 0; i < 9; i++){
            if(board[row-1][i] == value){
                System.out.println("Not quite, try again!");
                return false;
            }
        }
        for(int j = 0; j < 9; j++){
            if(board[j][column-1] == value){
                System.out.println("Not quite, try again!");
                return false;
            }
        }
        System.out.println("That's right!\nThe updated board is shown below");
        return true;
    }
 }