/*
 * Copyright Lealone Database Group.
 * Licensed under the Server Side Public License, v 1.
 * Initial Developer: zhh
 */
package org.lealone.plugins.oracle.server;

import java.util.Map;

import org.lealone.common.logging.Logger;
import org.lealone.common.logging.LoggerFactory;
import org.lealone.net.WritableChannel;
import org.lealone.server.AsyncServer;
import org.lealone.server.Scheduler;

public class OracleServer extends AsyncServer<OracleServerConnection> {

    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(OracleServer.class);

    public static final String VERSION = "21c";
    public static final int DEFAULT_PORT = 1521;

    @Override
    public String getType() {
        return OracleServerEngine.NAME;
    }

    @Override
    public void init(Map<String, String> config) {
        super.init(config);
    }

    @Override
    public synchronized void start() {
        super.start();
    }

    @Override
    protected int getDefaultPort() {
        return DEFAULT_PORT;
    }

    @Override
    protected OracleServerConnection createConnection(WritableChannel writableChannel,
            Scheduler scheduler) {
        return new OracleServerConnection(this, writableChannel, scheduler);
    }

    @Override
    protected void beforeRegister(OracleServerConnection conn, Scheduler scheduler) {
    }
}
