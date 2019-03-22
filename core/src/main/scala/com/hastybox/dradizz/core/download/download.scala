package com.hastybox.dradizz.core.download

/**
  * A downloadable item, like a movie or a tv show episode referencing a torrent or nzb or something like that
  *
  * @author suicide (suicide@get-it.us)
  */
trait Downloadable

/**
  * A NZB or Torrent file
  *
  * @author suicide (suicide@get-it.us)
  */
trait DownloadContainer


/**
  * A unique identifier that represents a download of a [[DownloadContainer]]. There might be multiple downloads the
  * same container each with a unique id
  */
trait DownloadId
