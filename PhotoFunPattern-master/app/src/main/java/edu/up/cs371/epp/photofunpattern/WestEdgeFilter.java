package edu.up.cs371.epp.photofunpattern;

import android.graphics.Color;

/**
 *  class GrayFilter changes the image manipulation behavior of its parent
 *  PhotoFilter to convert the image to gray scale.
 *
 *  @author Edward C. Epp
 *  @version November 2017
 *  https://github.com/edcepp/PhotoFunPattern
 */

public class WestEdgeFilter extends PhotoFilter {


    private final int ADJUSTMENT = 100;

    /*
     * transformPixel This method overrides the transformPixel in the parent
     * class. It adds 100 to each RGB color component. The maximum value of each
     * component is limited to 255
     *
     * @param inPixel is a 32 bit pixel that contains RGB color values
     * @return a new Pixel in which each of the RGB components has been increased
     */

    public int transformPixel(int pixel1, int pixel2, int pixel3, int pixel4, int pixel5,
                              int pixel6, int pixel7, int pixel8, int pixel9) {

        int red = constrain(Color.red(pixel1) + Color.red(pixel2) + (Color.red(pixel3)*-1)
                + Color.red(pixel4) + (Color.red(pixel5)*-2) + (Color.red(pixel6)*-1)
                + Color.red(pixel7) + Color.red(pixel8) + (Color.red(pixel9)*-1));
        int green = constrain(Color.green(pixel1) + Color.green(pixel2) + (Color.green(pixel3)*-1)
                + Color.green(pixel4) + (Color.green(pixel5)*-2) + (Color.green(pixel6)*-1)
                + Color.green(pixel7) + Color.green(pixel8) + (Color.green(pixel9)*-1));
        int blue = constrain(Color.blue(pixel1) + Color.blue(pixel2) + (Color.blue(pixel3)*-1)
                + Color.blue(pixel4) + (Color.blue(pixel5)*-2) + (Color.blue(pixel6)*-1)
                + Color.blue(pixel7) + Color.blue(pixel8) + (Color.blue(pixel9)*-1));

        return Color.argb(Color.alpha(pixel4), red, green, blue);
    }


}
