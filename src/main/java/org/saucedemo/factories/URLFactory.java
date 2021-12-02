package org.saucedemo.factories;

import org.saucedemo.enums.Host;

import java.net.MalformedURLException;
import java.net.URL;

public class URLFactory {
    private URLFactory() {
        throw new IllegalStateException("Static factory class");
    }

    public static URL getHostURL(Host host) {
        try {
            return new URL(getHostUri(host));
        } catch (MalformedURLException e) {
            throw new IllegalStateException(String.format("%s is Malformed host URL.", getHostUri(host)), e);
        }
    }

    private static String getHostUri(Host host) {
        switch (host) {
            case SAUCELABS:
                String sauceUri = EnvFactory.getConfig().getString("SAUCE_URI");
                return "https://" + System.getenv("SAUCE_USERNAME") + ":" + System.getenv("SAUCE_ACCESS_KEY") + sauceUri + "/wd/hub";
            case BROWSERSTACK:
                // fall through - use setting as defined in the config file.
            case LOCALHOST:
                return EnvFactory.getConfig().getString("HOST_URI");
            default:
                throw new IllegalStateException(String.format("HOST_URI not defined in config file for host: %s", host));
        }
    }
}