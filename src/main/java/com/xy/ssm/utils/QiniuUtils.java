package com.xy.ssm.utils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

/**
 * Created by wlonec on 2017/4/11.
 */
@Slf4j
public class QiniuUtils {

    Configuration cfg = new Configuration(Zone.zone2());
    //创建上传对象
    UploadManager uploadManager = new UploadManager(cfg);

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public String getUpToken(Map map){
        //密钥配置
        Auth auth = Auth.create(map.get("accesskey").toString(),map.get("secretKey").toString());
        //使用那个节点

        return auth.uploadToken(map.get("bucketName").toString());
    }

    public void upload(byte[] file, String key, Map map) throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(file, key,getUpToken(map));
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
            //打印返回的信息
            log.info("测试返回结果："+res.bodyString()+":hash:"+putRet.hash+":key:"+putRet.key);
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }

    /**
     * 上传文件
     * @param file byte
     * @param key 文件名
     * @param map
     * @throws Exception
     */
    public void uploadFile(byte[] file, String key, Map map) throws Exception{
        new QiniuUtils().upload(file,key,map);
    }
}