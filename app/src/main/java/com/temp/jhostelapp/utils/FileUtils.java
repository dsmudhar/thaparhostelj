package com.temp.jhostelapp.utils;

import android.content.Context;

import com.temp.jhostelapp.utils.Utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by DSM_ on 1/30/16.
 */
public class FileUtils {

    public static void writeString(File file, String string) throws IOException {

        FileOutputStream f = new FileOutputStream(file);
        f.write(string.getBytes());
        f.close();

    }

    public static boolean writeStringCache(Context context, String filename, String string) {
        try {
            File file = new File(context.getCacheDir(), filename);
            writeString(file, string);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String readCache(Context context, String filename) {

        try {
            File file = new File(context.getCacheDir(), filename);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null)
                stringBuilder.append(line).append("\n");
            bufferedReader.close();
            return Utils.emptyToNull(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
