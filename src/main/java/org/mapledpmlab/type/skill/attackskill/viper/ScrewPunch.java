package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ScrewPunch extends AttackSkill {
    public ScrewPunch() {
        this.setName("스크류 펀치");
        this.setAttackCount(2L);
        this.setDamage(337.0 + 110);    // 오펜스 폼
        this.setDelayByAttackSpeed(750L);
        this.setCooldown(4.0);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
