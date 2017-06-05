package com.lupawktu.contekan.BangunRuang.Kerucut;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lupawktu.contekan.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/17/2017.
 */

public class KerucutActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.showLuas)
    Button luas;
    @BindView(R.id.showVolume)
    Button volume;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_kerucut);
        ButterKnife.bind(this);

        getFragmentManager().beginTransaction()
                .add(R.id.fragment, new LuasFragmentKerucut())
                .commit();
        luas.setOnClickListener(this);
        volume.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.luas:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new LuasFragmentKerucut())
                        .commit();
                break;
            case R.id.volume:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new VolumeFragmentKerucut())
                        .commit();
                break;
        }
    }
}
