package nuno.lasalle.mdpa.matchapp.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.FileInputStream;

import nuno.lasalle.mdpa.matchapp.R;

/**
 * Created by nunoreis on 04/02/2018.
 */

public class LoginActivity extends AppCompatActivity {

    // member variables here:
    private FirebaseAuth mAuth;

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailView = (AutoCompleteTextView) findViewById(R.id.login_email);
        mPasswordView = (EditText) findViewById(R.id.login_password);


        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int id, KeyEvent keyEvent) {
                if (id == R.integer.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });


        // Grab an instance of FirebaseAuth
         mAuth = FirebaseAuth.getInstance();

    }


    // When Sign in button pressed
    public void signInExistingUser(View v) {
        attemptLogin();
    }

    // when Register button pressed
    public void registerNewUser(View v) {
        Intent intent = new Intent(this, RegisterActivity.class);
        finish();
        startActivity(intent);
    }


    private void attemptLogin() {

        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        if(email == "" || password == "") {
            return;
        } else {
            Toast.makeText(this, "Loging in...",
                    Toast.LENGTH_LONG).show();
        }

        // Use FirebaseAuth to sign in with email & password
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Log.d("matchapp", "signInWithEmail() onComplete()" + task.isSuccessful());

                if(!task.isSuccessful()){
                    Log.d("matchapp", "Problem signing in", task.getException());
                    showErrorDialog("There was a problem signing in");
                } else {
                    Intent intent = new Intent(LoginActivity.this, DiscoveryActivity.class);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    // Show error on screen with an alert dialog
    private void showErrorDialog(String message) {

        new AlertDialog.Builder(this)
                .setTitle("Oops")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
