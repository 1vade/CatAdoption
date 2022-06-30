package com.example.catadoption;/*
 项目名:  CatAdoption
 包名:    com.example.catadoption
 文件名:  Register
 创建者:  1vade
 创建时间:2022/6/6 12:20
 描述:    TODO
*/

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.catadoption.ui.LoginActivity;
import com.example.catadoption.util.PersonSQLiteHelper;


public class Register extends AppCompatActivity {
    private EditText et_name;
    private EditText et_password;
    private EditText et_confirm;
    private Button btn_register;
    private PersonSQLiteHelper helper;
    private Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        btn_register = findViewById(R.id.btn_register);
        et_name = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);
        et_confirm = findViewById(R.id.et_confirm);

        helper = new PersonSQLiteHelper(Register.this);
        intent = new Intent(this, LoginActivity.class);

        btn_register.setOnClickListener(v -> {
            if (v.getId() == R.id.btn_register) {
                skipMainActivity();
            }
        });
    }

    private void skipMainActivity() {
        String password = et_password.getText().toString();
        String confirm = et_confirm.getText().toString();
        if (password.equals(confirm)) {
            boolean isRegisterSuccess = add(et_name.getText().toString().trim(),
                    et_password.getText().toString());
            if (isRegisterSuccess) {
                Toast.makeText(this, "注册成功 等待跳转", Toast.LENGTH_SHORT).show();
                new Thread(() -> {
                    try {
                        Thread.sleep(2000); // 单位毫秒
                        startActivity(intent);
                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                }).start();
            } else {
                Toast.makeText(this, "注册失败", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
            et_password.setText("");
            et_confirm.setText("");
        }


    }

    private boolean add(String name, String number) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("password", number);

        long id = database.insert("user", null, values);
        database.close();
        return id != -1;

    }
}
