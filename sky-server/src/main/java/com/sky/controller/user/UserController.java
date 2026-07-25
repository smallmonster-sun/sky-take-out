package com.sky.controller.user;

import com.sky.constant.JwtClaimsConstant;
import com.sky.dto.UserLoginDTO;
import com.sky.entity.User;
import com.sky.properties.JwtProperties;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.service.UserService;
import com.sky.utils.JwtUtil;
import com.sky.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: sky-take-out
 * @Package: com.sky.controller.user
 * @Author: SUN
 * @Date: 2026/7/21 15:39
 * @Version: v1.0.0
 * @Description: 用户使用
 **/

@RestController
@RequestMapping("/user/user")
@Api(tags = "C端用户相关接口")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtProperties jwtProperties;
	/**
	 * 微信登录
	 * @param userLoginDTO
	 * @return
	 */
	@PostMapping("/login")
	@ApiOperation("微信登录")
	public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
		log.info("微信用户登录：{}",userLoginDTO.getCode());
		//微信登录
		User user = userService.wxLogin(userLoginDTO);
		//为微信用户生成jwt令牌
		Map<String, Object> claims = new HashMap<>();
		claims.put(JwtClaimsConstant.USER_ID, user.getId());
		String token = JwtUtil.createJWT(jwtProperties.getUserSecretKey(), jwtProperties.getUserTtl(),claims);
		UserLoginVO userLoginVO = UserLoginVO.builder()
				.id(user.getId())
				.openid(user.getOpenid())
				.token(token)
				.build();
		return Result.success(userLoginVO);
	}
}
