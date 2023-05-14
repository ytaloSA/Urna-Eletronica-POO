# Urna-Eletronica-POO
Projeto da disciplina POO - UFS

Integrantes:
Ytalo Santos Aragão
Yuri Dias Pereira

Professor:
Kalil Araújo Bispo

Sistemas operacionais utilizados:
Windows e Linux Mint

Versão do Java utilizada:
Java 11

IDEs utilizadas:
Visual Studio Code/Codium (O Visual Studio Codium trata-se apenas de uma
compilação alternativa do Visual Studio Code onde os módulos de telemetria são excluídos do
código fonte antes da compilação)

Objetivo do projeto:
Realizar uma simples eleição na qual cada eleitor expressará sua
opinião em relação aoseguinte questionamento: "O correto é biscoito ou boalcha?"

Descrição geral:
O modo como a aplicação foi construída permite que outros tipos de eleições sejam
realizadas porém, Biscoito X Bolacha é a eleição prédefinida e realizar outras eleições
exigiria alguns ajustes na interface gráfica.

O algoritmo de criptografia hash consiste em usar a função fornecida pelo professor, sem
alterações de qualquer natureza, para gerar um hash correspondente aos dados dos campos
contidos em cada linha e naõ da linha inteira de modo que o nome do campo seja ignorado no
processo de criptografia.
Exemplo:
    Campo:dado
    Neste caso, apenas a string "dado" será passada para a função geradora de hash.
No arquivo de controle, o hash de cada arquivo é gerado considerando o conteúdo integral do
arquivo, diferente do hash linha a linha mencionado anteriormente

Na execução inicial, um menu principal apresenta a eleição pré-determinada e permite iniciar
os módulos do programa como, por exemplo, a tela de votação e um módulo de mesário capaz de
gerenciar todo o sistema de votação. Dessa forma, o menu principal funciona como uma
introdução ao programa, o módulo de mesário como um painel de administrador e a tela de
votação como o a principal fonte de entrada de dados e onde o objetivo principal deve ser
realmente acançado.