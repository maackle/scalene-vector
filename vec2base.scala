package scalene.vector

import math._

abstract class vec2base extends vec {

  def x : V
  def y : V

  override def equals(other: Any):Boolean = {
    other match {
      case v:vec2 => x == v.x && y == v.y
      case _ => false
    }
  }

  // hashMap is defined only for the immutable class

  def isValid:Boolean = !x.isNaN && !y.isNaN

  @inline
  def lengthSquared = x*x + y*y
  @inline
  def length = sqrt(lengthSquared)
  @inline
  def manhattan = math.abs(x) + math.abs(y)

  def rotate(rad:Radian):vec2 = {
    val ca = cos(rad)
    val sa = sin(rad)
    vec ( x*ca - y*sa,
      y*ca + x*sa )
  }

  def tuple = (x,y)

  def project(other:vec2):vec2 = {
    val denom = (other dot other)
    if(denom < eps) return vec2.zero
    else other * ((this dot other)/denom)
  }

  def unit:vec2 = {
    val len = length
    if(len < eps || len.isNaN) vec2.zero
    else this / len
  }

  def limit(cap:Float):vec2 = {
    val len = length
    if (len > cap && !len.isNaN) {
      vec(
        x * cap/len,
        y * cap/len
      )
    }
    else vec(x,y) // FIXME unnecessary copy
  }

  @inline
  def angle:Float = {
    if(x!=0 || y!=0) atan2(y,x).toFloat else 0
  }

  def flipX = new vec2(-x, y)
  def flipY = new vec2(x, -y)

  def +(v:vec2):vec2 = new vec2(x+v.x, y+v.y)
  def -(v:vec2):vec2 = new vec2(x-v.x, y-v.y)
  def *(c:V):vec2 = new vec2(x*c, y*c)
  def *(v:vec2):vec2 = new vec2(x*v.x, y*v.y)
  def /(c:V):vec2 = new vec2(x/c, y/c)

  @inline
  def dot(v:vec2):V = (x*v.x + y*v.y)

  @inline
  def polar = (length,angle)

  @inline
  def unary_- : vec2 = new vec2(-x, -y)

  @deprecated
  def <(v:vec2) = x < v.x && y < v.y
  def <=(v:vec2) = x <= v.x && y <= v.y
  def >(v:vec2) = x > v.x && y > v.y
  def >=(v:vec2) = x >= v.x && y >= v.y

  override def toString = "vec2( %s, %s )".format(x,y)

}
