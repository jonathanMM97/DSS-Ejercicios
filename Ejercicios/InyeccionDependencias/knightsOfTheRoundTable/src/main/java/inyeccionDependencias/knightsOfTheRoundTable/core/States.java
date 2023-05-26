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