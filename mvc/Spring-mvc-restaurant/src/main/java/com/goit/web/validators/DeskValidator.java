package com.goit.web.validators;

import com.goit.model.Desk;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DeskValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Desk.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Desk desk = (Desk) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deskTitle", "", "DeskTitle is empty");

        if (desk.getDeskStatus() != null) {
            errors.rejectValue("deskStatus", "", "DeskStatus is not valid");
        }
    }
}
