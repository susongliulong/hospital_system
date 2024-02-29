package com.sun.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {

    /**
     * 去YAML文件里找
     */
    @Value("${liulong.path}")
    private String basePath;

    /**
     * 上传
     *
     * @param file
     * @throws IOException
     */
    @PostMapping("/upload")
    public R upload(MultipartFile file) throws IOException {
        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        log.info("原始文件名:{}", originalFilename);
        // 获取后缀
        String extension = "." + FilenameUtils.getExtension(originalFilename);
        log.info("文件后缀:{}", extension);
        // 使用原始文件名，后上传相同文件名的文件，会覆盖原文件，所以用UUID防止文件名重复
        String fileName = UUID.randomUUID() + extension;
        log.info("新文件名称:{}", fileName);
        // 判断当前图片存储目录是否存在，不存在创建一个
        File directory = new File(basePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
        // 保存文件到指定位置
        file.transferTo(new File(basePath + fileName));
        return R.success(fileName);
    }

    /**
     * 下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response) throws Exception {
        // 读取文件
        FileInputStream fileInputStream = new FileInputStream(basePath + name);
        // 文件写回浏览器
        ServletOutputStream outputStream = response.getOutputStream();

        response.setContentType("image/jpeg");

        int len;
        byte[] bytes = new byte[1024];
        while (-1 != (len = fileInputStream.read(bytes))) {
            outputStream.write(bytes, 0, len);
            outputStream.flush();
        }
        // 关流
        outputStream.close();
        fileInputStream.close();
    }
}
