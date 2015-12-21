/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gomoku;

import java.awt.Color;
import java.util.Random;


/**
 *
 * @author jjpikoov
 */
public class Data {
    private int edge;
    private Square[][] squares;
    private Sequence colsBlack[];
    private Sequence rowsBlack[];
    private Sequence colsBlue[];
    private Sequence rowsBlue[];
    private int blue;
    private int black;
    
    public Data(){
        blue = black = 0;
        
        colsBlack = new Sequence[19];
        rowsBlack = new Sequence[19];
        colsBlue = new Sequence[19];
        rowsBlue = new Sequence[19];
        for (int i = 0; i < 19; i++){
            colsBlack[i] = new Sequence();
            rowsBlack[i] = new Sequence();
            colsBlue[i] = new Sequence();
            rowsBlue[i] = new Sequence();
        }
        
        squares = new Square[19][19];        
        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                squares[i][j] = new Square();
                squares[i][j].color = Color.WHITE;
            }
        }
    }
    
    public void init(int edge){
        int pointX = 0;
        int pointY = 0;
        
        this.whoWin();
        this.computerMove();        
        
        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                squares[i][j].begX = pointX;
                squares[i][j].endX = pointX + edge;
                squares[i][j].begY = pointY;
                squares[i][j].endY = pointY + edge;
                squares[i][j].edge = edge;
                
                
                pointX += edge;
            }
            pointX = 0;
            pointY += edge;
        }

    }
    
    public void changeColor(int x, int y, Color color){
        int maxX = squares[0][18].endX;
        int maxY = squares[18][0].endY;
        
        if (x <= maxX && y <= maxY){
            
            double xd = x / (maxX / 19);
            xd = Math.ceil(xd);
            int col = (Double.valueOf(xd).intValue());
            
            double yd = y / (maxY / 19);
            yd = Math.ceil(yd);
            int row = (Double.valueOf(yd).intValue());
            
            if (squares[row][col].color == Color.WHITE)
                squares[row][col].color = color;
        }
    }
    
    
    public Square[][] getSquares(){
        return this.squares;
    }
    
    public int maxVerticalyInRow(Square squares[][], int col, Color color){
        int inRow = 0;
        Color previous = color;
        int maxInRow = 0;
        
        for (int i = 0; i < 19; i++){
            if (squares[i][col].color == previous){
                inRow++;
                
                int maxInRowCopy = maxInRow;
                maxInRow = Math.max(inRow, maxInRow);
                if (maxInRow != maxInRowCopy && color == Color.BLACK){
                    if (!this.isBlocked(i - maxInRow + 1, i, true, col)){
                        this.colsBlack[col].end = i;
                        this.colsBlack[col].beg = i - maxInRow + 1;
                        this.colsBlack[col].len = maxInRow;
                    }
                    else
                        this.colsBlack[col].len = 0;
                }
                else if (maxInRow != maxInRowCopy && color == Color.BLUE){
                    if (!this.isBlocked(i - maxInRow + 1, i, true, col)){
                        this.colsBlue[col].end = i;
                        this.colsBlue[col].beg = i - maxInRow + 1;
                        this.colsBlue[col].len = maxInRow;
                    }
                    else
                        this.colsBlue[col].len = 0;
                }

            }
            else{
                inRow = 0;
            }
        }
        if (color == Color.BLACK)
            return colsBlack[col].len;
        return colsBlue[col].len;
    }
    
    public int maxHorizontallyInRow(Square squares[][], int row, Color color){
        int inRow = 0;
        Color previous = color;
        int maxInRow = 0;
        
        for (int i = 0; i < 19; i++){
            if (squares[row][i].color == previous){
                inRow++;
                
                int maxInRowCopy = maxInRow;
                maxInRow = Math.max(inRow, maxInRow);
                if (maxInRow != maxInRowCopy && color == Color.BLACK){
                    if (!this.isBlocked(i - maxInRow + 1, i, false, row)){
                        this.rowsBlack[row].end = i;
                        this.rowsBlack[row].beg = i - maxInRow + 1;
                        this.rowsBlack[row].len = maxInRow;
                    }
                    else
                        this.rowsBlack[row].len = 0;
                }
                else if (maxInRow != maxInRowCopy && color == Color.BLUE){
                    if (!this.isBlocked(i = maxInRow + 1, i, false, row)){
                        this.rowsBlue[row].end = i;
                        this.rowsBlue[row].beg = i - maxInRow + 1;
                        this.rowsBlue[row].len = maxInRow;
                    }
                    else
                        this.rowsBlue[row].len = 0;
                }
            }
            else
                inRow = 0;
        }
        if (color == Color.BLACK)
            return rowsBlack[row].len;
        return rowsBlue[row].len;
                    
    }
    
    public void computerMove(){
        this.countColors();

        if (this.beginning()){
            squares[9][9].color = Color.BLACK;
        }
        else if (blue == black){
            
            int maxVer = Integer.MIN_VALUE;
            int v = 0;
            int maxHor = Integer.MIN_VALUE;
            int h = 0;
            int maxVerOpp = Integer.MIN_VALUE;
            int vOpp = 0;
            int maxHorOpp = Integer.MIN_VALUE;
            int hOpp = 0;

            for (int i = 0; i < 19; i++){
                int maxVerInRow = maxVerticalyInRow(squares, i, Color.BLACK);
                if (maxVerInRow > maxVer){
                    maxVer = maxVerInRow;
                    v = i;
                }
                
                int maxHorInRow = maxHorizontallyInRow(squares, i, Color.BLACK);
                if (maxHorInRow > maxHor){
                    maxHor = maxHorInRow;
                    h = i;
                }
                
                int maxVerInRowOpp = maxVerticalyInRow(squares, i, Color.BLUE);
                if (maxVerInRowOpp > maxVerOpp){
                    maxVerOpp = maxVerInRowOpp;
                    vOpp = i;
                }
                
                int maxHorInRowOpp = maxHorizontallyInRow(squares, i, Color.BLUE);
                if (maxHorInRowOpp > maxHorOpp){
                    maxHorOpp = maxHorInRowOpp;
                    hOpp = i;
                }
            }
            
            
            if (maxVer == 4){
                this.computerClick(true, v, Color.BLACK);
            }
            else if (maxHor == 4){
                this.computerClick(false, h, Color.BLACK);
            }
            else if (maxVerOpp == 4){
                this.computerClick(true, vOpp, Color.BLUE);
            }
            else if (maxHorOpp == 4){
                this.computerClick(false, hOpp, Color.BLUE);
            }
            else if (maxVerOpp == 3){
                this.computerClick(true, vOpp, Color.BLUE);
            }
            else if (maxHorOpp == 3){
                this.computerClick(false, hOpp, Color.BLUE);
            }
            else if (maxVer >= maxHor){
                this.computerClick(true, v, Color.BLACK);
            }
            else{
                this.computerClick(false, h, Color.BLACK);
            }
        }
    }
    
    public void whoWin(){
        for (int i = 0; i < 19; i++){
            if (maxVerticalyInRow(squares, i, Color.BLUE) == 5){
                System.err.println("YOU WON!");
                System.exit(0);
            }
            else if (maxVerticalyInRow(squares, i, Color.BLACK) == 4){
                System.err.println("COMPUTER WON!!!");
                System.exit(0);

            }
            else if (maxHorizontallyInRow(squares, i, Color.BLUE) == 5){
                System.err.println("YOU WON!");
                System.exit(0);
            }
            else if (maxHorizontallyInRow(squares, i, Color.BLACK) == 4){
                System.err.println("COMPUTER WON!!!");
                System.exit(0);
            }
        }
    }
    
    public boolean beginning(){
        boolean beg = true;
        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                if (squares[i][j].color != Color.WHITE){
                    beg = false;
                }
            }
        }
        return beg;
    }
    
    public void computerClick(boolean vertically, int colOrRow, Color color){
        if (color == Color.BLACK){
            if (vertically){
                if (colsBlack[colOrRow].beg - 1 >= 0 && 
                        squares[colsBlack[colOrRow].beg - 1][colOrRow].color == Color.WHITE){
                    squares[colsBlack[colOrRow].beg - 1][colOrRow].color = Color.BLACK;
                }
                else if (colsBlack[colOrRow].end + 1 <= 19 && 
                        squares[colsBlack[colOrRow].end + 1][colOrRow].color == Color.WHITE){
                    squares[colsBlack[colOrRow].end + 1][colOrRow].color = Color.BLACK;
                }
                else if (colsBlack[colOrRow].len == 0){
                    while(true){
                        Random random = new Random();
                        int row = random.nextInt(18);
                        int col = random.nextInt(18);
                        if (squares[row][col].color == Color.WHITE){
                            squares[row][col].color = Color.BLACK;
                            break;
                        }
                    }
                }
            }
            else{
                if (rowsBlack[colOrRow].beg - 1 >= 0 &&
                        squares[colOrRow][rowsBlack[colOrRow].beg - 1].color == Color.WHITE){
                    squares[colOrRow][rowsBlack[colOrRow].beg - 1].color = Color.BLACK;
                }
                else if (rowsBlack[colOrRow].end + 1 <= 19 &&
                        squares[colOrRow][rowsBlack[colOrRow].end + 1].color == Color.WHITE){
                    squares[colOrRow][rowsBlack[colOrRow].end + 1].color = Color.BLACK;
                }
                else if (rowsBlack[colOrRow].len == 0){
                    while(true){
                        Random random = new Random();
                        int row = random.nextInt(18);
                        int col = random.nextInt(18);
                        if (squares[row][col].color == Color.WHITE){
                            squares[row][col].color = Color.BLACK;
                            break;
                        }
                    }
                }
            }
        }
        else if (color == Color.BLUE){
            if (vertically){
                if (colsBlue[colOrRow].beg - 1 >= 0 && 
                        squares[colsBlue[colOrRow].beg - 1][colOrRow].color == Color.WHITE){
                    squares[colsBlue[colOrRow].beg - 1][colOrRow].color = Color.BLACK;
                }
                else if (colsBlue[colOrRow].end + 1 <= 19 && 
                        squares[colsBlue[colOrRow].end + 1][colOrRow].color == Color.WHITE){
                    squares[colsBlue[colOrRow].end + 1][colOrRow].color = Color.BLACK;
                }
            }
            else{
                if (rowsBlue[colOrRow].beg - 1 >= 0 &&
                        squares[colOrRow][rowsBlue[colOrRow].beg - 1].color == Color.WHITE){
                    squares[colOrRow][rowsBlue[colOrRow].beg - 1].color = Color.BLACK;
                }
                else if (rowsBlue[colOrRow].end + 1 <= 19 &&
                        squares[colOrRow][rowsBlue[colOrRow].end + 1].color == Color.WHITE){
                    squares[colOrRow][rowsBlue[colOrRow].end + 1].color = Color.BLACK;
                }
            }
        }
    }
    
    public void countColors(){
        blue = black = 0;
        for (int i = 0; i < 19; i++){
            for (int j = 0; j < 19; j++){
                if (squares[i][j].color == Color.BLACK){
                    black++;
                }
                else if (squares[i][j].color == Color.BLUE){
                    blue++;
                }
            }
        }
    }
    
    public boolean isBlocked(int beg, int end, boolean vertically, int colOrRow){
        if (vertically == true){
            if (beg - 1 >= 0 && squares[beg - 1][colOrRow].color == Color.WHITE){
                return false;
            }
            else if (end + 1 <= 19 && squares[end + 1][colOrRow].color == Color.WHITE){
                return false;
            }
        }
        else if (vertically == false){
            if (beg - 1 >= 0 && squares[colOrRow][beg - 1].color == Color.WHITE){
                return false;
            }
            else if (end + 1 <= 19 && squares[colOrRow][end + 1].color == Color.WHITE){
                return false;
            }
        }
        return true;
    }

}
