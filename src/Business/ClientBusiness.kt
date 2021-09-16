package Business

import Entity.ClientEntity
import Repository.ClientRepository
import java.awt.Color;
import javax.swing.BorderFactory
import javax.swing.JTextField
import javax.swing.border.Border

class ClientBusiness {
    private var mTextLabel : JTextField = JTextField()
    private var border: Border = BorderFactory.createLineBorder(Color.RED, 1);

    fun getBorder(): Border{
        return border
    }

    fun checkCPF(cpf: String, level :Int) : Boolean{
        if(cpf.any()){
        var max:Int = 11 - level
        var end : Int = 1 + level

        var total: Int = 0
        var div: Int

        for(i in 0..(cpf.length -(end+1))){
            //println("Total = $total + ${cpf[i].digitToInt()} * $max")
            total += cpf[i].digitToInt()*max
            max--
        }
        div = ((total*10)%11)

        if( div == 10)
            div = 0
        println(cpf[cpf.length -end])
        return if(div == cpf[cpf.length -end].digitToInt() && level == 0){
            checkCPF(cpf,level+1)
        }else{
            div == cpf[(cpf.length -(end))].digitToInt()
        }
        }else{
            return false
        }
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

    private fun validate(client: ClientEntity) : Boolean{
        return ( checkCPF(client.cpf,0)
           && checkAddr(client.addr)
           && checkBirthday(client.birthday)
           && checkPhone(client.phone)
           && checkName(client.name)
           && checkMail(client.mail))

    }

    fun save(name : String, phone: String, birthday: String, mail: String,cpf: String,addr: String){
        val client = ClientEntity(name,phone,birthday,mail,cpf,addr)
        if(validate(client)){
            ClientRepository.save(client)
        }
    }
    fun remove(cpf: String){
        val client = ClientEntity(cpf = cpf)
        if(checkCPF(cpf,0))
            ClientRepository.remove(client)
    }
    fun getList(): List<ClientEntity>{
        return  ClientRepository.getClientList()
    }
    fun getDescription(): String{
        return if(ClientRepository.getClientList().isEmpty()){
            return "Não há contatos salvos"
        }
        else "Total de contatos: ${ClientRepository.getClientList().size}"
    }


}