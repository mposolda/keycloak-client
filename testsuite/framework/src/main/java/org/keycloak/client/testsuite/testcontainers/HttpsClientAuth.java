package org.keycloak.client.testsuite.testcontainers;

/**
 * Forked from https://github.com/dasniko/testcontainers-keycloak/blob/main/src/main/java/dasniko/testcontainers/keycloak/HttpsClientAuth.java
 */
public enum HttpsClientAuth {

    NONE,
    REQUEST,
    REQUIRED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
