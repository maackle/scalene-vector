package scalene.vector

import scala.math._
import scalene.util._

  object vec2 {

    lazy val zero = new vec2(0,0)
    lazy val one = new vec2(1,1)
    val eps:Float = 0.001f

    object polar {
      def apply(r:Float, t:Double) = new vec2(r*cos(t), r*sin(t))
      def apply(v:vec2):vec2 = polar(v.length, v.angle)
      def random(r:Float) = polar(Random.uniform(0,r), Random.uniform(0,math.Pi*2))
    }

    def lerp(a:vec2, b:vec2, t:Float) = {
      if(0 <= t && t <= 1.000001) {}
      else printf("lerp() warning: t=%f out of range[0,1]", t)
      a*(1-t) + b*t
    }

    object immutable {
      import scalene.vector.vec2.{mutable=>mut}
      case class vec2(x:Float,y:Float) extends vec2base {
        def mutable = new mut.vec2(x,y)

        override def hashCode = ((31*x + y)*31).toInt
      }
    }

    object mutable {

      class vec2(var x:Float, var y:Float) extends vec2base {

        import scalene.vector.vec2.{immutable=>imm}
        def immutable = new imm.vec2(x,y)
        @inline
        def +=(v:vec2) { x+=v.x; y+=v.y }
        @inline
        def -=(v:vec2) { x-=v.x; y-=v.y }
        @inline
        def *=(v:vec2) = {
          x *= v.x
          y *= v.y
        }
        @inline
        def *=(c:Float) = {
          x *= c
          y *= c
        }
        @inline
        def set(v:vec2) {
          x = v.x
          y = v.y
        }
      }
    }

  }

  trait vec2base extends Validates {

    def x :Float
    def y :Float


    def equals(other: Object):Boolean = {
      other match {
        case v:vec2base => x == v.x && y == v.y
        case _ => false
      }
    }
    def valid():Boolean = {
      val v = !x.isNaN && !y.isNaN
      v
    }

    @inline
    def lengthSquared = x*x + y*y
    @inline
    def length = sqrt(lengthSquared).toFloat
    @inline
    def manhattan = math.abs(x) + math.abs(y)

    def rotate(rad:Double):vec2 = {
      val ca = cos(rad).toFloat
      val sa = sin(rad).toFloat
      vec ( x*ca - y*sa,
        y*ca + x*sa )
    }
    def project(other:vec2):vec2 = {
      val denom = (other dot other)
      if(denom < vec2.eps) return vec2.zero
      else return other * ((this dot other)/denom)
    }
    def unit = {
      val len = length
      if(len < vec2.eps || len.isNaN) vec2.zero
      else this / len
    }
    def limit(cap:Float):vec2 = {
      val len = length
      if (len > cap && !len.isNaN) {
        new vec2(
          x * cap/len,
          y * cap/len
        )
      }
      else new vec2(x,y) // FIXME unnecessary copy
    }

    @inline
    def angle:Float = {
      if(x!=0 || y!=0) atan2(y,x).toFloat else 0
    }

    def flipX = new vec2(-x, y)
    def flipY = new vec2(x, -y)

    def +(v:vec2):vec2 = new vec2(x+v.x, y+v.y)
    def -(v:vec2):vec2 = new vec2(x-v.x, y-v.y)
    def *(c:Float):vec2 = new vec2(x*c, y*c)
    def *(c:Double):vec2 = new vec2(x*c toFloat, y*c toFloat)
    def *(v:vec2):vec2 = new vec2(x*v.x, y*v.y)
    def /(c:Float):vec2 = new vec2(x/c, y/c)

    @inline
    def dot(v:vec2):Float = (x*v.x + y*v.y)

    @inline
    def polar = (length,angle)

    @inline
    def unary_- : vec2 = new vec2(-x, -y)

    @deprecated
    def <(v:vec2) = x < v.x && y < v.y
    def <=(v:vec2) = x <= v.x && y <= v.y
    def >(v:vec2) = x > v.x && y > v.y
    def >=(v:vec2) = x >= v.x && y >= v.y

  }

