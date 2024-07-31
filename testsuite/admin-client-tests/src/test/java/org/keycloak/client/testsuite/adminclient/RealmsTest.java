package org.keycloak.client.testsuite.adminclient;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.client.testsuite.testcontainers.KeycloakContainer;
import org.keycloak.representations.idm.RealmRepresentation;
import org.testcontainers.shaded.org.hamcrest.MatcherAssert;
import org.testcontainers.shaded.org.hamcrest.Matchers;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class RealmsTest {

    private static KeycloakContainer keycloakContainer;

    private static Keycloak adminClient;

    public static final String MASTER_REALM = "master";

    public static final String ADMIN_CLI_CLIENT = "admin-cli";

    @BeforeAll
    // TODO:mposolda Better way for test containers instead of "static" method
    public static void beforeAll() {
        // TODO:mposolda jboss logging?
        System.err.println("Starting everything");

        keycloakContainer = new KeycloakContainer().useTls();
        keycloakContainer.start();

        adminClient = getKeycloakAdminClient(true);
    }

    @AfterAll
    public static void afterAll() {
        // TODO:mposolda jboss logging?
        System.err.println("Closing everything");
        adminClient.close();
        keycloakContainer.close();
    }

    public static Keycloak getKeycloakAdminClient(boolean useTls) {
        if (useTls) {
            return Keycloak.getInstance(keycloakContainer.getAuthServerUrl(), MASTER_REALM, keycloakContainer.getAdminUsername(),
                    keycloakContainer.getAdminPassword(), ADMIN_CLI_CLIENT, keycloakContainer.buildSslContext());
        } else {
            return Keycloak.getInstance(keycloakContainer.getAuthServerUrl(), MASTER_REALM, keycloakContainer.getAdminUsername(), keycloakContainer.getAdminPassword(), ADMIN_CLI_CLIENT);
        }
    }

    @Test
    public void realmsList() {
        List<RealmRepresentation> realms = adminClient.realms().findAll();
        MatcherAssert.assertThat(realms.stream()
                .map(RealmRepresentation::getRealm)
                .filter(realmName -> MASTER_REALM.equals(realmName))
                .findFirst()
                .isPresent(), Matchers.is(true));
    }
}
