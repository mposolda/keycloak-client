/*
 * Copyright (c) 2021 Niko Köbler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.keycloak.client.testsuite.testcontainers;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 *
 * Forked from https://github.com/dasniko/testcontainers-keycloak/blob/main/src/main/java/dasniko/testcontainers/keycloak/KeycloakContainer.java
 *
 */
public class KeycloakContainer extends ExtendableKeycloakContainer<KeycloakContainer> {

    public KeycloakContainer() {
        super();
    }

    public KeycloakContainer(String dockerImageName) {
        super(dockerImageName);
    }

}
