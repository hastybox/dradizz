package com.hastybox.dradizz.core.download

import com.hastybox.dradizz.core.media.Media

import scala.language.higherKinds

/**
  * Search for [[Downloadable]]s for given [[Media]]
  *
  * @author suicide (suicide@get-it.us)
  */
trait DownloadableSearchService[F[_], Med <: Media, Down <: Downloadable] {

  def find(media: Med): F[List[Down]]

}
