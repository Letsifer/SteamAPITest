package edu.altstu.testapi.util;

import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author gea
 */
@Setter
@NoArgsConstructor
public class AddressMaker {

    /**
     * Example of address: private String address =
     * "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v2/?key=D7FD21E5F0C49A925E78DEA682AE4338&SteamIDs=(76561198074290718,76561198087274995,76561198281494851,76561198194103706)";
     */
    private final static String startUrl = "http://api.steampowered.com/";

    @Setter(AccessLevel.NONE)
    private Map<String, String> parameters = new HashMap<>();

    private String key;
    private String version;
    private String method;
    private String apiInterface;

    public AddressMaker(String version, String method, String apiInterface) {
        this.key = Util.getKey();
        this.version = version;
        this.method = method;
        this.apiInterface = apiInterface;
    }
    
    /**
     * Add parameter to url parameters list. If there are list of values, they
     * should be appended in other place.
     *
     * @param name
     * @param value
     */
    public void addParameter(String name, String value) {
        if (Util.isStringEmpty(name)) {
            throw new IllegalArgumentException("Parameters name is null");
        }
        if (Util.isStringEmpty(value)) {
            throw new IllegalArgumentException("Parameters value is null fro name " + name);
        }
        parameters.put(name, value);
    }

    public boolean removeParameter(String name) {
        return parameters.remove(name) == null;
    }

    public String getFullAddress() {
        StringBuffer buffer = new StringBuffer(startUrl);

        addPartOfAddress(buffer, "Api interface", apiInterface);
        addPartOfAddress(buffer, "Method", method);
        addPartOfAddress(buffer, "Version", version);
        addKey(buffer);

        parameters
                .entrySet()
                .forEach(entry -> addParameter(buffer, entry));
        return buffer.toString();
    }

    private void addPartOfAddress(StringBuffer buffer, String key, String value) {
        if (!Util.isStringEmpty(value)) {
            buffer.append(value).append("/");
        } else {
            throw new IllegalArgumentException(key + " is null");
        }
    }

    private void addKey(StringBuffer buffer) {
        if (!Util.isStringEmpty(key)) {
            buffer.append("?key=").append(key);
        } else {
            throw new IllegalArgumentException("Key is null");
        }
    }

    private void addParameter(StringBuffer buffer, Map.Entry<String, String> entry) {
        buffer.append("&").append(entry.getKey()).append("=").append(entry.getValue());
    }

}
