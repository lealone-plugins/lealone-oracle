/*
 * Copyright Lealone Database Group.
 * Licensed under the Server Side Public License, v 1.
 * Initial Developer: zhh
 */
package com.lealone.plugins.oracle.server;

import com.lealone.server.ProtocolServer;
import com.lealone.server.ProtocolServerEngineBase;

public class OracleServerEngine extends ProtocolServerEngineBase {

    public static final String NAME = "Oracle";

    public OracleServerEngine() {
        super(NAME);
    }

    @Override
    protected ProtocolServer createProtocolServer() {
        return new OracleServer();
    }
}
