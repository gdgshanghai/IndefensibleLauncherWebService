package com.dandelion.membership.dianpingsdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import com.dandelion.membership.constant.HackathonConstant;

public class DianpingSign {

    
    public static String sign(Map<String, String> paramMap) throws UnsupportedEncodingException {
        // 定义申请获得的appKey和appSecret
        String secret = HackathonConstant.DIANPING_SECRETKEY;
        String appKey = HackathonConstant.DIANPING_APPKEY;
        // 创建参数表


        // 对参数名进行字典排序
        String[] keyArray = paramMap.keySet().toArray(new String[0]);
        Arrays.sort(keyArray);

        // 拼接有序的参数名-值串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(appKey);
        for (String key : keyArray)
        {
            stringBuilder.append(key).append(paramMap.get(key));
        }
        
        stringBuilder.append(secret);
        String codes = stringBuilder.toString();
        
        // 字符串连接示例
        // XXXXXXXXcategory美食city上海formatjsonhas_coupon1has_deal1keyword泰国菜latitude31.21524limit20longitude121.420033offset_type0radius2000region长宁区sort7XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        
        // SHA-1编码， 这里使用的是Apache codec，即可获得签名(shaHex()会首先将中文转换为UTF8编码然后进行sha1计算，使用其他的工具包请注意UTF8编码转换)
        /*
         * 以下sha1签名代码效果等同
         * byte[] sha = org.apache.commons.codec.digest.DigestUtils.sha(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(codes));
         *  String sign = org.apache.commons.codec.binary.Hex.encodeHexString(sha).toUpperCase(); 
         */
        String sign = org.apache.commons.codec.digest.DigestUtils.shaHex(codes).toUpperCase();
        
        //签名示例 
        //7D78381BC58E1DB1DBA4BD965916FE6B4D5DC892
        stringBuilder = new StringBuilder(); 

		stringBuilder.append("appkey=").append(appKey).append("&sign=").append(sign);
        for (Entry<String, String> entry : paramMap.entrySet())
        {
        	String value = entry.getValue();
            stringBuilder.append('&').append(entry.getKey()).append('=').append(URLEncoder.encode(value, "UTF-8"));
        }
        String queryString = stringBuilder.toString();
        return queryString;
    }

}
