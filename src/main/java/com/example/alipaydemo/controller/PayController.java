package com.example.alipaydemo.controller;

import com.example.alipaydemo.alipay.PayUtil;
import com.example.alipaydemo.alipay.QueryRefundOrder;
import com.example.alipaydemo.alipay.QueryTrade;
import com.example.alipaydemo.alipay.RefundOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处理支付
 */
@RestController
public class PayController {

	Logger log= LoggerFactory.getLogger(PayController.class);

	@Autowired
	PayUtil payUtil;


	/**
	 * 处理下单支付入口
	 * @return
	 */
	@RequestMapping("/payorder")
	public  String payOrder(){
		log.info("【支付宝支付扫码支付处理开始】");
		return  payUtil.doAliPayWapReq();
	}

	@Autowired
	RefundOrder refundOrder;

	/**
	 * 处理退款入口
	 * @return
	 */
	@RequestMapping("/refundorder")
	public String refund(){
		String s=refundOrder.refundAlipay();
		return s;
	}

	@Autowired
	QueryTrade queryTrade;

	/**
	 * 查询交易入口
	 * @return
	 */
	@RequestMapping("/queryTrade")
	public String queryTrade(){
		return  queryTrade.queryOrder();
	}

	@Autowired
	QueryRefundOrder queryRefundOrder;

	/**
	 * 查询退款交易入口
	 * @return
	 */
	@RequestMapping("/queryRefundOrder")
	public  String queryRefundOrder(){
		return  queryRefundOrder.queryRefound();
	}
}
