/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage Flo2.jpeg
 *
 *  @author:
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) 
    {
        collageDimension = 4;
        tileDimension = 100;
        original = new Picture(filename);
        collage = new Picture(tileDimension*collageDimension, tileDimension*collageDimension);
        for (int tileCol = 0; tileCol < collage.width(); tileCol++)
        {
            for (int tileRow = 0; tileRow< collage.height(); tileRow++)
            {
                int scaleCol = tileCol * original.width() / collage.width();
                int scaleRow = tileRow * original.height() / collage.height();
                Color color = original.get(scaleCol, scaleRow);
                collage.set(tileCol, tileRow, color);
            }
        }
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) 
    {
        collageDimension = cd;
        tileDimension = td;
        original = new Picture(filename);
        collage = new Picture(tileDimension*collageDimension, tileDimension*collageDimension);
        for (int tileColumn = 0; tileColumn < collage.width(); tileColumn++)
        {
            for (int tileRow = 0; tileRow< collage.height(); tileRow++)
            {
                int scaleColumn = tileColumn * original.width() / collage.width();
                int scaleRow = tileRow * original.height() / collage.height();
                Color color = original.get(scaleColumn, scaleRow);
                collage.set(tileColumn, tileRow, color);
            }
        }
    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() 
    {
        return collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() 
    {
        return tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() 
    {
        return original;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() 
    {
        return collage;
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() 
    {
        original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() 
    {
        collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) 
    {
        Picture replacement = new Picture(filename);
        for (int tileColumn = 0; tileColumn < tileDimension; tileColumn++)
        {
            for (int tileRow = 0; tileRow < tileDimension; tileRow++)
            {
                int temporaryColumn = tileColumn % tileDimension;
                int temporaryRow = tileRow % tileDimension;
                int replacementColumn = temporaryColumn * replacement.width() / tileDimension;
                int replacementRow = temporaryRow * replacement.height() / tileDimension;
                Color color = replacement.get(replacementColumn, replacementRow);
                collage.set((collageCol * tileDimension) + tileColumn, (collageRow * tileDimension) + tileRow, color);
            }
        }
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () 
    {
	    for (int i = 0; i < collageDimension; i++)
        {
            for (int j = 0; j < collageDimension; j++)
            {
                for (int tileColumn = j * tileDimension; tileColumn < (j + 1) * tileDimension; tileColumn++)
                {
                    for (int tileRow = i * tileDimension; tileRow < (i + 1) * tileDimension; tileRow++)
                    {
                        int temporaryColumn = tileColumn % tileDimension;
                        int temporaryRow = tileRow % tileDimension;
                        int scaleColumn = temporaryColumn * original.width() / tileDimension;
                        int scaleRow = temporaryRow * original.height() / tileDimension;
                        Color color = original.get(scaleColumn, scaleRow);
                        collage.set(tileColumn, tileRow, color);
                    }
                }
            }
        }
    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see CS111 Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) 
    {
        for (int tileColumn = collageCol * tileDimension; tileColumn < (collageCol * tileDimension) + tileDimension; tileColumn++)
        {
            for (int tileRow = collageRow * tileDimension; tileRow < (collageRow * tileDimension) + tileDimension; tileRow++)
            {
                Color color = collage.get(tileColumn, tileRow);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                if (component.equals("red"))
                {
                    collage.set(tileColumn, tileRow, new Color(r, 0, 0));
                }
                else if (component.equals("green"))
                {
                    collage.set(tileColumn, tileRow, new Color(0, g, 0));
                }
                else
                {
                    collage.set(tileColumn, tileRow, new Color(0, 0, b));
                }
            }
        }
    }

    /*
     * Grayscale tile at (collageCol, collageRow)
     * (see CS111 Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void grayscaleTile (int collageCol, int collageRow) 
    {
        for (int tileColumn = collageCol * tileDimension; tileColumn < (collageCol * tileDimension) + tileDimension; tileColumn++)
        {
            for (int tileRow = collageRow * tileDimension; tileRow < (collageRow * tileDimension) + tileDimension; tileRow++)
            {
                Color color = collage.get(tileColumn, tileRow);
                Color gray = Luminance.toGray(color);
                collage.set(tileColumn, tileRow, gray);
            }
        }
    }


    /*
     *
     *  Test client: use the examples given on the assignment description to test your ArtCollage
     */
    public static void main (String[] args) 
    {
        ArtCollage art = new ArtCollage(args[0], 200, 4);
        art.makeCollage();
        art.replaceTile(args[1], 3, 3);
        art.replaceTile(args[2], 2, 2);
        art.colorizeTile("blue", 3, 3);
        art.grayscaleTile(2, 2);
        art.showCollagePicture();
    }
}
