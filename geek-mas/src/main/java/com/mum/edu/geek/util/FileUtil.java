package com.mum.edu.geek.util;

import org.springframework.web.multipart.MultipartFile;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.*;

public class FileUtil {

    public static List<String> readFile(MultipartFile file) throws Exception{
        Path path = Paths.get("file.txt");
        file.transferTo(path);
        List<String> list = Files.readAllLines(path);
        Files.delete(path);
        return null;
    }

    public static List<String> readFileFaster(MultipartFile file) throws Exception{

        List<String> lines = new ArrayList<>();
        CharBuffer charBuffer = null;

        Path pathToRead = Paths.get(LocalDateTime.now().getNano()+".txt");
        file.transferTo(pathToRead);

        try (FileChannel fileChannel =(FileChannel) Files.newByteChannel(
                pathToRead, EnumSet.of(StandardOpenOption.DELETE_ON_CLOSE))) {
            MappedByteBuffer mappedByteBuffer = fileChannel
                    .map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            charBuffer = Charset.forName("UTF-8").decode(mappedByteBuffer);
            Scanner scanner = new Scanner(charBuffer);
            while(scanner.hasNextLine()){
                lines.add(scanner.nextLine().toString());
            }

            mappedByteBuffer.clear();
        }

        return lines;
    }

}