package com.example.letsbuy;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class Deals extends ArrayAdapter<String> {
    private String[] items;
    private String[] desc;
    private int[] images;
    private Activity context;
    public Deals(Activity context,String[]items,String[]desc, int[]images ) {
        super(context, R.layout.activity_products,items);
        this.context=context;
        this.items=items;
        this.desc=desc;
        this.images=images;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder =null;
        if(r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder=(ViewHolder)r.getTag();
        }
        viewHolder.iv.setImageResource(images[position]);
        viewHolder.t1.setText(items[position]);
        viewHolder.t2.setText(desc[position]);
        return r;
    }
    class ViewHolder
    {
        TextView t1,t2;
        ImageView iv;
        ViewHolder(View vw)
        {
            t1=(TextView)vw.findViewById(R.id.text1);
            t2=(TextView)vw.findViewById(R.id.text2);
            iv=(ImageView) vw.findViewById(R.id.imageView);
        }
    }
}



