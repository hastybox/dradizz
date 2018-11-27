package com.hastybox.dradizz.core.media

import scala.language.higherKinds

/**
  * a source of [[Media]] items like IMDB or TVMaze
  *
  * @author suicide (suicide@get-it.us)
  */
trait MediaDataSource[F[_], M <: Media] {

  /**
    * find media items by its title
    * @param title a (partial) title
    * @return a list of possible results, ordered by relevance
    */
  def find(title: String): F[List[M]]

  /**
    * find a media item by one of its external ids
    * @param id an external id that is supported by this media source
    * @return a media that is associated with the id
    */
  def find(id: ExternalMediaId): F[Option[M]]

}
