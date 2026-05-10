package com.sky.service;

import com.sky.dto.DishDTO;

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
}
