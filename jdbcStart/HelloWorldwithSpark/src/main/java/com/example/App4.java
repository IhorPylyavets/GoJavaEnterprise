package com.example;

import com.example.template.velocity.VelocityTemplateEngine;
import spark.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

public class App4 {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates4/layout.vtl";

        get("/", (request, response) -> {
            HashMap model = new HashMap();
            model.put("tasks", request.session().attribute("tasks"));

            model.put("template", "templates4/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/tasks", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Task> tasks = request.session().attribute("tasks");

            if (tasks == null) {
                tasks = new ArrayList();
                request.session().attribute("tasks", tasks);
            }

            String description = request.queryParams("description");
            Task newTask = new Task(description);

            tasks.add(newTask);
            //request.session().attribute("task", newTask);
            model.put("template", "templates4/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
    }
}
