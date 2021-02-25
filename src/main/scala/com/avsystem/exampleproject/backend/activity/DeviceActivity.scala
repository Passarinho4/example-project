package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.ISeq
import com.avsystem.commons.misc.{AutoNamedEnum, NamedEnumCompanion}

sealed trait DeviceActivity extends AutoNamedEnum {
  def name: String
}

object DeviceActivity extends NamedEnumCompanion[DeviceActivity] {
  case object Register extends DeviceActivity
  case object Telemetry extends DeviceActivity

  override val values: ISeq[DeviceActivity] = caseObjects
}
