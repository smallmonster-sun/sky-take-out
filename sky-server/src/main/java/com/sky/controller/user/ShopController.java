package com.sky.controller.user;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @Project: sky-take-out
 * @Package: com.sky.controller.admin
 * @Author: SUN
 * @Date: 2026/5/24 19:26
 * @Version: v1.0.0
 * @Description: 店铺相关接口
 **/
@RestController("userShopController")
@RequestMapping("/user/shop")
@Api(tags = "店铺相关接口")
@Slf4j
public class ShopController {

	private final static String KEY = "SHOP_STATUS";

	@Autowired
	private RedisTemplate redisTemplate;

	/**
	 * 获取店铺的营业状态
	 * @return
	 */
	@GetMapping("/status")
	@ApiOperation("获取店铺的营业状态")
	public Result<Integer> getStatus() {
		String status = (String) redisTemplate.opsForValue().get(KEY);
		Integer value = Integer.parseInt(status);
		log.info("获取到店铺的营业状态：{}", value == 1 ? "营业中" : "打样中");
		return Result.success(value);
	}
}
