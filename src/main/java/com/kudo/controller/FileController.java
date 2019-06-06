package com.kudo.controller;

import com.kudo.utils.FileHandleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        String fileURL = FileHandleUtil.upload(file.getInputStream(), "image/", file.getOriginalFilename());
        return "文件存放路径为: " + fileURL;
    }
}
