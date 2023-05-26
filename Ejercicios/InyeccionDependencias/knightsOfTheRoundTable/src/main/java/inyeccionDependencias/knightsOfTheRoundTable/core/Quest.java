package main.java.inyeccionDependencias.KnightsOfTheRoundTable.core;

public interface Quest<States> {
    abstract States embark() throws QuestFailedException;
}
