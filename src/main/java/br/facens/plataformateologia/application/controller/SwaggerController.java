package br.facens.plataformateologia.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class SwaggerController {

    @RequestMapping(
            value = {"", "/"},
            method = RequestMethod.GET
    )
    public ModelAndView abrirSwagger() {
        return new ModelAndView("redirect:/swagger-ui/index.html");
    }

}
