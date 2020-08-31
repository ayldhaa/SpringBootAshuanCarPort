package com.aaa.QController;

import com.aaa.Entity.CustomerTestIngPeople;
import com.aaa.Util.UploadUtils;
import com.aaa.Util.UserShopUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("Shop")
public class ReceptionUserShopCarController {


    /*车辆图片上传*/
    @PostMapping("/upload1")
    @ResponseBody
    public String upload1(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();

        // 存放上传图片的文件夹
        File fileDir = UserShopUploadUtils.getImgDirFile();
        // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
        System.out.println(fileDir.getAbsolutePath());

        try {
            // 构建真实的文件路径
            File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
            System.out.println(newFile.getAbsolutePath());
            // 上传图片到 -》 “绝对路径”
            file.transferTo(newFile);
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*添加检车商*/
    @PostMapping("/Addcustomertestingpeople")
    @ResponseBody
    public Integer Addcustomertestingpeople(@RequestBody CustomerTestIngPeople customerTestIngPeople)
    {
        System.out.println("获取检车商用户:"+customerTestIngPeople);
        return 1;
    }


}
