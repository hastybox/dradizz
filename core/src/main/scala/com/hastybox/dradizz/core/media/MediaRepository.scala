package com.hastybox.dradizz.core.media

import scala.language.higherKinds

/**
  * Access to on-site [[Media]] storage
  *
  * @author suicide (suicide@get-it.us)
  */
trait MediaRepository[F[_], M <: Media] {

  /**
    * find [[Media]] items by its title
    * @param title a (partial) title
    * @return a list of possible results, ordered by relevance
    */
  def find(title: String): F[List[M]]

  /**
    * find a [[Media]] item by its [[MediaId]]
    * @param id unique id
    * @return a [[Media]]
    */
  def find(id: MediaId): F[Option[M]]

}
