package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NaturesBeliefWaveDelay extends AttackSkill {
    public NaturesBeliefWaveDelay() {
        this.setName("네이쳐스 빌리프(파동)");
        this.setDelay(3180L);
        this.setRelatedSkill(new NaturesBeliefRoar());
    }
}
