package com.sam.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.sam.dto.User;
import com.sam.dto.UserQueryCondition;
import com.sam.exception.UserNotExistException;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huangxin
 * @Date: Created in 上午11:15 2018/2/26
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user) {


        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult errors) {


        if (errors.hasErrors()) {
            errors.getAllErrors().stream().forEach(error -> {
//                    FieldError fieldError = (FieldError) error;
//                    String message = fieldError.getField() +" "+ error.getDefaultMessage();
                        System.out.println(error.getDefaultMessage());
                    }
            );
        }

        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(
//            @RequestParam(name = "username",required = false,defaultValue = "sam111") String nickname
            UserQueryCondition userQueryCondition,
            @PageableDefault(page = 2, size = 17, sort = "username,asc") Pageable pageable
    ) {
        List<User> users = new ArrayList<>();


        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        System.out.println(ReflectionToStringBuilder.toString(userQueryCondition));
        users.add(new User());
        users.add(new User());
        users.add(new User());

        return users;
    }

    @GetMapping("/{id:\\d+}")//加正则校验
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String idxxx) {

        throw new UserNotExistException(idxxx);

//        System.out.println("进入getInfo服务");
//        User user = new User();
//        user.setUsername("tom");
//        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {

        System.out.println(id);

    }




}
