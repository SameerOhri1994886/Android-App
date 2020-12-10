package com.example.letsbuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.letsbuy.API_Interfaces.JSONAPI;
import com.example.letsbuy.API_Interfaces.Json;
import com.example.letsbuy.modals.Post;
import com.example.letsbuy.modals.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Address extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        t1 = findViewById(R.id.t1);
        Retrofit re = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        Json json = re.create(Json.class);
        Call<List<Posts>> ca = json.getPosts();
        ca.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                if (!response.isSuccessful()) {
                    t1.setText("Code:" + response.code());
                    return;
                }
                List<Posts> posts = response.body();
                for (Posts post : posts) {
                    String content = "";
                    content += "StreetAddress :" + post.getStreetAddress() + "\n";
                    content += "City :" + post.getCity() + "\n";
                    content += "State :" + post.getState() + "\n";
                    content += "PostalCode :" + post.getPostalCode() + "\n\n";
                    t1.append(content);
                    break;

                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                t1.setText(t.getMessage());

            }
        });
    }
}