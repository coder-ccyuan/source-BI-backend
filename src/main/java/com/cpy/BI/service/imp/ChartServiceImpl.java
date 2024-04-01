package com.cpy.BI.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cpy.BI.model.entity.Chart;
import com.cpy.BI.service.ChartService;
import com.cpy.BI.mapper.ChartMapper;
import org.springframework.stereotype.Service;

/**
* @author 成希德
* @description 针对表【chart(用户)】的数据库操作Service实现
* @createDate 2024-04-01 20:54:38
*/
@Service
public class ChartServiceImpl extends ServiceImpl<ChartMapper, Chart>
    implements ChartService{

}




