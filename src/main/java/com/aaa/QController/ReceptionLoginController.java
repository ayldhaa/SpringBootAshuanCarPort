package com.aaa.QController;

import com.aaa.Entity.Customeruser;
import com.aaa.SdkTest.SDKDemo;
import com.aaa.Service.ReceptionUserService;
import com.montnets.mwgate.common.GlobalParams;
import com.montnets.mwgate.common.Message;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("ReceLogin")
public class ReceptionLoginController {
    @Autowired
    private ReceptionUserService receptionUserService;

    @RequestMapping("/Login")
    public String TestLogin()
    {
        return "Login/RegisterLogin";
    }

    /*测试参数页面*/
    @RequestMapping("/Ceshicanashu")
    public String Ceshicanashu()
    {
        return "Menu/TestCarMsg";
    }



    @PostMapping("/ReceptionLogin/{cname}/{cpass}")
    @ResponseBody
    public List<Customeruser> ReceptionLogin(@PathVariable("cname")String cname,@PathVariable("cpass")String cpass)
    {
        List<Customeruser> customeruserList =receptionUserService.showCustomerLogin(cname,cpass);
        return receptionUserService.showCustomerLogin(cname,cpass);
    }



    @RequestMapping("test1")
    public String Login()
    {
        System.out.println("进入方法");
        return "Menu/MenuAll";
    }

    @RequestMapping("test2")
    public String test2()
    {
        System.out.println("进入方法");
        return "Login/TestVue";
    }

    /*注册方法*/
    @RequestMapping("Register")
    public String Register()
    {
        return "Menu/Register";
    }


    /*注册方法*/
    @PostMapping("AddCustomerUser")
    public String AddCustomerUser(Customeruser customeruser)
    {
        System.out.println("进入方法");
        System.out.println("获取对象:"+customeruser);
        return "redirect:/ReceLogin/test1";
    }


    /*测试手机号*/

    @PostMapping("/SendTel/{Usertel}")
    @ResponseBody
    public String SendTel(@PathVariable("Usertel") String Usertel)
    {
        System.out.println("进入方法");
        System.out.println("获取手机号"+Usertel);


        String userid = "E10B9V";

        // 创建全局参数
        GlobalParams globalParams = new GlobalParams();
        // 设置请求路径
        globalParams.setRequestPath("/sms/v2/std/");
        // 设置是否需要日志 1:需要日志;0:不需要日志
        globalParams.setNeedLog(1);
        // 设置全局参数
        ConfigManager.setGlobalParams(globalParams);

        // 设置用户账号信息
        SDKDemo.setAccountInfo();

        // 是否保持长连接
        boolean isKeepAlive = true;
        // 实例化短信处理对象
        SmsSendConn smsSendConn = new SmsSendConn(isKeepAlive);

        // 单条发送
        SDKDemo.singleSend(smsSendConn, userid);

        try {
            // 参数类
            Message message = new Message();
            // 设置用户账号 指定用户账号发送，需要填写用户账号，不指定用户账号发送，无需填写用户账号
            message.setUserid(userid);
            // 设置手机号码 此处只能设置一个手机号码
            String tel ="0086";
            message.setMobile(tel+Usertel);
            // 设置内容
            String memos = UUID.randomUUID().toString().substring(0, 5);
            System.out.print(memos);
            message.setContent("您的验证码是"+memos+"，在10分钟内输入有效。如非本人操作请忽略此短信。");
            // 设置扩展号
            message.setExno("11");
            // 用户自定义流水编号
            message.setCustid("2019-12-10");
            // 自定义扩展数据
            message.setExdata("abcdef");
            // 业务类型
            message.setSvrtype("SMS001");

            // 返回的流水号
            StringBuffer returnValue = new StringBuffer();
            // 返回值
            int result = -310099;
            // 发送短信
            result = smsSendConn.singleSend(message, returnValue);
            // result为0:成功
            if (result == 0) {
                System.out.println("单条发送提交成功！");
                System.out.println(returnValue.toString());
                return memos;
            }
            // result为非0：失败
            else {
                System.out.println("单条发送提交失败,错误码：" + result);
            }
        } catch (Exception e) {
            // 异常处理
            e.printStackTrace();
        }


        // 查询余额
        SDKDemo.getBalance(smsSendConn, userid);

        //查询剩余金额或条数接口
        SDKDemo.getRemains(smsSendConn, userid);

        // 实例化短信处理对象
        SmsSendConn smsSendConnMo = new SmsSendConn(isKeepAlive);
        // 每次请求想要获取的上行的最大条数。
        int retsizeMo = 100;
        // 实例化获取上行线程

        // 实例化短信处理对象
        SmsSendConn smsSendConnRpt = new SmsSendConn(isKeepAlive);
        // 每次请求想要获取的状态报告的最大条数。


        // 移除用户账号(此处为移除用户账号功能示例，使用时请根据实际情况，有需要才调用此方法)
        SDKDemo.removeAccount(userid);


        return "1";
    }

}
