package com.green.board7.fileupload;

import com.green.board7.fileupload.model.FileEntity;
import com.green.board7.fileupload.model.FileLoadDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileuploadMapper {
    int insFile(FileEntity entity);
    FileEntity selFileById(FileLoadDto dto);
}
