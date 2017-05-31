
class Konstante(override val faktor:Int, override val vorzeichen:Boolean) extends Variable(faktor, "1", vorzeichen) {
	override def toString:String = {
		if (!vorzeichen) {
			"-" + faktor 
		} else {
			"+" + faktor 
		}
	}
}

class Variable(val faktor:Int, val variable:String, val vorzeichen:Boolean) {
	
	override def toString:String = {
		if (!vorzeichen) {
			"-" + faktor + variable
		} else {
			"+" + faktor + variable
		}
	}
}




class UnGleichung[A](val linkeVariablen:List[A], val rechteVariablen:List[A], val zeichen:String) {
	
	println(toString())
	
	override def toString:String = {
		"Gleichung" + printSeite(linkeVariablen) + zeichen + printSeite(rechteVariablen)
	}
	

	def printSeite[A](variablen:List[A]) : String = {
		variablen.map(a => a.toString).reduceLeft( (a,b) => a+b) 		
	}
}



object UnGleichung {
	import scala.collection.mutable.ListBuffer
	
	def apply(zeichen:String, rechts:Int, links:Int*) = {
		
		var listeLinks = new ListBuffer[Variable]();
		

		links.foreach {
			listeLinks += new Variable(2,"x", true)
		}

	

		
		val vR = new Konstante(rechts, true)
		val listeRechts = List(vR)
		
		
		new UnGleichung(listeLinks, listeRechts, zeichen)
	}
}







object Simplex extends App {
	
	
	/* 1. Gleichung */
	val v1 = new Variable(2,"x",true)
	val v2 = new Variable(1,"y", true)
	val listeLinks1 = List(v1,v2)
	
	val v3 = new Konstante(10, true)
	val listeRechts1 = List(v3)
	
	val g1 = new UnGleichung(listeLinks1, listeRechts1, "<=")
	
	
	/* 2. Gleichung */	
	val g2 = UnGleichung("=", 1, 10, 20, 4)


	
}



