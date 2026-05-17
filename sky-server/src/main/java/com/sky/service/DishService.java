package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

import java.util.List;

/**
 * @Project: sky-take-out
 * @Package: com.sky.service
 * @Author: SUN
 * @Date: 2026/5/10 18:42
 * @Version: v1.0.0
 * @Description: 菜品管理
 **/
public interface DishService {
	/**
	 * 新增菜品和口味
	 * @param dishDTO
	 */
	public void saveWithFlavor(DishDTO dishDTO);

	/**
	 * 菜品分页查询
	 * @param dishPageQueryDTO
	 * @return
	 */
	PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

	/**
	 * 菜品批量删除
	 * @param ids
	 */
	void deleteBatch(List<Long> ids);
}
