package com.example.letsbuy;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.letsbuy.models.AccountInfo;
import com.example.letsbuy.models.Passwords;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class SubmitActivity extends AppCompatActivity
{
    EditText Username,NewPassword,ConfirmPassword;
    Button b;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        Username=findViewById(R.id.edit1);
        NewPassword=findViewById(R.id.edit2);
        ConfirmPassword=findViewById(R.id.edit3);
        b=findViewById(R.id.btn);
        db=FirebaseFirestore.getInstance();
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String Uname=Username.getText().toString();
                String newpassword=NewPassword.getText().toString();
                String confirmpassword=ConfirmPassword.getText().toString();
                addData(Uname,newpassword,confirmpassword);
            }
        });
    }
    public void addData(String Username,String NewPassword,String ConfirmPassword)
    {
        Passwords p=new Passwords(Username,NewPassword,ConfirmPassword);
        db.collection("Changed Passwords")
                .add(p)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Password Changed!",Toast.LENGTH_LONG).show();
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


