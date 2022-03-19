package com.example.puzzleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Integer[] imgList = {R.drawable.a1 , R.drawable.a2 , R.drawable.a3 , R.drawable.a4 ,
                        R.drawable.a5 , R.drawable.a6 , R.drawable.a7 , R.drawable.a8 , R.drawable.a9 ,
                        R.drawable.a10 , R.drawable.a11 , R.drawable.a12 , R.drawable.a13 , R.drawable.a14 ,
                        R.drawable.a15 , R.drawable.a16 , R.drawable.a17 , R.drawable.a18 , R.drawable.a19 ,
                        R.drawable.a20 , R.drawable.a21 , R.drawable.a22 , R.drawable.a23 , R.drawable.a24 ,
                        R.drawable.a25 , R.drawable.a26 , R.drawable.a27 , R.drawable.a29 , R.drawable.a30
    };

   private String[] imid=new String[]{"im1" , "im2" , "im3" , "im4" , "im5" , "im6" , "im7" , "im8" , "im9" , "im10" ,"im11" ,
           "im12" , "im13" , "im14" , "im15" , "im16" , "im17" , "im18" , "im19" , "im20" , "im21" ,
           "im22" , "im23" , "im24" , "im25"
   };

   private String[] tvid=new String[]{"tv1" , "tv2" , "tv3" , "tv4" , "tv5" , "tv6" , "tv7" , "tv8" , "tv9" , "tv10" , "tv11" ,
           "tv12" , "tv13" , "tv14" , "tv15" , "tv16" , "tv17" , "tv18" , "tv19" , "tv20" , "tv21" ,
           "tv22" , "tv23" , "tv24" , "tv25"
   };
   public static List<Integer> imL;
   private ImageView[] imView;
   private TextView[] tView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imView = new ImageView[25];
        tView = new TextView[25];
        imL= Arrays.asList(imgList);

        for(int i=0;i<25;i++){
            int temp=getResources().getIdentifier(imid[i] , "id" , getPackageName());
            imView[i]=(ImageView)findViewById(temp);

            temp = getResources().getIdentifier(tvid[i] , "id" , getPackageName());
            tView[i]=(TextView)findViewById(temp);
        }


        Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , HowToPlayActivity.class);
                startActivity(intent);
            }
        });


    }
    public void changeImg(View view){
        //List<Integer> imL= Arrays.asList(imgList);
        Collections.shuffle(imL);

        int temp = imL.get(0);
        for(int i=0;i<25;i++){
            if(((i+1)%9)==0)
                imView[i].setImageResource(temp);
            else
                imView[i].setImageResource(imL.get(i));

            String x=Integer.toString(i+1);
            tView[i].setText(x);
        }

        Button showbtn = findViewById(R.id.showbtn);
        showbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , ResultActivity.class);
                startActivity(intent);
            }
        });
    }
}
