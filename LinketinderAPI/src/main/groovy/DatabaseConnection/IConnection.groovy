package DatabaseConnection

import groovy.sql.Sql

interface IConnection {
    Sql connect()
}