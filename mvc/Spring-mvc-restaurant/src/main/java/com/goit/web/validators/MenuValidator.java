package com.goit.web.validators;

import com.goit.model.Menu;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MenuValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Menu.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Menu menu = (Menu) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "menuTitle", "", "MenuTitle is empty");

        /*if (menu.getDishesList().size() <= 0) {
            errors.rejectValue("dishesList", "", "DishesList is not correct");
        }*/
    }
}
