package com.soydomain.stava.wingapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.soydomain.stava.wingapp.API.APIRequest;
import com.soydomain.stava.wingapp.API.RetrofitHelper;
import com.soydomain.stava.wingapp.Model.ResponseModel;
import com.soydomain.stava.wingapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btn_login;

    String mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsername = username.getText().toString();
                mPassword = password.getText().toString();
                loginAuth();
            }
        });
    }

    private void loginAuth(){
    APIRequest requestData = RetrofitHelper.conRetrofit().create(APIRequest.class);
    Call<ResponseModel> authLoginData = requestData.login(mUsername, mPassword);
    authLoginData.enqueue(new Callback<ResponseModel>() {
        @Override
        public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
            int code = response.body().getCode();
            String message = response.body().getMessage();

            if (message.equals("User Available") && code == 1){
                Intent maIntent = new Intent(LoginActivity.this, ProductListActivity.class);
                startActivity(maIntent);
            }else{
                Toast.makeText(LoginActivity.this, "User Not Found", Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onFailure(Call<ResponseModel> call, Throwable t) {
            Toast.makeText(LoginActivity.this, "Login Failed !"+t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
}
}