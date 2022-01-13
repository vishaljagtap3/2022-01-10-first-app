package in.bitcode.firstapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private LinearLayout mLinearLayout;
    private TextView mTxtUsername;
    private ImageView mImgUserIcon;

    private String mUsername;
    private int mCode;

    private int mUserImageIconId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLinearLayout = new LinearLayout(this);
        mLinearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        mLinearLayout.setOrientation(LinearLayout.VERTICAL);
        mLinearLayout.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                )
        );


        ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        //create the UI through code
        mTxtUsername = new TextView(this);
        mTxtUsername.setLayoutParams(params);
        mTxtUsername.setText("Username");
        mTxtUsername.setTextSize(30);
        mTxtUsername.setPadding(20, 20, 20, 20);

        mLinearLayout.addView(mTxtUsername);


        mImgUserIcon = new ImageView(this);
        mImgUserIcon.setLayoutParams(params);
        mImgUserIcon.setImageResource(R.drawable.bitcode);
        mLinearLayout.addView(mImgUserIcon);

        setContentView(mLinearLayout);

        //get the input data
        Intent intent = getIntent();
        Bundle input = intent.getExtras();
        mUsername = input.getString(Constants.KEY_USERNAME, "Not available");
        mCode = input.getInt(Constants.KEY_CODE, -1);
        mTxtUsername.setText(mUsername  + " - " + mCode);

        //setup listener

        mImgUserIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentImagePickerActivity =
                        new Intent(HomeActivity.this, ImagePickerActivity.class);

                startActivityForResult(intentImagePickerActivity, 1);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data == null) {
            return;
        }

        //mUserImageIconId = data.getExtras().getInt(Constants.KEY_RESULT_IMAGE_ID);
        mUserImageIconId = data.getIntExtra(Constants.KEY_RESULT_IMAGE_ID, R.mipmap.ic_launcher_round);
        mImgUserIcon.setImageResource(mUserImageIconId);
    }
}
