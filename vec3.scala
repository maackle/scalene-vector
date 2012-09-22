package scalene.vector

import scala.math._

  object vec3 {
    implicit def vec_tuple(v:vec3):(Float, Float, Float) = (v.x, v.y, v.z)
    implicit def tuple_vec(x:(Double, Double, Double)) = new vec3(x._1, x._2, x._3)
    implicit def Double_Float(c:Double):Float = c.toFloat
    //   implicit def Float_Double(c:Float):Double = c.toDouble
    def zero = new vec3(0,0,0)
    val eps:Float = 0.001f

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

  class vec3(var x:Float, var y:Float, var z:Float)  {

    def valid():Boolean = {
      val v = !x.isNaN && !y.isNaN
      v
    }

    def lengthSquared:Float = x*x + y*y + z*z
    def length:Float = math.sqrt(lengthSquared).toFloat

    def project(other:vec3):vec3 = {
      val denom = (other dot other)
      if(denom < vec3.eps) return vec3.zero
      else return other * ((this dot other)/denom)
    }
    def unit = {
      val len = length
      if(len < vec3.eps || len.isNaN) vec3.zero
      else this / len
    }
    def limit(cap:Float) = {
      val len = length
      if (len > cap && !len.isNaN) {
        vec3(
          x * cap/len,
          y * cap/len,
          z * cap/len
        )
      }
      else this
    }
    def manhattan = math.abs(x) + math.abs(y) + math.abs(z)

    def flipX = vec(-x, y, z)
    def flipY = vec(x, -y, z)
    def flipZ = vec(x, y, -z)

    def +(v:vec3):vec3 = vec3(x+v.x, y+v.y, z+v.z)
    def -(v:vec3):vec3 = vec3(x-v.x, y-v.y, z-v.z)
    def dot(v:vec3):Float = (x*v.x + y*v.y + z*v.z)
    def *(c:Float):vec3 = vec3(x*c, y*c, z*c)
    def *(c:Double):vec3 = vec3(x*c toFloat, y*c toFloat, z*c toFloat)
    def *(v:vec3):vec3 = vec3(x*v.x, y*v.y, z*v.z)
    def /(c:Float):vec3 = vec3(x/c, y/c, z/c)

    def +=(v:vec3) { x+=v.x; y+=v.y; z+=v.z }
    def -=(v:vec3) { x-=v.x; y-=v.y; z-=v.z }
    def *=(v:vec3) = { x *= v.x; y *= v.y; z *= v.z }
    def *=(c:Float) = { x *= c; y *= c; z *= c }

    def unary_- :vec3 = new vec3(-x, -y, -z)

    def <(v:vec3) = x < v.x && y < v.y && z < v.z
    def <=(v:vec3) = x <= v.x && y <= v.y && z <= v.z
    def >(v:vec3) = x > v.x && y > v.y && z > v.z
    def >=(v:vec3) = x >= v.x && y >= v.y && z >= v.z

    override def toString = "vec3(%f, %f, %f)".format(x,y,z)
  }
