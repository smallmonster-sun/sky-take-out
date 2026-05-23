package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;

import java.util.List;

/**
 * @Project: sky-take-out
 * @Package: com.sky.service
 * @Author: SUN
 * @Date: 2026/5/20 20:29
 * @Version: v1.0.0
 * @Description: 套餐管理
 **/
public interface SetmealService {
	/**
	 * 新增套餐，同时需要保存套餐和菜品的关联关系
	 *
	 * @param setmealDTO
	 */
	void saveWithDish(SetmealDTO setmealDTO);

	/**
	 * 分页查询
	 * @param setmealPageQueryDTO
	 * @return
	 */
	PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

	/**
	 * 批量删除套餐
	 * @param ids
	 */
	void deleteBatch(List<Long> ids);

	/**
	 * 根据id查询套餐
	 * @param id
	 * @return
	 */
	SetmealVO getByIdWithDish(Long id);

	/**
	 * 修改套餐
	 * @param setmealDTO
	 */
	void update(SetmealDTO setmealDTO);
}
