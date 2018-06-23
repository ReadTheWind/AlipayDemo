package com.example.alipaydemo.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeQueryModel;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeQueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * 查询交易信息
 */
@Component
public class QueryTrade {

	Logger log= LoggerFactory.getLogger(QueryTrade.class);

	public  String queryOrder(){
		log.info("【查询交易信息开始处理】");
		//获得初始化的AlipayClient
		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

		//设置请求参数
		AlipayTradeQueryRequest alipayRequest = new AlipayTradeQueryRequest();

		AlipayTradeQueryModel model =new AlipayTradeQueryModel();
		//商户订单号，商户网站订单系统中唯一订单号
		model.setOutTradeNo("20180508001");
		//支付宝交易号
//		model.setTradeNo("00");

		alipayRequest.setBizModel(model);
		String result=null;
		try{
			AlipayTradeQueryResponse response=alipayClient.execute(alipayRequest);
			String tatalAmount=response.getTotalAmount();
			String tradeNo=response.getTradeNo();
			String outTradeNo=response.getOutTradeNo();
			result=tatalAmount+";"+tradeNo+";"+outTradeNo;
			log.info("查询结果："+result);
		}catch (AlipayApiException e){
			e.printStackTrace();
		}
		return result;
	}




}
