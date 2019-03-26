public class TextCell implements Cell {
   private String text;
   
   public TextCell(String text) {
      this.text = text;
   }
   
   public String abbreviatedCellText() {
      // removing quotes here
      String tempText = text.substring(1, text.length() - 1);
      while (tempText.length() < Cell.CELLWIDTH) {
         tempText += " ";
      }
      return tempText.substring(0, Cell.CELLWIDTH);
   }
   
	public String fullCellText() {
      return text;
   }
}