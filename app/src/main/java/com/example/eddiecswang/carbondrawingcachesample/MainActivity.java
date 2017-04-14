package com.example.eddiecswang.carbondrawingcachesample;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import carbon.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mRelativeLayout;
    Button mButton;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = (Button) findViewById(R.id.button);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relative_layout_circle);
        mImageView = (ImageView) findViewById(R.id.image_view_for_cache);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mImageView.setImageBitmap(loadBitmapFromView(mRelativeLayout));
            }
        });

    }

    public Bitmap loadBitmapFromView(View view) {
        view.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
        view.setDrawingCacheEnabled(false);
        return bitmap;
    }
}
