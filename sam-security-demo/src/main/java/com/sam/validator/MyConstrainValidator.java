package com.sam.validator;

import com.sam.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: huangxin
 * @Date: Created in 下午2:27 2018/2/26
 * @Description:
 */
public class MyConstrainValidator implements ConstraintValidator<MyConstraint,Object>{

    @Autowired
    private HelloService helloService;


    @Override
    public void initialize(MyConstraint constraintAnnotation) {

        System.out.println("init my validator");

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        helloService.greeting("tom");

        System.out.println(value);

        return false;
    }
}
