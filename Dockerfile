# Etapa(stage) 1: Construcción (Build)-----------------------------------------
# imagen q se va a basar
FROM amazoncorretto:17.0.7-alpine AS build-image-stage


#working directory
WORKDIR /myApp


# Copiar archivos necesarios para instalar dependencias
COPY .mvn .mvn
COPY mvnw mvnw
COPY pom.xml pom.xml


# Copiar el código fuente
COPY src src


# Agregar permisos de ejecución a mvnw
RUN chmod +x mvnw


# Construyendo el prollecto con maven, ignorando los junit
RUN ./mvnw clean install -DskipTests


#Etapa(stage) 2 Ejecucion----------------------------------------------------
FROM amazoncorretto:17.0.7-alpine


#working directory
WORKDIR /myApp


# Copiar el JAR desde la etapa de build
COPY --from=build-image-stage /myApp/target/*.jar app.jar
# Test Copy ???????????????????????????????????????
COPY  mvnw pom.xml ./
COPY .mvn .mvn
COPY src src

#Ejecutamos el jar
CMD ["java", "-jar", "app.jar"]