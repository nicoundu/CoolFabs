package cl.pingon.coolfabs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import cl.pingon.catalogopingon.R;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton first, second, third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        first = findViewById(R.id.fab);
        second = findViewById(R.id.fab2);
        third = findViewById(R.id.fab3);


        first.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {
               if (first.getRotation() !=0){
                   hideFabs();
               } else {
                   showFabs();
               }
           }
        });

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flyIntent = new Intent(Intent.ACTION_VIEW);
                flyIntent.setData(Uri.parse("https://www.latam.com"));
                startActivity(flyIntent);            }
        });

        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rideIntent = new Intent(Intent.ACTION_VIEW);
                rideIntent.setData(Uri.parse("https://www.harley-davidson.com/"));
                startActivity(rideIntent);            }
        });
    }

    private void showFabs(){
        first.animate().rotation(45).setDuration(400).start();
        second.animate().translationY(-175).setDuration(600).start();
        third.animate().translationY(-350).setDuration(800).start();

    }

    private void hideFabs(){
        first.animate().rotation(0).setDuration(400).start();
        second.animate().translationY(0).setDuration(600).start();
        third.animate().translationY(0).setDuration(800).start();

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
