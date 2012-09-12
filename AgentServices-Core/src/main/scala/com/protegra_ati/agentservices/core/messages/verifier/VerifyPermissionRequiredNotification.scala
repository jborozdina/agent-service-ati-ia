package com.protegra_ati.agentservices.core.messages.verifier

import com.protegra_ati.agentservices.core.messages._
import com.protegra_ati.agentservices.core.events._

case class VerifyPermissionRequiredNotification(override val eventKey: EventKey) extends Message(eventKey) with Notification {
     override def channel = Channel.Verify

     def generateEvent(): MessageEvent[ _ <: Message with Notification ] = {
       new VerifyPermissionRequiredNotificationReceivedEvent(this)
     }
}