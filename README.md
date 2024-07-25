# Software Cliente de Troca de Mensagens
O cliente de Troca de Mensagens com Jogo de Cartas 21 deve se comunicar com o servidor larc.inf.furb.br através de
mensagens na forma de strings ASCII, terminadas pelo fim de linha padrão IETF.

O software cliente de Troca de Mensagens deve implementar as seguintes funcionalidades:

1. Lista de usuários e keepalive: obter do servidor, estabelecendo uma conexão a cada 6 segundos, a lista de usuários
conectados através da seguinte requisição TCP (porta 1012):

    Requisição: “GET USERS &lt;userid>:&lt;passwd>”
   
    &lt;userid>: número que identifica o usuário cliente
   
    &lt;passwd>: senha do usuário cliente
   
    Ex.: “GET USERS 4123:rsybt”

    Resposta: “&lt;userid>:&lt;username>:&lt;wins>:”
    &lt;userid>: número que identifica o usuário
    &lt;username>: nome do usuário
    &lt;wins>: número de vitórias do usuário

    Ex.: “2756:João da Silva:4:1235:José da Silva:0:1243:Manuel da Silva:2:”

   
3. Requisição de mensagens: obter do servidor uma mensagem (a mais antiga) destinada ao usuário através da seguinte
requisição TCP (porta 1012):
    Requisição: “GET MESSAGE &lt;userid>:&lt;passwd>”
   
    &lt;userid>: número que identifica o usuário cliente
   
    &lt;passwd>: senha do usuário cliente
   
    Ex.: “GET MESSAGE 4123: rsybt”
   
    Resposta: “&lt;userid>:&lt;msg>”
   
    &lt;userid>: número que identifica o remetente (0 significa mensagem do servidor)
   
    &lt;msg>: mensagem recebida
   
    Obs.: se não houver mensagem é enviado “:”
   
    Ex.: “3825:Oi!”
   
5. Envio de mensagens: enviar ao servidor uma mensagem destinada a um usuário, ou a todos, através de uma mensagem
UDP (porta 1011):
    Requisição: “SEND MESSAGE &lt;userid1>:&lt;passwd1>:&lt;userid2>:&lt;msg>”
   
    &lt;userid1>: número que identifica o usuário cliente
   
    &lt;passwd1>: senha do usuário cliente
   
    &lt;userid2>: número que identifica o destinatário (0 significa todos os usuários)
   
    &lt;msg>: mensagem enviada
   
    Ex.: “SEND MESSAGE 3825: rsybt:1416:Hello world!”
