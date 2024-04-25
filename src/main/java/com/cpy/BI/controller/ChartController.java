package com.cpy.BI.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.cpy.BI.common.BaseResponse;
import com.cpy.BI.common.ErrorCode;
import com.cpy.BI.common.ResultUtils;
import com.cpy.BI.exception.BusinessException;
import com.cpy.BI.model.vo.ChartAnalysisVO;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author:成希德
 */
@RestController
@RequestMapping("/chart")
public class ChartController {
    @Resource
    private YuCongMingClient client;
    @PostMapping("/analysis")
    public BaseResponse<ChartAnalysisVO> analysis(@RequestPart("file") MultipartFile file, String goal, String type) throws IOException {
        String filename = file.getOriginalFilename();
        if (!filename.split("\\.")[1].equals("xlsx")) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件类型不符合要求");
        }
        if (file.getSize() >= 100 * 1024 * 1024) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "文件大小超出限制");
        }
        ExcelReaderBuilder read = EasyExcel.read(file.getInputStream());
        List<LinkedHashMap<Object, Object>> dataList = read.sheet().doReadSync();
        StringBuffer sb = new StringBuffer("");
        for (LinkedHashMap<Object, Object> stringStringLinkedHashMap : dataList) {
            for (Object o : stringStringLinkedHashMap.keySet()) {
                Object o1 = stringStringLinkedHashMap.get(o);
                sb.append(o1);
                sb.append(",");
            }
            sb.append("\n");
        }
        //请求AI
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(1783495301978906625L);
        devChatRequest.setMessage("如果你是数据分析师"+goal+"得出数据结论和Echarts的options数据json对象并且不要有注释，只要{}写成一行"+type+"使用‘-----’将结论和json对象分隔，不要使用md语法"+":"+sb);
        com.yupi.yucongming.dev.common.BaseResponse<DevChatResponse> response = client.doChat(devChatRequest);
        ChartAnalysisVO chartAnalysisVO = new ChartAnalysisVO();
        String content = response.getData().getContent();
        System.out.println(content);
        chartAnalysisVO.setConclusion(content.split("-----")[0]);
        chartAnalysisVO.setJson(content.split("-----")[1]);
        return ResultUtils.success(chartAnalysisVO);
    }
}