package com.example.eureka.controller.swaggerController;

import com.example.eureka.bean.Dog;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuxiaopeng
 * @create 2018-07-12 17:54
 **/

@RestController//接口注解
@Api(value="用户接口描述",description = "接口描述")//接口简要标注，对中文的支持不太好
@RequestMapping(value = "/swagger")//接口基本路径
public class AnimalController {
    //接口需要的参数，可以有多个，这里只写了一个，它的paramType还有path、query、body、form几种，
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "Token", value = "token", dataType = "String", required = true, defaultValue = "123")})
    //接口功能描述
    @ApiOperation(value = "获取一只狗",notes = "获取只小狗")
    //接口响应信息，这里定义了一个401，当出现401，接口返回的是自定的错误AnimalError的实例。当然可以定义多个。
    @ApiResponses(value = {@ApiResponse(code = 401, message = "请求未通过认证.", response = AnimalError.class)})
    @RequestMapping(value = "/onedog", method = RequestMethod.GET)
    public Dog oneDog() {
        return new Dog();
    }

    //多个请求参数设置
    @ApiImplicitParams({@ApiImplicitParam(paramType = "header", name = "Token", value = "token", dataType = "String", required = true, defaultValue = "123")})
    @ApiOperation(value = "创建一只狗")
    @ApiResponses(value = {@ApiResponse(code = 401, message = "请求未通过认证.", response = AnimalError.class)})
    @RequestMapping(value = "/dog/{name}", method = RequestMethod.GET)
    //@ApiParam和@RequestParam注解作用效果相同，单个参数描述
    public Dog createDog(@ApiParam(defaultValue = "二哈")
            @PathVariable("name") String name) {
        Dog dog = new Dog();
        dog.setName(name);
        return dog;
    }
}