package com.dao;

import com.entity.ChuangweiBingliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChuangweiBingliView;

/**
 * 患者住院房屋 Dao 接口
 *
 * @author 
 */
public interface ChuangweiBingliDao extends BaseMapper<ChuangweiBingliEntity> {

   List<ChuangweiBingliView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
