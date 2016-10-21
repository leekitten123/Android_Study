package com.example.hyojin.android_study;

/**
 * Created by hyojin on 2016-10-15.
 */
public class MyAverage extends MyValues {

    int getResult () {

        ans = 0 ;

        for (int tmp : value) {

            ans += tmp ;
        }

        ans /= value.length ;

        return ans ;
    }
}
