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
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("first_bpmn_execute");
        String item = "Computer";
        instance.setVariable("itemName", item);
        instance.businessKey("hello-endpoint");
        instance.executeWithVariablesInReturn();

        return "Hello Camunda";
    }

    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String execute() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("tasks_execute");
        instance.executeWithVariablesInReturn();
        return "Camunda Task Successfully Execute";
    }

    @RequestMapping(value = "/sequence_flow", method = RequestMethod.GET)
    public String executes() {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("sequence_flow_execute");
        instance.executeWithVariablesInReturn();
        return "Camunda Task Successfully Execute";
    }
}
