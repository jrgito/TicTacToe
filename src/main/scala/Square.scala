/**
  * Created by JRGv89 on 30/6/16.
  */
class Square(_position: Int, _value: String, _moved: Boolean) {

  val position: Int = _position
  var value: String = _value
  var moved: Boolean = _moved

  override def toString: String = {
    "%s %s %s".format(position, value, moved)
  }
}
