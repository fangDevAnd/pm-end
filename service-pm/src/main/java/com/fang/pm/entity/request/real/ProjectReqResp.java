package com.fang.pm.entity.request.real;

import com.fang.pm.sub.base.base.bean.LimitRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ProjectReqResp extends LimitRequest {

    private String proName;
    private String mainUrl;

    private Integer isDel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String descri;

    private String engName;


}
