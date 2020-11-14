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
import com.example.letsbuy.models.Orders;
import com.example.letsbuy.models.Payments;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class Order extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    FirebaseFirestore db;
    Spinner Item,Qty,State;
    TextView t1,t2,t3;
    EditText StreetAddress,City,PostalCode;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        t1 = findViewById(R.id.text1);
        t2 = findViewById(R.id.text2);
        t3 = findViewById(R.id.text3);
        b=findViewById(R.id.btn);
        Item = findViewById(R.id.s1);
        Qty = findViewById(R.id.s2);
        State = findViewById(R.id.s3);
        StreetAddress = findViewById(R.id.edit1);
        City = findViewById(R.id.edit2);
        PostalCode = findViewById(R.id.edit3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Item.setAdapter(adapter);
        Item.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter<CharSequence> ad = ArrayAdapter.createFromResource(this, R.array.Numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Qty.setAdapter(ad);
        Qty.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter<CharSequence> a = ArrayAdapter.createFromResource(this, R.array.States, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        State.setAdapter(a);
        State.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        db = FirebaseFirestore.getInstance();
        b.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String item = Item.getSelectedItem().toString();
                String qty = Qty.getSelectedItem().toString();
                String address=StreetAddress.getText().toString();
                String city=City.getText().toString();
                String state=State.getSelectedItem().toString();
                String code=PostalCode.getText().toString();
                addData(item,qty,address,city,state,code);
            }
        });

    }
    private void addData(String Item, String Qty, String StreetAddress, String City, String State, String PostalCode)
    {
                 Orders o = new Orders(Item,Qty,StreetAddress,City,State,PostalCode);
                db.collection("Orders")
                        .add(o)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(getApplicationContext(), "Order Placed!", Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "Error :" + e.getMessage(), Toast.LENGTH_LONG).show();
                            }
                        });
            }
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String text=parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
            }














