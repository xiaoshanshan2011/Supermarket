package com.shan.admin.controller;

import com.publib.bean.Result;
import com.publib.utils.ResultUtils;
import com.publib.utils.TextUtils;
import com.shan.admin.dto.SysUserDto;
import com.shan.admin.service.LoginService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(tags={"登录"})
@RestController
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource
    private LoginService loginService;
    
    /**
     * 用户名密码登录
     * @param request
     * @return token
     */
    @PostMapping(value = "/api/admin/login")
    public Result login(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        try {
            if (TextUtils.isEmpty(username)) {
                return ResultUtils.error("请输入用户名");
            } else if (TextUtils.isEmpty(password)) {
                return ResultUtils.error("请输入密码");
            }
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);

            SysUserDto user = (SysUserDto) subject.getPrincipal();
            String newToken = loginService.generateJwtToken(user.getUserid());
            response.setHeader("authtoken", newToken);

            return ResultUtils.success("登录成功");
        } catch (AuthenticationException e) {
            logger.error("User {} login fail, Reason:{}", username, e.getMessage());
            return ResultUtils.error("用户名或者密码错误");
        } catch (Exception e) {
            return ResultUtils.error("登录失败");
        }
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping(value = "/api/admin/logout")
    public Result logout() {
    	Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipals() != null) {
            SysUserDto user = (SysUserDto)subject.getPrincipals().getPrimaryPrincipal();
            loginService.deleteLoginInfo(user.getUserid());
        }
        SecurityUtils.getSubject().logout();
        return ResultUtils.success("退出成功");
    }

    @GetMapping(value = "/api/admin/getUserInfo")
    public Result getUserInfo(){
        return loginService.getUserInfo();
    }
}
