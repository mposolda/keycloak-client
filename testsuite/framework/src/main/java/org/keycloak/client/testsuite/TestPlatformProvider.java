package org.keycloak.client.testsuite;

import org.keycloak.admin.client.Keycloak;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public interface TestPlatformProvider {

    ServerLifecycle getServerLifecycle();

    Keycloak getKeycloakAdminClient();

    interface ServerLifecycle {

        void start();

        void stop();
    }
}
