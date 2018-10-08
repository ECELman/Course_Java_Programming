package com.username.java_final_restaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class RestaurantMainActivity extends AppCompatActivity {

    int[] imgId = {R.drawable.place, R.drawable.team, R.drawable.food, R.drawable.waiter};
    String[] titleOfIntroArray = {"優質環境", "頂尖廚師團隊", "嚴選食材", "優質服務"};
    String[] textOfIntroArray = {"這是美食與視覺的雙重享宴，餐廳內部的任何地區都經過精心的裝潢與設計，讓您彷彿置身在藝術的天地，並且從餐廳外部放眼望去就是一片蔚藍的海洋，讓你可以邊享用餐點邊觀賞大自然的美。",
            "讓強大的廚師團隊來去把關你的胃，每一位廚師都曾在海外受過最專業的訓練，能夠提供最優質的餐點來去提供顧客享用，絕對讓您是一吃就上癮，還在等什麼，快來享用主廚們精心為您特製的高檔的餐點。",
            "我們餐廳的最高原則就是只提供最新鮮的食材給顧客，這是在經營多年來一直堅守的原則，每個顧客都是我們尊貴的貴賓，我們希望每一位顧客都能夠品嘗到最鮮美的食物，以此致上我們對顧客的最高敬意。",
            "為了讓顧客有賓至如歸的感覺，在餐廳裡的每一位服務員都是經過我們嚴密的禮儀訓練，在這裡我們將為您提供最優質的服務，帶給您最滿意的用餐體驗。"};
    int indexOfPicture = 0;
    private ImageView imgPhoto;
    private Button nextButton;
    private Button previousButton;
    private TextView titleOfIntro;
    private TextView textOfIntro;
    private Intent intent;

    private ListView slideMenuList;
    String[] slideMenuListArray = {"餐點介紹", "點餐專區", "意見回饋"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_main);
        imgPhoto = (ImageView) findViewById(R.id.img1);
        nextButton = (Button) findViewById(R.id.nextButton);
        previousButton = (Button) findViewById(R.id.previousButton);
        imgPhoto.setImageResource(imgId[indexOfPicture]);
        titleOfIntro = (TextView) findViewById(R.id.titleOfIntro);
        textOfIntro = (TextView) findViewById(R.id.textOfIntro);
        slideMenuList = (ListView) findViewById(R.id.slideMenuList);

        ArrayAdapter<String> adapterMenu = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, slideMenuListArray);
        slideMenuList.setAdapter(adapterMenu);
        slideMenuList.setOnItemClickListener(mySlideMenuListListener);


        nextButton.setOnClickListener(myListener);
        previousButton.setOnClickListener(myListener);
    }

    private Button.OnClickListener myListener = new Button.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.nextButton: {
                    indexOfPicture++;
                    if (indexOfPicture > 3)
                        indexOfPicture = 0;
                    imgPhoto.setImageResource(imgId[indexOfPicture]);
                    titleOfIntro.setText(titleOfIntroArray[indexOfPicture]);
                    textOfIntro.setText(textOfIntroArray[indexOfPicture]);
                    break;
                }
                case R.id.previousButton: {
                    indexOfPicture--;
                    if (indexOfPicture < 0)
                        indexOfPicture = 3;
                    imgPhoto.setImageResource(imgId[indexOfPicture]);
                    titleOfIntro.setText(titleOfIntroArray[indexOfPicture]);
                    textOfIntro.setText(textOfIntroArray[indexOfPicture]);
                    break;
                }
            }
        }
    };

    private ListView.OnItemClickListener mySlideMenuListListener = new ListView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id)
        {
            switch(position)
            {
                case 0:
                {
                    intent = new Intent("com.username.java_final_restaurant.menu");
                    startActivity(intent);
                    break;
                }
                case 1:
                {
                    intent = new Intent("com.username.java_final_restaurant.order");
                    startActivity(intent);
                    break;
                }
                case 2:
                {
                    intent = new Intent("com.username.java_final_restaurant.advice");
                    startActivity(intent);
                    break;
                }
            }
        }
    };
}