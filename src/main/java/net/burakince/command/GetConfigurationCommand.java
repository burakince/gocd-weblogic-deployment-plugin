package net.burakince.command;

import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.HashMap;
import java.util.Map;

public class GetConfigurationCommand extends AbstractCommand {

    @Override
    public GoPluginApiResponse execute(GoPluginApiRequest request) {
        Map config = new HashMap();

        loadConfiguration(config, "0", "Url", true, URL_PROPERTY);
        loadConfiguration(config, SECURE_CONNECTION, "1", "Secure Connection", false, SECURE_CONNECTION_PROPERTY);
        loadConfiguration(config, REQUEST_TYPE, "2", "Request Type", false, REQUEST_PROPERTY);
        loadConfiguration(config, "3", "Additional Options", false, ADDITIONAL_OPTIONS);

        return prepareResponse(DefaultGoPluginApiResponse.SUCCESS_RESPONSE_CODE, config);
    }

    private void loadConfiguration(Map config, String displayOrder, String displayName, boolean required, String configurationKey) {
        loadConfiguration(config, null, displayOrder, displayName, required, configurationKey);
    }

    private void loadConfiguration(Map config, String defaultValue, String displayOrder, String displayName, boolean required, String configurationKey) {
        Map configurations = new HashMap();
        if (defaultValue != null) {
            configurations.put("default-value", defaultValue);
        }
        configurations.put("display-order", displayOrder);
        configurations.put("display-name", displayName);
        configurations.put("required", required);
        config.put(configurationKey, configurations);
    }

}
