package jishaokang.util;

/**
 * Created by Administrator on 2017/4/30.
 */
public class EscapeString {
    public static String transfer(String origin){
        String result = new String(origin);
        result = result.replaceAll(" ","&nbsp;");
        result = result.replaceAll("<","&lt;");
        result = result.replaceAll(">","&gt;");
        result = result.replaceAll("\"","&quot;");
        result = result.replaceAll("\n","<br>");
        result = result.replaceAll("\r","<br>");
        result = result.replaceAll("\t","&nbsp;&nbsp;&nbsp;&nbsp;");
        result = result.replaceAll("&lt;br&gt;","<br>");
        System.out.println(result);
        return result;
    }
}
