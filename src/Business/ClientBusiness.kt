package Business

class ClientBusiness {

    fun checkCPF(cpf: String,level: Int) : Boolean{
        var max:Int = 11
        var end : Int = 1
        if(level == 1){
            max = 10
            end = 2
        }
        var total: Int = 0
        var div: Int

        for(i in 0..(cpf.length -(end+1))){
            println("Total = $total + ${cpf[i].digitToInt()} * $max")
            total += cpf[i].digitToInt()*max
            max--
        }
        div = ((total*10)%11)

        if( div == 10)
            div = 0
        return div == cpf[(cpf.length -(end))].digitToInt()
    }
    fun checkName(name: String): Boolean{
        return name.any()
    }
    fun checkPhone(phone: String): Boolean{
        return phone.any()
    }
    fun checkBirthday(birthday: String): Boolean{
        return birthday.any()
    }
    fun checkMail(mail: String): Boolean{
        var p = 0;
        return mail.indexOf("@") != -1

    }
    fun checkAddr(addr: String): Boolean{
        return addr.any()
    }

    fun validate(name : String, phone: String, birthday: String, mail: String,cpf: String,addr: String){
       if( checkCPF(cpf,1)
           && checkCPF(cpf,2)
           && checkAddr(addr)
           && checkBirthday(birthday)
           && checkPhone(phone)
           && checkName(name)
           && checkMail(mail)){

       }

    }



}