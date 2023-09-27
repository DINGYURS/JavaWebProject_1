package com.example.controller;


import com.example.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController
{
    // 文件上传使用Post请求
    @PostMapping("/upload")
    // image需与前端form表单中的name属性值相对应
    public Result upload(String username, Integer age, MultipartFile image) throws IOException
    {
        // 获取原始文件名，以该名称存储在本地磁盘
        String originalFilename = image.getOriginalFilename();

        // 构造唯一文件名(随机UUID)
        int index = originalFilename.lastIndexOf(".");
        String fileExtension = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + fileExtension;


        // 文件储存本地目录
        image.transferTo(new File("W://"+newFileName));
        return Result.success();
    }
}
