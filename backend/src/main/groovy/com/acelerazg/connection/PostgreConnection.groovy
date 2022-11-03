package com.acelerazg.connection

class PostgreConnection extends Connection implements IConnection {
    static final Map dbConnParams = [
            url: 'jdbc:postgresql://localhost:5432/linketinderdb',
            user: 'postgres',
            password: 'postgres',
            driver: 'org.postgresql.Driver']

    @Override
    Map Connection() {
        return dbConnParams
    }
}
