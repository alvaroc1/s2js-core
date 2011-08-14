package s2js.xml

import browser.Object

class Elem (
	val prefix:String,
	val label:String,
	val attributes:Object,
	val children:List[Node]
) extends Node {
	override def toString = {
		val tag = (if (prefix!=null) ":"+prefix else "") + label
		
		var attrsMap = goog.structs.map(attributes, ((value:String, key:String) => {
			key + "=\"" + value + "\""
		}))
		
		var attrs = goog.structs.getValues(attrsMap).mkString(" ")
		
		"<" + tag + (if (attrs.length > 0) " "+attrs else "") + ">" + goog.array.map(children, (x:Node) => x.toString).mkString("") + "</" + tag + ">"
	}
}
