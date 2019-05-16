package com.mum.edu.geek.util;

import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtil {


    public static List<String> readFile(MultipartFile file) throws Exception{
        Path path = Paths.get("file.txt");
        file.transferTo(path);
        List<String> list = Files.readAllLines(path);
        Files.delete(path);
        return list;
    }



}
