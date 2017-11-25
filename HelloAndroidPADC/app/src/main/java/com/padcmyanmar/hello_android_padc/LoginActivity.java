package com.padcmyanmar.hello_android_padc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ag Phone Khant on 5/11/2017.
 */

public class LoginActivity extends AppCompatActivity {


    private static final String CORRECT_EMAIL = "apk@gmail.com";
    private static final String CORRECT_PASSWORD = "123456789"; //Constant Attribute

    public static Intent newIntent (Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    private Button btnLogin;
    private EditText etEmailOrPhone;
    private EditText etPassowrd;
    private TextView btnForgotPassword, btnNewSeller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        etEmailOrPhone = findViewById(R.id.et_email_or_phone);
        etPassowrd = findViewById(R.id.et_password);
        btnForgotPassword = findViewById(R.id.btn_forget_password);
        btnNewSeller = findViewById(R.id.btn_new_seller);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailOrPhone = etEmailOrPhone.getText().toString();
                String password = etPassowrd.getText().toString();

                if (TextUtils.isEmpty(emailOrPhone)) {
                    etEmailOrPhone.setError("Email or Phone cannot be empty.");
                    return; //stop execute
                }

                if (TextUtils.isEmpty(password)) {
                    etPassowrd.setError("Password cannot be empty.");
                    return;
                }

                if (TextUtils.equals(emailOrPhone, CORRECT_EMAIL) && TextUtils.equals(password, CORRECT_PASSWORD)) {
                    //Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                    Intent intent = HelloAndroidActivity.newIntent((getApplicationContext()));
                    startActivity(intent);

                } else {
                    Snackbar.make(v, "Incorrect email or password. Please try again", Snackbar.LENGTH_INDEFINITE).show();
                }


//                Log.d("TAG", "Click Me button clicked.");
//                Snackbar.make(v, "Login to your account", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });

        btnForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, " \"Forgot Password\" is comming soon.", Snackbar.LENGTH_INDEFINITE).show();
            }
        });

        btnNewSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(v, "Registration Screen is coming soon", Snackbar.LENGTH_INDEFINITE).show();

                Intent intent = RegistrationActivity.newIntent((getApplicationContext()));
                startActivity(intent);
            }
        });


    }

}




