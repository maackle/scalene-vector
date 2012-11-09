package scalene

package object vector {

  type V = Double
  type Radian = Double

  val eps:V = 0.001f

//  implicit def b2vec2_vec2(v:b2vec2):vec2 = new vec2(v.x, v.y)

  implicit def tuple_vec2(x:(V, V)):vec2 = new vec2(x._1, x._2)

//  implicit def vec3_tuple(v:vec3):(V, V, V) = (v.x, v.y, v.z)
//  implicit def tuple_vec3(x:(V, V, V)) = new vec3(x._1, x._2, x._3)

}
