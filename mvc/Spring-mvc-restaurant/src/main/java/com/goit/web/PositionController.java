package com.goit.web;

import com.goit.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class PositionController {

    private static PositionService positionService;

    @RequestMapping(value = "/position", method = RequestMethod.GET)
    public String positions() {
        return "position";
    }

    @RequestMapping(value = "/all_positions", method = RequestMethod.GET)
    public String allPositions(Map<String, Object> model) {
        model.put("all_positions", positionService.getAllPosition());
        return "all_positions";
    }

    @Autowired
    public void setPositionService(PositionService positionService) {
        this.positionService = positionService;
    }
}
