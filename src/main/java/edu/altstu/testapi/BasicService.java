package edu.altstu.testapi;

import edu.altstu.testapi.util.AddressMaker;
import edu.altstu.testapi.util.Util;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

/**
 *
 * @author gea
 */
public abstract class BasicService {

    private AddressMaker maker;

    public BasicService() {
        maker = new AddressMaker();
    }

    protected URL getUrl() throws IOException{
        maker.setKey(Util.getKey());
        maker.setApiInterface(getApiInterface());
        maker.setMethod(getMethod());
        maker.setVersion(getVersion());
        return new URL(maker.getFullAddress());
    }

    protected void addParameter(String name, String... values) {
        String value = values[0];
        if (values.length > 1) {
            StringBuffer buffer = new StringBuffer("(").append(value);
            Arrays.stream(values)
                    .skip(1)
                    .forEach(str -> buffer.append(",").append(str));
            buffer.append(")");
            value = buffer.toString();
        }
        maker.addParameter(name, value);
    }

    protected abstract String getApiInterface();

    protected abstract String getMethod();

    protected abstract String getVersion();

}
