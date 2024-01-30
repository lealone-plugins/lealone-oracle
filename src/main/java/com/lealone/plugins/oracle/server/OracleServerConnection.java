/*
 * Copyright Lealone Database Group.
 * Licensed under the Server Side Public License, v 1.
 * Initial Developer: zhh
 */
package com.lealone.plugins.oracle.server;

import com.lealone.db.scheduler.Scheduler;
import com.lealone.db.session.ServerSession;
import com.lealone.net.NetBuffer;
import com.lealone.net.WritableChannel;
import com.lealone.server.AsyncServerConnection;
import com.lealone.server.scheduler.SessionInfo;

public class OracleServerConnection extends AsyncServerConnection {

    private final OracleServer server;
    private final Scheduler scheduler;
    private ServerSession session;
    private SessionInfo si;

    protected OracleServerConnection(OracleServer server, WritableChannel writableChannel,
            Scheduler scheduler) {
        super(writableChannel);
        this.server = server;
        this.scheduler = scheduler;
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public SessionInfo getSessionInfo() {
        return si;
    }

    @Override
    public void closeSession(SessionInfo si) {
    }

    @Override
    public int getSessionCount() {
        return 1;
    }

    @Override
    public void close() {
        if (session == null)
            return;
        try {
            session.close();
            super.close();
        } catch (Exception e) {
        }
        session = null;
        si = null;
        server.removeConnection(this);
    }

    @Override
    public int getPacketLength() {
        return 0;
    }

    @Override
    public void handle(NetBuffer buffer) {
    }
}
