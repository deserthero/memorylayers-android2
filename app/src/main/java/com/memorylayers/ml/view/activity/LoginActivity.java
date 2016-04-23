package com.memorylayers.ml.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.memorylayers.ml.R;
import com.memorylayers.ml.controller.LoginController;
import com.memorylayers.ml.helper.LoginHelper;
import com.memorylayers.ml.helper.UIHelper;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.Collection;


public class LoginActivity extends Activity  implements TextWatcher{

    // Controller
    LoginController controller = new LoginController();

    // UI references & Assignments.
    Button mLoginBtn;
    View mParentView;
    Button mSignUpBtn;
    Button mFacebookLogin;
    Button mForgotPasswordBtn;
    EditText mUsernameEdittxt;
    EditText mPasswordEditText;

    //
    Collection<String> mFacebookReadPermissions;


    // Duration of background transation
    private final int BACKGROUND_TRANSATION_DURATION = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI (We didn't use buterknife cause it have an issue with transation )
        mParentView = findViewById(R.id.activity_login_mainview);
        mLoginBtn =   (Button) findViewById(R.id.btn_login);
        mSignUpBtn = (Button) findViewById(R.id.btn_login_signup);
        mForgotPasswordBtn = (Button) findViewById(R.id.btn_login_forgotlogindetails);
        mFacebookLogin = (Button) findViewById(R.id.btn_login_facebook);
        mUsernameEdittxt = (EditText) findViewById(R.id.edittxt_username);
        mPasswordEditText = (EditText) findViewById(R.id.edittxt_password);

        // Let The Background Transation begin ...
        UIHelper.startViewBackgroundTransation(mParentView,BACKGROUND_TRANSATION_DURATION);

        // Disable Login Button if Email & Pass Empty
           mLoginBtn.setEnabled(false);

        // Set Validation Listner
        mUsernameEdittxt.addTextChangedListener(this);
        mPasswordEditText.addTextChangedListener(this);


        // get facebook read permissions
        mFacebookReadPermissions = new ArrayList<>();
        mFacebookReadPermissions.add("public_profile");
        mFacebookReadPermissions.add("email");
        mFacebookReadPermissions.add("user_birthday");


        // On Click
        mSignUpBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try
                {
                    Intent k = new Intent(LoginActivity.this, SignupActivity.class);
                    startActivity(k);
                }catch(Exception e){

                }

            }
        });

        mLoginBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String loginUsername = mUsernameEdittxt.getText().toString();
                String loginPassword = mPasswordEditText.getText().toString();

                controller.loginAsDefault(loginUsername,loginPassword);

                try
                {
                    Intent k = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(k);
                }catch(Exception ex){

                }

            }
        });


        mFacebookLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.loginOrSignUpWithFacebook(LoginActivity.this, LoginActivity.this,mFacebookReadPermissions);
            }
        });

        mForgotPasswordBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try
                {
                    Intent k = new Intent(LoginActivity.this, ResetPassActivity.class);
                    startActivity(k);
                }catch(Exception e){

                }

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ParseFacebookUtils.onActivityResult(requestCode, resultCode, data);
    }

    // Validation
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

        // Validation
        String userNameString = mUsernameEdittxt.getText().toString();
        String passwordString = mPasswordEditText.getText().toString();

     if(!LoginHelper.isPasswordValid(passwordString)){
            mPasswordEditText.setError( "Password should be larger than 6 characters!" );
        }else if(!LoginHelper.isUsernameValid(userNameString)){
            mUsernameEdittxt.setError( "Username should be larger than 6 characters!" );
        }else if(LoginHelper.isPasswordValid(passwordString) && LoginHelper.isUsernameValid(userNameString)){

            // Enable SignUp Button
            mLoginBtn.setEnabled(true);
        }


    }
}
