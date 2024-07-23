package org.keycloak.client.testsuite.admin;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.client.testsuite.AbstractClientTest;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.test.framework.annotations.KeycloakIntegrationTest;
import org.keycloak.test.framework.annotations.TestAdminClient;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
@KeycloakIntegrationTest
public class RealmsResourceTest extends AbstractClientTest {

    @TestAdminClient
    Keycloak adminClient;

    @Test
    public void testRealms() {
        List<RealmRepresentation> realms = adminClient.realms().findAll();
        getLogger().tracef("Realms count: %d", realms.size());

        Assertions.assertFalse(realms.isEmpty());
        Assertions.assertEquals(1, realms.size());
        Assertions.assertEquals("master", realms.get(0).getRealm());
    }

}
