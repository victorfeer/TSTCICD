# Laboratório GitHub + Azure Pipelines

Projeto Java 8 + Maven + JUnit 4. Os estágios de CD apenas imprimem mensagens; nenhum sistema real é alterado.

## Configuração
1. Crie um repositório GitHub vazio e envie estes arquivos.
2. No Azure DevOps, crie um pipeline apontando para o GitHub e selecione `azure-pipelines.yml`.
3. Configure a conexão/autorização GitHub solicitada pelo Azure DevOps.
4. Em Pipelines > Environments, crie `lab-dev`, `lab-hml` e `lab-prod`.
5. Em `lab-prod` > Approvals and checks, adicione aprovação manual por um usuário autorizado. O YAML sozinho não cria essa aprovação.
6. Configure as regras de proteção da branch `main` no GitHub e associe o check de CI do Azure Pipelines depois de uma execução inicial. Exija revisão e check aprovado.
7. Crie `feature/primeiro-teste`, altere `Calculadora.java` e o teste, faça push e abra PR para `main`.
8. Verifique o CI no PR; depois de aprovação, faça merge e acompanhe CI -> DEV -> HML -> aprovação PROD -> PROD simulado.

## Observações
- O CI usa `JavaToolInstaller@0` com JDK 8 pré-instalado. Confirme a disponibilidade da versão no agente hospedado; se não houver, configure agente próprio ou instalação suportada.
- Dependendo da integração e da configuração do Azure Pipelines com GitHub, os gatilhos de PR podem requerer autorização e configurações adicionais.
- Não armazene tokens/senhas no repositório.
- O artefato contém o diretório `target` inteiro; para uso real, restrinja ao JAR e relatórios necessários.
- Para simular falha, altere a expectativa do teste para `assertEquals(6, ...)`, faça push e observe o CI falhar.
