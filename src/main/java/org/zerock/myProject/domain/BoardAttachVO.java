package org.zerock.myProject.domain;

import lombok.Data;

@Data
public class BoardAttachVO {

    private String uuid;
    private String uploadPath;

    private String fileName;
    private boolean fileType;

    private Long bno;

    @Override
    public String toString() {
        return "AttachDTO{" +
                "fileName='" + fileName + '\'' +
                ", uuid='" + uuid + '\'' +
                ", uploadPath='" + uploadPath + '\'' +
                ", fileType=" + fileType +
                '}';
    }
}
