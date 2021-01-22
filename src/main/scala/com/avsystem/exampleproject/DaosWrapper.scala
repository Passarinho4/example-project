package com.avsystem.exampleproject

import com.avsystem.commons.mongo.typed.TypedMongoCollection
import com.avsystem.exampleproject.backend.user.{User, UserDao}
import com.mongodb.reactivestreams.client.{MongoClient, MongoClients}


case class DaosWrapper(userDao: UserDao)

object DaosWrapper {
  val client: MongoClient = MongoClients.create()

  val daosWrapper: DaosWrapper = new DaosWrapper(
    new UserDao(new TypedMongoCollection[User](client.getDatabase("example").getCollection("user"))),
  )
}
