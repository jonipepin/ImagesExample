package edu.usna.mobileos.imagesexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        // instantiate Java objects
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        
        // set on click listeners
        imageView.setOnClickListener(this);
        imageView2.setOnClickListener(this);
        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);
        imageView6.setOnClickListener(this);
        
        // setting the image source programmatically
//        imageView.setImageResource(R.drawable.pic2);

        // load image from the app's assets folder
        try {
            // get input stream
            InputStream inStream = getAssets().open("severn.jpg");
            
            // load image as Drawable
//            Drawable d = Drawable.createFromStream(inStream, null);
//            imageView.setImageDrawable(d);
            
            // load image as Bitmap using decodeStream
            Bitmap b = BitmapFactory.decodeStream(inStream);
            imageView.setImageBitmap(b);

        }
        catch(IOException ex) {
            return;
        }

        imageView.getDrawable();
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageView) {
            ImageView myImageView = (ImageView) v;
            Drawable clickedDrawable = myImageView.getDrawable();
            imageView.setImageDrawable(clickedDrawable);
        }
    }
}
