package com.sam.controller;

import com.sam.dto.FileInfo;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Author: huangxin
 * @Date: Created in 下午4:46 2018/2/26
 * @Description:
 */
@RequestMapping("/file")
@RestController
public class FileController {

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        String folder = "./";

        File localFile = new File(folder, System.currentTimeMillis() + ".txt");

//        file.getInputStream();
        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());

    }

    @GetMapping("/{id}")
    public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
        try (
                InputStream inputStream = new FileInputStream(new File("./", id + ".txt"));
                OutputStream outputStream = response.getOutputStream();
        ) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition","attachment;filename=test.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        } catch (Exception e) {
        }
    }
}
