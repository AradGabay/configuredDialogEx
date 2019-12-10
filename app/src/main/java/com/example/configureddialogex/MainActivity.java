package com.example.configureddialogex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author Arad Gabay
 * @version 1
 * @since 10/12/2019
 */
public class MainActivity extends AppCompatActivity {
    LinearLayout ll;
    AlertDialog.Builder adb;
    AlertDialog ad;
    String[] colorname = new String[]{"Red","Green","Blue"};
    int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = findViewById(R.id.ll);


    }


    /*
     * This method creates an alert that changes the background color when button preesed
     */
    public void activatefirst(View view) {
        colors = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("Single Choice");
        adb.setItems(colorname, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                colors[which] = 255;
                ll.setBackgroundColor(Color.rgb(colors[0], colors[1], colors[2]));
            }

        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad=adb.create();
        ad.show();

    }
    /*
     * This method creates an alert that allows to combine all rgb colors.
     */
    public void activatesecond(View view) {
        colors = new int[]{0,0,0};
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Multi Choice");
        adb.setCancelable(false);
        adb.setMultiChoiceItems(colorname, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                colors[which] = 255;
            }
        });
        adb.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(colors[0],colors[1],colors[2]));
            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        ad=adb.create();
        ad.show();
    }
    /*
     * This method creates an alert with a reset button to white color
     */
    public void activatethird(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Reset Dialog");
        adb.setCancelable(false);
        adb.setNeutralButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.WHITE);
            }
        });
        ad = adb.create();
        ad.show();
    }
    /*
     * This method creates an alert where you can type a text and toast it.
     */
    public void activatefourth(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Toast Dialog");
        adb.setCancelable(false);
        final EditText et = new EditText(this);
        et.setHint("Type text here");
        adb.setView(et);
        adb.setPositiveButton("Toast", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = et.getText().toString();
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();

            }
        });
        adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        ad = adb.create();
        ad.show();

    }



}
