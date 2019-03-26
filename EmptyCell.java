public class EmptyCell implements Cell {

   // empty cell has value of 0.0
   public static final double VALUE = 0.0;
   public static final String CELL_TEXT = "          ";
     
   public String abbreviatedCellText() {
      return CELL_TEXT;
   }
   
   public String fullCellText() {
      return "";
   }
}