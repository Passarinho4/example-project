package com.avsystem.exampleproject

import com.avsystem.commons.misc.Timestamp
import com.avsystem.exampleproject.api.MainApi
import com.avsystem.exampleproject.backend.activity.UserActivity
import io.udash.rest.SttpRestClient
import monix.eval.Task
import sttp.client.SttpBackend

import java.util.{Calendar, Date}
import scala.concurrent.{Await, Future}
import scala.concurrent.duration.{Duration, DurationInt}


object TestDataPublisher extends App {

  import monix.execution.Scheduler.Implicits.global

  implicit val sttpBackend: SttpBackend[Future, Nothing, Nothing] = SttpRestClient.defaultBackend()

  val apiClient: MainApi = SttpRestClient[MainApi](baseUri = "http://localhost:9090")

  val calendar = Calendar.getInstance()
  calendar.set(2020, 1, 1)
  val fromTimestamp = Timestamp(calendar.getTimeInMillis)
  val count = 1000
  val users = Iterator.continually(Set("Miron", "Marcin", "Paweł")).flatten

  val generateTasks = (0 until count).map { i =>
    println(i)
    apiClient.userApi.logActivity(users.next(), UserActivity.Login, fromTimestamp + i.minutes)
  }

  val allTask = for {
    _ <- apiClient.userApi.purge()
    _ <- Task.sequence(generateTasks)
  } yield ()

  Await.ready(allTask.runToFuture, Duration.Inf)
  println("Done!")
  sttpBackend.close()
}
