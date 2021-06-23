package cht.designpattern.structuralpatterns.adapterpattern.interfaces.impl;

import cht.designpattern.structuralpatterns.adapterpattern.interfaces.AdvancedMediaPlayer;

/**
 * TODO
 *
 * @author chenhantao
 * @since 2021/6/24
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing Mp4 file. Name: " + fileName);
    }

    @Override
    public void platMKV(String fileName) {

    }
}
