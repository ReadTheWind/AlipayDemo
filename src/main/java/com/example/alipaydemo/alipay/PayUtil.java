package com.example.alipaydemo.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 付款工具类
 */
@Component
public class PayUtil {

	Logger log= LoggerFactory.getLogger(PayUtil.class);

	public String doAliPayWapReq() {
		//初始化Alipayclient
		AlipayClient alipayClient =new DefaultAlipayClient(
				AlipayConfig.gatewayUrl,AlipayConfig.app_id,AlipayConfig.merchant_private_key,
				"json",AlipayConfig.charset,AlipayConfig.alipay_public_key,AlipayConfig.sign_type);

		//设置请求参数
		AlipayTradePagePayRequest alipay_request = new AlipayTradePagePayRequest();

		// 封装请求支付信息
		AlipayTradePagePayModel model=new AlipayTradePagePayModel();
		//商户订单号，商户网站订单系统中唯一订单号，必填
		model.setOutTradeNo("20180508004");
		//订单名称，必填
		model.setSubject("测试订单");
		//付款金额，必填
		model.setTotalAmount("1");
		//商品描述，可空
		model.setBody("测试商品");
		model.setProductCode("FAST_INSTANT_TRADE_PAY");
		alipay_request.setBizModel(model);
		// 设置异步通知地址
		alipay_request.setNotifyUrl(AlipayConfig.notify_url);
		// 设置同步地址
		alipay_request.setReturnUrl(AlipayConfig.return_url);
		String payUrl = null;
		try {
//			Object obj=alipayClient.pageExecute(alipay_request);
			payUrl = alipayClient.pageExecute(alipay_request).getBody();
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		log.info("【支付宝支付返回payurl：】"+payUrl);
		return payUrl;

	}
}
