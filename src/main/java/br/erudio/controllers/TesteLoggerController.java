package br.erudio.controllers;

import br.erudio.service.PersonService;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.LoggerFactory;


@RestController
public class TesteLoggerController {

    private Logger logger = LoggerFactory.getLogger(TesteLoggerController.class.getName());

    @GetMapping("/teste")
    public  String TestLogger(){
        logger.debug("TESTANDO O DEBUG!");
        logger.info("TESTANDO O INFO!");
        logger.warn("TESTANDO O WARN!");
        logger.error("TESTANDO O ERROR!");
        return "Logger Initialize Sucess";
    }
}
