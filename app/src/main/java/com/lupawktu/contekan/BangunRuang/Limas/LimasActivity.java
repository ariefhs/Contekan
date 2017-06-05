package com.lupawktu.contekan.BangunRuang.Limas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lupawktu.contekan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/18/2017.
 */

public class LimasActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.showLuas)
    Button luas;
    @BindView(R.id.showVolume)
    Button keliling;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limas);
        ButterKnife.bind(this);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, new LuasLimasFragment())
                .commit();
        luas.setOnClickListener(this);
        keliling.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.showLuas:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new LuasLimasFragment())
                        .commit();
                break;
            case R.id.showVolume:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new VolumeLimasFragment())
                        .commit();
                break;
        }
    }

}
