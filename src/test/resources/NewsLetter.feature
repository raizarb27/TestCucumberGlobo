#language: pt
#Author:
@TestesNavegadoresNewsLetters
Funcionalidade: Teste de funcionalidade por navegadores escolha as edições de sua preferência: Diária, Ela , Acervo, RioShow, Eleições 2018, Saber viver,Gastronomia.

  @Chrome @AcessoLogin1
  Esquema do Cenario: O usuário pode realizar a escolha da NEWSLETTERS da pagina
    Dado o usuario acessa a pagina do newsletter a url <vUrl>
    E selecionar na tela Newsletters O Globo as edições de sua preferência <Edicoes>
    Quando o usuario digitar na tela de login no campo Endereço de e-mail <vEmail>
    Quando o usuario digitar na tela de login no campo Confirmar seu e-mail <vEmailConf>
    E digitar na tela Newsletters O Globo em Informe seu e-mail para recebimento da newsletter no campo DR3D
    E clicar na tela Newsletters O Globo no botão increva-se
    Entao verificar texto <VerfText>, <vImg>

    Cenarios: 
      | VerfText                                             | vImg                                                      | vUrl                                          | Edicoes | vEmail           | vEmailConf        |
      | Texto não correponde à imagem                        | case1_Texto_não_correponde_à_imagem                       | https://oglobo.globo.com/newsletter/cardapio/ | Ela     | Test@test.com.br | Test@test.com.br  |
      | Texto não correponde à imagem                        | case2_Texto_não_correponde_à_imagem                       | https://oglobo.globo.com/newsletter/cardapio/ | Acervo  | Test@test.com.br | Test@test.com.br  |
      | Verifique se preencheu corretamente os campos acima. | case3_Verifique_se_preencheu_corretamente_os_campos_acima | https://oglobo.globo.com/newsletter/cardapio/ | Acervo  | Test@test.com.br | Test1@test.com.br |

  @Chrome @AcessoLogin1
  Esquema do Cenario: O usuário pode realizar a escolha da NEWSLETTERS da pagina não selecionando edições de sua preferência
    Dado o usuario acessa a pagina do newsletter a url <vUrl>
    Quando o usuario digitar na tela de login no campo Endereço de e-mail <vEmail>
    Quando o usuario digitar na tela de login no campo Confirmar seu e-mail <vEmailConf>
    E digitar na tela Newsletters O Globo em Informe seu e-mail para recebimento da newsletter no campo DR3D
    E clicar na tela Newsletters O Globo no botão increva-se
    Entao verificar texto <VerfText>, <vImg>

    Cenarios: 
      | VerfText                               | vImg                                         | vUrl                                          | Edicoes | vEmail           | vEmailConf       |
      | Escolha ao menos uma das opções acima. | case4_Escolha_ao_menos_uma_das_opções_acima. | https://oglobo.globo.com/newsletter/cardapio/ |         | Test@test.com.br | Test@test.com.br |
