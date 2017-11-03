package net.burakince;

import com.thoughtworks.go.plugin.api.exceptions.UnhandledRequestTypeException;
import net.burakince.command.*;

public class CommandFactory {

    public AbstractCommand getCommand(String requestName) throws UnhandledRequestTypeException {
        if ("configuration".equals(requestName)) {
            return new GetConfigurationCommand();
        } else if ("validate".equals(requestName)) {
            return new ValidationCommand();
        } else if ("execute".equals(requestName)) {
            return new TaskExecutionCommand();
        } else if ("view".equals(requestName)) {
            return new ViewCommand();
        }
        throw new UnhandledRequestTypeException(requestName);
    }

}
