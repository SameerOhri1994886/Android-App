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
import com.example.letsbuy.models.Addresses;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class ChangeAddress extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
   EditText StreetAddress,City,PostalCode;
   TextView t;
   Spinner State;
   Button b;
   FirebaseFirestore db;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_address);
        StreetAddress=findViewById(R.id.edit1);
        City=findViewById(R.id.edit2);
        PostalCode=findViewById(R.id.edit3);
        t=findViewById(R.id.text1);
        State=findViewById(R.id.spinner);
        b=findViewById(R.id.button);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.States, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        State.setAdapter(adapter);
        State.setOnItemSelectedListener(this);
        db=FirebaseFirestore.getInstance();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String Address=StreetAddress.getText().toString();
                String city=City.getText().toString();
                String state=State.getSelectedItem().toString();
                String code=PostalCode.getText().toString();
                addData(Address,city,state,code);
            }
        });
    }
    public void addData(String StreetAddress,String City,String State,String PostalCode)
    {
        Addresses a=new Addresses(StreetAddress,City,State,PostalCode);
        db.collection("Changed Addresses")
                .add(a)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Address Changed!",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"Error :"+e.getMessage(),Toast.LENGTH_LONG).show();
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

