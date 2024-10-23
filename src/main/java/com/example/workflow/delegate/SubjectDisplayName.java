package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SubjectDisplayName implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        Map subjectMap = (Map) execution.getVariable("subjectObj");
        String displayName = "";
        switch(subjectMap.get("name").toString()) {
            case "English":
                displayName = "Eng";
                break;
            case "Mathematics":
                displayName = "Maths";
                break;
            case "Science":
                displayName = "Sci";
                break;
            case "Social Studies":
                displayName = "Social";
                break;
            default:
                displayName = "";
        }
        subjectMap.put("displayName", displayName);
    }
}
