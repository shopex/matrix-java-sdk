package cn.shopex.open.sdk.java;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

public class EcosMd5Signer {
	private String token;
   
    
    public EcosMd5Signer(String token) {
    	this.token = token;
	}
    
    public String sign(Map<String, String> map) throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	Map<String, String> resultMap = this.sortMapByKey(map);
    	String sign = "";
    	String result = "";
    	String result1 = "";
    	for(Map.Entry<String, String> entity : resultMap.entrySet()) {
    		sign = sign + entity.getKey() + entity.getValue(); 
    		
    	}
  
			MessageDigest md5=MessageDigest.getInstance("MD5");
			result = this.toHex(md5.digest(sign.getBytes("utf-8")));
			result = result+this.token;
			result1 = this.toHex(md5.digest(result.getBytes("utf-8")));
			
			
	//	    result = md5.digest(sign.getBytes("utf-8")).toString();

		return result1;
    }
    public Map<String, String> sortMapByKey(Map<String, String> map) {
    	TreeMap<String, String> sortMap = new TreeMap<String, String>(new MapKeyComparator());
    	sortMap.putAll(map);
    	return sortMap;
    }
    
    private String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }
    
  
}
