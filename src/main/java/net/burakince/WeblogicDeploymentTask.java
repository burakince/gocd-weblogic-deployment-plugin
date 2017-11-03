package net.burakince;

import com.thoughtworks.go.plugin.api.AbstractGoPlugin;
import com.thoughtworks.go.plugin.api.GoPluginIdentifier;
import com.thoughtworks.go.plugin.api.annotation.Extension;
import com.thoughtworks.go.plugin.api.exceptions.UnhandledRequestTypeException;
import com.thoughtworks.go.plugin.api.logging.Logger;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.Arrays;

@Extension
public class WeblogicDeploymentTask extends AbstractGoPlugin {

    private final Logger logger = Logger.getLoggerFor(WeblogicDeploymentTask.class);
    private final CommandFactory commandFactory = new CommandFactory();

    @Override
    public GoPluginApiResponse handle(GoPluginApiRequest requestMessage) throws UnhandledRequestTypeException {
        return commandFactory.getCommand(requestMessage.requestName()).execute(requestMessage);
    }

    @Override
    public GoPluginIdentifier pluginIdentifier() {
        return new GoPluginIdentifier("task", Arrays.asList("1.0"));
    }

}
