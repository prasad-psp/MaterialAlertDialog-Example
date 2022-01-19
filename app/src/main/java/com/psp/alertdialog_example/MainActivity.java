package com.psp.alertdialog_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Button btnSimple,btnMultiChoice,btnSingleChoice,btnRoundedAlert, btnCustom;

    private final CharSequence[] items = new CharSequence[] {
            "A",
            "B",
            "C"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimple = findViewById(R.id.btnSimple);
        btnMultiChoice = findViewById(R.id.btnMultiChoice);
        btnSingleChoice = findViewById(R.id.btnSingleChoice);
        btnRoundedAlert = findViewById(R.id.btnRoundedAlert);
        btnCustom = findViewById(R.id.btnCustom);



        btnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Simple dialog")
                        .setMessage("Alert dialog message")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnSimple,"YES ",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnSimple,"NO ",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .create().show();
            }
        });

        btnMultiChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean[] itemCheck = {false,true,true};

                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("MultiChoice dialog")
                        .setMultiChoiceItems(items, itemCheck, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Snackbar.make(btnMultiChoice,"You have selected "+which+" and isChecked is "+
                                        isChecked,Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnMultiChoice,"OK ",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnMultiChoice,"CANCEL ",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .create().show();
            }
        });

        btnSingleChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("SingleChoice dialog")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnSingleChoice,"You have selected "+which,Snackbar.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        })
                        .create().show();

            }
        });

        btnRoundedAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialAlertDialogBuilder(MainActivity.this)
                        .setTitle("Simple dialog")
                        // Rounded Alert box
                        .setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.background_alert_dialog,null))
                        .setMessage("Alert dialog message")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnSimple,"YES ",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnSimple,"NO ",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .create().show();
            }
        });

        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new MaterialAlertDialogBuilder(MainActivity.this,R.style.CustomMaterialAlertDialog)
                        .setTitle("Custom dialog")
                        .setMessage("Alert dialog message")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnCustom,"YES ",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Snackbar.make(btnCustom,"NO ",Snackbar.LENGTH_SHORT).show();
                            }
                        })
                        .create().show();

            }
        });

    }
}