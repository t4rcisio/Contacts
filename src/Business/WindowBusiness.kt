package Business

import java.awt.event.FocusEvent
import java.awt.event.FocusListener
import javax.swing.BorderFactory
import javax.swing.JTextField

class WindowBusiness {
    private var mClientBusiness : ClientBusiness = ClientBusiness()
    private val labelName = arrayOf("CPF","Name","Addr","Phone","Mail","Birthday")

    private fun setName(vectorlabel: Array< out JTextField>){
        var i = 0
        for(labelBox in vectorlabel){
            labelBox.name = labelName[i]
            i++
        }
    }

    private fun muxFunction(functionName: String, value: String) : Boolean{
        when(functionName){
            labelName[0] -> return mClientBusiness.checkCPF(value,0)
            labelName[1] -> return mClientBusiness.checkName(value)
            labelName[2] -> return mClientBusiness.checkAddr(value)
            labelName[3] -> return mClientBusiness.checkPhone(value)
            labelName[4] -> return mClientBusiness.checkMail(value)
            labelName[5] -> return mClientBusiness.checkBirthday(value)
        }
        return false
    }

    fun chekTextField(vararg vectorlabel: JTextField){
        setName(vectorlabel)
        for(labelBox in vectorlabel) {
            labelBox.addFocusListener(object : FocusListener {
                override fun focusGained(e: FocusEvent) {
                    //println(labelBox.name)
                    if (muxFunction(labelBox.name,labelBox.text)) {
                        labelBox.setBorder(BorderFactory.createEmptyBorder())

                    } else {
                        labelBox.setBorder(mClientBusiness.getBorder())
                    }
                }

                override fun focusLost(e: FocusEvent) {
                    //println(labelBox.name)
                    focusGained(e)
                }
            })
        }

    }



}