package com.example.letsbuy;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.edit1);
        et2=findViewById(R.id.edit2);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegistration();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {
                openProducts();
            }
        });
    }
    private void openRegistration() {
        Intent i=new Intent(this,Registration.class);
        startActivity(i);
    }
    private void openProducts() {
        Intent intent=new Intent(this,Products.class);
        startActivity(intent);
    }
}

