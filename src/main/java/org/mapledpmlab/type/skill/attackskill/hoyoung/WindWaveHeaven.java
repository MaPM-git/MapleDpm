package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WindWaveHeaven extends AttackSkill {
    public WindWaveHeaven() {
        this.setName("파초풍 : 천");
        this.setDamage(420.0);
        this.setDelay(510L + 30);
        // this.setDelayByAttackSpeed(660L);
        this.setAttackCount(5L);
        this.setRelatedSkill(new WindWaveFalseTrue());
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
