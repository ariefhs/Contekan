package com.lupawktu.contekan.BangunRuang;

import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.VolumeModel;

/**
 * Created by Mind on 5/15/2017.
 */

public interface MainView {
    void tampilLuas(LuasModel luasModel);
    void tampilVolume(VolumeModel volumeModel);
    void tampilKeliling(KelilingModel kelilingModel);
}
