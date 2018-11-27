package com.hastybox.dradizz.core.media

/**
  * Common media properties shared between internal and external media representations
  *
  * @author suicide (suicide@get-it.us)
  */
trait MediaCommon {

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

/**
  * Some kind of general, external media information of a tv show or a movie
  *
  * @author suicide (suicide@get-it.us)
  */
trait MediaInfo extends MediaCommon

/**
  * Internal representation of a tv show or a movie
  *
  * @author suicide (suicide@get-it.us)
  */
trait Media extends MediaCommon