import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.text.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * Copyright Georgia Institute of Technology 2004
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors /////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to 
     * super() child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a width and height for a new
   * picture and sets the color for the new picture
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   * @param theColor the color for the background
   */
  public Picture(int width, int height, Color theColor)
  {
    // let the parent class handle these parameters
    super(width,height,theColor);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods /////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as 
   * fileName, height, and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + this.getFileName() + 
      " height " + this.getHeight() 
      + " width " + this.getWidth();
    return output;
    
  }
  
  /**
   * Method to decrease the red by half in the current picture
   */
  public void decreaseRed()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int index = 0;

    // loop through all the pixels
    while(index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // get the value
      value = pixel.getRed();

      // decrease the red value by 50% (1/2)
      value = (int) (value * 0.5);

      // set the red value of the current pixel to the new value
      pixel.setRed(value);

      // increment the index
      index = index + 1;
    }
  }
  
  /**
   * Method to decrease red by the passed
   * percent
   * @param percent the percent to reduce by
   */
  public void decreaseRed(int percent)
  {
    Pixel[] pixelArray = this.getPixels();
    int red = 0;
    double factor = 1.0 - (percent / 10);
    
    // loop through all the pixels
    for (Pixel currPixel : pixelArray)
    {
      red = currPixel.getRed();
      currPixel.setRed((int) (red * factor));
    }   
  }
  
  /**
   * Method to clear the blue from the picture (set
   * the blue to 0 for all pixels)
   */
  public void clearBlue()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int index = 0;

    // loop through all the pixels
    while (index < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[index];

      // set the blue on the pixel to 0
      pixel.setBlue(0);

      // increment index
      index++;
    }
  }
  
  /**
   * Method to clear the red from a picture
   */
  public void clearRed()
  {
    Pixel[] pixelArray = this.getPixels();
    for (Pixel currPixel : pixelArray)
    {
      currPixel.setRed(0);
    }
  }
  
  /**
   * Method to clear the green from a picture
   */
  public void clearGreen()
  {
    Pixel[] pixelArray = this.getPixels();
    for (Pixel currPixel : pixelArray)
    {
      currPixel.setGreen(0);
    }
  }
  
  /**
   * Method to simulate a sunset by decreasing the green
   * and blue
   */
  public void makeSunset()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;

    // loop through all the pixels
    while (i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (value * 0.7));

      // change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (value * 0.7));

      // increment the index
      i++;
    }
  }
  
  /**
   * Method to simulate a sunset by decreasing the green
   * and blue
   * @param factor the amount to multiply the original values by
   */
  public void makeSunset(double factor)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;

    // loop through all the pixels
    while (i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (value * factor));

      // change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (value * factor));

      // increment the index
      i++;
    }
  }
  
  /**
   * Method to change the red by an amount
   * @param amount the amount to change the red by
   */
  public void changeRed(double amount)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int value = 0;
    int i = 0;

    // loop through all the pixels
    while( i < pixelArray.length)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the value
      value = pixel.getRed();

      /* set the red value to the original value
      * times the passed amount
      */
      pixel.setRed((int) (value * amount));

      // increment i
      i++;
    }
  }
  
  /**
   * Method to change the color of each pixel in the picture
   * object by passed in amounts.
   * @param redAmount the amount to change the red value
   * @param greenAmount the amount to change the green value
   * @param blueAmount the amount to change the blue value
   */
  public void changeColors(double redAmount,
                           double greenAmount,
                           double blueAmount)
  {
    Pixel[] pixelArray = this.getPixels();
    int value = 0;

    // loop through all the pixels
    for (Pixel pixel : pixelArray)
    {

      // change the red value
      value = pixel.getRed();
      pixel.setRed((int) (redAmount * value));

      // change the green value
      value = pixel.getGreen();
      pixel.setGreen((int) (greenAmount * value));

      // change the blue value
      value = pixel.getBlue();
      pixel.setBlue((int) (blueAmount * value));
    }
  }
  
  /**
   * Method to negate the pixels in the 
   * current picture
   */
  public void negate()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int redValue, blueValue, greenValue = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the current red, green, and blue values
      redValue = pixel.getRed();
      greenValue = pixel.getGreen();
      blueValue = pixel.getBlue();

      // set the pixel's color to the new color
      pixel.setColor(new Color(255 - redValue,
                               255 - greenValue,
                               255 - blueValue));
    }
  }
  
  
  /**
   * Method to change the picture to gray scale
   */
  public void grayscale()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int intensity = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // compute the intensity of the pixel (average value)
      intensity = (int) ((pixel.getRed() + pixel.getGreen() +
                     pixel.getBlue()) / 3);

      // set the pixel color to the new color
      pixel.setColor(new Color(intensity,intensity,intensity));

    }
  }
  
  /**
   * Method to change the picture to gray scale
   */
  public void grayscale(int startX, int startY,
                        int endX, int endY)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int intensity = 0;
    
    // loop through x
    for (int x = startX; x < endX; x++)
    {
      for (int y = startY; y < endY; y++)
      {
        
        // get the current pixel
        pixel = this.getPixel(x,y);
        
        // compute the intensity of the pixel (average value)
        intensity = (int) ((pixel.getRed() + pixel.getGreen() +
                            pixel.getBlue()) / 3);
        
        // set the pixel color to the new color
        pixel.setColor(new Color(intensity,intensity,intensity));
        
      }
    }
  }
  
  
  /**
   * Method to change the picture to gray scale with luminance
   */
  public void grayscaleWithLuminance()
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel pixel = null;
    int luminance = 0;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;

    // loop through all the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      pixel = pixelArray[i];

      // get the corrected red, green, and blue values
      redValue = pixel.getRed() * 0.299;
      greenValue = pixel.getGreen() * 0.587;
      blueValue = pixel.getBlue() * 0.114;

      // compute the intensity of the pixel (average value)
      luminance = (int) (redValue + greenValue + blueValue);

      // set the pixel color to the new color
      pixel.setColor(new Color(luminance,luminance,luminance));

    }
  }
  
 /**
  * Method to mirror around a vertical line in the middle
  * of the picture based on the width
  */
 public void mirrorVertical()
 {
   int width = this.getWidth();
   int mirrorPoint = width / 2;
   Pixel leftPixel = null;
   Pixel rightPixel = null;

   // loop through all the rows
   for (int y = 0; y < getHeight(); y++)
   {
     // loop from 0 to the middle (mirror point)
     for (int x = 0; x < mirrorPoint; x++)
     {
       leftPixel = getPixel(x, y);
       rightPixel = getPixel(width - 1 - x, y);
       rightPixel.setColor(leftPixel.getColor());
     }
   }
 }
 
 /**
  * Method to mirror around a horizontal line in the middle
  * based on the height.  It copies the top mirrored to
  * the bottom
  */
 public void mirrorHorizontal()
 {
   int height = this.getHeight();
   int mirrorPoint = height / 2;
   Pixel topPixel = null;
   Pixel bottomPixel = null;

   // loop through the columns
   for (int x=0; x < getWidth(); x++)
   {
     // loop from 0 to just before the mirror point
     for (int y=0; y < mirrorPoint; y++)
     {
       topPixel = getPixel(x,y);
       bottomPixel = getPixel(x,height - 1 - y);
       bottomPixel.setColor(topPixel.getColor());
     }
   }
 }
 
  /**
   * Method to mirror around a horiztonal line in the middle
   * based on the height of the picture.  It copies the bottom
   * to the top.
   */
  public void mirrorHorizontalBottomToTop()
  {
    int height = this.getHeight();
    int mirrorPoint = height / 2;
    Pixel topPixel = null;
    Pixel bottomPixel = null;

    // loop through the columns
    for (int x=0; x < getWidth(); x++)
    {
      // loop from 1 to just before the mirror point
      for (int y=0; y < mirrorPoint; y++)
      {
        topPixel = getPixel(x,y);
        bottomPixel = getPixel(x,height - 1 - y);
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }
  
  /**
   * Mirror diagonal from 0,0 to width-1,height-1
   */
  public void mirrorDiagTopLeftBotRight()
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    for (int y = 1; y < this.getHeight(); y++)
    {
      for (int x = 0; x < y; x++)
      {
        leftPixel = this.getPixel(x,y);
        rightPixel = this.getPixel(y,x);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /**
   * Method to mirror around a diagonal line
   * from width-1,0 to 0,height-1
   */
  public void mirrorDiagTopRightBotLeft()
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int height = this.getHeight();
    for (int y = height - 2; y >= 0; y--)
    {
      for (int x = 0; x < height - 1 -y; x++)
      {
        leftPixel = this.getPixel(x,y);
        rightPixel = this.getPixel(height-1-y,
                                   height - 1- x);
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
 
 /**
  * Method to mirror part of the temple picture around a 
  * vertical line at a mirror point
  */
 public void mirrorTemple()
 {
   int mirrorPoint = 276;
   Pixel leftPixel = null;
   Pixel rightPixel = null;
   int count = 0;

   // loop through the rows
   for (int y = 27; y < 97; y++)
   {
     // loop from 13 to just before the mirror point
     for (int x = 13; x < mirrorPoint; x++)
     {
       System.out.println("Copying color from " +
                         x + " to " +
                         (mirrorPoint + (mirrorPoint - x)));
       leftPixel = getPixel(x, y);       
       rightPixel = getPixel(mirrorPoint + (mirrorPoint - x), y);
       rightPixel.setColor(leftPixel.getColor());
       count = count + 1;
     }
   }
   System.out.println("We copied " + count + " pixels");
 }
 
 /**
  * Method to mirror part of the temple picture around a 
  * vertical line at a mirror point
  */
 public void mirrorHorizontalRange(int startX, 
                                   int endX,
                                   int startY,
                                   int endY,
                                   int mirrorX)
 {
   Pixel leftPixel = null;
   Pixel rightPixel = null;

   // loop through the rows
   for (int y = startY; y < endY; y++)
   {
     // loop from startX to just before the 
     // mirror point: endX
     for (int x = startX; x < endX; x++)
     {
       leftPixel = getPixel(x, y);       
       rightPixel = getPixel(mirrorX + (mirrorX - x), y);
       rightPixel.setColor(leftPixel.getColor());
     }
   }
 }
 
 /**
  * Method to mirror part of the picture around a 
  * horiztonal mirror 
  * @param startX the start x of the range to mirror
  * @param endX the end x of the range to mirror
  * @param mirrorPoint the y value to mirror around
  */
 public void mirrorHorizRange(int startX,int endX,
                              int mirrorPoint)
 {
   Pixel topPixel = null;
   Pixel botPixel = null;
   int count = 0;

   // loop through the rows till the mirror point
   for (int y = 0; y < mirrorPoint; y++)
   {
     // loop from start to end of x range
     for (int x = startX; x < endX; x++)
     {
     
       topPixel = this.getPixel(x, y);       
       botPixel = this.getPixel(x,
                        this.getHeight() - 1 - y);
       botPixel.setColor(topPixel.getColor());
     }
   }
 }
 
 /**
  * Method to mirror part of a picture around
  * a vertical mirror point
  */
 public Picture mirrorVertRange(int mirrorPoint)
 {
   Pixel left = null;
   Pixel right = null;
   int resultWidth = (mirrorPoint + 1) * 2;
   Picture result = 
     new Picture(resultWidth,this.getHeight());
   Color resColor = null;
   
   for (int x =0; x <= mirrorPoint; x++)
   {
     for(int y = 0; y < this.getHeight(); y++)
     {
       left = this.getPixel(x,y);
       right = result.getPixel(resultWidth - 1 - x,y);
       resColor = left.getColor();
       right.setColor(resColor);
       result.getPixel(x,y).setColor(resColor);
     }
   }
   return result;
 }
 
 /**
  * Method to copy the picture of Katie to the 
  * upper left corner of the current picture
  */
 public void copyKatie()
 {
   String sourceFile = 
     FileChooser.getMediaPath("KatieFancy.jpg");
   Picture sourcePicture = new Picture(sourceFile);
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX=0;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++) 
   {
     
     // loop through the rows
     for (int sourceY = 0, targetY =0;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++) 
     {
       // set the target pixel color to the source pixel color
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
 }
 
 /**
  * Method to copy the picture of Katie to (100,100) in the 
  * current picture
  */
 public void copyKatieMidway()
 {
   String sourceFile = 
     FileChooser.getMediaPath("KatieFancy.jpg");
   Picture sourcePicture = new Picture(sourceFile);
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX=100;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++)
   {
     // loop through the rows
     for (int sourceY = 0, targetY =100;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++)
     {
       // set the target pixel color to the source pixel color
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
 }
 
 /**
  * Method to copy just Katie's face to the current picture
  */
 public void copyKatiesFace()
 {
   String sourceFile = 
     FileChooser.getMediaPath("KatieFancy.jpg");
   Picture sourcePicture = new Picture(sourceFile);
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 70, targetX = 100;
        sourceX < 135; sourceX++, targetX++)
   {
     // loop through the rows
     for (int sourceY = 3, targetY = 100;
          sourceY < 80; sourceY++, targetY++)
     {
       // set the target pixel color to the source pixel color
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
 }
 
 /**
  * Method to copy flower pictures to create a collage.
  * All the flower pictures will be lined up near the
  * top of the current picture
  */
 public void copyFlowersTop()
 {
   // create the flower pictures
   Picture flower1Picture =
     new Picture(FileChooser.getMediaPath("flower1.jpg"));
   Picture flower2Picture =
     new Picture(FileChooser.getMediaPath("flower2.jpg"));
   
   // declare the source and target pixel variables
   Pixel sourcePixel = null;
   Pixel targetPixel = null;
   
   // copy the first flower picture to the top left corner
   for (int sourceX = 0, targetX = 0;
        sourceX < flower1Picture.getWidth();
        sourceX++, targetX++)
   {
     for (int sourceY = 0, targetY = 0;
          sourceY < flower1Picture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
       targetPixel  = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
   
   // copy the flower2 picture starting with x = 100
   for (int sourceX = 0, targetX = 100;
        sourceX < flower2Picture.getWidth();
        sourceX++, targetX++)
   {
     for (int sourceY = 0, targetY = 0;
          sourceY < flower2Picture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = flower2Picture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
   
   // copy the flower1 negated to x = 200
   flower1Picture.negate();
   for (int sourceX = 0, targetX = 200;
        sourceX < flower1Picture.getWidth();
        sourceX++, targetX++)
   {
     for (int sourceY = 0, targetY = 0;
          sourceY < flower1Picture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
   
// clear the blue in flower 2 picture and add at x=300
   flower2Picture.clearBlue();
   for (int sourceX = 0, targetX = 300;
        sourceX < flower2Picture.getWidth();
        sourceX++, targetX++)
   {
     for (int sourceY = 0, targetY = 0;
          sourceY < flower2Picture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = flower2Picture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
   
   String fileName = FileChooser.getMediaPath("7inx95in.jpg");// copy the negated flower 1 to x=400
   for (int sourceX = 0, targetX = 400;
        sourceX < flower1Picture.getWidth();
        sourceX++, targetX++)
   {
     for (int sourceY = 0, targetY = 0;
          sourceY < flower1Picture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }
 }
 
 /**
  * Method that will copy all of the passed source picture into
  * the current picture object starting with the  left corner
  * given by xStart. It will put the sourcePicture at 5 pixels
  * from the bottom of this picture
  * @param sourcePicture the picture object to copy
  * @param xStart the x position to start the copy in  the target
  */
public void copyPicture(Picture sourcePicture,
                          int xStart)
{
  Pixel sourcePixel = null;
  Pixel targetPixel = null;

  // loop through the columns
  for (int sourceX = 0, targetX = xStart;
       sourceX < sourcePicture.getWidth();
       sourceX++, targetX++)
  {
    // loop through the rows
    for (int sourceY =0, targetY = 0;
         sourceY < sourcePicture.getHeight();
         sourceY++, targetY++)
    {
      sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
      targetPixel = this.getPixel(targetX,targetY);
      targetPixel.setColor(sourcePixel.getColor());
    }
  }
}


/**
  * Method to copy two flowers in a pattern to the
  * top of the current picture
  */
public void copyFlowersBetter()
{
  // create the flower pictures
  Picture flower1Picture =
    new Picture(FileChooser.getMediaPath("flower1.jpg"));
  Picture flower2Picture =
    new Picture(FileChooser.getMediaPath("flower2.jpg"));

  // copy the first flower picture 
  this.copyPicture (flower1Picture,0);

  // copy the flower2 picture starting with x = 100 
  this.copyPicture (flower2Picture,100);

  // copy the flower1 negated to x = 200 in the canvas
  flower1Picture.negate() ;
  this.copyPicture(flower1Picture,200);

  /* clear the blue in flower 2 picture and
   * add at x=300 in the canvas
   */
  flower2Picture.clearBlue();
  this.copyPicture(flower2Picture,300);

  // copy the negated flower 1 to x=400
  this.copyPicture(flower1Picture,400);
}


 
  /**
   * Method to copy flower pictures to create a collage.  
   * All the flower pictures will be lined up near the 
   * bottom of the current picture (5 pixels from the bottom)
   */
  public void copyFlowers()
  {

    // create the flower pictures
    Picture flower1Picture = 
      new Picture(FileChooser.getMediaPath("flower1.jpg"));
    Picture flower2Picture = 
      new Picture(FileChooser.getMediaPath("flower2.jpg"));
  
    // declare the source and target pixel variables
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // save the heights of the two pictures
    int flower1Height = flower1Picture.getHeight();
    int flower2Height = flower2Picture.getHeight();

    /* copy the first flower picture to 5 pixels from the bottom
     * left corner of the current picture
     */
    for (int sourceX = 0, targetX = 0;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

    // copy the flower2 picture starting with x = 100 
    for (int sourceX = 0, targetX = 100;
         sourceX < flower2Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower2Height - 5;
           sourceY < flower2Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower2Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

    // copy the flower1 negated to x = 200 
    flower1Picture.negate();
    for (int sourceX = 0, targetX = 200;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

    // clear the blue in flower 2 picture and add at x=300 
    flower2Picture.clearBlue();
    for (int sourceX = 0, targetX = 300;
         sourceX < flower2Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower2Height - 5;
           sourceY < flower2Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower2Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

    // copy the negated flower 1 to x=400
    for (int sourceX = 0, targetX = 400;
         sourceX < flower1Picture.getWidth();
         sourceX++, targetX++)
    {
      for (int sourceY = 0,
           targetY = this.getHeight() - flower1Height - 5;
           sourceY < flower1Picture.getHeight();
           sourceY++, targetY++)
      {
        sourcePixel = flower1Picture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  } 
  
 /**
  * Method that will copy all of the passed source picture into
  * the current picture object starting with the left corner
  * given by xStart.  It will put the sourcePicture at 5 pixels
  * from the bottom of this picture
  * @param sourcePicture  the picture object to copy
  * @param xStart the x position to start the copy in the target
  */
 public void copyPictureTo(Picture sourcePicture, 
                           int xStart)
 {
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX = xStart;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++)
   {
     // loop through the rows
     for (int sourceY = 0,
          targetY = this.getHeight() - 
                    sourcePicture.getHeight() - 5;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }

 }
 
 /**
  * Method to create a flower collage 
  */
 public void createCollage()
 {

   // create the flower pictures
   Picture flower1Picture = 
     new Picture(FileChooser.getMediaPath("flower1.jpg"));
   Picture flower2Picture = 
     new Picture(FileChooser.getMediaPath("flower2.jpg"));
   int end1X = flower1Picture.getWidth();
   int end2X = flower2Picture.getWidth();
   int end1Y = flower1Picture.getHeight();
   int end2Y = flower2Picture.getHeight();

   // copy the first flower picture to the
   // top left corner of the canvas
   this.copy(flower1Picture,0,0,end1X,end1Y,
             0,0);

   /* copy the flower2 picture starting with 
    * x = 100 in the canvas
    */
   this.copy(flower2Picture,0,0,end2X,end2Y,
                      100,0);

   // copy the flower1 negated to x = 200 in the canvas
   flower1Picture.negate();
   this.copy(flower1Picture,0,0,end1X,end1Y,
                      200,0);

   /* clear the blue in flower 2 picture and 
    * add at x=300 in the canvas
    */
   flower2Picture.clearBlue();
   this.copy(flower2Picture,0,0,end2X,end2Y,
             300,0);

   // copy the negated flower 1 to x=400
   this.copy(flower1Picture,0,0,end1X,end1Y,
                      400,0);
   
   this.mirrorHorizontal();
 }

 
 
 /**
   * Method to copy from the passed source picture to the current 
   * picture object
   * The copying will start at startX, startY, and end at endX-1 
   * and endY-1
   * The copy will be placed starting at targetStartX, 
   * targetStartY
   * @param sourcePicture the source picture to copy from
   * @param startX the starting x value in the source picture
   * @param startY the starting y value in the source picture
   * @param endX the ending x value in the source picture
   * @param endY the ending y value in the source picture
   * @param targetStartX the starting x value in the 
   * current picture
   * @param targetStartY the starting y value in the 
   * current picture
   */
  public void copy(Picture sourcePicture, 
                   int startX, int startY, 
                   int endX, int endY, 
                   int targetStartX, int targetStartY)
  {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the x values
    for (int x = startX, tx = targetStartX; 
         x < endX && x < sourcePicture.getWidth() && 
                     tx < this.getWidth();
         x++, tx++)
    {
      // loop through the y values
      for (int y = startY, ty = targetStartY; 
           y < endY && y < sourcePicture.getHeight() && 
                       ty < this.getHeight();
           y++, ty++)
      {
        sourcePixel = sourcePicture.getPixel(x,y);
        targetPixel = this.getPixel(tx,ty);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
 
  /**
   * Method to copy from the passed source picture to the current 
   * picture object
   * The copying will start at startX, startY, and end at 
   * endX-1 and endY-1
   * The copy will be placed starting at targetStartX, 
   * targetStartY
   * @param sourcePicture the source picture to copy from
   * @param startX the starting x value in the source picture
   * @param startY the starting y value in the source picture
   * @param endX the ending x value in the source picture
   * @param endY the ending y value in the source picture
   * @param targetStartX the starting x value in the current picture
   * @param targetStartY the starting y value in the current picture
   */
  public void copyNonGreenPixels(Picture sourcePicture, 
                                 int startX, int startY, 
                                 int endX, int endY, 
                                 int targetStartX, 
                                 int targetStartY)
  {
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    double distance = 50.0;
    
    if (this.getImage() == null)
      System.out.println(this.getFileName());
    //this.getWidth();
    
    // loop through the x values
    for (int x = startX, tx = targetStartX; 
         x < endX && x < sourcePicture.getWidth() && 
                     tx < this.getWidth();
         x++, tx++)
    {
      // loop through the y values
      for (int y = startY, ty = targetStartY; 
           y < endY && y < sourcePicture.getHeight() && 
                       ty < this.getHeight();
           y++, ty++)
      {
        sourcePixel = sourcePicture.getPixel(x,y);
        targetPixel = this.getPixel(tx,ty);
        if (sourcePixel.getGreen() < sourcePixel.getRed() +
            sourcePixel.getBlue())
           targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
  
 /**
  * Method that will copy all of the passed source picture into
  * the current picture object starting with the left corner
  * given by xStart, yStart
  * @param sourcePicture  the picture object to copy
  * @param xStart the x position to start the copy into on 
  * the target
  * @param yStart the y position to start the copy into on 
  * the target
  */
 public void copyPictureTo(Picture sourcePicture, 
                           int xStart, int yStart)
 {
   Pixel sourcePixel = null;
   Pixel targetPixel = null;

   // loop through the columns
   for (int sourceX = 0, targetX = xStart;
        sourceX < sourcePicture.getWidth();
        sourceX++, targetX++)
   {
     // loop through the rows
     for (int sourceY = 0,
          targetY = yStart;
          sourceY < sourcePicture.getHeight();
          sourceY++, targetY++)
     {
       sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
       targetPixel = this.getPixel(targetX,targetY);
       targetPixel.setColor(sourcePixel.getColor());
     }
   }

 }
 
 /**
  * Method to copy the picture of Katie but rotate 
  * her left 90 degrees on the current picture
  */
 public void copyKatieLeftRotation()
  {
    String sourceFile = 
      FileChooser.getMediaPath("KatieFancy.jpg");
    Picture sourcePicture = new Picture(sourceFile);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    
    // loop through the columns
    for (int sourceX = 0; 
         sourceX < sourcePicture.getWidth(); 
         sourceX++)
    {
      // loop through the rows
      for (int sourceY = 0; 
           sourceY < sourcePicture.getHeight(); 
           sourceY++)
      {
        // set the target pixel color to the source pixel color
        sourcePixel = sourcePicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(sourceY, 
                    sourcePicture.getWidth() - 1 - sourceX);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
  }
 
 /**
   * Method to copy the flower but smaller (half as big)
   * on to the current picture
   */
  public void copyFlowerSmaller()
  {
    Picture flowerPicture = 
      new Picture(FileChooser.getMediaPath("passionFlower.jpg"));
    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    // loop through the columns
    for (int sourceX = 0, targetX=0;
         sourceX < flowerPicture.getWidth();
         sourceX+=2, targetX++)
    {
      // loop through the rows
      for (int sourceY=0, targetY=0;
           sourceY < flowerPicture.getHeight();
           sourceY+=2, targetY++)
      {
        sourcePixel = flowerPicture.getPixel(sourceX,sourceY);
        targetPixel = this.getPixel(targetX,targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

  }
  
  /**
   * Method to scale any picture up to 2x
   * @return the new picture
   */
  public Picture scaleBy2()
  {
    Picture target = new Picture(this.getWidth() * 2,
                                 this.getHeight() * 2);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    // loop through the columns
    for (double sourceX = 0, targetX=0;
         sourceX < this.getWidth();
         sourceX = sourceX + 0.5, targetX++)
    {
      // loop through the rows
      for (double sourceY=0, targetY=0; 
           sourceY <  this.getHeight();
           sourceY = sourceY + 0.5, targetY++)
      {
        sourcePixel = 
          this.getPixel((int) sourceX,(int) sourceY);
        targetPixel = target.getPixel((int) targetX,(int) targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }
    return target;
  }
  
  /**
   * Method to copy a flower but scaled to 2x normal size
   * onto the current picture
   */
  public void copyFlowerLarger()
  {
    Picture flowerPicture = 
      new Picture(FileChooser.getMediaPath("rose.jpg"));
    Pixel sourcePixel = null;
    Pixel targetPixel = null;

    // loop through the columns
    for (double sourceX = 0, targetX=0;
         sourceX < flowerPicture.getWidth();
         sourceX = sourceX + 0.5, targetX++)
    {
      // loop through the rows
      for (double sourceY=0, targetY=0; 
           sourceY <  flowerPicture.getHeight();
           sourceY = sourceY + 0.5, targetY++)
      {
        sourcePixel = 
          flowerPicture.getPixel((int) sourceX,(int) sourceY);
        targetPixel = this.getPixel((int) targetX,(int) targetY);
        targetPixel.setColor(sourcePixel.getColor());
      }
    }

  }
  
  /**
   * Method to turn the brown in a picture
   * into red
   */
  public void turnBrownIntoRed()
  {
    Color brown = new Color(42,25,15);
    Pixel[] pixels = this.getPixels();
    Pixel pixel = null;

    // loop through the pixels
    for (int i=0; i<pixels.length; i++)
    {
      // get the current pixel
      pixel = pixels[i];

      // check if in dist to brown and if so double the red
      if (pixel.colorDistance(brown) < 50.0)
        pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                 pixel.getGreen(),
                                 pixel.getBlue()));
    }
  }
  
  /**
   * Method to turn brown to red inside of 
   * a rectangular area
   */
  public void turnBrownToRedInRectangle()
  {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;

    // loop through the x values
    for (int x=63; x < 125; x++)
    {
      for (int y=6; y < 76; y++)
      {

        // get the current pixel
        pixel = this.getPixel(x,y);

        // check if in distance to brown and if so double the red
        if (pixel.colorDistance(brown) < 50.0)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                     pixel.getGreen(),
                                     pixel.getBlue()));
      }
    }
  }
  
  /**
   * Method to turn brown to red in a rectangular area 
   * specifed
   * by startX, endX-1, startY, endY-1
   * @param startX the starting location to check in x
   * @param endX the last pixel checked is one less than 
   * this in x
   * @param startY the starting location to check in y
   * @param endY the last pixel checked is one less than 
   * this in y
   */
  public void turnBrownToRedInRectangle(int startX, int endX, 
                                    int startY, int endY)
  {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;

    // loop through the x values
    for (int x=startX; x < endX; x++)
    {
      for (int y=startY; y < endY; y++)
      {

        // get the current pixel
        pixel = this.getPixel(x,y);

        // check if in distance to brown and if so double the red
        if (pixel.colorDistance(brown) < 50.0)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                     pixel.getGreen(),
                                     pixel.getBlue()));
      }
    }
  }
  
  /**
   * Method to turn brown to red in a rectangular area 
   * specifed
   * by startX, endX-1, startY, endY-1
   * @param startX the starting location to check in x
   * @param endX the last pixel checked is one less than 
   * this in x
   * @param startY the starting location to check in y
   * @param endY the last pixel checked is one less than 
   * this in y
   * @param distance if the current color is within this distance
   * to brown then change it
   */
  public void turnBrownToRedInRectangle(int startX, int endX, 
                                        int startY, int endY,
                                        double distance)
  {
    Color brown = new Color(42,25,15);
    Pixel pixel = null;

    // loop through the x values
    for (int x=startX; x < endX; x++)
    {
      for (int y=startY; y < endY; y++)
      {

        // get the current pixel
        pixel = this.getPixel(x,y);

        /* check if in distance to brown is less than
         * the passed distance and if so double the red
         */
        if (pixel.colorDistance(brown) < distance)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                     pixel.getGreen(),
                                     pixel.getBlue()));
      }
    }
  }
    
  /**
   * Method to double the red in a picture in a rectangular 
   * area if it is less than the passed distance to the 
   * passed color
   * @param startX the x value at the top left of the rectangular 
   * area
   * @param startY the y value at the top left of the rectangular 
   * area
   * @param endX the bottom right x value of the rectangular area
   * @param endY the bottom right y value of the rectangular area 
   * @param distance the amount that the distance must be less than 
   * @param compareColor the color to compare the current pixel 
   * color to
   */
  public void doubleRedInRange(int startX, int startY, 
                               int endX, int endY, 
                               double distance, Color compareColor)
  {
    Pixel pixel = null;

    // loop through the x values
    for (int x=startX; x <= endX; x++)
    {
      // loop through the y values
      for (int y=startY; y <= endY; y++)
      {

        // get the current pixel
        pixel = this.getPixel(x,y);

        /* check if the distance is less than the allowed distance 
          and if so double the red */
        if (pixel.colorDistance(compareColor) < distance)
          pixel.setColor(new Color((int) (pixel.getRed() * 2.0),
                                    pixel.getGreen(),
                                    pixel.getBlue()));
      }
    }

  }
  
  /**
   * Method to change all the pixels within a passed distance of a 
   * passed color in a range specified by a startX, startY, 
   * endX, and endY by passed red, green, and blue factors. 
   * @param compareColor the color to compare to
   * @param distance the distance that this should be within 
   * (less than)
   * @param redFactor the amount to multiply the current red 
   * value by
   * @param greenFactor the amount to multiply the current green 
   * value by
   * @param blueFactor the amount to multiply the current blue 
   * value by
   * @param startX the starting x value to use in checking the 
   * pixels 
   * @param startY the starting y value to use in checking the 
   * pixels
   * @param endX the ending x value to use in checking the 
   * pixels (< this)
   * @param endY the ending y value to use in checking the 
   * pixels (< this)
   */
  public void changePixelsWithinDistance(Color compareColor, 
                                         double distance, 
                                         double redFactor, 
                                         double greenFactor, 
                                         double blueFactor, 
                                         int startX, int startY, 
                                         int endX, int endY)
  {
    Pixel pixel = null;
    Color color = null;
    
    // loop through the x values
    for (int x = startX; x < endX; x++)
    {
      for (int y = startY; y < endY; y++)
      {
        // get the pixel at this x and y
        pixel = this.getPixel(x,y);
        
        /* if the current color is within the passed distance to 
         * the passed color
         */
        if (pixel.colorDistance(compareColor) < distance)
        {
          color = new Color((int) (pixel.getRed() * redFactor),
                            (int) (pixel.getGreen() * greenFactor),
                            (int) (pixel.getBlue() * blueFactor));
          
          pixel.setColor(color);
        }
      }
      
    }    
  }
  
  /**
   * Method to remove red eye from the current picture object in 
   * the rectangle defined by startX, startY, endX, endY.  The red 
   * will be replaced with the passed newColor
   * @param startX  the top left corner x value of a rectangle
   * @param startY  the top left corner y value of a rectangle
   * @param endX    the bottom right corner x value of a rectangle
   * @param endY    the bottom right corner y value of a rectangle
   * @param newColor the new color to use
   */
  public void removeRedEye(int startX, int startY, int endX,
                           int endY, Color newColor)
  {
    Pixel pixel = null;

    /* loop through the pixels in the rectangle defined by the 
       startX, startY, and endX and endY */
    for (int x = startX; x < endX; x++)
    {
      for (int y = startY; y < endY; y++)
      {
        // get the current pixel
        pixel = getPixel(x,y);

        // if the color is near red then change it
        if (pixel.colorDistance(Color.red) < 167)
          pixel.setColor(newColor);
      }
    }
  }
  
  /**
   * Method to change the current picture to a sepia
   * tint (modify the middle colors to a light brown and
   * the light colors to a light yellow and make the 
   * shadows darker)
   */
  public void sepiaTint()
  {
    Pixel pixel = null;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;

    // first change the current picture to grayscale
    this.grayscale();

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++)
    {
      for (int y = 0; y < this.getHeight(); y++)
      {
        // get the current pixel and color values
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // tint the shadows darker
        if (redValue < 60)
        {
          redValue = redValue * 0.9;
          greenValue = greenValue * 0.9;
          blueValue = blueValue * 0.9;
        }

        // tint the midtones a light brown
        // by reducing the blue
        else if (redValue < 190)
        {
          blueValue = blueValue * 0.8;
        }

        // tint the highlights a light yellow
        // by reducing the blue
        else
        {
          blueValue = blueValue * 0.9;
        }

        // set the colors
        pixel.setRed((int) redValue);
        pixel.setGreen((int) greenValue);
        pixel.setBlue((int) blueValue);
      }
    }
  }
  
 
  
  /**
   * Method to change a range in the current picture to a sepia
   * tint (modify the middle colors to a light brown and
   * the light colors to a light yellow and make the 
   * shadows darker)
   * @param startX the starting x in the range
   * @param startY the starting y in the range
   * @param endX the ending x in the range (not inclusive)
   * @param endY the ending y in the range (not inclusive)
   */
  public void sepiaTint(int startX, int startY,
                        int endX, int endY)
  {
    Pixel pixel = null;
    double redValue = 0;
    double greenValue = 0;
    double blueValue = 0;

    // first change the current picture to grayscale
    this.grayscale(startX,startY,endX,endY);

    // loop through the pixels
    for (int x = startX; x < endX; x++)
    {
      for (int y = startY; y < endY; y++)
      {
        // get the current pixel and color values
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // tint the shadows darker
        if (redValue < 60)
        {
          redValue = redValue * 0.9;
          greenValue = greenValue * 0.9;
          blueValue = blueValue * 0.9;
        }

        // tint the midtones a light brown
        // by reducing the blue
        else if (redValue < 190)
        {
          blueValue = blueValue * 0.8;
        }

        // tint the highlights a light yellow
        // by reducing the blue
        else
        {
          blueValue = blueValue * 0.9;
        }

        // set the colors
        pixel.setRed((int) redValue);
        pixel.setGreen((int) greenValue);
        pixel.setBlue((int) blueValue);
      }
    }
  }
  
  /**
   * Method to posterize (reduce the number of colors) in 
   * the picture.  The number of reds, greens, and blues will be 4
   */
  public void posterize()
  {
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {

        // get the current pixel and colors
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // check for red range and change color
        if (redValue < 64)
          redValue = 31;
        else if (redValue < 128)
          redValue = 95;
        else if (redValue < 192)
          redValue = 159;
        else
          redValue = 223;

        // check for green range
        if (greenValue < 64)
          greenValue = 31;
        else if (greenValue < 128)
          greenValue = 95;
        else if (greenValue < 192)
          greenValue = 159;
        else
          greenValue = 223;

        // check for blue range
        if (blueValue < 64)
          blueValue = 31;
        else if (blueValue < 128)
          blueValue = 95;
        else if (blueValue < 192)
          blueValue = 159;
        else
          blueValue = 223;

        // set the colors
        pixel.setRed(redValue);
        pixel.setGreen(greenValue);
        pixel.setBlue(blueValue);
      }
    }
  }
  
  /**
   * Method to posterize (reduce the number of colors) in 
   * the picture
   * @param numLevels the number of color levels to use
   */
  public void posterize(int numLevels)
  {
    Pixel pixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int increment = (int) (256.0 / numLevels);
    int bottomValue, topValue, middleValue = 0;

    // loop through the pixels
    for (int x = 0; x < this.getWidth(); x++) {
      for (int y = 0; y < this.getHeight(); y++) {

        // get the current pixel and colors
        pixel = this.getPixel(x,y);
        redValue = pixel.getRed();
        greenValue = pixel.getGreen();
        blueValue = pixel.getBlue();

        // loop through the number of levels
        for (int i = 0; i < numLevels; i++)
        {
          // compute the bottom, top, and middle values
          bottomValue = i * increment;
          topValue = (i + 1) * increment;
          middleValue = (int) ((bottomValue + topValue - 1) / 2.0);

          // check if current values are in current range and if so
          // set them to the middle value
          if (bottomValue <= redValue && redValue < topValue)
            pixel.setRed(middleValue);
          if (bottomValue <= greenValue && greenValue < topValue)
            pixel.setGreen(middleValue);
          if (bottomValue <= blueValue && blueValue < topValue)
            pixel.setBlue(middleValue);
        }
      }
    }
  }
  
  /**
   * Method to replace the pixel colors in the current picture object
   * that have a color distance less than the passed amount to white 
   * or black with the passed replacement color
   * @param replacementColor the new color to use 
   */
  public void highlightLightAndDark(double amount, 
                                    Color replacementColor) {
    Pixel pixel = null;
    
    // loop through all the pixels in the x direction
    for (int x = 0; x < getWidth(); x++) {
      
      // loop through all the pixels in the y direction
      for (int y = 0; y < getHeight(); y++) {
        
        // get the current pixel
        pixel = getPixel(x,y);
        
        // if the distance from white or black is less than the 
        // passed amount use the replace color instead
        if (pixel.colorDistance(Color.white) < amount ||
            pixel.colorDistance(Color.black) < amount) {
          pixel.setColor(replacementColor);
        }
      }
    }
  }
        
  /**
   * Method to create a new picture that is scaled up by the 
   * passed  number of times.
   * @return the new scaled up picture
   */
  public Picture scaleUp(int numTimes)
  {
    Picture targetPicture = 
      new Picture(this.getWidth() * numTimes, 
                  this.getHeight() * numTimes);
    Pixel sourcePixel = null;
    Pixel targetPixel = null;
    int targetX = 0;
    int targetY = 0;

    // loop through the source picture columns
    for (int sourceX = 0;
         sourceX < this.getWidth();
         sourceX++)
    {
      // loop through the source picture rows
      for (int sourceY=0;
          sourceY < this.getHeight();
          sourceY++)
      {
        // get the source pixel
        sourcePixel = this.getPixel(sourceX,sourceY);
        
        // loop copying to the target y
        for (int indexY = 0; indexY < numTimes; indexY++)
        {
          // loop copying to the target x
          for (int indexX = 0; indexX < numTimes; indexX++)
          {
            targetX = sourceX * numTimes + indexX;
            targetY = sourceY * numTimes + indexY;
            targetPixel = targetPicture.getPixel(targetX,targetY);
            targetPixel.setColor(sourcePixel.getColor());
          }
        }
      }
    }

    return targetPicture;

  }
  
  /**
   * Method to blur the pixels
   * @param numPixels the number of pixels to average in all 
   * directions.  So if the numPixels is 2 then we will average 
   * all pixels in the rectangle defined by 2 before the current 
   * pixel to 2 after the current pixel
   */
  public void blur(int numPixels)
  {
    Pixel pixel = null;
    Pixel samplePixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int count = 0;

    // loop through the pixels
    for (int x=0; x < this.getWidth(); x++) {
      for (int y=0; y < this.getHeight(); y++) {

        // get the current pixel
        pixel = this.getPixel(x,y);

        // reset the count and red, green, and blue values
        count = 0;
        redValue = greenValue = blueValue = 0;

        // loop through pixel numPixels before x to numPixels after x
        for (int xSample = x - numPixels; 
             xSample <= x + numPixels; 
             xSample++) {
          for (int ySample = y - numPixels; 
               ySample <= y + numPixels;
               ySample++) {

            // check that we are in the range of acceptable pixels
            if (xSample >= 0 && xSample < this.getWidth() &&
                ySample >= 0 && ySample < this.getHeight()) {
              samplePixel = this.getPixel(xSample,ySample);
              redValue = redValue + samplePixel.getRed();
              greenValue = greenValue + samplePixel.getGreen();
              blueValue = blueValue + samplePixel.getBlue();
              count = count + 1;
            }
          }
        }

        // use average color of surrounding pixels
        Color newColor = new Color(redValue / count,
                                   greenValue / count,
                                   blueValue / count);
        pixel.setColor(newColor);
      }
    }
  }
  
  /**
   * Method to blur the pixels
   * @param numPixels the number of pixels to average in all 
   * directions.  So if the numPixels is 2 then we will average 
   * all pixels in the rectangle defined by 2 before the current 
   * pixel to 2 after the current pixel
   */
  public void blurWithCopy(int numPixels)
  {
    Pixel pixel = null;
    Pixel samplePixel = null;
    int redValue = 0;
    int greenValue = 0;
    int blueValue = 0;
    int count = 0;
    Picture copyPict = new Picture(this);

    // loop through the pixels
    for (int x=0; x < this.getWidth(); x++) {
      for (int y=0; y < this.getHeight(); y++) {

        // get the current pixel
        pixel = this.getPixel(x,y);

        // reset the count and red, green, and blue values
        count = 0;
        redValue = greenValue = blueValue = 0;

        // loop through pixel numPixels before x to numPixels after x
        for (int xSample = x - numPixels; 
             xSample <= x + numPixels; 
             xSample++) {
          for (int ySample = y - numPixels; 
               ySample <= y + numPixels;
               ySample++) {

            // check that we are in the range of acceptable pixels
            if (xSample >= 0 && xSample < this.getWidth() &&
                ySample >= 0 && ySample < this.getHeight()) {
              samplePixel = copyPict.getPixel(xSample,ySample);
              redValue = redValue + samplePixel.getRed();
              greenValue = greenValue + samplePixel.getGreen();
              blueValue = blueValue + samplePixel.getBlue();
              count = count + 1;
            }
          }
        }

        // use average color of surrounding pixels
        Color newColor = new Color(redValue / count,
                                   greenValue / count,
                                   blueValue / count);
        pixel.setColor(newColor);
      }
    }
  }
  
  /**
   * Method to do a simple edge detection by comparing the absolute 
   * value of the difference between the color intensities (average 
   * of the color values) between a pixel and the pixel below it.  
   * If the absolute value of the difference between the color 
   * intensities is less than a passed amount the top pixel color 
   * will be set to white.  Otherwise it is set to black.
   * @param amount if the absolute value of the differences in the 
   * color average is less than this
   * set the color to white, else black
   */
  public void edgeDetection(double amount) {
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    double topAverage = 0.0;
    double bottomAverage = 0.0;
    int endY = this.getHeight() - 1;
    
    /* loop through y values from 0 to height - 1 
     * (since compare to below pixel) */
    for (int y = 0; y < endY; y++) {
      
      // loop through the x values from 0 to width
      for (int x = 0; x < this.getWidth(); x++) {
        
        // get the top and bottom pixels
        topPixel = this.getPixel(x,y);
        bottomPixel = this.getPixel(x,y+1);
        
        // get the color averages for the two pixels
        topAverage = topPixel.getAverage();
        bottomAverage = bottomPixel.getAverage();
        
        /* check if the absolute value of the difference 
         * is less than the amount */
        if (Math.abs(topAverage - bottomAverage) < amount) {
          topPixel.setColor(Color.WHITE);
        
        // else set the color to black
        } else {
          topPixel.setColor(Color.BLACK);
        }
      }
    }
  }
  
  /**
   * Method to replace the background in the current picture 
   * with the background from another picture
   * @param oldBackground the old background to replace
   * @param newBackground the new background to use
   */
  public void swapBackground(Picture oldBackground,
                             Picture newBackground)
  {
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel and old background pixel
        currPixel = this.getPixel(x,y);
        oldPixel = oldBackground.getPixel(x,y);

        /* if the distance between the current pixel color 
         * and the old background pixel color is less than the 15
         * then swap in the new background pixel
         */
        if (currPixel.colorDistance(oldPixel.getColor()) < 15.0)
        {
          newPixel = newBackground.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to replace the background in the current picture with 
   * the background from another picture
   * @param oldBackground the old background to replace
   * @param newBackground the new background to use
   * @param threshold if the distance between the current pixel 
   * color and the background
   * pixel color is less than this amount use the new background 
   * pixel color
   */
  public void swapBackground(Picture oldBackground, 
                             Picture newBackground, 
                             double threshold)
  {
    Pixel currPixel = null;
    Pixel oldPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel and old background pixel
        currPixel = this.getPixel(x,y);
        oldPixel = oldBackground.getPixel(x,y);

        /* if the distance between the current pixel color and 
         * the old background pixel color is less than the 
         * threshold then swap in the new background pixel
         */
        double distance = 
          currPixel.colorDistance(oldPixel.getColor());
        if (distance < threshold)
        {
          newPixel = newBackground.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to do chromakey using the passed background
   * color and the distance to the color
   * @param newBg the new background image to use to replace
   * @param color the background color to compare to
   * @param dist the distance that limits the chromakey
   * it will happen if the distance is less than or equal
   * to this value
   */
  public void chromakey(Picture newBg, Color color, double dist)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel
        currPixel = this.getPixel(x,y);

        /* if the color at the current pixel is mostly blue 
         * (blue value is greater than red and green combined), 
         * then use the new background color
         */
        double currDist = currPixel.colorDistance(color);
        if (currDist <= dist)
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to do chromakey using a blue background
   * @param newBg the new background image to use to replace
   * the blue from the current picture
   */
  public void chromakey(Picture newBg)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel
        currPixel = this.getPixel(x,y);

        /* if the color at the current pixel is mostly blue 
         * (blue value is greater than red and green combined), 
         * then use the new background color
         */
        int combindedColor = 
          currPixel.getRed() + currPixel.getGreen();
        if (combindedColor < currPixel.getBlue())
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
   /**
   * Method to do chromakey using a green background
   * @param newBg the new background image to use to replace
   * the green from the current picture
   */
  public void chromakeyGreen(Picture newBg)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<getHeight(); y++)
      {

        // get the current pixel
        currPixel = this.getPixel(x,y);

        /* if the color at the current pixel is mostly green
         * (green value is greater than blue and red combined), 
         * then use the new background color
         */
        int combindedColor = 
          currPixel.getRed() + currPixel.getBlue();
        if (combindedColor < currPixel.getGreen())
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to do chromakey using a green background.  This method
   * copies from the greenPict any non green pixels into the current
   * picture at the offset
   * @param greenPict the green screen picture
   * @param xOffset the amount to add to x for the green screen picture
   */
  public void chromakeyGreenPict(Picture greenPict,
                                 int xOffset, int yOffset)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=0; x<greenPict.getWidth(); x++)
    {

      // loop through the rows
      for (int y=0; y<greenPict.getHeight(); y++)
      {

        // get the current pixel
        currPixel = greenPict.getPixel(x,y);

        /* if the color at the current pixel is not green
         * (red and blue > green) copy it to the background
         */
        int combindedColor = 
          currPixel.getRed() + currPixel.getBlue();
        if (combindedColor > currPixel.getGreen() &&
            x + xOffset < this.getWidth() &&
            y + yOffset < this.getHeight())
        {
          newPixel = this.getPixel(x + xOffset,y + yOffset);
          newPixel.setColor(currPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to do chromakey using a green background.  This method
   * copies from the greenPict any non green pixels into the current
   * picture at the offset in the area defined by the green start and
   * end.
   * @param greenPict the green screen picture
   * @param xGreenStart the starting X for the green screen picture
   * @param yGreenStart the starting Y for the green screen picture
   * @param xGreenEnd the ending X for the green screen picture
   * @param yGreenEnd the ending Y for the green screen picture
   * @param xBackOffset the starting X for the background pict
   * @param yBackOffset the ending Y for the background pict
   */
  public void chromakeyGreenPict(Picture greenPict,
                                 int xGreenStart, int yGreenStart,
                                 int xGreenEnd, int yGreenEnd,
                                 int xBackOffset, int yBackOffset)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=xGreenStart; x<xGreenEnd; x++)
    {

      // loop through the rows
      for (int y=yGreenStart; y<yGreenEnd; y++)
      {

        // get the current pixel
        currPixel = greenPict.getPixel(x,y);

        /* if the color at the current pixel is not green
         * (red and blue > green) copy it to the background
         */
        int combindedColor = 
          currPixel.getRed() + currPixel.getBlue();
        if (combindedColor > currPixel.getGreen())
        {
          newPixel = this.getPixel(x + xBackOffset,y + yBackOffset);
          newPixel.setColor(currPixel.getColor());
        }
      }
    }
  }

  /**
   * Method to do chromakey using a blue background in 
   * a range
   * @param newBg the new background image to use to replace
   * the blue from the current picture
   * @param startX the start x in the range
   * @param startY the start y in the range
   * @param endX the end x in the range
   * @param endY the end y in the range
   */
  public void chromakey(Picture newBg,
                        int startX, int startY,
                        int endX, int endY)
  {
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the columns
    for (int x=startX; x<endX; x++)
    {

      // loop through the rows
      for (int y=startY; y<endY; y++)
      {

        // get the current pixel
        currPixel = this.getPixel(x,y);

        /* if the color at the current pixel is mostly blue 
         * (blue value is greater than red and green combined), 
         * then use the new background color
         */
        int combindedColor = 
          currPixel.getRed() + currPixel.getGreen();
        if (combindedColor < currPixel.getBlue())
        {
          newPixel = newBg.getPixel(x,y);
          currPixel.setColor(newPixel.getColor());
        }
      }
    }
  }
  
  /**
   * Method to do chromakey using a blue background
   * @param newBg the new background image to use to replace
   * the blue from the current picture
   */
  public void chromakeyBlue(Picture newBg)
  {
    Pixel[] pixelArray = this.getPixels();
    Pixel currPixel = null;
    Pixel newPixel = null;

    // loop through the pixels
    for (int i = 0; i < pixelArray.length; i++)
    {
      // get the current pixel
      currPixel = pixelArray[i];

      /* if the color at the current pixel is mostly blue (the blue 
       * value is greater than green and red combined), then use 
       * the new background color
       */
      int combindedColor = 
          currPixel.getRed() + currPixel.getGreen();
      if (combindedColor < currPixel.getBlue())
      {
        newPixel = newBg.getPixel(currPixel.getX(),
                                  currPixel.getY());
        currPixel.setColor(newPixel.getColor());
      }

    }
  }
  
  /**
   * Method to draw a grid on a picture
   */
  public void drawGrid() 
  {
    Pixel pixel = null;
    
    // Draw the horizontal lines
    for (int y = 20; y < this.getHeight(); y+=20) {
      for (int x = 0; x < this.getWidth(); x++) {
        pixel = this.getPixel(x,y);
        pixel.setColor(Color.black);
      }
    }
    
    // draw the vertical lines
    for (int x = 20; x < this.getWidth(); x+=20) {
      for (int y = 0; y < this.getHeight(); y++) {
        pixel = this.getPixel(x,y);
        pixel.setColor(Color.black);
      }
    }
  }
  
  /**
   * Method to add a solid red rectangle to the current picture
   */
  public void addBox()
  {
    
    // get the graphics context from the picture
    Graphics g = this.getGraphics();
    
    // set the color to red
    g.setColor(Color.red);
    
    // draw the box as a filled rectangle
    g.fillRect(150,200,50,50);
  }
    
  /**
   * Method to add a solid red rectangle to the beach picture
   */
  public static Picture addBoxToBeach()
  {
    Picture p = 
      new Picture(FileChooser.getMediaPath("beach-smaller.jpg"));
    
    // get the graphics context from the picture
    Graphics g = p.getGraphics();
    
    // set the color to red
    g.setColor(Color.red);
    
    // draw the box as a filled rectangle
    g.fillRect(150,200,50,50);
    
    return p;
  }
  
  /**
   * Method to draw a filled box on the current picture
   * @param color the color to draw the box with
   * @param topLeftX the top left x coordinate of the box
   * @param topLeftY the top left y coordinate of the box
   * @param width the width of the box
   * @param height the height of the box
   */
  public void drawBox(Color color, int topLeftX, int topLeftY,
                      int width, int height)
  {
    // get the graphics context for drawing 
    Graphics g = this.getGraphics();
    
    // set the current color
    g.setColor(color);
    
    // draw the filled rectangle
    g.fillRect(topLeftX,topLeftY,width,height);
  }  
  
  /**
   * Method to show different drawing capabilities.  It 
   * will draw a string, a line, a filled rectangle, the 
   * outline of a rectangle, the outline of an oval, 
   * and a filled arc.
   */
  public void drawExample()
  {

    // get the graphics object to use for drawing
    Graphics graphics = this.getGraphics();

    // start with a black color
    graphics.setColor(Color.black);

    /* draw the string with the upper left corner 
     * at x=10, y=75
     */
    graphics.drawString(
       "This is a test of drawing a string on a picture",
                        10,75);

    // draw a line from (10,20) to (300,50)
    graphics.drawLine(10,20,300,50);

    // set the color to yellow
    graphics.setColor(Color.yellow);

    /* draw a filled rectangle (filled with yellow) at 
     * upper left (0,200) with a width of 300 and 
     * height 250
     */
    graphics.fillRect(0,200,300,250);

    // set the color back to black
    graphics.setColor(Color.black);

    /* draw the outline of a rectangle with the upper 
     * left at (10,210) and a width of 200 and a height 
     * of 100
     */
    graphics.drawRect(10,210,200,100);
    
    /* draw an oval enclosed by a rectangle with the top 
     * left corner at (400,10) and a width of 200 and a 
     * height of 100 
     */
    graphics.drawOval(400,10,200,100);
    
    /* draw an arc which is part of an oval enclosed by 
     * a rectangle with the top left corner at (400,300) 
     * a width of 200, and a height of 150.  The arc 
     * starts at 0 (3 o'clock position) and goes 180 
     * degrees counter-clockwise to the 9 o'clock position
     */
    graphics.fillArc(400,300,200,150,0,180);
  }
  
  /**
   * Method to draw a face to demonstrate drawing 
   * ovals and arcs
   */
  public void drawFace()
  {
    // get the graphics object to use for drawing
    Graphics graphics = this.getGraphics();

    // start with a black color
    graphics.setColor(Color.black);
    
    // draw the oval for the face
    graphics.drawOval(130,50,380,380);
    
    // draw the ovals for the eyes
    graphics.fillOval(225,155,40,40);
    graphics.fillOval(375,155,40,40);
    
    // draw the arcs for the eyebrows
    graphics.drawArc(225,145,40,40,45,90);
    graphics.drawArc(375,145,40,40,45,90);
    
    // draw the arc for the mouth
    graphics.drawArc(190,85,255,255,-45,-90);
  }
  
   /**
   * Method to draw a face to demonstrate drawing 
   * ovals and arcs
   * @param upperLeftX the upper left x of the
   * enclosing rectangle
   * @param upperLeftY the upper left y of the
   * enclosing rectangle
   * @param width of enclosing rectangle
   * @param height of enclosing rectangle
   */
  public void drawFace(int upperLeftX,
                       int upperLeftY,
                       int width, int height)
  {
    // get the graphics object to use for drawing
    Graphics graphics = this.getGraphics();

    // start with a black color
    graphics.setColor(Color.black);
    
    // draw the oval for the face
    //130,50,380,380
    graphics.drawOval(upperLeftX,upperLeftY,
                      width,height);
    
    // draw the ovals for the eyes
    int quarterDist = width / 4;
    int tenth = height / 10;
    graphics.fillOval(upperLeftX + quarterDist,
                      upperLeftY + quarterDist,
                      tenth,tenth);
    graphics.fillOval(upperLeftX + width - 
                      quarterDist - tenth,
                      upperLeftY + quarterDist,
                      tenth,tenth);
    
    // draw the arcs for the eyebrows
    graphics.drawArc(upperLeftX + quarterDist,
                     upperLeftY + quarterDist - 10,
                     tenth,tenth,45,90);
    graphics.drawArc(upperLeftX + width - 
                      quarterDist - tenth,
                     upperLeftY + quarterDist - 10,
                     tenth,tenth,45,90);
    
    // draw the arc for the mouth
    int arcWidth = (int) (width * 0.67);
    int arcY  = (int) (width * 0.09);
    graphics.drawArc(upperLeftX + (width / 6),
                     upperLeftY + arcY,
                     arcWidth,arcWidth,
                     -45,-90);
  }
  
  /**
   * Method to draw a string on the current picture
   * @param text the string to draw
   * @param x the x location to start at
   * @param y the y location of the baseline
   */
  public void drawString(String text, int x, int y)
  {
    
    this.drawString(text,x,y,
                    new Font("Arial",Font.BOLD,24),
                    Color.BLACK);
  }
  
  /**
   * Method to draw a string on the current picture
   * @param text the string to draw
   * @param x the x location to start at
   * @param y the y location of the baseline
   */
  public void drawString(String text, int x, int y,
                         Color strColor)
  {
    
    this.drawString(text,x,y,
                    new Font("Arial",Font.BOLD,24),
                    strColor);
  }
  
  /**
   * Method to draw a string on the current picture
   * @param text the string to draw
   * @param x the x location to start at
   * @param y the y location of the baseline
   * @param font the font to use
   * @param color the color to use
   */
  public void drawString(String text, int x, int y,
                         Font font, Color color)
  {
    
    // get the graphics object
    Graphics g = this.getGraphics();
    
    // set the color 
    g.setColor(color);
    
    // set the font
    g.setFont(font);
    
    // draw the string
    g.drawString(text,x,y);
  }
  
  /**
   * Method to draw a horizontally centered string 
   * on the current picture
   * @param text the string to draw
   * @param y the y location of the baseline
   */
  public void drawHorizontalCenteredString(String text, 
                                           int y)
  {
    
    // get the graphics object
    Graphics g = this.getGraphics();
    
    // create the font object
    Font font = new Font("Arial",Font.BOLD,24);
    
    // set the color 
    g.setColor(Color.black);
    
    // set the font
    g.setFont(font);
    
    // get the font metrics
    FontMetrics fontMetrics = g.getFontMetrics();
    
    // get the width of the string
    int strWidth = fontMetrics.stringWidth(text);
    
    // calculate the center of the  picture
    int center = (int) (this.getWidth() * 0.5);
    
    // draw the string centered in x
    g.drawString(text,
                 center - (int) (strWidth * 0.5),
                 y);
  }
  
  /**
   * Method to copy the passed picture into the current 
   * picture at the given x and y position in the 
   * current picture
   * @param source the picture to copy
   * @param x the x of the upper left corner to copy to
   * @param y the y of the upper left corner to copy to
   */
  public void copy(Picture source, int x, int y)
  {
    // get the graphics object
    Graphics g = this.getGraphics();
    
    // copy the image
    g.drawImage(source.getImage(),x,y,null);
  }
  
  /**
   * Method to fill the picture with a gradient paint from
   * one color to another
   */
  public void drawGradient(Color color1, Color color2)
  {
    // get the graphics object for this picture
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // get mid point in x
    int xMid = this.getWidth() / 2;
    
    // create the gradient paint
    GradientPaint gPaint = new GradientPaint(xMid, 0, 
                                             color1,
                                             xMid, this.getHeight() - 1, 
                                             color2);
    
    // set the paint and fill a rectangle
    g2.setPaint(gPaint);
    g2.fill(new Rectangle2D.Double(0,0,this.getWidth(),this.getHeight()));
    
  }
  
  /**
   * Method to add a gradient painted sun to the current picture
   * @param x the x location for the upper left corner of the 
   * rectangle enclosing the sun
   * @param y the y location for the upper left corner of the 
   * rectangle enclosing the sun
   * @param width the width of the enclosing rectangle
   * @param height the height of the enclosing rectangle
   */
  public void drawSun(int x, int y, int width, int height)
  {
    
    // get the graphics2D object for this picture
    Graphics g = this.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // create the gradient for painting from yellow to red with
    // yellow at the top of the sun and red at the bottom
    float xMid = (float) (width / 0.5 + x);
    GradientPaint gPaint = new GradientPaint(xMid, y, 
                                             Color.yellow, 
                                             xMid, y + height, 
                                             Color.red);
    
    // set the gradient and draw the ellipse
    g2.setPaint(gPaint);
    g2.fill(new Ellipse2D.Double(x,y,width,height));
  }
  
  /**
   * Method to clip the picture to a triangle
   * @return a new picture with the image clipped 
   * to a triangle
   */
  public Picture clipToTriangle()
  {
    int width = this.getWidth();
    int height = this.getHeight();
    Picture result = new Picture(width,height);
    
    // get the graphics2D object for this picture
    Graphics g = result.getGraphics();
    Graphics2D g2 = (Graphics2D) g;
    
    // create a path to use for clipping
    GeneralPath path = 
      new GeneralPath(new Line2D.Double(0,height,
                                        width / 2,0));
    path.append(new Line2D.Double(width / 2, 0, 
                                  width, height), true);
    path.append(new Line2D.Double(width, height, 
                                  0, height), true);
    
    // use the path for clipping
    g2.setClip(path);
    
    // draw the image
    g2.drawImage(this.getImage(),0,0,width,
                 height,null);
    
    // return the result
    return result;
  }
  
} // end of class Picture, put all new methods before this
  