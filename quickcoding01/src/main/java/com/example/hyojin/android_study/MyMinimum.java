package com.example.hyojin.android_study;

/**
 * Created by hyojin on 2016-10-15.
 */
public class MyMinimum  extends MyValues{

    int getResult () {

        int ans = value[0] ;

        for (int i = 0 ; i < value.length ; i++) {

            if (ans > value[i]) {

                ans = value[i];
            }
        }

        return ans ;
    }
}
