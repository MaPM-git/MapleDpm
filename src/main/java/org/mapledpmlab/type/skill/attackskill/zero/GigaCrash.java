package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GigaCrash extends AttackSkill implements BetaSkill {
    public GigaCrash() {
        this.setName("기가 크래시");
        this.setAttackCount(6L);
        this.setDamage(400.0);
        this.setDelayByAttackSpeed(630L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
