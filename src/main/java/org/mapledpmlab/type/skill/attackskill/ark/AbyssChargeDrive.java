package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AbyssChargeDrive extends AttackSkill implements LefSkill {
    public AbyssChargeDrive() {
        this.setName("어비스 차지드라이브");
        this.setDamage(550.0);
        this.setAttackCount(4L);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
        this.setRelatedSkill(new AbyssSpell());
    }
}
