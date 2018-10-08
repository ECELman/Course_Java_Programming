package com.username.java_final_restaurant;

import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

public class order extends AppCompatActivity {
    private int[] imageIds = {
            R.drawable.food1,R.drawable.food2,R.drawable.food3,
            R.drawable.food4,R.drawable.food5,R.drawable.food6,
            R.drawable.food7,R.drawable.food8,R.drawable.food9,
            R.drawable.food10,R.drawable.food11,R.drawable.food12
    };
    private ImageView imgShow;
    private Button startOrder;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order);

        imgShow=(ImageView)findViewById(R.id.imgShow01);
        GridView gridView = (GridView) findViewById(R.id.GridView01);
        startOrder = (Button)findViewById(R.id.startOrder);
        startOrder.setOnClickListener(orderListener);

        // 建立自訂的 Adapter
        MyAdapter adapter=new MyAdapter(this);

        // 設定  GridView 的資料來源
        gridView.setAdapter(adapter);

        // 設定  GridView 元件 ItemSelected 事件的  listener 為  galListener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                imgShow.setImageResource(imageIds[position]);
            }
        });
    }

    private Button.OnClickListener orderListener = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.startOrder:
                {
                    intent = new Intent("com.username.java_final_restaurant.startOrder");
                    startActivity(intent);
                    break;
                }
            }
        }
    };

    class MyAdapter extends BaseAdapter {
        private Context mContext;
        public MyAdapter(Context c){
            mContext=c;
        }

        public int getCount(){
            return imageIds.length; // 圖片共有多少張
        }
        public Object getItem(int position){
            return position;
        }
        public long getItemId(int position){
            return position; // 目前圖片索引
        }

        // 設定 GridView 顯示的圖片
        public View getView(int position, View contextView, ViewGroup parent){
            ImageView iv = new ImageView(mContext);
            iv.setImageResource(imageIds[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setLayoutParams(new GridView.LayoutParams(260,160));
            return iv;
        }
    }
}
