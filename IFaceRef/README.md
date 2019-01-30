# IFace
## Funcionalidades
### Criar conta
Cria uma conta no sistema. O usuário deve fornecer um login (único), uma senha e um nome de usuário. A partir daqui, o usuário pode acessar cada uma das demais funcionalidades fornecendo seu login e senha.
### Remover conta
Remove do sistema a conta do usuário. Tudo relacionado à conta, incluindo amizades, comunidades criadas, participação em outras comunidades e mensagens enviadas e recebidas, também é excluído do sistema.
### Editar perfil
Edita o perfil do usuário. Pode-se editar um atributo existente ou criar um novo atributo.
### Adicionar amigo
Envia uma solicitação de amizade para outro usuário do sistema. Deve-se fornecer o login do usuário a ser solicitado.
### Aceitar amigos
Para cada solicitação de amizade recebida, o usuário pode aceitar ou não a amizade.
### Criar comunidade
Cria uma comunidade no sistema. Deve-se fornecer um nome (único) e uma breve descrição. O usuário passa a ser então o proprietário (e também membro) da comunidade.
### Entrar em comunidade
Envia uma solicitação de participação em uma comunidade, que será analisada pelo proprietário dela. O usuário deve fornecer o nome da comunidade.
### Aceitar membros
Para cada comunidade de propriedade do usuário, e para cada solicitação de participação nesta comunidade recebidas, o proprietário pode aceitar ou não a participação.
### Enviar mensagem
Envia uma mensagem para um único usuário ou todos os membros uma comunidade da qual seja membro. Caso seja um usuário, deve-se fornecer o login do destinatário. Caso seja uma comunidade, deve-se fornecer o nome da comunidade.
### Visualizar informações
O usuário pode visualizar informações sobre seu perfil, comunidades que participa, amigos e mensagens enviadas e recebidas.
## Classes e interfaces
### iface.IFace
A classe principal do sistema.
### iface.action.Action
1. Motivação: Cada funcionalidade contém um conjunto próprio de ações, que deve ser chamado de uma forma comum pela classe principal.
2. Solução: 'Action' é uma classe abstrata que representa uma funcionalidade qualquer. Cada funcionalidade é representada por uma das subclasses de Action, que são:
   - 'iface.action.AcceptFriends' (aceitar amigos);
   - 'iface.action.AcceptMembers' (aceitar membros);
   - 'iface.action.AddCommunity' (criar comunidade);
   - 'iface.action.AddFriend' (adicionar amigo);
   - 'iface.action.EditProfile' (editar perfil);
   - 'iface.action.EnterCommunity' (entrar em comunidade);
   - 'iface.action.Sendmessage' (enviar mensagem);
   - 'iface.action.SignOut' (remover conta);
   - 'iface.action.SignUp' (criar conta);
   - 'iface.action.ViewInfo' (visualizar informações).
3. Vantagem: seu método abstrato 'doAction()' é implementado de forma específica por cada subclasse, ao mesmo tempo que é chamado de forma comum pela classe principal.
### iface.action.info.Info
1. Motivação: Em 'iface.action.ViewInfo', as informações do usuário são classificadas em *perfil*, *comunidades*, *amigos* e *mensagens*, mas para cada uma delas existe um conjunto próprio de instruções que deve ser chamado de uma forma comum.
2. Solução: 'Info' é uma interface que representa uma informação específica do usuário. Cada informação específica é representada por uma das implementações de Info, que são:
   - 'iface.action.info.CommunitiesInfo' (comunidades);
   - 'iface.action.info.FriendsInfo' (amigos);
   - 'iface.action.info.Messagesinfo' (mensagens);
   - 'iface.action.info.ProfileInfo' (perfil).
3. Vantagem: 'ViewInfo' realiza a chamada do método abstrato 'view()', o qual é implementado pelas implementações da interface.
### iface.model.User
