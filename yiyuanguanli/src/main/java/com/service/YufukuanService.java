package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YufukuanEntity;
import java.util.Map;

/**
 * 预付款账户 服务类
 */
public interface YufukuanService extends IService<YufukuanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}