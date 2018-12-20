package com.hastybox.dradizz.core.download

import java.time.Instant

import scala.language.higherKinds

/**
  * Downloads a [[com.hastybox.dradizz.core.media.Media]] file(s) using a [[Downloadable]] and a
  * configured backend service
  *
  * @author suicide (suicide@get-it.us)
  */
trait DownloadService[F[_], D <: Downloadable] {

  /**
    * triggers the download of a [[Downloadable]] item in a configured backend service.
    *
    * the download is being monitored and access to the current state is given through the returned [[DownloadPromise]]
    * @param downloadable the item to be downloaded
    * @return a promise like reference to the ongoing download to view the current state
    */
  def download(downloadable: D): F[DownloadPromise[F]]

}

/**
  * Retrieves an actually downloadable [[DownloadContainer]] that is referenced within a [[Downloadable]].
  * This service is intended to be used by a [[DownloadService]]
  *
  * @author suicide (suicide@get-it.us)
  */
trait DownloadContainerService[F[_], D <: Downloadable, C <: DownloadContainer] {

  /**
    * Retrieves a [[DownloadContainer]] from the information given by the given [[Downloadable]]
    * @param downloadable a downloadable item
    * @return a container that can be used to download a [[com.hastybox.dradizz.core.media.Media]]
    */
  def get(downloadable: D): F[C]

}


trait DownloadPromise[F[_]] {

  def state: F[DownloadState]

  def progress: F[DownloadProgress]

  def start: F[Instant]

  def end: F[Option[Instant]]

  def completed: F[Boolean]

  def cancel: F[Unit]
}

/**
  * a download progress index, giving a an estimated progress of completion (whatever that actually is and means)
  * @param value a progression value between 0 and 100
  * @todo enforce value range using refined
  */
case class DownloadProgress(value: Int)

/**
  * the state of a download
  */
sealed trait DownloadState {

  /**
    * marks an end state
    * @return true if is an end state, otherwise false
    */
  def `final`: Boolean

}

object DownloadState {

  case object InternalError extends DownloadState {
    val `final` = true
  }

}
