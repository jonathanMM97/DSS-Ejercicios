package main.java.inyeccionDependencias.KnightsOfTheRoundTable.logical;

import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.QuestFailedException;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.States;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.Knight;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.Quest;


public class KnightOfTheRoundTable implements Knight {
    private String name;
    private Quest<States> quest;
    public KnightOfTheRoundTable(String name, Quest<States> quest) {
        this.name = name;
        this.quest = quest;
    }

    public void setQuest(Quest<States> quest) {
        this.quest = quest;
    }

    @Override
    public States embarkOnQuest() {
        try {
            return quest.embark();
        } catch (QuestFailedException e) {
            throw new RuntimeException(e);
        }
    }
}