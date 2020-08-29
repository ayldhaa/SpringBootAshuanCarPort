package com.aaa.QController;

import com.aaa.AlibabaPay.Alipay;
import com.aaa.AlibabaPay.AlipayBean;
import com.aaa.AlibabaPay.AlipayUntil;
import com.alipay.api.AlipayApiException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
public class ReceptionPayController {

    @Resource
    private Alipay aliPay;


    @PostMapping(value = "order/alipay")
    public String alipay(@RequestBody AlipayUntil alipayUntil) throws AlipayApiException {

        AlipayBean alipayBean = new AlipayBean();
        alipayBean.setOut_trade_no(alipayUntil.getOutTradeNo());
        alipayBean.setSubject(alipayUntil.getSubject());
        alipayBean.setTotal_amount(alipayUntil.getTotalAmout());
        alipayBean.setBody(alipayUntil.getBody());
        System.out.println(alipayBean);
        return aliPay.pay(alipayBean);
//        return "success";
    }


}
