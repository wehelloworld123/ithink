package com.fc.ithink.common.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {
	@Autowired
	private V2Config v2Config;

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
    	Contact contact=new Contact("ithink","https://www.vvvpure.com/think/app/download", "1131095930@qq.com");
        Docket docket=new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        //.title("swagger-bootstrap-ui-demo RESTful APIs")
                        .description("我思ithink艺术作品创作平台")
                        //服务条款Url
                        .termsOfServiceUrl("https://wjy.vvvpure.com/think/agree")
                        .contact(contact)
                        .version(v2Config.getVersion())
                        .build())
                //分组名称
                .groupName("ithink")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.fc.v2.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
