package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalDestroyerDelay2 extends AttackSkill {
    public FinalDestroyerDelay2() {
        this.setName("파이널 디스트로이어(폭발)");
        this.setDelay(1260L);
        this.setRelatedSkill(new RevolvingCannonReinforce());
    }
}
