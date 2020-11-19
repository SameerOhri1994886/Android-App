package com.example.letsbuy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.example.letsbuy.models.AccountInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2;
    Button b1,b2,b3,b4;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.edit1);
        et2=findViewById(R.id.edit2);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn);
        db=FirebaseFirestore.getInstance();
        b1.setOnClickListener(this);
        b2.setOnClickListener(new View.OnClickListener() {
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
        b4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View vi) {
            openSubmitActivity();
        }
    });
    }
    private void openRegistration()
    {
        Intent i=new Intent(this,Registration.class);
        startActivity(i);
    }
    private void openProducts()
    {
        Intent intent=new Intent(this,Products.class);
        startActivity(intent);
    }
    private void openSubmitActivity()
    {
        Intent i=new Intent(this,SubmitActivity.class);
        startActivity(i);
    }
    @Override
    public void onClick(View vi)
    {
       switch(vi.getId())
       {
           case R.id.btn1:
               Intent in=new Intent(this.getApplicationContext(),Retrieve.class);
               this.startActivity(in);
               break;
       }
    }
}

