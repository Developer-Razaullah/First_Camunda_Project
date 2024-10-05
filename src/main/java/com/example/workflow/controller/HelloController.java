package com.example.workflow.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getMessage() {

        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("First_BPMN");
        String item = "Computer";
        instance.setVariable("itemName", item);
        instance.businessKey("hello-endpoint");
        instance.executeWithVariablesInReturn();

        return "Hello Camunda";
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String execute() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("tasks");
        instance.executeWithVariablesInReturn();
        return "Camunda Task Successfully Execute";
    }
}
