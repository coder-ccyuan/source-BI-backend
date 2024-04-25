package com.cpy.BI.model.vo;

import lombok.Data;

/**
 * @Author:成希德
 */
@Data
public class ChartAnalysisVO {
    /**
     * 结论
     */
    private String conclusion;
    /**
     * ECharts json string
     */
    private String json;
}
