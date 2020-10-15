package com.example.letsbuy;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import static android.app.ProgressDialog.show;
public class Products extends AppCompatActivity {
    String items[]= new String[]{"Shoes","Bags","Mobile Accessories","Watches","Masks","Cosmetics"};
    String desc[]=new String[]{"Sports shoes for both men and women","Laptop bags","Mobile Covers,Headphones and USB","Smart Watches are also available",
            "Face Masks for Protection and safety against COVID ","Includes shampoos,creams and soaps"};
    int images[]={R.drawable.shoes,R.drawable.bags,R.drawable.mobile,R.drawable.watch,R.drawable.masks,R.drawable.cosmetics};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        ListView l = findViewById(R.id.lv);
        CustomListView cv=new CustomListView(this,items,desc,images);
        l.setAdapter(cv);
           }
         }









