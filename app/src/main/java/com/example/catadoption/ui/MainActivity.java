package com.example.catadoption.ui;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption.ui
 文件名:  MainActivity
 创建者:  1vade
 创建时间:2022/6/22 13:09
 描述:    主页
*/

import static com.example.catadoption.ui.LoginActivity.CURRENT_USERNAME;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catadoption.Login;
import com.example.catadoption.R;
import com.example.catadoption.Register;
import com.example.catadoption.util.PreferenceUtil;

public  class MainActivity extends AppCompatActivity {
    private Button btn_login;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean autoLogin= PreferenceUtil.getBoolean(this,"AUTO_LOGIN");
        Log.i("MainActivityTAG",String.valueOf(autoLogin));

        if(autoLogin){
            String username= PreferenceUtil.getString(this,"username");
            String password= PreferenceUtil.getString(this,"password");

            if (username!=null&&password!=null){
                Login login=new Login(this);

                if (login.login(username,password)){
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                    PreferenceUtil.setString(this,CURRENT_USERNAME,username);
                    Intent intent=new Intent(this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        }

        btn_login=findViewById(R.id.btn_login);
        btn_register=findViewById(R.id.btn_register);

        btn_register.setOnClickListener(v -> {
            if (v.getId() == R.id.btn_register) {
                startActivity(new Intent(this, Register.class));
            }
        });
        btn_login.setOnClickListener(v -> {
            if (v.getId()==R.id.btn_login){
                startActivity(new Intent(this, LoginActivity.class));
            }
        });

    }
}