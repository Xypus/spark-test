package api.config

import org.jetbrains.exposed.dao.IntIdTable

object Users: IntIdTable() {
    val firstName = varchar("first_name", 50).nullable()
    val lastName = varchar("last_name",  50).nullable()
    val email = varchar("email", 50).nullable()
    val password = varchar("password", 50).nullable()
}