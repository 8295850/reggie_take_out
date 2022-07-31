package com.study.service.impl;

import com.study.common.R;
import com.study.service.IUploadImageService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

@Service
public class UploadImageServiceImpl implements IUploadImageService {
    @Override
    public R<String> upLoadImage(MultipartFile file, String folder) {
        if (file == null) {
            return R.error("请选择要上传的图片");
        }
        if (file.getSize() > 1024 * 1024 * 10) {
            return R.error("文件大小不能大于10M");
        }
        //获取文件后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));



        if (!".jpg,.jpeg,.gif,.png".toUpperCase().contains(suffix.toUpperCase())) {
            return R.error("请选择jpg,jpeg,gif,png格式的图片");
        }



        File savePathFile = new File(folder);
        if (!savePathFile.exists()) {
            //若不存在该目录，则创建目录
            savePathFile.mkdir();
        }

        //通过UUID生成唯一文件名
        String filename = UUID.randomUUID().toString() + suffix;


        try {
            //将文件保存指定目录
            file.transferTo(new File(folder + filename));

        } catch (Exception e) {
            e.printStackTrace();
            return R.error("保存文件异常");
        }
        //返回文件名称
        return R.success(filename);

    }
}
