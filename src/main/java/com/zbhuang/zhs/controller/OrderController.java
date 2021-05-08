package com.zbhuang.zhs.controller;

import com.alipay.api.AlipayApiException;
import com.zbhuang.zhs.bean.AlipayBean;
import com.zbhuang.zhs.service.PayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/* 订单接口 */
@RestController
@RequestMapping("order")
public class OrderController {
  @Resource
  private PayService payService;//调用支付服务​
  /*阿里支付*/
  @PostMapping(value = "/alipay")
  public String alipay(String out_trade_no,String subject,String total_amount,String body) throws AlipayApiException {

    return payService.aliPay(new AlipayBean()
                        .setBody(body)
         .setOut_trade_no(out_trade_no)
         .setTotal_amount(new StringBuffer().append(total_amount))
         .setSubject(subject));
   }

  /*阿里支付*/
  @ResponseBody
  @RequestMapping("/notifyUrl")
  public void notifyUrl(HttpServletRequest request) throws Exception {
    System.out.println("========================================支付回调=====================================");
  }
}
