package com.example.bytecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by chengjie on 2020-03-07
 * Description:
 */
public class AdSourceUtil {

    private static final String CONFIG_PATH = "/Users/chengjie/Desktop/adSource.properties";
    private static final String KEY_ALIFACE_AD = "aliFaceAd";
    private static final String SERVICE_ID_DENGHUO = "xling";


    /**
     * 获取刷脸广告初始化ID
     * 规则：默认使用灯火广告，读取到配置属性(aliFaceAd=null或aliFaceAd=)停止使用广告，文件不存在或者没有配置aliFaceAd字段都使用默认。
     * @return 空字符串""，或其他值
     */
    public static String getAliFaceAdServiceId() {
        String defaultAd = SERVICE_ID_DENGHUO;
        File file = new File(CONFIG_PATH);
        if (!file.exists())
            return defaultAd;
        InputStream is = null;
        Properties properties = new Properties();
        try {
            is = new FileInputStream(file);
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
            }
        }
        String value = properties.getProperty(KEY_ALIFACE_AD);
        if (value == null)
            return defaultAd;
        if (value.equals("null")||value.equals(""))
            return "";
        System.out.println("使用config配置："+value);
        return value;
    }

    public static void main(String[] args) {
        String aliFaceAdServiceId = getAliFaceAdServiceId();
        System.out.println(aliFaceAdServiceId);
    }

}
