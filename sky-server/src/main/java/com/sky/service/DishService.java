package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

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

	/**
	 * 菜品起售停售
	 * @param status
	 * @param id
	 */
	void startOrStop(Integer status, Long id);

	/**
	 * 根据id查询菜品和对应的口味数据
	 * @param id
	 * @return
	 */
	DishVO getByIdWithFlavor(Long id);

	/**
	 * 根据id修改菜品的基本信息和口味信息
	 * @param dishDTO
	 */
	void updateWithFlavor(DishDTO dishDTO);
}
