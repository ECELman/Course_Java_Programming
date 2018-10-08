package com.username.java_final_restaurant;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

public class advice extends AppCompatActivity {

    private Button buttonSendEmail;
    private EditText subjectString;
    private EditText contentString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advice);

        buttonSendEmail = (Button)findViewById(R.id.buttonSendEmail);
        subjectString = (EditText)findViewById(R.id.editTextOfSubject);
        contentString = (EditText)findViewById(R.id.editTextOfContent);


        buttonSendEmail.setOnClickListener(myListener);
    }

    private Button.OnClickListener myListener = new Button.OnClickListener()
    {
        public void onClick(View v)
        {
            String stringOfSubject = subjectString.getText().toString();
            String stringOfContent = contentString.getText().toString();
            Intent intentEmail = new Intent();
            intentEmail.setAction(Intent.ACTION_SENDTO);
            intentEmail.setData(Uri.parse("mailto:steven88sky@gmail.com"));
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, stringOfSubject);
            intentEmail.putExtra(Intent.EXTRA_TEXT, stringOfContent);
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
