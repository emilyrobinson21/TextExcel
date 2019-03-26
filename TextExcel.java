import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code

public class TextExcel {

   public static void main(String[] args) {
      Spreadsheet spreadsheet = new Spreadsheet();
      System.out.println(spreadsheet.getGridText());
      Scanner scan = new Scanner(System.in);
      String command = scan.next();
      while (!spreadsheet.processCommand(command).equals("quit")) {
         command = scan.next();
      }
   }
}
