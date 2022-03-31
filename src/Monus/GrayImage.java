package Monus;

public class GrayImage
{ 
  public static final int BLACK = 0; 
  public static final int WHITE = 255; 
  
  /** The 2-dimensional representation of this image. Guaranteed not to be null. 
    * * All values in the array are within the range [BLACK, WHITE], inclusive. 
    */ 
  private int[][] pixelValues; 
  
  public GrayImage(int[][] values)
  {
    pixelValues = values;
  }
  
  /** @return the total number of white pixels in this image. 
    * * Postcondition: this image has not been changed. 
    */ 
  public int countWhitePixels() 
  {
    int whitePixelCount = 0;
    for (int row = 0; row < pixelValues.length; row++) {
      for (int col = 0; col < pixelValues[0].length; col++) {
        if (pixelValues[row][col] == WHITE) {
          whitePixelCount++;
        }
      }
    }
    return whitePixelCount;
  } 
  
  /** Processes this image in row-major order and decreases the value of each pixel at 
    * position (row, col) by the value of the pixel at position (row + 2, col + 2) if it exists. 
    * Resulting values that would be less than BLACK are replaced by BLACK. 
    * Pixels for which there is no pixel at position (row + 2, col + 2) are unchanged. 
    */ 
  public void processImage() 
  {
    for (int row = 0; row < pixelValues.length; row++) {
      for (int col = 0; col < pixelValues[0].length; col++) {
        int valueToSubtract = 0;
        if (row + 2 < pixelValues.length && col + 2 < pixelValues[0].length) {
          valueToSubtract = pixelValues[row + 2][col + 2];
        }
        if (pixelValues[row][col] - valueToSubtract < BLACK) {
          pixelValues[row][col] = BLACK;
        }
        else {
          pixelValues[row][col] -= valueToSubtract;
        }
      }
    }
  }
  
  public void printValues()
  {
    for (int r = 0; r < pixelValues.length; r++)
    {
      for (int c = 0; c < pixelValues[0].length; c++)
      {
        System.out.print(pixelValues[r][c] + ", ");
      }
      System.out.println();
    }
  }
  
  public static void main (String[] args)
  {
    int[][] values = {{255, 184, 178, 84, 129}, {84, 255, 255, 130, 94}, {78, 255, 0, 0, 78}, {84, 130, 255, 130, 84}};
    GrayImage image = new GrayImage(values);
    System.out.println("count white should be 5 and is " + image.countWhitePixels());
    int[][] values2 = {{221, 184, 178, 84, 135}, {84, 255, 255, 130, 84}, {78, 255, 0, 0, 78}, {84, 130, 255, 130, 84}};
    image = new GrayImage(values2);
    image.printValues();
    image.processImage();
    System.out.println("after process image");
    image.printValues(); 
  }
  
  
   
} 
