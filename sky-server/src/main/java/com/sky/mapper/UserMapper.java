package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Project: sky-take-out
 * @Package: com.sky.mapper
 * @Author: SUN
 * @Date: 2026/7/21 16:19
 * @Version: v1.0.0
 * @Description:
 **/
@Mapper
public interface UserMapper {
	/**
	 * 根据openid查询用户
	 * @param openid
	 * @return
	 */
	@Select("select * from user where openid = #{openid} ")
	User getByOpenid(String openid);

	/**
	 * 插入数据
	 * @param user
	 */
	void insert(User user);
}
