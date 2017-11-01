package net.burakince.command;

import com.google.gson.GsonBuilder;
import com.thoughtworks.go.plugin.api.request.GoPluginApiRequest;
import com.thoughtworks.go.plugin.api.response.DefaultGoPluginApiResponse;
import com.thoughtworks.go.plugin.api.response.GoPluginApiResponse;

import java.util.HashMap;
import java.util.Map;

public class ValidationCommand extends AbstractCommand {

    @Override
    public GoPluginApiResponse execute(GoPluginApiRequest request) {
        Map configMap = (Map) new GsonBuilder().create().fromJson(request.requestBody(), Object.class);
        Map validationResult = new HashMap();

        String urlValue = getUrlValue(configMap);
        if (urlValue == null || urlValue.trim().isEmpty()) {
            Map errorMap = new HashMap();
            errorMap.put(URL_PROPERTY, "URL cannot be empty");
            validationResult.put("errors", errorMap);
        }

        int responseCode = DefaultGoPluginApiResponse.SUCCESS_RESPONSE_CODE;
        return prepareResponse(responseCode, validationResult);
    }

    private String getUrlValue(Map configMap) {
        Map urlProperties = (Map) configMap.get(URL_PROPERTY);
        String urlValue = urlProperties != null ? (String) urlProperties.get("value") : null;
        return urlValue;
    }

}
