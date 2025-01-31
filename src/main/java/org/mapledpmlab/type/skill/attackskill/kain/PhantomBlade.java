package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhantomBlade extends AttackSkill {
    public PhantomBlade() {
        this.setName("[처형] 팬텀 블레이드");
        this.setDamage(745.0);
        this.setAttackCount(6L);
        this.setDelayByAttackSpeed(660L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);
    }
}
