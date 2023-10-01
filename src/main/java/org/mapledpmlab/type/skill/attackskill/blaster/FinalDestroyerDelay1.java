package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalDestroyerDelay1 extends AttackSkill {
    public FinalDestroyerDelay1() {
        this.setName("파이널 디스트로이어(열기)");
        this.setDelay(6000L);
        this.setRelatedSkill(new FinalDestroyer2());
    }
}
