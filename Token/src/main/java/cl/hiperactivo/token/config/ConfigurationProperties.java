package cl.hiperactivo.token.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "config")
public class ConfigurationProperties {

    private String SECRETKEY;

    public void setSECRETKEY(String SECRETKEY) {
        this.SECRETKEY = SECRETKEY;
    }

    public String getSECRETKEY() {
        return SECRETKEY;
    }

    @Override
    public String toString() {
        return "ConfigurationProperties{" +
                "SECRETKEY='" + SECRETKEY + '\'' +
                '}';
    }

}

