package com.example.nasser.savedata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences shareref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shareref = getSharedPreferences("MyPrefs", Context.MODE_APPEND);

        Button btn = (Button) findViewById(R.id.button);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtname = (EditText) findViewById(R.id.txtname);
                SharedPreferences.Editor myeditor = shareref.edit();
                myeditor.putString("data",txtname.getText().toString());
               // Toast.makeText(getApplicationContext()," shooooort ",Toast.LENGTH_LONG).show();
                myeditor.commit();
            }
        });

        btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                EditText txtname = (EditText) findViewById(R.id.txtsave);
                txtname.setText(shareref.getString("data","empty"));
              //  Toast.makeText(getApplicationContext()," looooong ",Toast.LENGTH_LONG).show();
                return  true;
            }
        });

    }



}
