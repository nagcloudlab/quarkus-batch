package org.acme.greeting.extension.deployment;

import io.quarkus.deployment.annotations.BuildStep;
import io.quarkus.deployment.builditem.FeatureBuildItem;
import org.acme.greeting.extension.GreetingExtensionServlet;
import io.quarkus.undertow.deployment.ServletBuildItem;

class GreetingExtensionProcessor {

    private static final String FEATURE = "greeting-extension";

    @BuildStep
    FeatureBuildItem feature() {
        return new FeatureBuildItem(FEATURE);
    }

    @BuildStep
    ServletBuildItem createServlet() {
        System.out.println("----------------------------------");
        System.out.println("GreetingExtensionProcessor::createServlet::BuildStep");
        System.out.println("----------------------------------");
        ServletBuildItem servletBuildItem = ServletBuildItem
                .builder("greeting-extension", GreetingExtensionServlet.class.getName()).addMapping("/greeting")
                .build();
        return servletBuildItem;
    }
}
