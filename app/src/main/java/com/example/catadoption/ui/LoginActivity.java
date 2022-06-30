package com.example.catadoption.ui;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  Register
 创建者:  1vade
 创建时间:2022/6/6 11:55
 描述:    TODO
*/

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catadoption.Login;
import com.example.catadoption.R;
import com.example.catadoption.util.PreferenceUtil;


public class LoginActivity extends AppCompatActivity {
    private EditText et_name;
    private EditText et_password;
    private Button btn_login;
    private CheckBox cb_remember, cb_auto;
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String AUTO_LOGIN = "AUTO_LOGIN";
    public static final String CURRENT_USERNAME="CURRENT_USERNAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btn_login = findViewById(R.id.btn_login);
        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
        cb_remember = findViewById(R.id.cb_remember);
        cb_auto = findViewById(R.id.cb_auto);

        String username = PreferenceUtil.getString(this, USERNAME);
        String password = PreferenceUtil.getString(this, PASSWORD);

        if (username != null && password != null) {
            cb_remember.setChecked(true);
            et_name.setText(username);
            et_password.setText(password);
        }

        btn_login.setOnClickListener(v -> {
            String usernameText = et_name.getText().toString().trim();
            String passwordText = et_password.getText().toString();
            Login login=new Login(this);
            if (login.login(usernameText,passwordText)) {
                if (cb_remember.isChecked()) {
                    PreferenceUtil.setString(this, USERNAME, usernameText);
                    PreferenceUtil.setString(this, PASSWORD, passwordText);
                }
                else{
                    PreferenceUtil.setString(this, USERNAME, null);
                    PreferenceUtil.setString(this, PASSWORD, null);
                }
                PreferenceUtil.setString(this,CURRENT_USERNAME,usernameText);

                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
                et_password.setText("");
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        boolean isRemember = cb_remember.isChecked();
        if (!isRemember) {
            PreferenceUtil.setString(this, USERNAME, null);
            PreferenceUtil.setString(this, PASSWORD, null);
        }
        PreferenceUtil.setBoolean(this, AUTO_LOGIN, cb_auto.isChecked());
    }

}

