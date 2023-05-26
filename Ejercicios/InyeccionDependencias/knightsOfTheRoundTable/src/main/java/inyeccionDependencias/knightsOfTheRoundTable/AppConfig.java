package inyeccionDependencias.KnightsOfTheRoundTable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.QuestFailedException;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.States;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.Knight;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.core.Quest;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.logical.HolyGrailQuest;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.logical.KnightOfTheRoundTable;
import main.java.inyeccionDependencias.KnightsOfTheRoundTable.logical.UnholyGrail;



@Configuration
public class AppConfig {

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

    //


}