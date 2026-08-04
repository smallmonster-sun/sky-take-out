package com.sky.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.constant.StatusConstant;
import com.sky.entity.Dish;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("userDishController")
@RequestMapping("/user/dish")
@Slf4j
@Api(tags = "C端-菜品浏览接口")
public class DishController {
	@Autowired
	private DishService dishService;
	// 替换为StringRedisTemplate
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	// JSON转换工具
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * 根据分类id查询菜品
	 *
	 * @param categoryId
	 * @return
	 */
	@GetMapping("/list")
	@ApiOperation("根据分类id查询菜品")
	public Result<List<DishVO>> list(Long categoryId) throws JsonProcessingException {
		// 构造redis中的key，规则：dish_分类id
		String key = "dish_" + categoryId;
		// 查询redis缓存（拿到JSON字符串）
		String jsonStr = stringRedisTemplate.opsForValue().get(key);
		List<DishVO> list = null;

		if (jsonStr != null) {
			// JSON字符串转回List集合
			list = objectMapper.readValue(jsonStr, new TypeReference<List<DishVO>>() {
			});
			return Result.success(list);
		}

		// 缓存无数据，查询数据库
		Dish dish = new Dish();
		dish.setCategoryId(categoryId);
		dish.setStatus(StatusConstant.ENABLE);
		list = dishService.listWithFlavor(dish);

		// List转JSON字符串存入Redis
		String json = objectMapper.writeValueAsString(list);
		stringRedisTemplate.opsForValue().set(key, json);

		return Result.success(list);
	}
}