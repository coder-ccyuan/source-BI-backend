package com.cpy.BI.model.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author:成希德
 */
@Data
public class ChartAnalysisRequest {
    /**
     * 分析目标
     */
    private String goal;

    /**
     * 图表数据
     */
    private MultipartFile file;

    /**
     * 图标类型
     */
    private String charType;
}
