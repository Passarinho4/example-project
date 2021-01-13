package com.avsystem.exampleproject.backend.utils

import monix.eval.Task

trait DaoUtils {
  implicit class TaskOps(task: Task[_]) {
    def unit(): Task[Unit] = task.map(_ => ())
  }
}
