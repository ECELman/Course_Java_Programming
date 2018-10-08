package com.username.java_final_restaurant;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

public class startOrder extends AppCompatActivity {

    private CheckBox food1CheckBox, food2CheckBox, food3CheckBox, food4CheckBox;
    private CheckBox food5CheckBox, food6CheckBox, food7CheckBox, food8CheckBox;
    private CheckBox food9CheckBox, food10CheckBox, food11CheckBox, food12CheckBox;
    private Button submitOrder;

    String[] foodString = new String[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_order);

        food1CheckBox = (CheckBox)findViewById(R.id.food1CheckBox);
        food2CheckBox = (CheckBox)findViewById(R.id.food2CheckBox);
        food3CheckBox = (CheckBox)findViewById(R.id.food3CheckBox);
        food4CheckBox = (CheckBox)findViewById(R.id.food4CheckBox);
        food5CheckBox = (CheckBox)findViewById(R.id.food5CheckBox);
        food6CheckBox = (CheckBox)findViewById(R.id.food6CheckBox);
        food7CheckBox = (CheckBox)findViewById(R.id.food7CheckBox);
        food8CheckBox = (CheckBox)findViewById(R.id.food8CheckBox);
        food9CheckBox = (CheckBox)findViewById(R.id.food9CheckBox);
        food10CheckBox = (CheckBox)findViewById(R.id.food10CheckBox);
        food11CheckBox = (CheckBox)findViewById(R.id.food11CheckBox);
        food12CheckBox = (CheckBox)findViewById(R.id.food12CheckBox);
        submitOrder = (Button)findViewById(R.id.submitOrder);

        food1CheckBox.setOnCheckedChangeListener(myListener);
        food2CheckBox.setOnCheckedChangeListener(myListener);
        food3CheckBox.setOnCheckedChangeListener(myListener);
        food4CheckBox.setOnCheckedChangeListener(myListener);
        food5CheckBox.setOnCheckedChangeListener(myListener);
        food6CheckBox.setOnCheckedChangeListener(myListener);
        food7CheckBox.setOnCheckedChangeListener(myListener);
        food8CheckBox.setOnCheckedChangeListener(myListener);
        food9CheckBox.setOnCheckedChangeListener(myListener);
        food10CheckBox.setOnCheckedChangeListener(myListener);
        food11CheckBox.setOnCheckedChangeListener(myListener);
        food12CheckBox.setOnCheckedChangeListener(myListener);
        submitOrder.setOnClickListener(submitListener);
    }

    private CheckBox.OnCheckedChangeListener myListener = new CheckBox.OnCheckedChangeListener()
    {
      @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
      {

          for(int i=0;i<12;i++)
              foodString[i] = "";

          if(food1CheckBox.isChecked())
          {
                foodString[0] = "1號  香菇雞湯\n";
          }else
          {
              foodString[0] ="";
          }
          if(food2CheckBox.isChecked())
          {
              foodString[1] = "2號  櫻花蝦炒飯\n";
          }else
          {
              foodString[1] = "";
          }
          if(food3CheckBox.isChecked())
          {
              foodString[2] = "3號  水果拼盤\n";
          }else
          {
              foodString[2] = "";
          }
          if(food4CheckBox.isChecked())
          {
              foodString[3] = "4號  冰淇淋饗宴\n";
          }else
          {
              foodString[3] = "";
          }
          if(food5CheckBox.isChecked())
          {
              foodString[4] = "5號  宮保雞丁\n";
          }else
          {
              foodString[4] = "";
          }
          if(food6CheckBox.isChecked())
          {
              foodString[5] = "6號  叉燒拼盤\n";
          }else
          {
              foodString[5] = "";
          }
          if(food7CheckBox.isChecked())
          {
              foodString[6] = "7號  炒麵\n";
          }else
          {
              foodString[6] = "";
          }
          if(food8CheckBox.isChecked())
          {
              foodString[7] = "8號  藥膳排骨湯\n";
          }else
          {
              foodString[7] = "";
          }
          if(food9CheckBox.isChecked())
          {
              foodString[8] = "9號  水信玄餅\n";
          }else
          {
              foodString[8] = "";
          }
          if(food10CheckBox.isChecked())
          {
              foodString[9] = "10號  豪華海鮮拼盤\n";
          }else
          {
              foodString[9] = "";
          }
          if(food11CheckBox.isChecked())
          {
              foodString[10] = "11號  清蒸石斑魚\n";
          }else
          {
              foodString[10] = "";
          }
          if(food12CheckBox.isChecked())
          {
              foodString[11] = "12號  季節食蔬\n";
          }else
          {
              foodString[11] = "";
          }
      }
    };

    private Button.OnClickListener submitListener = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            String send = "您好，我想預定的餐點如下\n";
            for(int i=0;i<12;i++)
                send += foodString[i];
            Intent intentEmail = new Intent();
            intentEmail.setAction(Intent.ACTION_SENDTO);
            intentEmail.setData(Uri.parse("mailto:steven88sky@gmail.com"));
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, "訂單");
            intentEmail.putExtra(Intent.EXTRA_TEXT, send);
            List<ResolveInfo> ResolveInfoList = getPackageManager().queryIntentActivities(intentEmail, 0);
            for(ResolveInfo Resolve : ResolveInfoList)
            {
                //尋找Gmail的Package
                if(Resolve.activityInfo.name.contains("com.google.android.gm"))
                {
                    ActivityInfo activity = Resolve.activityInfo;
                    ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
                    intentEmail.setComponent(name);
                    startActivity(intentEmail);
                    break;
                }
            }
        }
    };
}
