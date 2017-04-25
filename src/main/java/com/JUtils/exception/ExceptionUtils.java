package main.java.com.JUtils.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Java如何将Exception.printStackTrace()转换为String输出
 * http://lijun0349-163-com.iteye.com/blog/1073356
 * Created by zd.yao on 2017/4/24.
 */
public class ExceptionUtils {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            String[] arr = {"111", "222"};
            arr[2] = "fff";
        } catch (Exception e) {
            String info = getErrorInfoFromException(e);
            System.out.println(info);
        }
    }

    public static String getErrorInfoFromException(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";
        } catch (Exception e2) {
            return "bad getErrorInfoFromException";
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
