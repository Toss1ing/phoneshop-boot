package com.expertsoft.phoneshop.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "phoneshop")
public class PaginationProperties {

    int plpMaxPage = 5;

    public void setPlpMaxPage(int plpMaxPage) {
        this.plpMaxPage = plpMaxPage;
    }

    public int getPlpMaxPage() {
        return plpMaxPage;
    }
}
