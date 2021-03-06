package com.a.eye.bot.chat.ui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.eye.bot.chat.share.conts.UserStateConstants;
import com.a.eye.bot.common.cache.redis.UserStateJedisRepository;

/**
 * @Title: UserStateService.java
 * @author: pengysh
 * @date 2016年8月13日 下午1:30:19
 * @Description:用户状态服务（此服务因为使用到Redis服务，所以写在UI层）
 */
@Service
public class UserStateRedisService {

	@Autowired
	private UserStateJedisRepository userStateJedisRepository;

	/**
	 * @Title: userOnline
	 * @author: pengysh
	 * @date 2016年8月13日 下午1:36:48
	 * @Description:用户上线
	 * @param userId
	 */
	public void userOnline(final Long userId) {
		userStateJedisRepository.modifyUserState(userId, UserStateConstants.Online_State);
	}

	/**
	 * @Title: userOffline
	 * @author: pengysh
	 * @date 2016年8月13日 下午1:36:59
	 * @Description:用户离线
	 * @param userId
	 */
	public void userOffline(final Long userId) {
		userStateJedisRepository.modifyUserState(userId, UserStateConstants.Offline_State);
	}
}
