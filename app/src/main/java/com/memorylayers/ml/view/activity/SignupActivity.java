package com.memorylayers.ml.view.activity;

import android.content.Intent;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.memorylayers.ml.R;
import com.memorylayers.ml.controller.SignupController;
import com.memorylayers.ml.helper.DateTimeHelper;
import com.memorylayers.ml.helper.LoginHelper;
import com.memorylayers.ml.helper.UIHelper;
import com.memorylayers.ml.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SignupActivity extends AppCompatActivity implements TextWatcher{

    // Controller
    SignupController controller = new SignupController();

    // UI references
    View mParentView;
    Button mSignupBtn;
    EditText mUserNameEdittxt;
    EditText mEmailEdittxt;
    EditText mFullNameEdittxt;
    EditText mPasswordEdittxt;
    EditText mBirthdateEdittxt;



    // Duration of background transation
    private final int BACKGROUND_TRANSATION_DURATION = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize UI (We didn't use buterknife cause it have an issue with transation )
        mParentView = findViewById(R.id.activity_signup_mainview);
        mSignupBtn = (Button) findViewById(R.id.btn_register_signup);
        mUserNameEdittxt = (EditText) findViewById(R.id.edittxt_register_username);
        mEmailEdittxt = (EditText) findViewById(R.id.edittxt_register_email);
        mFullNameEdittxt = (EditText) findViewById(R.id.edittxt_register_fullname);
        mPasswordEdittxt = (EditText) findViewById(R.id.edittxt_register_password);
        mBirthdateEdittxt = (EditText) findViewById(R.id.edittxt_register_birthdate);

        // Let The Background Transation begin ...
        UIHelper.startViewBackgroundTransation(mParentView,BACKGROUND_TRANSATION_DURATION);

        // Disable Signup button if required inputs empty
        mSignupBtn.setEnabled(false);

       // Set Validation Listner
        mUserNameEdittxt.addTextChangedListener(this);
        mEmailEdittxt.addTextChangedListener(this);
        mPasswordEdittxt.addTextChangedListener(this);

        // onClick
        mSignupBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                User newUser = new User();

                newUser.setEmail(mEmailEdittxt.getText().toString());
                newUser.setUserName(mUserNameEdittxt.getText().toString());
                newUser.setFullName(mFullNameEdittxt.getText().toString());
                newUser.setPassword(mPasswordEdittxt.getText().toString());

                // Get & Set BirthDate
                /*
                SimpleDateFormat birthDateFormat = new SimpleDateFormat("DD-MM-YYYY");
                String birthDayAsString = "";
                try {
                    Date birthDayAsDate = birthDateFormat.parse(mBirthdateEdittxt.getText().toString());
                    birthDayAsString = DateTimeHelper.convertDateToString(birthDayAsDate,birthDateFormat);
                    newUser.setBirthDate(birthDayAsString);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                */

               controller.signUpAsDefault(newUser,SignupActivity.this);


            }


        });
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
        String userNameString = mUserNameEdittxt.getText().toString();
        String emailString = mEmailEdittxt.getText().toString();
        String passwordString = mPasswordEdittxt.getText().toString();

        if(!LoginHelper.isEmailValid(emailString)){
            mEmailEdittxt.setError( "Email should be valid!" );
        }else if(!LoginHelper.isPasswordValid(passwordString)){
            mPasswordEdittxt.setError( "Password should be larger than 6 characters!" );
        }else if(!LoginHelper.isUsernameValid(userNameString)){
            mUserNameEdittxt.setError( "Username should be larger than 6 characters!" );
        }else if(LoginHelper.isEmailValid(emailString) && LoginHelper.isPasswordValid(passwordString) && LoginHelper.isUsernameValid(userNameString)){

            // Enable SignUp Button
            mSignupBtn.setEnabled(true);
        }




    }
}
