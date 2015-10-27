package yourmarriageyear.arifhasnat.com.yourmarriageyear;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String month[]={"January","February","March","April","May","June","July","August","Septembar","October","November","December"};

    String how[]={"Home Arragement","Community Center Arrangement","Indivisual Arrangement"};

    Button find,refresh;

    EditText et1,et2;
    ImageView iv;
    TextView moreApps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        find=(Button) findViewById(R.id.button1);
        refresh=(Button) findViewById(R.id.button2);
        et1=(EditText) findViewById(R.id.editText1);
      //  et2=(EditText) findViewById(R.id.editText2);
        moreApps= (TextView) findViewById(R.id.textView2);

        iv=(ImageView) findViewById(R.id.imageView1);
        iv.setVisibility(0);


        find.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                String name = et1.getText().toString().toUpperCase();


                Random r = new Random();
                String monthname = month[r.nextInt(11)];
                long year = r.nextInt(20) + 2017;
                int date = r.nextInt(30) + 1;
                String howH = how[r.nextInt(3)];
                if (!(name).equalsIgnoreCase("")) {

                   // et2.setText(name + "  Your Marriage date is  " + monthname + "  " + date + " in    " + year + "       " + "And Marrage will be held with   " + howH);


                    builder.setMessage(name + "  Your Marriage date is  " + monthname + "  " + date + " in    " + year + "       " + "And Marrage will be held with   " + howH);
                    //builder.setMessage("hey !"+yourName +" you are  in "+values+"%"+"love with "+gfName +" Its very low . Are you actually in Love?? ");
                    builder.setCancelable(false);

                    builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            System.exit(0);

                        }
                    });


                    AlertDialog alert = builder.create();
                    alert.show();


                }


            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                et1.setText("");
            }
        });
        moreApps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://play.google.com/store/search?q=arif%20hasnat";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            String url = "http://arifhasnatinfo.wordpress.com/";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
