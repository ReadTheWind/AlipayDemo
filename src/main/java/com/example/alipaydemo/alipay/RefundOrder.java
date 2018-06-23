package com.example.alipaydemo.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeRefundModel;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.alipay.api.response.AlipayTradeRefundResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 退款例子
 */
@Component
public class RefundOrder {
	Logger log= LoggerFactory.getLogger(RefundOrder.class);

	public String refundAlipay(){
		log.info("【开始处理支付宝退款】");
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

		//设置请求参数
		AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();

		AlipayTradeRefundModel model =new AlipayTradeRefundModel();
		//商户订单号，商户网站订单系统中唯一订单号
		model.setOutTradeNo("20180508003");
		//支付宝交易号
//		model.setTradeNo("");
		//请二选一设置
		//需要退款的金额，该金额不能大于订单金额，必填
		model.setRefundAmount("1");
		//退款的原因说明
		model.setRefundReason("测试退款");
		//标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
		model.setOutRequestNo("R001");

		alipayRequest.setBizModel(model);
		// 设置异步通知地址
//		alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
		// 设置同步地址
//		alipayRequest.setReturnUrl(AlipayConfig.return_url);
		//请求
		String result=null;
		try {
//			AlipayTradeRefundResponse response = alipayClient.pageExecute(alipayRequest);
			AlipayTradeRefundResponse response = alipayClient.execute(alipayRequest);
			String code=response.getCode();
			if ("10000".equals(code)){
				result=response.getMsg();
				log.info("支付宝退款成功");
			}else {
				result=response.getMsg();
			}
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		log.info("【支付宝退款返回result：】"+result);
		return result;
	}




}
