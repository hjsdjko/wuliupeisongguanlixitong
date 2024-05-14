package com.dao;

import com.entity.ChengyunrenwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChengyunrenwuView;

/**
 * 承运任务 Dao 接口
 *
 * @author 
 */
public interface ChengyunrenwuDao extends BaseMapper<ChengyunrenwuEntity> {

   List<ChengyunrenwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
