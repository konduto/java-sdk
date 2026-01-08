## Maven Public Central Portal publish

### Estrutura
```
java-jdk/
├── build.gradle
├── secring.gpg <-- Chave GPG gerada (Sensível)
└── gradle.properties  <-- Credenciais (Sensível)
```

### Chave GPG
Os artefatos dos novos builds devem obrigatoriamente serem assinadas antes de subir para o Central Portal, segue passo a passo da criação e exportação da chave GPG **secring.gpg**:

```bash
gpg --full-generate-key
# Opções recomendadas
# 1- RSA padrão
# 2- 4096
# 3- 0
# 4- email address: Mesmo do POM
# 5- 0
# 6- Será solicitado uma senha para utilizar no gradle.properties

# Lista a chave gerada (keys os ultimos 8 caracteres)
gpg --list-keys

# Distribui a chave(caso falhar usar o keys.openpgp.org ou pgp.mit.edu) 
gpg --keyserver keyserver.ubuntu.com --send-keys ABC12345

#Exporta a chave
gpg --export-secret-keys -o secring.gpg
```

### Properties

Exemplo do arquivo **gradle.properties**:
```bash
# Credenciais do Portal (Token)
mavenCentralUsername=seu-token-username
mavenCentralPassword=seu-token-password

# Configuração GPG
signing.keyId=ABC12345
signing.password=senha-gpg
signing.secretKeyRingFile=secring.gpg
```
### Publish

``` bash
# Build
gradle wrapper

# Publish
gradle publishToMavenCentral
```

## Publish Nexus Repository

### Estrutura
```
java-jdk/
├── build.gradle
└── gradle.properties  <-- Credenciais Nexus(Sensível)
```

Use o **build_nexus_example.gradle** para publicar em repositorio Nexus, adapte o **gradle.properties** com suas credencias do Nexus:

```shell
nexusUsername=usuario
nexusPassword=senha/token
```

## Builder Container (Validar)

```shell
docker build -t java11-builder .
```
```docker
docker run --rm \
  -v "$(pwd)":/project \
  -v "$HOME/.gradle/gradle.properties":/root/.gradle/gradle.properties \
  -v "$HOME/.gradle/secring.gpg":/root/secring.gpg \
  java11-builder \
  gradle publishToMavenCentral
```

## Java compatibility e Grandle

| Java version | Support for toolchains | Support for running Gradle |
| :--- | :--- | :--- |
| 8 | N/A | 2.0 to 8.14.* |
| 9 | N/A | 4.3 to 8.14.* |
| 10 | N/A | 4.7 to 8.14.* |
| 11 | N/A | 5.0 to 8.14.* |
| 12 | N/A | 5.4 to 8.14.* |
| 13 | N/A | 6.0 to 8.14.* |
| 14 | N/A | 6.3 to 8.14.* |
| 15 | 6.7 | 6.7 to 8.14.* |
| 16 | 7.0 | 7.0 to 8.14.* |
| 17 | 7.3 | 7.3 and after |
| 18 | 7.5 | 7.5 and after |
| 19 | 7.6 | 7.6 and after |
| 20 | 8.1 | 8.3 and after |
| 21 | 8.4 | 8.5 and after |
| 22 | 8.7 | 8.8 and after |
| 23 | 8.10 | 8.10 and after |
| 24 | 8.14 | 8.14 and after |