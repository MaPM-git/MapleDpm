package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TrueSpiritClaw extends AttackSkill {
    public TrueSpiritClaw() {
        this.setName("진 귀참");
        this.setDamage(720.0);
        this.setDelayByAttackSpeed(720L);
        this.setCooldown(6.0);
        this.setAttackCount(12L + 1);   // 귀참-보너스 어택
        this.setAddDamage(20L + 20);    // 귀참-리인포스, 보스 킬러
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
