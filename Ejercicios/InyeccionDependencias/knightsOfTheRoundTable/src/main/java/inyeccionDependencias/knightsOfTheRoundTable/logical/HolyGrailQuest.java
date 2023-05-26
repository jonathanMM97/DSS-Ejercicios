package main.java.inyeccionDependencias.KnightsOfTheRoundTable.logical;

import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.QuestFailedException;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.States;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.Quest;

public class HolyGrailQuest implements Quest<States>{

    public HolyGrailQuest()
    {

    }

    public States embark() throws QuestFailedException{
        return new HolyGrail();
    }
}
