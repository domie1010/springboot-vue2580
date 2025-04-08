package com.dao;

import com.entity.JianchaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JianchaView;

/**
 * 检查 Dao 接口
 *
 * @author 
 */
public interface JianchaDao extends BaseMapper<JianchaEntity> {

   List<JianchaView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
