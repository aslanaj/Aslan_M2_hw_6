package com.example.aslan_m2_hw_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button_enter);
        EditText username = findViewById(R.id.edittext_login);
        EditText password = findViewById(R.id.edittext_password);
        TextView text_enter = findViewById(R.id.text_enter);
        TextView text1 = findViewById(R.id.text_1);
        TextView text3 = findViewById(R.id.text_3);
        TextView text4 = findViewById(R.id.text_4);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( username.getText().toString().isEmpty() ) {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.gray));
                } else {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.orange));
                }

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if ( password.getText().toString().isEmpty() ) {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.gray));
                } else {
                    button.setBackgroundColor(ContextCompat.getColor(MainActivity.this,R.color.orange));
                }

            }
        });

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") &&
                        password.getText().toString().equals("admin")) {
                    text_enter.setVisibility(View.GONE);
                    username.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    text1.setVisibility(View.GONE);
                    text3.setVisibility(View.GONE);
                    text4.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);

                    Toast.makeText(getApplicationContext(), "Вы успешно зарегистрировались",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Неправильный логин и пароль",
                            Toast.LENGTH_LONG).show();
                }

            }


        }));

        password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setSelection(password.length());



    }

}