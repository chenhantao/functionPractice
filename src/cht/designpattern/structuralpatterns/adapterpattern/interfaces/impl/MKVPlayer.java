package cht.designpattern.structuralpatterns.adapterpattern.interfaces.impl;

import cht.designpattern.structuralpatterns.adapterpattern.interfaces.AdvancedMediaPlayer;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/24
 */
public class MKVPlayer implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {

    }

    @Override
    public void platMKV(String fileName) {
        System.out.println("Playing MKV file. Name: " + fileName);
    }
}
