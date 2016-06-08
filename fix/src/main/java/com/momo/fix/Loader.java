package com.momo.fix;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import dalvik.system.DexClassLoader;

/**
 * Created by Momo on 2016/6/8.
 */
public class Loader {

    private static Loader instance;
    private Loader(){}
    public static Loader getInstance(){
        if (instance == null){
            instance = new Loader();
        }
        return instance;
    }

    private File filesDir;
    private ClassLoader classLoader;
    private String localDexPath;

    public Class<?> getClass(Context context,String name){
        File filesDir = context.getDir("fix", Context.MODE_PRIVATE);
        if (!filesDir.exists()) filesDir.mkdir();

        String dir = context.getCacheDir().getAbsolutePath();
        localDexPath = dir + File.separator + "momo.apk";

        removePath(context);

        ClassLoader appLoader = context.getClassLoader();
        classLoader = new DexClassLoader(localDexPath, filesDir.getAbsolutePath(), null, appLoader);
        Class myClass = null;
        try {
            myClass = classLoader.loadClass(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return myClass;
    }

    private void removePath(Context context){
        AssetManager assets = context.getAssets();
        InputStream open = null;
        try {
            open = assets.open("momo");
            copyFile(open, localDexPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(InputStream src, String dst) throws IOException {
        BufferedInputStream in = null;
        BufferedOutputStream ou = null;
        try {
            in = new BufferedInputStream(src);
            ou = new BufferedOutputStream(new FileOutputStream(dst));
            byte[] buffer = new byte[8192];
            int read;
            while ((read = in.read(buffer)) != -1) {
                ou.write(buffer, 0, read);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
            if (ou != null) {
                try {
                    ou.close();
                } catch (Exception e) {
                }
            }
        }
    }








}
