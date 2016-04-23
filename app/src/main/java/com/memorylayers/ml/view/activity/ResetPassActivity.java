package com.memorylayers.ml.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.memorylayers.ml.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

public class ResetPassActivity extends AppCompatActivity {

    // UI references & Assignments.
    View mParentView;
    Button mSendResetMainBtn;
    EditText mEmailEdittxt;

    // Duration of background transation
    private final int BACKGROUND_TRANSATION_DURATION = 7000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pass);

        // Initialize UI (We didn't use buterknife cause it have an issue with transation )
        mParentView = findViewById(R.id.activity_reset_pass);
        mSendResetMainBtn =   (Button) findViewById(R.id.btn_resetpass_reset);
        mEmailEdittxt = (EditText) findViewById(R.id.edittxt_resetpass_email);

        // Let The Background Transation begin ...
        com.memorylayers.ml.helper.UIHelper.startViewBackgroundTransation(mParentView,BACKGROUND_TRANSATION_DURATION);

        // Disable Login Button if Email & Pass Empty
        mSendResetMainBtn.setEnabled(false);

        // onTextChange

        mEmailEdittxt.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                // TODO Auto-generated method stub

                if (s.toString().equals("")) {
                    mSendResetMainBtn.setEnabled(false);
                } else {
                    mSendResetMainBtn.setEnabled(true);
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        // onClick
        mSendResetMainBtn.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Get Email
                String emailToBeReset = mEmailEdittxt.getText().toString();

                // Check If Mail Valid
                boolean isEmailValid = com.memorylayers.ml.helper.LoginHelper.isEmailValid(emailToBeReset);

                if(!isEmailValid){
                    Toast.makeText(ResetPassActivity.this,"Email not valid",Toast.LENGTH_LONG).show();
                }else{

                    ParseUser.requestPasswordResetInBackground(emailToBeReset, new RequestPasswordResetCallback() {
                        public void done(ParseException e) {
                            if (e == null) {
                                // An email was successfully sent with reset instructions.
                                Toast.makeText(ResetPassActivity.this,"Email Sent Successfuly",Toast.LENGTH_LONG).show();
                            } else {
                                // Something went wrong. Look at the ParseException to see what's up.
                                Toast.makeText(ResetPassActivity.this,"Error Happen" + e.toString(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }



            }
        });
    }
}
