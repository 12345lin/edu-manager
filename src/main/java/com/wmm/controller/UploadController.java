package com.wmm.controller;

import com.wmm.pojo.Result;
import com.wmm.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j

public class UploadController {
//    /**
//     * 本地磁盘上传
//     * @param name
//     * @param age
//     * @param file
//     * @return
//     * @throws IOException
//     */
//    @PostMapping("/upload")
//    public Result upload(String  name, Integer age, MultipartFile  file) throws IOException {
//        log.info("接收到的参数，{}，{}，{}", name, age, file );
//        //获取原始文件扩展名
//        String[] split = file.getOriginalFilename().split("\\.");
//        String suffix = split[split.length - 1];
//
//        String newFileName = UUID.randomUUID().toString() + "." + suffix;
//        //保存文件
//        file.transferTo(new File("E:/java课程资源/images/" + newFileName));
//        return Result.success();
//    }
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传文件：{}", file.getOriginalFilename());
        //将文件交给OSS管理

        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        log.info("文件上传OSS成功，{}", url);

        return Result.success(url);
    }
}
