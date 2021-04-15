package com.zbhuang.zhs.service.impl;

import com.alipay.api.AlipayApiException;
import com.zbhuang.zhs.bean.AlipayBean;
import com.zbhuang.zhs.config.AlipayUtil;
import com.zbhuang.zhs.service.PayService;
import org.springframework.stereotype.Service;


/* 支付服务 */
@Service(value = "alipayOrderService")
public class PayServiceImpl implements PayService {
  @Override
  public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
    return AlipayUtil.connect(alipayBean);
   }
}
