package com.study.service;

import com.study.common.R;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Transactional
public interface IUploadImageService {
    public R<String> upLoadImage(MultipartFile file,String folder);
}
