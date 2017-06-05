package com.lupawktu.contekan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

import com.lupawktu.contekan.BangunDatar.BelahKetupat.BelahKetupatActivity;
import com.lupawktu.contekan.BangunDatar.JajarGenjang.JajarGenjangActivity;
import com.lupawktu.contekan.BangunDatar.LayangLayang.LayangActivity;
import com.lupawktu.contekan.BangunDatar.Lingkaran.LingkaranActivity;
import com.lupawktu.contekan.BangunDatar.Persegi.PersegiActivity;
import com.lupawktu.contekan.BangunDatar.PersegiPanjang.PersegiPanjangActivity;
import com.lupawktu.contekan.BangunDatar.Segitiga.SegitigaActivity;
import com.lupawktu.contekan.BangunDatar.Trapesium.TrapesiumActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/10/2017.
 */
public class BangunDatarActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.persegi) RelativeLayout persegi;
    @BindView(R.id.persegipanjang) RelativeLayout persegipanjang;
    @BindView(R.id.lingkarang) RelativeLayout lingkaran;
    @BindView(R.id.trapesium) RelativeLayout trapesium;
    @BindView(R.id.belahketupat) RelativeLayout belahketupat;
    @BindView(R.id.segitiga) RelativeLayout segitiga;
    @BindView(R.id.layanglayang) RelativeLayout layanglayang;
    @BindView(R.id.jajargenjang) RelativeLayout jajaargenjang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangun_datar);
        ButterKnife.bind(this);

        persegi.setOnClickListener(this);
        persegipanjang.setOnClickListener(this);
        lingkaran.setOnClickListener(this);
        segitiga.setOnClickListener(this);
        belahketupat.setOnClickListener(this);
        trapesium.setOnClickListener(this);
        jajaargenjang.setOnClickListener(this);
        layanglayang.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.persegi:
                Intent a = new Intent(BangunDatarActivity.this, PersegiActivity.class);
                startActivity(a);
                break;
            case R.id.persegipanjang:
                Intent b = new Intent(BangunDatarActivity.this, PersegiPanjangActivity.class);
                startActivity(b);
                break;
            case R.id.lingkarang:
                Intent g = new Intent(BangunDatarActivity.this, LingkaranActivity.class);
                startActivity(g);
                break;

            case R.id.segitiga:
                Intent c = new Intent(BangunDatarActivity.this, SegitigaActivity.class);
                startActivity(c);
                break;
            case R.id.belahketupat:
                Intent x = new Intent(BangunDatarActivity.this, BelahKetupatActivity.class);
                startActivity(x);
                break;
            case R.id.layanglayang:
                Intent f = new Intent(BangunDatarActivity.this, LayangActivity.class);
                startActivity(f);
                break;

            case R.id.jajargenjang:
                Intent e = new Intent(BangunDatarActivity.this, JajarGenjangActivity.class);
                startActivity(e);
                break;

            case R.id.trapesium:
                Intent d = new Intent(BangunDatarActivity.this, TrapesiumActivity.class);
                startActivity(d);
                break;
        }
    }
}
