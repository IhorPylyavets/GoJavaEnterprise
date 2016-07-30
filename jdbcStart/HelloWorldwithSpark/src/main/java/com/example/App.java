package com.example;

import com.example.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;

import java.util.HashMap;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates1/layout.vtl";

        get("/", (request, response) -> {
            HashMap model = new HashMap();
            model.put("template", "templates1/hello.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/favorite_photos", (request, response) -> {
            HashMap model = new HashMap();
            model.put("template", "templates1/favorite_photos.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/form", (request, response) -> {
            HashMap model = new HashMap();
            model.put("template", "templates1/form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/greeting_card", (request, response) -> {
            HashMap model = new HashMap();
            System.out.println(request.queryParams());
            model.put("recipient", request.queryParams("recipient"));
            model.put("sender", request.queryParams("sender"));

            model.put("template", "templates1/greeting_card.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
