package scalene.vector

import scala.math._
//
//trait vec3base {
//
//  def x:V
//  def y:V
//  def z:V
//
//  def isValid():Boolean = !x.isNaN && !y.isNaN && !z.isNaN
//
//  @inline def lengthSquared:Float = x*x + y*y + z*z
//  @inline def length:Float = math.sqrt(lengthSquared).toFloat
//
//  def project(other:vec3):vec3 = {
//    val denom = (other dot other)
//    if(denom < vec3.eps) return vec3.zero
//    else return other * ((this dot other)/denom)
//  }
//  def unit = {
//    val len = length
//    if(len < vec3.eps || len.isNaN) vec3.zero
//    else this / len
//  }
//  def limit(cap:Float) = {
//    val len = length
//    if (len > cap && !len.isNaN) {
//      vec3(
//        x * cap/len,
//        y * cap/len,
//        z * cap/len
//      )
//    }
//    else this
//  }
//  def manhattan = math.abs(x) + math.abs(y) + math.abs(z)
//
//  def flipX = vec(-x, y, z)
//  def flipY = vec(x, -y, z)
//  def flipZ = vec(x, y, -z)
//
//  def +(v:vec3):vec3 = vec3(x+v.x, y+v.y, z+v.z)
//  def -(v:vec3):vec3 = vec3(x-v.x, y-v.y, z-v.z)
//  def dot(v:vec3):Float = (x*v.x + y*v.y + z*v.z)
//  def *(c:Float):vec3 = vec3(x*c, y*c, z*c)
//  def *(c:Double):vec3 = vec3(x*c toFloat, y*c toFloat, z*c toFloat)
//  def *(v:vec3):vec3 = vec3(x*v.x, y*v.y, z*v.z)
//  def /(c:Float):vec3 = vec3(x/c, y/c, z/c)
//
//  def +=(v:vec3) { x+=v.x; y+=v.y; z+=v.z }
//  def -=(v:vec3) { x-=v.x; y-=v.y; z-=v.z }
//  def *=(v:vec3) = { x *= v.x; y *= v.y; z *= v.z }
//  def *=(c:Float) = { x *= c; y *= c; z *= c }
//
//  def unary_- :vec3 = new vec3(-x, -y, -z)
//
//  def <(v:vec3) = x < v.x && y < v.y && z < v.z
//  def <=(v:vec3) = x <= v.x && y <= v.y && z <= v.z
//  def >(v:vec3) = x > v.x && y > v.y && z > v.z
//  def >=(v:vec3) = x >= v.x && y >= v.y && z >= v.z
//
//  override def toString = "vec3(%f, %f, %f)".format(x,y,z)
//}
