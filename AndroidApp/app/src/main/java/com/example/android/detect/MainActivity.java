package com.example.android.detect;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.soundcloud.android.crop.Crop;

import java.io.File;

public class MainActivity extends AppCompatActivity {


    ListView list;

    String[] maintitle ={
            "白内障检测","皮肤疾病检测",
            "癌症检测","糖尿病检测",
            "更多",
    };

    String[] subtitle ={
            "包含有关眼睛相关疾病和基于AI的预测的信息。",
            "包含有关皮肤相关疾病和基于AI的预测的信息。",
            "包含有关癌症相关疾病和基于AI的预测的信息。",
            "包含有关糖尿病相关疾病和基于AI的预测的信息。",
            "包含有关改善健康和幸福生活的各种技巧的信息",
    };

    Integer[] imgid={
            R.drawable.normaleye,
            R.drawable.s1,
            R.drawable.c1,
            R.drawable.dd1,
            R.drawable.o1,
    };


    static final int number_item=14;
    ImageFragmentPagerAdapter imageFragmentPagerAdapter;
    ViewPager viewPager;
    public static final String[] Image_name={"d2","d1","d3","d4","d5","d6","d7","d8","d9","d77","d10","d11","d12","d13"};


    // button for each available classifier
    private Button akhaJach;
    // for permission requests
    public static final int REQUEST_PERMISSION = 300;
    // request code for permission requests to the os for image
    public static final int REQUEST_IMAGE = 100;
    // will hold uri of image obtained from camera
    private Uri imageUri;
    // string to send to next activity that describes the chosen classifier
    private String chosen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                if(position == 0) {
                    //code specific to first list item
                    //Before using intent in any activity add class in manifest file.
                    Intent i=new Intent(getApplicationContext(),SecondActivity.class);
                    startActivity(i);
                }
                else if(position == 1) {
                    //code specific to 2nd list item
                    Toast.makeText(getApplicationContext(),"对不起！！，该模块正在开发中ing",Toast.LENGTH_SHORT).show();
                }

                else if(position == 2) {

                    Toast.makeText(getApplicationContext(),"对不起！！，该模块正在开发中ing",Toast.LENGTH_SHORT).show();
                }
                else if(position == 3) {

                    Toast.makeText(getApplicationContext(),"对不起！！，该模块正在开发中ing",Toast.LENGTH_SHORT).show();
                }
                else if(position == 4) {

                    Toast.makeText(getApplicationContext(),"对不起！！，该模块正在开发中ing",Toast.LENGTH_SHORT).show();
                }

            }
        });

        ///////////////slide view //////////
        imageFragmentPagerAdapter= new ImageFragmentPagerAdapter(getSupportFragmentManager());
        viewPager=(ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(imageFragmentPagerAdapter);

    }

}
