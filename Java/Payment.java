package com.example.letsbuy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.letsbuy.models.Passwords;
import com.example.letsbuy.models.Payments;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class Payment extends AppCompatActivity
{
TextView t1,t2,t3,t4,t5,t6,t7,t8;
EditText Name,CardNumber,CVV,Date;
Button b;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);
        t4 = findViewById(R.id.text4);
        t5 = findViewById(R.id.text5);
        t6 = findViewById(R.id.text6);
        t7 = findViewById(R.id.text7);
        t8 = findViewById(R.id.text8);
        b=findViewById(R.id.btn);
        Name = findViewById(R.id.edittext1);
        CardNumber = findViewById(R.id.edittext2);
        CVV = findViewById(R.id.edittext3);
        Date = findViewById(R.id.edittext4);
        db = FirebaseFirestore.getInstance();
        b.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String Cardholder = Name.getText().toString();
                String date = Date.getText().toString();
                addData(Cardholder,date);

            }
        });

    }
    private void addData(String Name, String Date) {
        Payments p = new Payments(Name,Date);
        db.collection("Payments")
                .add(p)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Order Confirmed!", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
    }
}
