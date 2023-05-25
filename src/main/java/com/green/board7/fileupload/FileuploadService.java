package com.green.board7.fileupload;


import com.green.board7.fileupload.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.net.MalformedURLException;
import java.util.UUID;

@Service
public class FileuploadService {

    @Value("${file.dir}")
    private String fileDir;

    private final FileuploadMapper mapper;

    @Autowired
    public FileuploadService(FileuploadMapper mapper) {
        this.mapper = mapper;
    }

    public Resource fileLoad(FileLoadDto dto) {
        FileEntity entity = mapper.selFileById(dto);
        try {
            File file = new File(fileDir + entity.getPath());
            Resource resource = new UrlResource(file.toURI());
            if(resource.exists()) {
                return resource;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void fileUpload(FileuploadInsDto dto, MultipartFile img) {
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

            FileEntity entity = FileEntity.builder()
                    .path(savedFileName)
                    .uploader(dto.getUploader())
                    .levelValue(dto.getLevelValue())
                    .build();

            mapper.insFile(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
