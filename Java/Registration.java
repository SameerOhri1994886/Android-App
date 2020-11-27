package com.example.letsbuy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.letsbuy.models.AccountInfo;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class Registration extends AppCompatActivity
{
    TextView t1,t2,t3,t4,t5;
    EditText FullName,Username,Password,Email,Phone;
    Button b;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        t1=findViewById(R.id.text1);
        t2=findViewById(R.id.text2);
        t3=findViewById(R.id.text3);
        t4=findViewById(R.id.text4);
        t5=findViewById(R.id.text5);
        FullName=findViewById(R.id.edit1);
        Username=findViewById(R.id.edit2);
        Password=findViewById(R.id.edit3);
        Email=findViewById(R.id.edit4);
        Phone=findViewById(R.id.edit5);
        b=findViewById(R.id.btn);
        db=FirebaseFirestore.getInstance();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Fname=FullName.getText().toString();
                String Uname=Username.getText().toString();
                String Pword=Password.getText().toString();
                String email=Email.getText().toString();
                String phone =Phone.getText().toString();
                addData(Fname,Uname,Pword,email,phone);
            }
        });
    }
    public void addData(String FullName,String Username,String Password,String Email,String Phone)
    {
        AccountInfo ai=new AccountInfo(FullName,Username,Password,Email,Phone);
        db.collection("Accounts")
                .add(ai)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Account Created!",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error :"+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }
}



