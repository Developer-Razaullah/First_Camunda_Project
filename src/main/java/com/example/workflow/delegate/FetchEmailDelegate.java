package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FetchEmailDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("This Email coming from API");
        System.out.println("This value coming from BPMN :"+ execution.getVariable("userInput"));
        execution.setVariable("EmailIdFromDelegate", "test@gmail.com");
    }
}
