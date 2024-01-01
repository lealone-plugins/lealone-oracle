/*
 * Copyright Lealone Database Group.
 * Licensed under the Server Side Public License, v 1.
 * Initial Developer: zhh
 */
package com.lealone.plugins.oracle.server;

import java.util.Map;

import com.lealone.common.logging.Logger;
import com.lealone.common.logging.LoggerFactory;
import com.lealone.db.scheduler.Scheduler;
import com.lealone.net.WritableChannel;
import com.lealone.server.AsyncServer;

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
