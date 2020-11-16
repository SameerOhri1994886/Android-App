package com.example.letsbuy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import com.example.letsbuy.models.AccountInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
public class Retrieve extends AppCompatActivity
{
       TextView t1;
       Button b1,b2,b3,b4,b5,b6;
       Switch s;
       SearchView sv;
       FirebaseFirestore db;
       @Override
       protected void onCreate(Bundle savedInstanceState)
       {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        t1 = findViewById(R.id.text1);
        sv = findViewById(R.id.search);
        s = findViewById(R.id.switch1);
        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);
        b4 = findViewById(R.id.btn4);
        b5 = findViewById(R.id.btn);
        b6 = findViewById(R.id.btn6);
        db=FirebaseFirestore.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                openMainActivity();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v2) {
                openProductDiscount();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v3) {
                openProducts();
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openMainActivity();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v4) {
                openChangeAddress();
            }

        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v5) {
                openPayment();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openOrder();
            }


        });
       }
       private void openProducts()
    {
        Intent i=new Intent(this,Products.class);
        startActivity(i);
    }
    private void openProductDiscount()
    {
        Intent i=new Intent(this,ProductDiscount.class);
        startActivity(i);
    }
    private void openMainActivity()
    {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
    private void openChangeAddress()
    {
        Intent i=new Intent(this,ChangeAddress.class);
        startActivity(i);
    }
    private void openPayment()
    {
        Intent i=new Intent(this,Payment.class);
        startActivity(i);
    }
    private void openOrder()
    {
        Intent i=new Intent(this,Order.class);
        startActivity(i);
    }
}


