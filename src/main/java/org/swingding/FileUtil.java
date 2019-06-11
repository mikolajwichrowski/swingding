package main.java.org.swingding;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileUtil {
    public static String fileReader(String fileName)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();
            String content = stringBuilder.toString();
            return content;
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }
}
