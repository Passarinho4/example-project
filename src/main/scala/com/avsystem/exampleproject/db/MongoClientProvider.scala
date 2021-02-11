package com.avsystem.exampleproject.db

import com.mongodb.reactivestreams.client.{MongoClient, MongoClients}
import de.flapdoodle.embed.mongo.MongodStarter
import de.flapdoodle.embed.mongo.config.{MongodConfig, Net}
import de.flapdoodle.embed.mongo.distribution.Version
import de.flapdoodle.embed.process.runtime.Network


class MongoClientProvider {

  private val port = Network.getFreeServerPort
  private val starter = MongodStarter.getDefaultInstance
  private val mongodConfig = MongodConfig.builder
    .version(Version.Main.PRODUCTION)
    .net(new Net(port, Network.localhostIsIPv6))
    .build

  private val mongodExecutable = starter.prepare(mongodConfig)
  mongodExecutable.start()

  def getMongoClient: MongoClient = MongoClients.create(s"mongodb://localhost:$port")

}
