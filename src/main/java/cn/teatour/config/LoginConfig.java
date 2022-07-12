package cn.teatour.config;

import cn.teatour.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: teatour
 * @description: 登陆配置
 * @author: 张佳
 * @create: 2022-06-08 10:41
 **/
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new LoginInterceptor());
        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns(    //添加不拦截路径
                "/register",
                "/home",
                "/login",
                "/loginPage",                    //登录路径
                "/**/*.html",                //html静态资源
                "/**/*.js",                  //js静态资源
                "/**/*.css",                //css静态资源
                "/**/*.jfif",                 //img静态资源
                "/**/*.png",                 //img静态资源
                "/**/*.jpg",                 //img静态资源
                "/**/**/*.jpg",                 //img静态资源
                "/**/**/*.png"                 //img静态资源
        );
    }
}


