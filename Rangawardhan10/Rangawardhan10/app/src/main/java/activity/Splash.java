package activity;

/**
 * Created by akashj on 29/07/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.VideoView;

import com.example.akashj.rangawardhan10.R;


public class Splash extends Activity {
    VideoView vd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        vd=(VideoView)findViewById(R.id.splash_video);
        String uriPath = "android.resource://com.example1.akashj.rangawardhan10/"+R.raw.videosplash;
        Uri uri=Uri.parse(uriPath);
        vd.setVideoURI(uri);
        vd.requestFocus();
        ViewGroup.LayoutParams lp = vd.getLayoutParams();
        lp.height=this.getWindowManager().getDefaultDisplay().getHeight();
        lp.width=this.getWindowManager().getDefaultDisplay().getWidth();
        vd.setLayoutParams(lp);
        vd.start();
        Thread waiting=new Thread(){
            public void run()
            {
                try{
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    final SharedPreferences sp = getSharedPreferences("file1", MODE_PRIVATE);
                    if(sp.getString("key1","")!=""){
                        Intent starting = new Intent("com.example.akashj.rangawardhan10.MAINACTIVITY");
                        startActivity(starting);
                        //System.out.println(sp.getString("key1", ""));
                        runOnUiThread(new Runnable() {
                            public void run() {
                                //Toast.makeText(Splash.this, "Hi " + sp.getString("key1", ""), //Toast.LENGTH_LONG).show();
                            }
                        });
                        // //Toast.makeText(Splash.this, "Hi " + sp.getString("key1",""), //Toast.LENGTH_LONG).show();
                    }
                    else {
                        Intent starting = new Intent("com.example.akashj.rangawardhan10.LOGIN");
                        startActivity(starting);
                    }
                }
            }
        };
        waiting.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        vd.stopPlayback();
        finish();
    }


}
