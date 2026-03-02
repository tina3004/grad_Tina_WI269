FROM eclipse-temurin:17

WORKDIR /app

COPY src/main/java/Main.java .

COPY lib/postgresql-42.7.5.jar .

RUN javac -cp postgresql-42.7.5.jar Main.java

CMD ["java", "-cp", ".:postgresql-42.7.5.jar", "Main"]