package scalene.vector

import scala.math._
import grizzled.slf4j.Logging

trait vec

object vec extends Logging { self =>

  private object Random {
    val rand = new scala.util.Random()
    def uniform(lo: Double = 0.0, hi: Double = 1.0): Double = (hi - lo) * rand.nextDouble + lo
    def uniform(lo: Float, hi: Float): Float = (hi - lo) * rand.nextFloat + lo
    def gaussian(mean: Double, std: Double): Double = rand.nextGaussian * std + mean
  }

  def apply(x: V, y: V) = new vec2(x,y)
  def apply(a: (V,V)) = new vec2(a._1, a._2)
//  def apply(x:V, y:V, z:V) = new vec3(x,y,z)
//  def apply(a: (V,V,V)) = new vec3(a._1, a._2, a._3)


  /*** 2-D ***/

  def lerp(a:vec2, b:vec2, t:V) = {
    if(0 <= t && t <= 1) {}
    else warn("lerp() warning: t=%f out of range[0,1]" format t)
    a*(1-t) + b*t
  }

  def pow(v:vec2, p:Double) = {
    vec(math.pow(v.x, p), math.pow(v.y,p))
  }

  object polar {
    def apply(r:V, t:Radian) = new vec2(r*cos(t), r*sin(t))
    def apply(p:(V, Radian)) = new vec2(p._1*cos(p._2), p._1*sin(p._2))
    def apply(v:vec2):vec2 = apply(v.length, v.angle)
    def random(r:Float) = polar(Random.uniform(0,r), Random.uniform(0,math.Pi*2))
  }

  /*** 3-D ***/

//  def lerp(a:vec3, b:vec3, t:V) = {
//    if(0 <= t && t <= 1.000001) {}
//    else printf("lerp() warning: t=%f out of range[0,1]", t)
//    a*(1-t) + b*t
//  }
//  def pow(v:vec3, p:Double) = {
//    vec3(math.pow(v.x, p), math.pow(v.y,p), math.pow(v.z,p))
//  }
}
