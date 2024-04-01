package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ScarletChargeDrive extends AttackSkill implements LefSkill {
    public ScarletChargeDrive() {
        this.setName("스칼렛 차지드라이브");
        this.setDamage(565.0 + 100 + 173);
        this.setAttackCount(3L);
        this.setDelayByAttackSpeed(690L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
        this.setRelatedSkill(new ScarletSpell());
    }
}
