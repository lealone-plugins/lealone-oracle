/*
 * Copyright Lealone Database Group.
 * Licensed under the Server Side Public License, v 1.
 * Initial Developer: zhh
 */
package com.lealone.plugins.oracle.sql;

import com.lealone.db.session.ServerSession;
import com.lealone.sql.SQLEngineBase;

import com.lealone.plugins.oracle.server.OracleServerEngine;

public class OracleSQLEngine extends SQLEngineBase {

    public OracleSQLEngine() {
        super(OracleServerEngine.NAME);
    }

    @Override
    public String quoteIdentifier(String identifier) {
        return OracleSQLParser.quoteIdentifier(identifier);
    }

    @Override
    public OracleSQLParser createParser(ServerSession session) {
        return new OracleSQLParser(session);
    }
}
