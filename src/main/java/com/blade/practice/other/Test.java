package com.blade.practice.other;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
//        testMod();
        testString();
    }

    private static void testMod() {
        // 取整
        System.out.println(5 / 2);
        // 取余
        System.out.println(5 % 2);
    }

    private static void testCpuCores() {
    }

    private static void testString() {
        String s = "{\"手机号码\" : \"13345678910\",\"证件号码\" : \"133456789105554714\"}";

//        String pattern = "[1][3,4,5,7,8][0-9]{9}\"";
//        String b = s.replaceAll(pattern, "jjj");
//        System.out.println(b);

        String text="wefawefaafickdbbjoasdfcweccwerqeasdaajfnblsdbboioe";
        String replaceText="&";//匹配到 替换的文字
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[1-9A-Z][\\d-]{12,22}\"");
        Matcher matcher= pattern.matcher(s);
        while(matcher.find()){
            String b=matcher.group();//得到匹配的结果
            String c = b.substring(0, b.length() - 8) + "****" + b.substring(b.length() - 4);
            matcher.appendReplacement(sb, c);
            System.out.println(b);
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}
