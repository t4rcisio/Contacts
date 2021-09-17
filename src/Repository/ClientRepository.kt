package Repository

import Entity.ClientEntity

class ClientRepository {

    companion object{

        private var clientsList : MutableList<ClientEntity> = ArrayList()

        fun save(client: ClientEntity){
            clientsList.add(client)
        }
        fun remove(client: ClientEntity){
            var index = 0
            for(i in clientsList){
                if(i.cpf == client.cpf){
                    clientsList.removeAt(index)
                    break;
                }
                index++
            }
        }

        fun getClientList() : List<ClientEntity>{
            return clientsList
        }

    }





}