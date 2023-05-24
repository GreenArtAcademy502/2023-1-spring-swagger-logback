package com.green.board7.fileupload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileuploadService {

    @Value("${file.dir}")
    private String fileDir;

    public void fileUpload(MultipartFile img) {
        System.out.println("fileDir : " + fileDir);

        //원래 파일 이름 추출
        String originFileName = img.getOriginalFilename();

        //파일 이름으로 사용할 uuid 생성
        String uuid = UUID.randomUUID().toString();

        int dotIdx = originFileName.lastIndexOf(".");
        String ext = originFileName.substring(dotIdx);

        String savedFileName = uuid + ext;
        String savedFilePath = fileDir + savedFileName;

        File file = new File(savedFilePath);
        try {
            img.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
