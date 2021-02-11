package com.avsystem.exampleproject

import com.avsystem.commons.mongo.typed.TypedMongoCollection
import com.avsystem.exampleproject.backend.activity.{DeviceActivityDao, DeviceActivityLog}
import com.avsystem.exampleproject.db.MongoClientProvider
import com.mongodb.reactivestreams.client.{MongoClient, MongoClients}


class DaosWrapper(clientProvider: MongoClientProvider) {

  val client: MongoClient = clientProvider.getMongoClient

  val deviceActivityDao = new DeviceActivityDao(new TypedMongoCollection[DeviceActivityLog](
    client.getDatabase("example").getCollection("device")))

}
