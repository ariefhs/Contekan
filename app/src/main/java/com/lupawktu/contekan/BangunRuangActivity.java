package com.lupawktu.contekan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.lupawktu.contekan.BangunRuang.Balok.BalokActivity;
import com.lupawktu.contekan.BangunRuang.Bola.BolaActivity;
import com.lupawktu.contekan.BangunRuang.Kerucut.KerucutActivity;
import com.lupawktu.contekan.BangunRuang.Kubus.KubusActivity;
import com.lupawktu.contekan.BangunRuang.Limas.LimasActivity;
import com.lupawktu.contekan.BangunRuang.Prisma.PrismaActivity;
import com.lupawktu.contekan.BangunRuang.Tabung.TabungActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/14/2017.
 */

public class BangunRuangActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.balok) RelativeLayout balok;
    @BindView(R.id.kubus) RelativeLayout kubus;
    @BindView(R.id.kerucut) RelativeLayout kerucut;
    @BindView(R.id.bola) RelativeLayout bola;
    @BindView(R.id.limas) RelativeLayout limas;
    @BindView(R.id.prisma) RelativeLayout prisma;
    @BindView(R.id.tabung) RelativeLayout tabung;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_ruang);
        ButterKnife.bind(this);

        balok.setOnClickListener(this);
        kubus.setOnClickListener(this);
        kerucut.setOnClickListener(this);
        bola.setOnClickListener(this);
        limas.setOnClickListener(this);
        prisma.setOnClickListener(this);
        tabung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.balok:
                Intent a = new Intent(this, BalokActivity.class);
                startActivity(a);
                break;
            case R.id.kubus:
                Intent b = new Intent(this, KubusActivity.class);
                startActivity(b);
                break;
            case R.id.bola:
                Intent c = new Intent(this, BolaActivity.class);
                startActivity(c);
                break;
            case R.id.kerucut:
                Intent d = new Intent(this, KerucutActivity.class);
                startActivity(d);
                break;
            case R.id.limas:
                Intent e = new Intent(this, LimasActivity.class);
                startActivity(e);
                break;
            case R.id.prisma:
                Intent f = new Intent(this, PrismaActivity.class);
                startActivity(f);
                break;
            case R.id.tabung:
                Intent g = new Intent(this, TabungActivity.class);
                startActivity(g);
                break;
        }
    }
}
