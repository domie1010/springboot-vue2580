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

import com.dao.ChuangweiBingliDao;
import com.entity.ChuangweiBingliEntity;
import com.service.ChuangweiBingliService;
import com.entity.view.ChuangweiBingliView;

/**
 * 患者住院房屋 服务实现类
 */
@Service("chuangweiBingliService")
@Transactional
public class ChuangweiBingliServiceImpl extends ServiceImpl<ChuangweiBingliDao, ChuangweiBingliEntity> implements ChuangweiBingliService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChuangweiBingliView> page =new Query<ChuangweiBingliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
