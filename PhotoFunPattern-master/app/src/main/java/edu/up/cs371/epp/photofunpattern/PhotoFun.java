package edu.up.cs371.epp.photofunpattern;

import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.graphics.Bitmap;
        import android.graphics.drawable.BitmapDrawable;
        import android.widget.ImageView;
        import android.widget.Button;
        import android.view.View;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.util.Log;
import android.widget.TextView;

/**
 *  class PhotoFun controls this photo manipulation app.
 *
 *  @author  Edward C. Epp
 *  @version November 2017
 *   https://github.com/edcepp/PhotoFunPattern
 *
 */

public class PhotoFun extends AppCompatActivity {

    // Image resources
    private Bitmap myOriginalBmp;
    private ImageView myNewImageView;

    /*
    * onCreate This constructor lays out the user interface, initializes the
    * original image and links buttons to their actions.
    *
    * @param savedInstanceState Required by parent object
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_fun);

        ImageView originalImageView =
                (ImageView) findViewById(R.id.originalImage);
        BitmapDrawable originalDrawableBmp =
                (BitmapDrawable) originalImageView.getDrawable();
        myOriginalBmp = originalDrawableBmp.getBitmap();

        //myOriginalView = (ImageView) findViewById(R.id.originalImage);

        myNewImageView = (ImageView) findViewById(R.id.newImage);
        Button WestEdgeButton =
                (Button) findViewById(R.id.WestEdgeButton);
        WestEdgeButton.setOnClickListener
                (new WestEdgeButtonListener());


    }


    /*
     * class WestEdgeFilter this inner class defines the action for the
     * West Edge filter
     * button.
     */
    private class WestEdgeButtonListener
            implements View.OnClickListener {
        public void onClick(View button) {
            WestEdgeFilter filter = new WestEdgeFilter();
            myNewImageView.setImageBitmap(filter.apply(myOriginalBmp));
        }
    }
}
