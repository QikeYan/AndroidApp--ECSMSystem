package com.test.myapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.test.myapplication.R;
import com.test.myapplication.dao.LoginDao;
import com.test.myapplication.util.NetCallBack;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private Context context=this;
    private EditText username = null;
    private EditText password = null;
    private TextView attempts;
    private Button login;

    private String usernames, passwords;
    int counter = 3;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);
        attempts = (TextView) findViewById(R.id.textView5);
        attempts.setText(Integer.toString(counter));
        login = (Button) findViewById(R.id.button1);
        usernames = username.getText().toString();
        passwords = password.getText().toString();

        onClick();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void onClick() {
        login.setOnClickListener(this);
    }

    public void onClick(View view) {
        LoginDao loginDao = new LoginDao();
        loginDao.sendUserinfo(this, usernames, passwords, new NetCallBack() {
            @Override
            public void onSuccess(String mssage) {
                Toast.makeText(getApplicationContext(), "Redirecting...",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("username", usernames);
                context.startActivity(intent);
            }

            @Override
            public void onFail(String strMsg) {
                Toast.makeText(getApplicationContext(), "Wrong Credentials",
                        Toast.LENGTH_SHORT).show();
                attempts.setBackgroundColor(Color.RED);
                counter--;
                attempts.setText(Integer.toString(counter));
                if (counter == 0) {
                    login.setEnabled(false);
                }
            }
        });

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Login Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

