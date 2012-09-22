package scalene.vector

import scala.math._
import scalene.util._

  object vec {

    ///// 2-D
    @specialized
    def apply[T : Numeric](x: T, y: T) = {
      val n = implicitly[Numeric[T]]
      new vec2(n.toFloat(x), n.toFloat(y))
    }
    @specialized
    def apply[T : Numeric](a: (T,T)) = {
      val n = implicitly[Numeric[T]]
      new vec2(n.toFloat(a._1), n.toFloat(a._2))
    }

    def lerp(a:vec2, b:vec2, t:Float) = {
      if(0 <= t && t <= 1.000001) {}
      else printf("lerp() warning: t=%f out of range[0,1]", t)
      a*(1-t) + b*t
    }
    def pow(v:vec2, p:Float) = {
      vec(math.pow(v.x, p), math.pow(v.y,p))
    }

    ///// 3-D

    def apply[T : Numeric](x: T, y: T, z:T) = {
      val n = implicitly[Numeric[T]]
      new vec3(n.toFloat(x), n.toFloat(y), n.toFloat(z))
    }
    def apply[T : Numeric](a: (T,T,T)) = {
      val n = implicitly[Numeric[T]]
      new vec3(n.toFloat(a._1), n.toFloat(a._2), n.toFloat(a._3))
    }
    def lerp(a:vec3, b:vec3, t:Float) = {
      if(0 <= t && t <= 1.000001) {}
      else printf("lerp() warning: t=%f out of range[0,1]", t)
      a*(1-t) + b*t
    }
    def pow(v:vec3, p:Float) = {
      vec3(math.pow(v.x, p), math.pow(v.y,p), math.pow(v.z,p))
    }
  }
