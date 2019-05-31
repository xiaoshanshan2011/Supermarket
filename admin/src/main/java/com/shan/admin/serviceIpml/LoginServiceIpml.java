package com.shan.admin.serviceIpml;

import com.publib.bean.Result;
import com.publib.utils.ResultUtils;
import com.shan.admin.component.RedisComponent;
import com.shan.admin.dto.SysUserDto;
import com.shan.admin.mapper.SysUserDtoMapper;
import com.shan.admin.service.LoginService;
import com.shan.admin.utils.GlobalUtils;
import com.shan.admin.utils.JwtUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class LoginServiceIpml implements LoginService {
    @Resource
    private RedisComponent redisComponent;

    @Resource
    private SysUserDtoMapper mapper;

    /**
     * 保存user登录信息，返回token
     * @param uid
     * @return
     */
    @Override
    public String generateJwtToken(String uid) {
        /**
         * @todo 将salt保存到数据库或者缓存中
         * redisTemplate.opsForValue().set("token:"+username, salt, 3600, TimeUnit.SECONDS);
         */
        String token = JwtUtils.sign(uid, 3600 * 24 * 7); //生成jwt token，设置过期时间为7天
        //保存用户token
        redisComponent.set(uid, token);
        return token;
    }

    /**
     * 清除token信息
     * @param uid
     */
    @Override
    public void deleteLoginInfo(String uid) {
      redisComponent.del(uid);
    }

    /**
     * 获取数据库中保存的用户信息，主要是加密后的密码
     * @param userName
     * @return
     */
    @Override
    public SysUserDto getUserInfo(String userName) {
        return mapper.selectByPrimaryName(userName);
    }

    @Override
    public SysUserDto getUserInfoByUid(String uid) {
        return mapper.selectByPrimaryKey(uid);
    }

    /**
     * 获取用户角色列表，强烈建议从缓存中获取
     * @param uid
     * @return
     */
    @Override
    public List<String> getUserRoles(String uid) {
        return Arrays.asList("admin");
    }

    @Override
    public Result getUserInfo() {
        SysUserDto sysUserDto = mapper.selectByPrimaryKey(GlobalUtils.getUid());
        if (sysUserDto == null) {
            ResultUtils.error("获取用户信息失败");
        }
        sysUserDto.setPassword("");
        return ResultUtils.success(sysUserDto);
    }
}
