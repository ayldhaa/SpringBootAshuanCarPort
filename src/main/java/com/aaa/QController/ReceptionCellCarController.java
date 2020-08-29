package com.aaa.QController;

import com.aaa.Dao.CustomerDao;
import com.aaa.Entity.Car_series;
import com.aaa.Entity.Customercellcar;
import com.aaa.Entity.Customeruser;
import com.aaa.Imple.ReceptionCellCarImple;
import com.aaa.Service.Car_seriesService;
import com.aaa.Service.ReceptionCellCarService;
import com.aaa.Service.ReceptionUserService;
import com.aaa.Util.HttpUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("CellCar")
public class ReceptionCellCarController {

    @Autowired
    private Car_seriesService car_seriesService;

    @Autowired
    private ReceptionUserService receptionUserService;

    @Autowired
    private ReceptionCellCarService cellCarService;



    @PostMapping("/showCarMsg/{CarJpg}")
    @ResponseBody
    public String TestCar(@PathVariable("CarJpg") String CarJpg)
    {
        String host = "https://chexing.market.alicloudapi.com";
        String path = "/do";
        String method = "POST";
        String appcode = "519f7bfc9d854427b72ee3b6c2ac6b84";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        //根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        Map<String, String> querys = new HashMap<String, String>();
        Map<String, String> bodys = new HashMap<String, String>();
        bodys.put("baike", "0");

        InputStream in =null;
        byte[]data =null;
        try
        {
            String car1= CarJpg;
            String TrueCar =car1 .replace("\"", "");
            in =new FileInputStream("E:\\1-三期项目总览\\UserCellCar\\"+TrueCar+"");
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        BASE64Encoder encoder =new BASE64Encoder();
        String TestMsg =encoder.encode(data);

        bodys.put("image",TestMsg);
        bodys.put("num", "5");



        try {

            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            //获取response的body
            String c2 =EntityUtils.toString(response.getEntity());
            System.out.println(c2);
            return c2;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/showCarCname/{full_name}")
    @ResponseBody
    public List<Car_series> showCarCname(@PathVariable("full_name") String full_name)
    {
        System.out.println("进入方法");
        System.out.println("获取查询"+car_seriesService.showCar_series(full_name));
        return car_seriesService.showCar_series(full_name);
    }

    @PostMapping("/GetCarMsgOk/{CarGetId}")
    @ResponseBody
    public String GetCarMsgOk(@PathVariable("CarGetId") String CarGetId) throws Exception
    {
        System.out.println("进入方法,开始获取最后参数");
        String host = "https://jisucxdq.market.alicloudapi.com";
        String path = "/car/detail";
        String method = "GET";
        String appcode = "519f7bfc9d854427b72ee3b6c2ac6b84";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("carid", CarGetId);

        HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
        String c =EntityUtils.toString(response.getEntity());
        System.out.println("最后参数:"+c);
        return c;
    }

    @PostMapping("/CheckUserName/{UserName}")
    @ResponseBody
    public List<Customeruser> CheckUserName(@PathVariable("UserName") String UserName)
    {
        return receptionUserService.showCustomeruser(UserName);
    }


    @PostMapping("addReceptionCellCarController")
    @ResponseBody
    public Integer addReceptionCellCarController(@RequestBody Customercellcar customercellcar){
        customercellcar.setCIid(0);
        return cellCarService.AddCellCar(customercellcar);
    };

    @PostMapping("/showUCellCar/{cuid}")
    @ResponseBody
    public List<Customercellcar> showUCellCar(@PathVariable("cuid")Integer cuid)
    {
        return cellCarService.showCustomerCellCar(cuid);
    }













}
