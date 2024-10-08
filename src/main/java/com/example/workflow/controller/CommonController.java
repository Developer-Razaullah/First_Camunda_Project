package com.example.workflow.controller;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    /**
     * As a path variable pass camunda id
     * first_bpmn_execute
     * tasks_execute
     * sequence_flow_execute
     * gateway_execute
     * @param processKey
     * @return
     */
    @RequestMapping(value = "/execute/{process}", method = RequestMethod.GET)
    public String execute(@PathVariable("process") String processKey) {
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey(processKey);
        instance.executeWithVariablesInReturn();
        return "Camunda process executed with Process Key:" +processKey;
    }
}
