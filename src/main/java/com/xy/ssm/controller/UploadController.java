package com.xy.ssm.controller;

import com.xy.ssm.utils.QiniuUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wlone on 2017/3/17.
 */
@Controller
@Slf4j
public class UploadController {



    /**
     * WangEditor富文本编辑器上传到七牛云
     * @param upfile
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "photoUpload")
    public void uploadFile(@RequestParam("file")MultipartFile upfile,HttpServletResponse response) throws Exception {
        String fileName = upfile.getOriginalFilename();
        fileName="jianzhi"+"/"+UUID.randomUUID().toString()+"."+fileName.substring(fileName.lastIndexOf(".") + 1);
        byte[] fileByte = upfile.getBytes();
        try {
            Map map=new HashMap();
            map.put("accesskey","iTzLlaCz6o0SayfSaSU2kb0owoXc55cmULhWy5p8");
            map.put("secretKey","CmUYvXlah41ejFId4YlQmcfXBsKIh1IeIsUULfVp");
            map.put("bucketName","knowledge");
            new QiniuUtils ().uploadFile(fileByte, fileName,map);
            response.getWriter().write("http://image.letters7.com/"+fileName);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("state", "上传失败!");
        }
    }
}
