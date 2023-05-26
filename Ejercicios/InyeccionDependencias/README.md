# Tarea Inyección de dependencias (knightsOfTheRoundTable)

## Contexto y presentación del problema
a) Rediseñar la interfaz *Quest* del ejemplo *knightsOfTheRoundTable* para que la genericidad no se implemente con *java.lang.Object*.

b) Implementar el ejemplo mediante un framework de inyección de dependencias como el explicado en [How to use the Spring FactoryBean](https://www.baeldung.com/spring-factorybean)

## Solución propuesta para ambos apartados

Para realizar el ejemplo usamos **Spring**. Para ello creamos un fichero de configuración llamado [AppConfig.java](/Ejercicios/InyeccionDependencias/knightsOfTheRoundTable/src/main/java/inyeccionDependencias/knightsOfTheRoundTable/AppConfig.java), donde se definen knight, quest, holyGrailQuest y state como beans:

```java
    @Bean
    public Knight knight() {
        return new KnightOfTheRoundTable("King Arturo", quest());
    }

    @Bean
    public Quest<States> quest() {
        return new HolyGrailQuest();
    }

    @Bean
    public HolyGrailQuest holyGrailQuest() {
        return new HolyGrailQuest();
    }

    @Bean
    public States state() {
        return new UnholyGrail();
    }
```

Como podemos observar en el código anterior, cada bean realiza una función diferente, por ejemplo knight inyecta la dependencia **quest** a un objeto **KnightOfTheRoundTable**.

Por otro lado, la parte mas compleja de la tarea era proporcionar un reemplazo para el objeto *Object* de **java.lang.Object**, para ello creamos una nueva interfaz, llamada ```States``` y es la que reemplazamos para que la interfaz ```quest``` no implemente *Object*.

El [código](/Ejercicios/InyeccionDependencias/knightsOfTheRoundTable/src/main/java/inyeccionDependencias/knightsOfTheRoundTable/core/States.java) utilizado para esta nueva intervaz es relativamente sencillo:

```java
    package main.java.inyeccionDependencias.KnightsOfTheRoundTable.core;

    public interface States {
        
        default boolean isHoly()
        {
            return false;
        }
        default boolean isEvil()
        {
            return false;
        }
        default boolean isAncient()
        {
            return false;
        }

    }
```

Como se puede observar en el código, establecemos una funcionalidad por defecto para cada método que proporciona la interfaz.

Con esto completamos el ejercicio y damos por explicado la solución propuesta.

## Como compilar(Si cambia algún nombre de directorio, debe saber que este tutorial puede fallar)

Para compilar el proyecto, debe situarse en el directorio llamado `knightsOfTheRoundTable`, una vez situado en el, debe introducir el siguiente comando:

```
    mvn clean install -DskipTests
```

Con esto, se comprobará que la funcionalidad del código no tiene errores de compilacion y evitamos realizar los tests inexistentes.

Cabe resaltar que para este ejercicio se ha realizado con la **versión de java 20**.