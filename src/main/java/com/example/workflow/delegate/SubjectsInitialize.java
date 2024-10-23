package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SubjectsInitialize implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<Map<String, String>> subjectsList = new ArrayList<>();
        for (int i=1;i<5;i++) {
            Map<String, String> subjects = new HashMap<>();
            subjects.put("id", String.valueOf(i));
            subjectsList.add(subjects);
        }
        execution.setVariable("subjectList", subjectsList);
    }
}
