package activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.akashj.rangawardhan10.R;

/**
 * Created by akashj on 29/07/2015.
 */
public class Login extends ActionBarActivity {
    Button login;
    EditText eTextName;
    String Name="";
    private Toolbar toolbar;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logi);
        login=(Button)findViewById(R.id.button1);
        eTextName=(EditText)findViewById(R.id.editText1);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        sp = getSharedPreferences("file1", MODE_PRIVATE);
        //eTextName.setText(sp.getString("key1",""));
        //eTextEmail.setText(sp.getString("key2",""));

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //Log.d(TAG, "sendFreeTextButton clicked");

                Name = eTextName.getText().toString();

                if (Name.equals("")) {

                    //Toast.makeText(Login.this, "I think...Something is missing", //Toast.LENGTH_SHORT).show();
                } else {


                    Intent starting = new Intent("com.example.akashj.rangawardhan10.MAINACTIVITY");
                    startActivity(starting);
                    //Toast.makeText(Login.this, "Hi " + Name, //Toast.LENGTH_LONG).show();

                    SharedPreferences.Editor Edit = sp.edit();
                    Edit.putString("key1", Name);
                    Edit.commit();
                    finish();
                }
            }
        });

    }
    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();

    }
}

