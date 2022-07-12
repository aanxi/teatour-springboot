package cn.teatour.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: teatour
 * @description: webmvc配置资源映射路径
 * @author: 张佳
 * @create: 2022-06-10 13:57
 **/

/**
 * 资源映射路径
 */
@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").
                addResourceLocations("file:"+System.getProperty("user.dir")+"/src/main/resources/static/img/");
    }
}
