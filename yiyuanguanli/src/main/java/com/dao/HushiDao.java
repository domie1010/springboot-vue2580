package com.dao;

import com.entity.HushiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HushiView;

/**
 * 护士 Dao 接口
 *
 * @author 
 */
public interface HushiDao extends BaseMapper<HushiEntity> {

   List<HushiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
