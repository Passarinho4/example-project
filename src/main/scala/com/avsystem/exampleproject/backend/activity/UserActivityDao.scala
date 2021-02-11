package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.mongo.typed.{MongoFilter, TypedMongoCollection}
import com.avsystem.exampleproject.backend.utils.DaoUtils
import monix.eval.Task

class DeviceActivityDao(collection: TypedMongoCollection[DeviceActivityLog]) extends DaoUtils {

  def insert(device: DeviceActivityLog): Task[Unit] = collection.insertOne(device).unit()

  def findBy(device: String): Task[List[DeviceActivityLog]] = collection.find(
    DeviceActivityLog.ref(_.device) === device
  ).toListL

  def isEmpty: Task[Boolean] = collection.find().isEmptyL

  def removeAll(): Task[Unit] = collection.deleteMany(MongoFilter.Empty()).map(_ => ())

}
