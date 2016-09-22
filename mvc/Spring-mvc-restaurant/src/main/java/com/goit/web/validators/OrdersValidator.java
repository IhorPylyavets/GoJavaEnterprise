package com.goit.web.validators;

import com.goit.model.Orders;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OrdersValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Orders.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Orders orders = (Orders) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "orderDate", null, "OrderDate is empty");

        if (orders.getDishesInOrder().size() <= 0) {
            errors.rejectValue("dishesList", "", "DishesList is not correct");
        }

        /*if (!orders.getDesk().getDeskStatus().equals("FREE")) {
            errors.rejectValue("desk", "", "Desk is not valid");
        }*/
    }
}
