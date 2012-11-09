scalene-vector
==============

A fast 2D and (eventually) 3D vector library in Scala suited for game development.

The 2D class is totally functional.  It still needs a little cleaning up, but it's ready to use!

Example Usage
-------------

	scala> import scalene.vector._
	import scalene.vector._

	scala> val position = vec2.zero
	position: scalene.vector.vec2 = vec2( 0.0, 0.0 )

	scala> position += vec(3,4)

	scala> position.toString
	res1: String = vec2( 3.0, 4.0 )

	scala> position.length
	res2: Double = 5.0

	scala> position.rotate(math.Pi /2)
	res3: scalene.vector.vec2 = vec2( -4.0, 3.0000000000000004 )

	scala> position.project(vec(1,0))
	res4: scalene.vector.vec2 = vec2( 3.0, 0.0 )

	scala> position dot position
	res5: scalene.vector.package.V = 25.0

	scala> position dot -position.rotate(math.Pi/2)
	res6: scalene.vector.package.V = -1.7763568394002505E-15

	scala> -position
	res7: scalene.vector.vec2 = vec2( -3.0, -4.0 )

	scala> position.flipX.flipY
	res8: scalene.vector.vec2 = vec2( -3.0, -4.0 )

	scala> vec.polar(5, math.Pi / 4)
	res9: scalene.vector.vec2 = vec2( 3.5355339059327378, 3.5355339059327373 )

