package com.lupawktu.contekan.BangunDatar.Trapesium;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lupawktu.contekan.BangunDatar.DetailPresenter;
import com.lupawktu.contekan.BangunDatar.ModelDetail;
import com.lupawktu.contekan.BangunDatar.ViewDetail;
import com.lupawktu.contekan.R;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/12/2017.
 */

public class TrapesiumActivity extends AppCompatActivity implements View.OnClickListener, ViewDetail {
    @BindView(R.id.fragment)
    LinearLayout fragament;
    @BindView(R.id.showLuas)
    Button showLuas;
    @BindView(R.id.showKeliling)
    Button showKeliling;

    @BindView(R.id.deskripsi)
    TextView deskripsi;
    @BindView(R.id.websifat)
    TextView websifat;

    @BindView(R.id.rumusLuas)
    TextView rLuas;
    @BindView(R.id.rumusKeliling)
    TextView rKeliling;

    @BindView(R.id.ket)
    TextView ket;

    DetailPresenter detailPresenter = new DetailPresenter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapesium);
        ButterKnife.bind(this);

        String namafile = "trapesium.json";
        detailPresenter.loadData(namafile);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, new LuasTrapesiumFragment())
                .commit();

        showLuas.setOnClickListener(this);
        showKeliling.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.showKeliling :
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new KelilingTrapesiumFragment())
                        .commit();
                break;
            case R.id.showLuas :
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new LuasTrapesiumFragment())
                        .commit();
                break;
        }
    }

    @Override
    public void tampilDetail(ModelDetail model) {
        try {
            deskripsi.setText(model.getJson().getString("deskripsi"));
            websifat.setText(model.getJson().getString("sifat"));
            rLuas.setText("Luas : "+model.getJson().getString("luas"));
            rKeliling.setText("Keliling : "+model.getJson().getString("keliling"));
            ket.setText("Ket : "+model.getJson().getString("ket"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
