package com.example.alipaydemo.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeFastpayRefundQueryModel;
import com.alipay.api.request.AlipayTradeFastpayRefundQueryRequest;
import com.alipay.api.response.AlipayTradeFastpayRefundQueryResponse;
import org.springframework.stereotype.Component;

/**
 * 退款查询
 */
@Component
public class QueryRefundOrder {

	public String queryRefound(){

		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

		//设置请求参数
		AlipayTradeFastpayRefundQueryRequest alipayRequest = new AlipayTradeFastpayRefundQueryRequest();

		AlipayTradeFastpayRefundQueryModel model=new AlipayTradeFastpayRefundQueryModel();
		//请求退款接口时，传入的退款请求号，如果在退款请求时未传入，则该值为创建交易时的外部交易号，必填
		model.setOutRequestNo("R001");
		//商户订单号，商户网站订单系统中唯一订单号
		model.setOutTradeNo("20180508001");
		//支付宝交易号
//		model.setTradeNo("");
		alipayRequest.setBizModel(model);
		String result=null;
		try{
			AlipayTradeFastpayRefundQueryResponse response=alipayClient.execute(alipayRequest);
			String tradeNo=response.getOutTradeNo();
			String refoundAmount=response.getRefundAmount();
			String refundReason=response.getRefundReason();
			String totalAmount=response.getTotalAmount();
			result=tradeNo+";"+refoundAmount+";"+refundReason+";"+totalAmount;
		}catch (AlipayApiException e){
			e.printStackTrace();
		}
		return result;
	}

}
