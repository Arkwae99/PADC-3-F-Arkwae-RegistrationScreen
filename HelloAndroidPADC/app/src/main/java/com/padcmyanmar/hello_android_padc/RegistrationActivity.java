package com.padcmyanmar.hello_android_padc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Ag Phone Khant on 24/11/2017.
 */

public class RegistrationActivity extends AppCompatActivity
{
    public static Intent newIntent (Context context) {
        Intent intent = new Intent(context, RegistrationActivity.class);
        return intent;
    }

    private Button btnRegister;
    private EditText etName,etPhone,etEmail,etPasswords,etConfirmPassword,etAddress;
    private RadioGroup rgButton;
    private RadioButton rbMale,rbFemale;
    private CheckBox cbHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_form);

        btnRegister = findViewById(R.id.btn_register);
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail=findViewById(R.id.et_email);
        etPasswords = findViewById(R.id.et_passwords);
        etConfirmPassword=findViewById(R.id.et_confirm_password);
        etAddress=findViewById(R.id.et_address);
        rgButton=findViewById(R.id.rg_button);
        rbMale=findViewById(R.id.rb_male);
        rbFemale=findViewById(R.id.rb_female);
        cbHome=findViewById(R.id.cb_home);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String email = etEmail.getText().toString();
                String passwords = etPasswords.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();
                String address = etAddress.getText().toString();


                if (TextUtils.isEmpty(name)) {
                    etName.setError("Name cannot be empty.");
                    return; //stop execute
                }
                if (TextUtils.isEmpty(phone)) {
                    etPhone.setError("Phone No. cannot be empty.");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    etEmail.setError("Email cannot be empty.");
                    return;
                }
                if (TextUtils.isEmpty(passwords)) {
                    etPasswords.setError("Password cannot be empty.");
                    return;
                }
                if (TextUtils.isEmpty(confirmPassword)) {
                    etConfirmPassword.setError("Confirm Password cannot be empty.");
                    return;
                }
                if (TextUtils.isEmpty(address)) {
                    etAddress.setError("Address cannot be empty.");
                    return;
                }

                    if (TextUtils.equals(passwords, confirmPassword)) {

                    } else {
                        Snackbar.make(v, "Password and Confirm Password are not same!", Snackbar.LENGTH_INDEFINITE).show();
                    }

                if(rgButton.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "Please select a Gender", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Registration Success", Toast.LENGTH_SHORT).show();
                    Intent intent = LoginActivity.newIntent((getApplicationContext()));
                    startActivity(intent);
                }

            }
        });
    }
}


