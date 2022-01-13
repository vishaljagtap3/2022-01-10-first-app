package in.bitcode.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private ImageView mImgLogo;
    private EditText mEdtUsername, mEdtPassword;
    private Button mBtnLogin, mBtnForgotPassword;
    private TextView mTxtClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mt("onCreate");

        setContentView(R.layout.activity_main);

        init();

        mBtnLogin.setOnClickListener(new BtnLoginClickListener());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mt("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mt("onResume");
    }

    @Override
    protected void onPause() {
        mt("onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        mt("onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mt("onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mt("onRestart");
    }

    private void init() {
        mImgLogo = findViewById(R.id.imgLogo);
        mEdtUsername = findViewById(R.id.edtUsername);
        mEdtPassword = findViewById(R.id.edtPassword);
        mBtnLogin = findViewById(R.id.btnLogin);
        mBtnForgotPassword = findViewById(R.id.btnForgotPassword);
        mTxtClear = findViewById(R.id.txtClear);
    }


    class BtnLoginClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(mEdtUsername.getText().toString().equals("bitcode") && mEdtPassword.getText().toString().equals("bitcode")) {

                Intent intent = new Intent(MainActivity.this, HomeActivity.class);

                intent.putExtra(Constants.KEY_USERNAME, mEdtUsername.getText().toString());
                intent.putExtra(Constants.KEY_CODE, 401124);

                startActivity(intent);

                finish();
            }
            else {
                mt("Failed to login!");
            }
        }
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}

