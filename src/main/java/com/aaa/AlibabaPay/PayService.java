package com.aaa.AlibabaPay;

import com.alipay.api.AlipayApiException;

public interface PayService {


    String aliPay(AlipayBean alipayBean) throws AlipayApiException;

}
