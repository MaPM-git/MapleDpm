package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ArtificialEvolutionDelay extends AttackSkill {
    public ArtificialEvolutionDelay() {
        this.setName("아티피셜 에볼루션");
        this.setDelay(5400L);
        this.setRelatedSkill(new ArtificialEvolutionAirFrame());
    }
}
