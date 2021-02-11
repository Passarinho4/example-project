package com.avsystem.exampleproject.backend.activity

import com.avsystem.commons.ISeq
import com.avsystem.commons.misc.{AutoNamedEnum, NamedEnumCompanion}

sealed trait DeviceActivity extends AutoNamedEnum {
  def name: String
}

object DeviceActivity extends NamedEnumCompanion[DeviceActivity] {
  case object Login extends DeviceActivity
  case object Logout extends DeviceActivity

  override val values: ISeq[DeviceActivity] = caseObjects
}
