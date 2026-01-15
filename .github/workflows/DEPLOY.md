# 🚀 Publicação e CI/CD

Este repositório utiliza **GitHub Actions** para automatizar o build, testes e a publicação dos artefatos no **Maven Central Repository**, além de gerar Releases no GitHub.

## 🎯 Triggers

A pipeline foi configurada com regras específicas para evitar publicações acidentais:

| Tipo | Branch | Comportamento |
| :--- | :--- | :--- |
| **🤖 Automático** | `master` | Executado automaticamente a cada `push` ou `merge` realizado na branch principal. |
| **👋 Manual** | *Qualquer* | Pode ser acionado manualmente na aba **Actions** do GitHub através da opção **"Run workflow"** (`workflow_dispatch`). Ideal para testar releases em branches de desenvolvimento ou correções. |

---

## 🔐 Configuração de Variáveis (Secrets)

Para que a assinatura GPG e a publicação funcionem corretamente, as seguintes chaves devem estar configuradas em `Settings > Secrets and variables > Actions`:

| Variável | Obrigatório | Descrição |
| :--- | :---: | :--- |
| `MAVEN_CENTRAL_USER` | ✅ Sim | Usuário ou Token gerado no [Sonatype Central Portal](https://central.sonatype.com/). |
| `MAVEN_CENTRAL_PASS` | ✅ Sim | Senha ou Token gerado no Sonatype Central Portal. |
| `GPG_SIGNING_KEY` | ✅ Sim | Chave Privada GPG. **Importante:** Deve ser exportada em formato ASCII e convertida para **Base64** (em linha única) para evitar erros de quebra de linha. |
| `GPG_SIGNING_KEY_ID` | ✅ Sim | Últimos 8 caracteres da sua Chave Privada GPG. |
| `GPG_SIGNING_PASS` | ✅ Sim | A senha que protege a sua chave privada GPG. |
| `GITHUB_TOKEN` | ❌ Não | Token injetado automaticamente pelo GitHub. Usado para criar o Draft da Release. |

> **ℹ️ Chave GPG:** A pipeline decodifica automaticamente o Base64 em tempo de execução para injetar a chave na memória, sem salvar arquivos no disco.

---

## 📄 Versionamento e Mensagens

A pipeline extrai informações dinâmicas do código para montar a release:

1.  **Versão do SDK (`SDK_VERSION`)**:
    * Lida automaticamente do arquivo `src/main/resources/konduto.properties`.
    * O script remove espaços em branco e quebras de linha para garantir a integridade.

2.  **Mensagem da Release (`CUSTOM_RELEASE_MSG`)**:
    * Lida do arquivo `RELEASE_MSG.md` na raiz do projeto.
    * A pipeline cria um release draft e insere automaticamente uma mensagem com:
        * 📝 Titulo e explicação das alterações do novo release.
        * 📅 Data/Hora da publicação.
        * 🔗 Link direto para o artefato no Maven Central.

---

## ✍🏻 Release Draft

Essa pipeline cria um _`Release Draft`_ com a mensagem criada no passo anterior(`RELEASE_MSG.md` na raiz do projeto), para você avaliar/alterar caso necessário.

Deve ser criado uma tag seguindo a sequencia existente Ex. v3.0.0, v3.0.1.... e depois de tudo certo, basta publicar, pois já estão lá a mensagem e os binarios craidos para facilitar nossa vida 👌. 

---

## ⚙️ Resumo do Fluxo

1.  **Checkout & Setup:** Baixa o código e configura o JDK/Gradle.
2.  **Preparação GPG:** Decodifica a chave e configura o ambiente.
3.  **Build & Publish:**
    * Compila o projeto com Gradle.
    * Gera JARs (Sources e Javadoc).
    * Assina digitalmente os artefatos com a chave GPG.
    * Envia para o [Maven Central](https://central.sonatype.com/artifact/com.konduto.sdk/java-sdk) com a versão em konduto.properties.
4.  **GitHub Release:** Cria um **Rascunho (Draft)** na aba [Releases](https://github.com/konduto/java-sdk/releases) contendo os binários gerados e você avalia e publica.