package com.example;

import com.example.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App3 {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates3/layout.vtl";

        get("/", (request, response) -> {
            HashMap model = new HashMap();
            model.put("username", request.session().attribute("username"));

            model.put("template", "templates3/welcome.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/welcome", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String inputtedUsername = request.queryParams("username");
            request.session().attribute("username", inputtedUsername);
            model.put("username", inputtedUsername);

            model.put("template", "templates3/welcome.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }

}
