package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalBlowWave extends AttackSkill {
    public FinalBlowWave() {
        this.setName("파이널 블로우(파동)");
        this.setDamage(350.0 + 100);
        this.setAttackCount(4L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new Beyonder1());
    }
}
