package com.hastybox.dradizz.core.media

/**
  * Some kind of media information: a tv show or a movie
  *
  * @author suicide (suicide@get-it.us)
  */
trait Media {

  /**
    * title of the media item
    * @return string title
    */
  def title: String

  /**
    * external media Ids of this media item
    * @return all known external media ids
    */
  def externalIds: Set[ExternalMediaId]

}


/**
  * an external ID, e.g. an IMDB id
  *
  * @author suicide (suicide@get-it.us)
  */
trait ExternalMediaId