package com.example1.demo1.validator;

import com.example1.demo1.dao.Userdao;
import com.example1.demo1.models.User;
import com.example1.demo1.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    @Autowired
    private Userdao userdao;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUserName().length() < 6 || user.getUserName().length() > 30) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userdao.userExist(user.getUserName())) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPwd().length() < 8 || user.getPwd().length() > 255) {
            errors.rejectValue("password", "Size.userForm.password");
        }

        // if (!user.getPasswordConfirm().equals(user.getPwd())) {
        //     errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        // }
    }
}