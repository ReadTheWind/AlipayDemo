package com.example.alipaydemo.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.example.alipaydemo.alipay.AlipayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 处理支付回调
 */
@RestController
public class NotifyController {

	private  Logger log= LoggerFactory.getLogger(NotifyController.class);

	@RequestMapping("alinotify")
	public String aliNotify(HttpServletRequest request){
		log.info("【支付宝支付回调通知处理开始】");
		Map<String,String> params=new HashMap<String, String>();
		Map requestParams =request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			params.put(name, valueStr);
		}
		log.info("通知请求数据:reqStr={}",params);
		if(params.isEmpty()) {
			log.error("请求参数为空", params);
			return "fail";
		}

		//异步验签
		log.info("异步验签开始");
		boolean verify_result = false;
		try {
			verify_result = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, "RSA2");
		} catch (AlipayApiException e) {
			log.error( "AlipaySignature.rsaCheckV1 error1");
		}
		if (!verify_result) {
			log.error("AlipaySignature.rsaCheckV1 error2");
			return "AlipaySignature.rsaCheckV1 error";
		}
		log.info("异步验签成功");
		return "success";
	}
}
