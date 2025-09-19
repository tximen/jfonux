package com.jfonux.controls;

import org.junit.jupiter.api.Test;

import java.net.URL;

public class TestResource {

    @Test
    public void testLoader() {
        String source = "fxml/hamburgerView.fxml";

        URL resource = Thread.currentThread().getContextClassLoader().getResource(source);
        System.err.println("resource: " + resource);

        resource = TestResource.class.getResource("fxml/hamburgerView.fxml");
        System.err.println("resource: " + resource);
        resource = TestResource.class.getResource("/fxml/hamburgerView.fxml");
        System.err.println("resource: " + resource);
    }
}
