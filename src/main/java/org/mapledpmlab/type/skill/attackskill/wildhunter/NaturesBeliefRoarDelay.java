package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NaturesBeliefRoarDelay extends AttackSkill {
    public NaturesBeliefRoarDelay() {
        this.setName("네이쳐스 빌리프(포효)");
        this.setDelay(1200L);
        this.setRelatedSkill(new SoulResonation());
    }
}
