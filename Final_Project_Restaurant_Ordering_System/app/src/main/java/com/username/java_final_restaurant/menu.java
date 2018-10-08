package com.username.java_final_restaurant;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    private int[] imageIds = {
            R.drawable.food1,R.drawable.food2,R.drawable.food3,
            R.drawable.food4,R.drawable.food5,R.drawable.food6,
            R.drawable.food7,R.drawable.food8,R.drawable.food9,
            R.drawable.food10,R.drawable.food11,R.drawable.food12
    };
    private ImageView imgShow;
    private TextView titleOfMenu;
    private TextView textOfMenu;
    private String[] textOfMenuArray = {"採用嚴選的新鮮上等雞肉，讓您體驗到前所未嚐的肉質口感，伴隨香菇的添加為這道菜增加了許多的鮮美度，雞湯的濃郁與滑順的口感將帶領您的味蕾到達另一個新的美食天地。",
                                        "每一粒米粒外表都鋪上了一層黃金色的面紗，讓您彷彿是看到了黃金置身在餐盤上，吃下的每一口都將讓您感受到米粒的顆粒感與飽足感，再加上櫻花蝦的添加，為這道餐點添加了風味與鮮麗的外表。",
                                        "採用最新鮮的水果，讓顧客品嘗到水果最為鮮美的一面，我們會不定時的改變拼盤的組合，讓其顧客能夠永不減對於餐點的新鮮度，並且在主廚的巧妙擺盤下，讓人彷彿是看到了一幅藝術畫作。",
                                        "對於只能每次享有單個口味的冰淇淋，讓人總是無法滿足口慾，別擔心，冰淇淋饗宴將會滿足您對每一種口味的慾望，讓您一次的點餐就能夠享有多種口味的冰淇淋。",
                                        "在主廚精巧的手藝下，為其肉塊添加了一層黃金外表，在咬下的每一口都能感受到雞肉的濃郁感，並且在少許辣椒的搭配下，為其雞肉增添了更多鮮美的口感與風味。",
                                        "經由慢火的悶烤，讓其外皮有著光亮的外表，在咬下去的瞬間，肉質的鬆軟與滑順的口感將會讓您對這道菜感到欲罷不能。",
                                        "經由大火快炒加上本店的獨特醬料，讓其麵條吃下去有著獨特的風味口感，並且讓您體驗到前所未有的滑順口感和濃郁的麵條香。",
                                        "排骨以及湯頭經由藥膳的慢火燉煮，讓您品嚐到最為鮮美的湯汁，排骨的滑順口感讓人吃下去別有一番的風味，可以說湯頭和排骨完美的融合在一起。",
                                        "晶瑩剔透的外表如同水晶球一般，讓人忘了它是食物的存在，Q彈的外表在加上一旁的佐料大大的提升口感，整體可以說呈現出了最完美的搭配，保證讓您吃到無法自拔。",
                                        "新鮮二字是最完美的比喻，想一次嚐到各式各樣的海鮮絕對不能錯過這項餐點，裡頭的食材除了新鮮還是新鮮，絕對包你愛上這一味。",
                                        "魚的鮮甜口感與Q嫩的肉質，將讓您在這項餐點一次獲得，整條魚都經過了長時間的悶燒，讓其外表變得十分的油亮，並且其肉質嫩口到一個不行。",
                                        "配合季節的轉變，我們將會為您呈上當季最為新鮮的蔬菜，讓您可以在享用美食的過程當中，也能感受到季節的氣息。"
    };
    private String[] titleOfMenuArray ={"香菇雞湯", "櫻花蝦炒飯", "水果拼盤", "冰淇淋饗宴", "宮保雞丁", "叉燒拼盤", "炒麵", "藥膳排骨湯", "水信玄餅", "豪華海鮮拼盤", "清蒸石斑魚", "季節時蔬"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        imgShow=(ImageView)findViewById(R.id.imgShow);
        Gallery gal=(Gallery)findViewById(R.id.Gallery01);
        titleOfMenu = (TextView)findViewById(R.id.titleOfMenu);
        textOfMenu = (TextView)findViewById(R.id.textOfMenu);


        // 建立自訂的 Adapter
        MyAdapter adapter=new MyAdapter(this);

        // 設定  Gallery 的資料來源
        gal.setAdapter(adapter);

        // 設定  Gallery 元件 ItemSelected 事件的  listener 為  galListener
        gal.setOnItemSelectedListener(galListener);


    }

    private Gallery.OnItemSelectedListener galListener=new Gallery.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position,
                                   long id) {
            imgShow.setImageResource(imageIds[position]);
            textOfMenu.setText(textOfMenuArray[position]);
            titleOfMenu.setText(titleOfMenuArray[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0){
            // TODO Auto-generated method stub
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

        // 設定 imageView 的圖片、顯示方式在中間，大小是 120x90
        public View getView(int position, View contextView, ViewGroup parent){
            ImageView iv = new ImageView(mContext);
            iv.setImageResource(imageIds[position]);
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setLayoutParams(new Gallery.LayoutParams(120,90));
            return iv;
        }
    }
}
