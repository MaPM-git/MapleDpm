package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritClawTrue extends AttackSkill {
    public SpiritClawTrue() {
        this.setName("진 귀참");
        this.setDelay(720L);
        this.setAttackCount(12L + 1);       // 귀참-보너스 어택
        this.setDamage(880.0);
        this.addIgnoreDefenseList(50L);
        this.setCooldown(6.0);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setAddDamage(20L + 20);        // 귀참-리인포스, 보스 킬러
    }
}
