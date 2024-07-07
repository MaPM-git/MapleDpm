package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GustChargeDrive extends AttackSkill implements LefSkill {
    public GustChargeDrive() {
        this.setName("거스트 차지드라이브");
        this.setDamage(645.0);
        this.setAttackCount(6L);
        this.setCooldown(5.0);
        this.setDelayByAttackSpeed(600L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
        this.setRelatedSkill(new GustSpell());
    }
}
