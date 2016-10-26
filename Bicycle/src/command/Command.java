package command;

import bean.Request;
import bean.Response;

public interface Command {
    
    Response execute(Request request);
    
}
