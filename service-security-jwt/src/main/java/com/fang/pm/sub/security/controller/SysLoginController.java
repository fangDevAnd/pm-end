package com.fang.pm.sub.security.controller;

import com.fang.pm.sub.base.base.Result;
import com.fang.pm.sub.base.base.bean.SysUser;
import com.fang.pm.sub.security.bean.JwtAuthenticatioToken;
import com.fang.pm.sub.security.bean.LoginBean;
import com.fang.pm.sub.security.mapper.UserMapper;
import com.fang.pm.sub.security.tools.PasswordUtils;
import com.fang.pm.sub.security.tools.SecurityUtils;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 登录控制器
 *
 * @author Louis
 * @date Jan 14, 2019
 */
@RestController
public class SysLoginController {

    @Autowired
    private Producer producer;
    @Autowired
    private UserMapper userMapper;
    /**
     * springsecurity 自动创建的对象
     * <p>
     * <p>
     * authenticationManager  调用  认证的提供者 ----> 调用里面的检查
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 验证码生成器
     *
     * @param response
     * @param request
     * @throws ServletException
     * @throws IOException
     */
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");  //设置不要缓存
        response.setContentType("image/jpeg");
        // 生成文字验证码
        String text = producer.createText();
        // 生成图片验证码
        BufferedImage image = producer.createImage(text);
        // 保存到验证码到 session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 登录接口
     */
    @PostMapping(value = "/userLogin")
    public Result login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
        String username = loginBean.getAccount();
        String password = loginBean.getPassword();
        String captcha = loginBean.getCaptcha();
        // 从session中获取之前保存的验证码跟前台传来的验证码进行匹配、
        /**
         *
         * 下面是需要注意的事情，
         *
         * 如果当前自己使用的tomcat 进行了集群的处理，那么就需要考虑自己应不应该使用 session ，因为如果相关数据使用的session进行存取数据，那么会导致
         *
         * session失效
         *
         */
        if (captcha != null) {
            Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (kaptcha == null) {
                return new Result().setCode(400).setMsg("验证码已失效");
            }
            if (!captcha.equals(kaptcha)) {
                return new Result().setCode(400).setMsg("验证码不正确");
            }
        }
        // 用户信息
        SysUser user = userMapper.findByName(username);
        // 账号不存在、密码错误
        if (user == null) {
            return new Result().setCode(400).setMsg("账号不存在");
        }
        if (!PasswordUtils.matches(user.getSalt(), password, user.getPassword())) {
            return new Result().setCode(400).setMsg("密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            return new Result().setCode(400).setMsg("账号已被锁定,请联系管理员");
        }
        // 系统登录认证
        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
        return new Result().setCode(200).setData(token);
    }

    /**
     * 获得用户信息
     */
    @RequestMapping("/user/info")
    public Result getUserInfo() {
        return new Result().setCode(200).setData(SecurityContextHolder.getContext().getAuthentication());
    }


}
