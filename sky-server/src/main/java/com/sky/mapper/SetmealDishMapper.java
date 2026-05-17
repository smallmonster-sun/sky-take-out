package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Project: sky-take-out
 * @Package: com.sky.mapper
 * @Author: SUN
 * @Date: 2026/5/16 17:17
 * @Version: v1.0.0
 * @Description:
 **/
@Mapper
public interface SetmealDishMapper {
	/**
	 * 根据菜品id查询对应的套餐id
	 * @param dishId
	 * @return
	 */
	List<Long> getSetmealIdsByDishIds(List<Long> dishId);
}
