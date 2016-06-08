package com.momo.pro;

import android.content.Context;
import android.util.Log;

/**
 * Created by Momo on 2016/6/8.
 */
public class Main {

    public static void init(Context context,int num){
        OtherOne otherOne = new OtherOne();
        OtherTwo otherTwo = new OtherTwo();

        otherOne.setNum(num);
        otherTwo.setNum(num);

        int number = otherOne.getNum()+otherTwo.getNum();
        Log.d("momotest",number+"");
    }
}
