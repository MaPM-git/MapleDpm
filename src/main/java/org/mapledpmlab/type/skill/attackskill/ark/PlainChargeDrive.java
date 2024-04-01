package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlainChargeDrive extends AttackSkill implements LefSkill {
    public PlainChargeDrive() {
        this.setName("플레인 차지드라이브");
        this.setDamage(900.0 + 260 + 253);
        this.setAttackCount(3L);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
        this.setRelatedSkill(new PlainSpell());
    }
}
