package com.example.alipaydemo.alipay;

/**
 * 支付宝支付配置文件
 */
public class AlipayConfig {

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016082700321599";

	// 商户私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCgzGPJeJcJhcoeTabq4nTRdv/xYzIHSAucBAT2pZuyzbv2+Fas2AZsn+kNmyALR9+XPpMRo8quNVx0zHrHpXMX2QJOck2a/ytAmNXL0Jdo43zQ2AmsM0DNQq77HlKeEBypqe65JP5RgNM3yHdiKy+LG1ZyaWDJ92gMwr8L8pDGJ7g+OplgmQqR/Ta6zwjbmx/YeKBuh7qMRmON0XWmkoIU7lOSVUHXbAlue1+StBHSWOLPH/Z1sRF/5b91TtfuoJ+S/iQmfzJIlLqQJ982V3a/vulbN7S4lwCBL49nmZAZboc0KkA4tR9CCxMkZwSjKRic0CW3ToGJdhCBAAMnJmuJAgMBAAECggEAZ/0mf3HEQ71JRCW1z+tZ3ujVhrc+8GSQVXpn91aMhar1ZzedXjRqmy8jWdA7ffAiUj5+gAbsGZOa0lI3CQwfjYmjKzZSp+1jfGgaw6+Ha6bK3okIYFvZCaWZYf9vMJd84eBq6UNaUT0927KCOnNxUMYCNwWdOaANo0sCoGhjZjHZoFjRAq59YeVhGcgH6/8w8a4/0DEJcXRA2cNdZEwBAXUF3NUIaYRfPvFy9srrXWk773Jjj5cFBAzjy+4+iHG8bwPgUhoNSl027tDTfSz2+TQqGo65SkroxRBuE8YKCaiAfZDak5DInGNfS4Pl1mKl0QZ/RA4AOSaOJ/wkK6SoLQKBgQDv50IgSxTVIFuR3ZA7VI4r4m+Jl0WvAVetqnfEyzpUb5+hNVOHxokZger10wjRWOv8Z7igyY0qjNmZJV31RAvPhC+2B1ChgDqq1fg5pUktC4bGQjoXTZrWmKnybrVmbpvVkDntSNIgiAzYok0NJTcZDnWxrV1wGcfy6jlBleLL/wKBgQCrll8X1aH5ahnNBjcE1MAg6abqYfP3V2lojkwvImeOAfOAINE0awmBSmflcZIG9sd542ybkC7RsAhQqTCpH6ZnA9RcDL6941SDyF6vht6OxCDThrkoHKYlO730dOaqHn0gzZPZKjn1zFM3KaLYwHyeYMEZE6cTEnzmBbVH8CZodwKBgGu0iKSU8Mpql5HaRjnM0XN0Wp0MNDXIxYNriA/rKcnkv2cR2OmZQc4Y3NL2pvvOD0yniGVvd5hF2h9+fjtyDFdjQkRX7mRDfJNcMvA2e67kgOKbsxbpOX3k1k/IUlqliAMOmGMmkWgXjKTp4Ovo7F6sdjyJ1+xPNsyhSYlfcI4jAoGAJNvSZY5QkwFFtZMGMpV5CBjo8CRGgfVXAUy/9MgRMqIcqoNiLT5o9ksDcngpBDHyu64s4GXiiMylnJ4bg9j2p95cucFLIAM7XmumW1I/cK+U1Zt1Hra4wfrJXT/XZOfTvT4r6lR1yuUvYwQgpSsEGglysW5VT3WDOu4y+NcPiRUCgYEApulh9W0olDkBgnZpPGhuviso0zEs6bOrZZyeuP+9EbNsy7PbpsroZgUU+9/jh4Uj+a/ihLXkrsngGB8r/8zTFc4+ZAimHVvBwWPt5tt37upUWdiVUW/uliajx7mPg8895QjCRxJlDVJVeTH097g8eDulK9ifXgXIE16HRMKlvYg=";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAupF90y7e/JRvva1uEhTgmiDuoZ+cuGXsq/GWgaR4e6oHtY737Zu9HewQ0/8bHAjfdTvKq81TzBCndhgY+M8zo8gXx0ieNcG1WEGyxjSIT4+eyVOuLQ8/HPJlD9cwfWJdZ2TvPorvGoEPGuy4+WJfsm1OKF/WrwVwryOe+ZMSuN/NjAPbmAXvY/jnGuTmLoLAhVBpOPACQ3bnJWbgXFLN906fdH+OHCxa1+UVpRC269i/QwDL9Uvbg68ZXY2DwhycfAjl1QsBI6D40AbzQaEhmZyvsIHvG54s2zLneRwA4MT0YiXb0EM0sgezz0WADabA6oT6IRuo4z3CAnTy6w3SMQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://192.168.2.71:8080/alinotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://192.168.2.71:8080/alinotify";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

	// 日志路径
	public static String log_path = "F:\\";


}
