package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ForsakenRelicWaveDelay extends AttackSkill {
    public ForsakenRelicWaveDelay() {
        this.setName("포세이큰 렐릭(파동)");
        this.setDelayByAttackSpeed(4500L);
        this.setRelatedSkill(new ForsakenRelicExplosion());
    }
}
