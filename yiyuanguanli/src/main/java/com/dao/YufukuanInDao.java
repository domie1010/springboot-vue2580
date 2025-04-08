package com.dao;

import com.entity.YufukuanInEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YufukuanInView;

/**
 * 预付款缴费 Dao 接口
 *
 * @author 
 */
public interface YufukuanInDao extends BaseMapper<YufukuanInEntity> {

   List<YufukuanInView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
