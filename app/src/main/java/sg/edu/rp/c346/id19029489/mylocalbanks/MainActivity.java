package sg.edu.rp.c346.id19029489.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView dbs, ocbc, uob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == dbs){
            menu.add(0,0,0, R.string.dbsWeb);
            menu.add(0,1,1, R.string.dbsCall);

        }
        else if (v == ocbc){
            menu.add(0,2,0, R.string.ocbcWeb);
            menu.add(0,3,1, R.string.ocbcCall);
        }
        else{
            menu.add(0,4,0, R.string.uobWeb);
            menu.add(0,5,1, R.string.uobCall);
        }

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()== 0) {
            Intent dbsWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsSite)));
            startActivity(dbsWeb);
        }
        else if(item.getItemId()== 1) {
            Intent dbsCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18001111111l));
            startActivity(dbsCall);
        }
        else if(item.getItemId()== 2) {
            Intent ocbcWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcSite)));
            startActivity(ocbcWeb);
        }
        else if(item.getItemId()== 3) {
            Intent ocbcCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+18003633333l));
            startActivity(ocbcCall);
        }
        else if(item.getItemId()== 4) {
            Intent uobWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobSite)));
            startActivity(uobWeb);
        }
        else if(item.getItemId()== 5) {
            Intent uobCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +18002222121l));
            startActivity(uobCall);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.eng){
            Toast.makeText(MainActivity.this, R.string.engChosen, Toast.LENGTH_SHORT).show();
            dbs.setText(R.string.dbs);
            ocbc.setText(R.string.ocbc);
            uob.setText(R.string.uob);

        }
        else if(item.getItemId() == R.id.chi){
            Toast.makeText(MainActivity.this, R.string.chiChosen, Toast.LENGTH_SHORT).show();
            dbs.setText(R.string.chiDbs);
            ocbc.setText(R.string.chiOcbc);
            uob.setText(R.string.chiUob);
        }
        return super.onOptionsItemSelected(item);
    }


}
