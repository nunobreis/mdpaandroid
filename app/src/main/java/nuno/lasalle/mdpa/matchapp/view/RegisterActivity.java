package nuno.lasalle.mdpa.matchapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import nuno.lasalle.mdpa.matchapp.R;

/**
 * Created by nunoreis on 04/02/2018.
 */

public class RegisterActivity extends AppCompatActivity {

    // Constants
    public static final String CHAT_PREFS = "ChatPrefs";
    public static final String DISPLAY_NAME_KEY = "username";

    // Add member variables:
    // UI references
    private AutoCompleteTextView mEmailView;
    private AutoCompleteTextView mUsernameView;
    private EditText mPasswordView;
    private EditText mConfirmPasswordView;

    // Firebase instance variables
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.register_email);
        mUsernameView = (AutoCompleteTextView) findViewById(R.id.register_username);
        mPasswordView = (EditText) findViewById(R.id.register_password);
        mConfirmPasswordView = findViewById(R.id.register_confirm_password);


        mConfirmPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int id, KeyEvent event) {
                if (id == 200 || id == EditorInfo.IME_NULL) {
                    //attemptRegistration(); this method needs to be created
                    return true;
                }
                return false;
            }
        });
    }
}
