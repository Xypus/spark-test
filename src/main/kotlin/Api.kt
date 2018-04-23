package api

import api.config.Users
import model.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SchemaUtils.create
import org.jetbrains.exposed.sql.SchemaUtils.drop

import spark.kotlin.*
//import com.google.gson.GsonBuilder

fun main(args: Array<String>) {
    get("/hello/:name") {
        "Hello ${params(":name")}"
    }
    get("/seed") {
        Database.connect(
                "jdbc:postgresql://${System.getenv("DB_URL")}/${System.getenv("DB_NAME")}",
                driver = "org.postgresql.Driver",
                user = System.getenv("DB_USER"),
                password = System.getenv("DB_PASSWORD")
        )

        transaction {
            drop(Users)
            create(Users)
            val user = User.new {
                firstName = "Test"
                lastName = "Testowski"
                email = "test@example.com"
                password = "test1234"
            }

            val newUser = User.findById(user.id)
            println("USER FULL NAME: ${newUser?.firstName} ${newUser?.lastName}")
            true
        }
    }
}

