package com.aaa.Util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/***
 * 图片上传的工具类处理
 */
public class ImageUploadUtils {

    public static /**/String imageUpload(MultipartFile file,String dateFormat,String uploadPath ,HttpSession session) throws IOException {
        String extension = "."+ FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ UUID.randomUUID().toString().replace("-","")+extension;
        file.transferTo(new File(uploadPath,newFileName));
        return dateFormat+"/"+newFileName;
    }
}