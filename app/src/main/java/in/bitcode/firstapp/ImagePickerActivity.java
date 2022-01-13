package in.bitcode.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ImagePickerActivity extends AppCompatActivity {

    private ImageView mImg1, mImg2, mImg3, mImg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker);

        init();

    }

    private void init() {
        mImg1 = findViewById(R.id.img1);
        mImg2 = findViewById(R.id.img2);
        mImg3 = findViewById(R.id.img3);
        mImg4 = findViewById(R.id.img4);

        View.OnClickListener onClickListener = new ImgClickListener();
        mImg1.setOnClickListener(onClickListener);
        mImg2.setOnClickListener(onClickListener);
        mImg3.setOnClickListener(onClickListener);
        mImg4.setOnClickListener(onClickListener);
    }

    private class ImgClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int selectedImageId = -1;

            switch (v.getId()) {
                case R.id.img1:
                    selectedImageId = R.drawable.tick;
                    break;

                case R.id.img2:
                    selectedImageId = R.drawable.cross;
                    break;

                case R.id.img3:
                    selectedImageId = R.drawable.bitcode;
                    break;

                case R.id.img4:
                    selectedImageId = R.mipmap.ic_launcher;
                    break;
            }

            Intent resultIntent = new Intent();
            resultIntent.putExtra(Constants.KEY_RESULT_IMAGE_ID, selectedImageId);

            setResult(1, resultIntent);

            finish();

        }
    }
}