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
public class ProductDiscount extends AppCompatActivity {
    String items[]= new String[]{"Shoes","Bags","Mobile Accessories","Watches","Masks","Cosmetics"};
    String desc[]=new String[]{"Sports shoes for both men and women                                 15% OFF",
            "Laptop bags                                                                            10% OFF",
            "Mobile Covers                                                                           8% OFF",
            "Headphones and USB                                                                     12% OFF",
            "Smart Watches are also available                                                       15% OFF",
            "Face Masks for Protection and safety against COVID                                      25% OFF",
            "Includes shampoos,creams and soaps                                                     20% OFF"};
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










