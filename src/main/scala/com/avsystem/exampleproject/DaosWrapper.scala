package com.avsystem.exampleproject

import com.avsystem.commons.mongo.typed.TypedMongoCollection
import com.avsystem.exampleproject.backend.activity.{UserActivityDao, UserActivityLog}
import com.avsystem.exampleproject.db.MongoClientProvider
import com.mongodb.reactivestreams.client.{MongoClient, MongoClients}


class DaosWrapper(clientProvider: MongoClientProvider) {

  val client: MongoClient = clientProvider.getMongoClient

  val userActivityDao = new UserActivityDao(new TypedMongoCollection[UserActivityLog](
    client.getDatabase("example").getCollection("user")))

}
