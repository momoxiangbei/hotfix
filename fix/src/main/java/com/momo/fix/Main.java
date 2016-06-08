package com.momo.fix;

import android.content.Context;

import com.momo.fix.reflect.MethodUtils;

/**
 * Created by Momo on 2016/6/8.
 */
public class Main {
    private static Class mainClass;

    public static void init(Context context,int num){
        mainClass = Loader.getInstance().getClass(context,"com.momo.pro.Main");
        
        try {
            MethodUtils.invokeStaticMethod(mainClass, "init", new Object[]{context, num}, new Class[]{Context.class, int.class});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
