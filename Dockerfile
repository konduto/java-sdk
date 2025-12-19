# 1. Base com Java 21 (Necessário para rodar o Gradle >+ 8.4 < or equal 8.14)
FROM eclipse-temurin:21-jdk-jammy

LABEL maintainer="silvano.junior@equifax.com"

# 2. Define a versão exata do Gradle
ENV GRADLE_VERSION=8.5
ENV GRADLE_HOME=/opt/gradle
ENV PATH=${PATH}:${GRADLE_HOME}/bin
ENV GRADLE_USER_HOME=/project/.gradle_cache

# 3. Instalação de ferramentas básicas e do Java 21 (para seu código legado)
RUN apt-get update && apt-get install -y --no-install-recommends \
    git \
    gnupg \
    curl \
    wget \
    unzip \
    zip \
    && rm -rf /var/lib/apt/lists/*

# 4. Instalação SDKman e Gradle 8.5
RUN curl -s "https://get.sdkman.io" | bash
SHELL ["/bin/bash", "-c"]    
RUN source "/root/.sdkman/bin/sdkman-init.sh" \
                && sdk install gradle 8.5-bin

# 5. Configuração do Diretório
WORKDIR /project
RUN mkdir -p $GRADLE_USER_HOME

# 6. Verifica as versões instaladas
RUN java -version && \
    javac -version && \
    ./gradle -v && \
    gpg --version

CMD ["/bin/bash"]