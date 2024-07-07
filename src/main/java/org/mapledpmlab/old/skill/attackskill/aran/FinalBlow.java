package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalBlow extends AttackSkill {
    public FinalBlow() {
        this.setName("파이널 블로우");
        this.setDamage(285.0 + 5 + 21 + 100 + 62);
        this.setAttackCount(5L);
        this.setDelay(420L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new Beyonder1());
    }
}
