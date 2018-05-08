# matrix-java-sdk

shopex matrix的开发工具包

## ECOS.md5签名工具

 - 用法：
 ```
 import cn.shopex.open.sdk.java.EcosMd5Signer;
  	  public static void main(String[] args) {
          Map<String, String> map = new TreeMap<String, String>();
          map.put("method", "aaa");
          map.put("to_api_v", "2.0");
          map.put("task", "abced");
          map.put("direct", "true");
          String token ="aaaaaaaaaa";
          EcosMd5Signer signer = new EcosMd5Signer(token);
          String output = "";
          try {
              output = signer.sign(map);
          } catch (NoSuchAlgorithmException e) {
              e.printStackTrace();
          } catch (UnsupportedEncodingException e) {
              e.printStackTrace();
          }
          //894E015DF45894623D756F0D0B15B78F
          System.out.println(output);
      }
 ```
