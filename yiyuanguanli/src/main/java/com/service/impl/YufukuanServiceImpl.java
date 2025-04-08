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

import com.dao.YufukuanDao;
import com.entity.YufukuanEntity;
import com.service.YufukuanService;
import com.entity.view.YufukuanView;

/**
 * 预付款账户 服务实现类
 */
@Service("yufukuanService")
@Transactional
public class YufukuanServiceImpl extends ServiceImpl<YufukuanDao, YufukuanEntity> implements YufukuanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<YufukuanView> page =new Query<YufukuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
