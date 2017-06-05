package com.lupawktu.contekan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.bangunDatar)
    RelativeLayout bangunDatar;

    @BindView(R.id.bangunRuang)
    RelativeLayout bangunRuang;

    @BindView(R.id.trigonometri)
    RelativeLayout trigonometri;

    @BindView(R.id.kalkulator)
    RelativeLayout kalkulator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bangunDatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, BangunDatarActivity.class);
                startActivity(a);
            }
        });

        bangunRuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(MainActivity.this, BangunRuangActivity.class);
                startActivity(b);
            }
        });

        trigonometri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert("Comming soon next update...");
            }
        });

        kalkulator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert("Comming soon next update...");
            }
        });
    }

    private void alert(String s) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Pesan")
                .setMessage(s)
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
        alertDialog.show();
    }
}
