package org.keycloak.client.testsuite;

import org.jboss.logging.Logger;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public abstract class AbstractClientTest {

    protected Logger getLogger() {
        return Logger.getLogger(getClass());
    }
}
