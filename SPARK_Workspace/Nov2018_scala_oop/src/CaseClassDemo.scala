

object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    
    val stu1=Student(1,"stu1",100)
    println(stu1.id+"::"+stu1.name)
  val stu2=stu1;
    
    println(stu2.id+"::"+stu2.name)
    val stu3=stu1.copy(name="stu2",fee=100000)
    println(stu3.id+"::"+stu3.name+"::"+stu3.fee)
    if(stu1==stu2){ println("both same")}
    if(stu1==stu3){ println("both same")}
    else { println("both not same")}  
        

  }
}

case class Student(id:Int,name:String,fee:Int)

// case class arguments are  vals
//how to create object of case class