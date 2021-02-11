package com.avsystem.exampleproject

import java.util.Calendar

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.api.MainApi
import com.avsystem.exampleproject.backend.activity.DeviceActivity
import io.udash.rest.SttpRestClient
import monix.eval.Task
import sttp.client.SttpBackend

import scala.concurrent.duration.{Duration, DurationInt}
import scala.concurrent.{Await, Future}


object TestDataPublisher extends App {

  import monix.execution.Scheduler.Implicits.global

  implicit val sttpBackend: SttpBackend[Future, Nothing, Nothing] = SttpRestClient.defaultBackend()

  val apiClient: MainApi = SttpRestClient[MainApi](baseUri = "http://localhost:9090")

  val calendar = Calendar.getInstance()
  calendar.set(2020, 1, 1)
  val fromTimestamp = Timestamp(calendar.getTimeInMillis)
  val count = 1000
  val devices = Iterator.continually(Set("Miron", "Marcin", "Paweł")).flatten

  val generateTasks = (0 until count).map { i =>
    println(i)
    apiClient.deviceApi.logActivity(devices.next(), DeviceActivity.Login, fromTimestamp + i.minutes)
  }

  val allTask = for {
    _ <- apiClient.deviceApi.purge()
    _ <- Task.sequence(generateTasks)
  } yield ()

  Await.ready(allTask.runToFuture, Duration.Inf)
  println("Done!")
  sttpBackend.close()
}
