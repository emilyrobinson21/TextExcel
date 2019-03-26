import java.util.*;

public class Spreadsheet implements Grid {
   public static final int ROWS = 20;
   public static final int COLS = 12;
   private Cell[][] cells;
   
   // constructor
   public Spreadsheet() {
      cells = new Cell[ROWS][COLS];
      clearSpreadsheet();
   }
   
   // processes command and directs to another method to execute proper command
   @Override
   public String processCommand(String command) {
      // "quit" quits the program
      if (command.toUpperCase().equals("QUIT")) {
         return command;
      }
      
      // for blank string
      if (command.toUpperCase().equals("")) {
         return "";
      }
       
      // "clear" clears whole spreadsheet
      else if (command.toUpperCase().equals("CLEAR")) {
         clearSpreadsheet();
         return this.getGridText();
      }
      
      // TODO don't split spaces past the second one, use scanner?
      String[] commandArray = command.split(" ");
      
      // if lenght is 1, then its a cell inspection, return full cell text
      if (commandArray.length == 1) {
         SpreadsheetLocation loc = new SpreadsheetLocation(commandArray[0].toUpperCase());
         return this.inspectCell(loc).fullCellText();
      }
      
      // if lenght is 2, then its a clear cell, return blank string and clear the cell
      else if (commandArray.length == 2) {
         SpreadsheetLocation loc = new SpreadsheetLocation(commandArray[1].toUpperCase());
         cells[loc.getRow()][loc.getCol()] = new EmptyCell();
         return this.getGridText();        
      }
      
      // if "=" follows the cell name, then it is a cell assignment, 
      else if (commandArray[1].equals("=")) {
         int equalsIndex = command.indexOf("=");
         int quoteIndex = command.indexOf("\"", equalsIndex);
         SpreadsheetLocation loc = new SpreadsheetLocation(commandArray[0].toUpperCase());
         cells[loc.getRow()][loc.getCol()] = new TextCell(command.substring(quoteIndex));
         return this.getGridText();
      }
      return command;
   }
   
   // returns a blank spreadsheet
   public void clearSpreadsheet() {
      for (int i = 0; i < ROWS; i++) {
         for (int j = 0; j < COLS; j++) {
            cells[i][j] = new EmptyCell();
         }
      }
   }
   
   // returns the cell using a location
   public Cell inspectCell(SpreadsheetLocation location) {
      return cells[location.getRow()][location.getCol()];
   }

   // returns number of rows
   @Override
   public int getRows() {      
      return ROWS;
   }

   // returns number of cols
   @Override
   public int getCols() {
      return COLS;
   }

   @Override
   public Cell getCell(Location loc) {
      // TODO Auto-generated method stub
      return cells[loc.getRow()][loc.getCol()];
   }

   // creates the text for the grid
   @Override
   public String getGridText() {
      String gridText = "";
      gridText += "   |";
      
      for (char i = 'A'; i < 'A' + COLS; i++) {
         gridText += i + "         |";
      }
      
      gridText += "\n";
      
      for (int i = 1; i <= ROWS; i++) {
         gridText += i;
         for (int j = 1; j <= 3 - ("" + i).length(); j++) {
            gridText += " ";
         }
         gridText += "|";
         for (int j = 'A'; j < 'A' + COLS; j++) {
            gridText += (cells[i - 1][j - 'A'].abbreviatedCellText()) + "|";
         }
         gridText += "\n";
      }
      
      return gridText;
   }
}