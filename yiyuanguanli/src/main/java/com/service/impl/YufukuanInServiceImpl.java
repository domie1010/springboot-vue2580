package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.YufukuanInDao;
import com.entity.YufukuanInEntity;
import com.service.YufukuanInService;
import com.entity.view.YufukuanInView;

/**
 * 预付款缴费 服务实现类
 */
@Service("yufukuanInService")
@Transactional
public class YufukuanInServiceImpl extends ServiceImpl<YufukuanInDao, YufukuanInEntity> implements YufukuanInService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YufukuanInView> page =new Query<YufukuanInView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
