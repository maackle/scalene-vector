package scalene

import org.jbox2d.common.{Vec2 => b2vec2}


package object vector {

  type vec2 = vec2.mutable.vec2

  implicit def b2vec2_vec2(v:b2vec2):vec2 = new vec2(v.x, v.y)
  implicit def vec2_tuple(v:vec2):(Float, Float) = (v.x, v.y)
  implicit def tuple_vec2(x:(Double, Double)):vec2 = new vec2(x._1, x._2)
  implicit def Double_Float(c:Double):Float = c.toFloat

}