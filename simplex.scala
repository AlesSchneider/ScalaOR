
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
	
	def this(a:Tuple3) = {
		/*val v4 = new Variable(1, "x", true)
		val v5 = new Variable(2, "y", true)
		val v6 = new Variable(1, "z", true)
		val listeLinks2 = List(v4,v5,v6)
	
	
		val v7 = new Konstante(12, true)
		val listeRechts2 = List(v7)
		
		val listeRechts2 = List(listeLinks2, listeRechts2, "<=")*/
		
		//this(listeLinks2, listeRechts2, "<=")
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
	val v4 = new Variable(1, "x", true)
	val v5 = new Variable(2, "y", true)
	val v6 = new Variable(1, "z", true)
	val listeLinks2 = List(v4,v5,v6)
	
	val v7 = new Konstante(12, true)
	val listeRechts2 = List(v7)
	
	val g2 = new UnGleichung(listeLinks2, listeRechts2, "<=")
	
	/* 3. Gleichung */
	//val g3 = new Ungleichung(1,2,3,"<=",10)
	
	
	
	
	
	
	
	
	

	
}








