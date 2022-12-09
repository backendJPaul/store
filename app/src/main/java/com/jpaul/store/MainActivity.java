package com.jpaul.store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String urlServer;
    IUserService iUserService;
    User user  = new User();
    private EditText editTextName;
    private EditText editTextPassword;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserService userService = new UserService("https://1e1a-2800-200-eb60-1be9-7c6c-776d-790b-6a7e.ngrok.io");

                User _user = new User();
                user.setName(editTextName.getText().toString());
                user.setPassword(editTextPassword.getText().toString());

                IChangeEventListener iChangeEventListener = new IChangeEventListener() {
                    @Override
                    public void fetch(ChangeEvent e) {

                    }

                    @Override
                    public void login(ChangeEvent e) {
                        user = userService.login(_user);
                        gotoDashBoard();
                        userService.removeEventListener(this);
                    }
                };

                userService.addEventListener(iChangeEventListener);
                userService.login(user);
            }
        });
    }

    private void initComponents() {
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
    }
    private void gotoDashBoard(){
        Intent intent = new Intent(this,com.jpaul.store.DashBoard.class);
        intent.putExtra("user",user);
        startActivity(intent);

    }

}