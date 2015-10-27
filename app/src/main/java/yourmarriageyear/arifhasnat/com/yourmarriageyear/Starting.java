package yourmarriageyear.arifhasnat.com.yourmarriageyear;

import android.app.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Starting extends Activity{
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        mp=MediaPlayer.create(getBaseContext(), R.raw.valobashi);

        mp.start();
        Thread th=new Thread(){

            public void run(){
                try{
                    sleep(18000);

                }catch(InterruptedException e){
                    e.printStackTrace();

                }finally{
                    Intent intent1 =new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent1);
                    mp.stop();
                }




            }




        };
        th.start();



    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }


}