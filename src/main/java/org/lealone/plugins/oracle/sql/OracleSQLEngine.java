/*
 * Copyright Lealone Database Group.
 * Licensed under the Server Side Public License, v 1.
 * Initial Developer: zhh
 */
package org.lealone.plugins.oracle.sql;

import org.lealone.db.session.ServerSession;
import org.lealone.plugins.oracle.server.OracleServerEngine;
import org.lealone.sql.SQLEngineBase;

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
