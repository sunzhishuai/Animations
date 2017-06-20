package com.newborntown.animations.utils;

import com.newborntown.animations.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunzhishuai on 17/6/16.
 * E-mail itzhishuaisun@sina.com
 */

public class DataUtils {
    public static List<Integer> getDrawbles() {


        ArrayList<Integer> longs = new ArrayList<>();
        Integer[] arr = new Integer[]{
                R.mipmap.belle0, R.mipmap.belle1, R.mipmap.belle2,
                R.mipmap.belle3, R.mipmap.belle4, R.mipmap.belle5,
                R.mipmap.belle6, R.mipmap.belle7, R.mipmap.belle8,
                R.mipmap.belle9
        };
        for (int anArr : arr) {
            longs.add(anArr);
        }
        return longs;
    }
}
