package model

import api.config.Users
import org.jetbrains.exposed.dao.*

class User(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<User>(Users)

    var firstName by Users.firstName
    var lastName by Users.lastName
    var email by Users.email
    var password by Users.password

}