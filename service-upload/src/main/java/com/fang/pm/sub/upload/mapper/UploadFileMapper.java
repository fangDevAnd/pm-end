package com.fang.pm.sub.upload.mapper;


import com.fang.pm.sub.upload.bean.Upload;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

/**
 * 文件上传
 */
public interface UploadFileMapper {

     int insert(Upload upload);

    @Select("select * from upload_file where id=#{id}")
    Upload find(Integer id);
}
