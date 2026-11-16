package com.mindlance.urlshortener.workflow;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WorkflowContext {

    private String requirement;

    private List<String> tasks =
            new ArrayList<>();
}
