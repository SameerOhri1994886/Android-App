package com.example.letsbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.letsbuy.API_Interfaces.JSONAPI;
import com.example.letsbuy.modals.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Info extends AppCompatActivity {
    private TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        t1 = findViewById(R.id.t1);
        createPost();


    }
    void createPost(){
        Post post=new Post( "Sameer Ohri" ,"sam","welcome","sameerohri1@gmail.com","5149189677" );
        Retrofit r=new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        JSONAPI jsonapi=r.create(JSONAPI.class);
        Call<Post> call=jsonapi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    t1.setText("Code:"+response.code());
                    return;
                }
                Post postResponse=response.body();

                String content="";
                content += "FullName :" + postResponse.getFullName() + "\n";
                content += "Username :" + postResponse.getUsername() + "\n";
                content += "Password :" + postResponse.getPassword() + "\n";
                content += "Email :" + postResponse.getEmail() + "\n";
                content += "Phone :" + postResponse.getPhone() + "\n\n";

                t1.append(content);


            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                t1.setText(t.getMessage());

            }
        });


    }


    }

