package com.hastybox.dradizz.core.media

import com.hastybox.dradizz.core.media.MediaInfoSource.MediaInfoResult

import scala.language.higherKinds

/**
  * a source of [[MediaInfo]] items from like IMDB or TVMaze
  *
  * @author suicide (suicide@get-it.us)
  */
trait MediaInfoSource[F[_], M <: MediaInfo] {

  /**
    * find [[MediaInfo]] items by its title
    * @param title a (partial) title
    * @return a list of possible results, ordered by relevance
    */
  def find(title: String): F[MediaInfoResult[List[M]]]

  /**
    * find a [[MediaInfo]] item by one of its external ids
    * @param id an external id that is supported by this media source
    * @return a media that is associated with the id
    */
  def find(id: ExternalMediaId): F[MediaInfoResult[Option[M]]]

}

object MediaInfoSource {

  type MediaInfoResult[A] = Either[MediaInfoError, A]

  case class MediaInfoError(msg: String) extends RuntimeException(msg)

}
