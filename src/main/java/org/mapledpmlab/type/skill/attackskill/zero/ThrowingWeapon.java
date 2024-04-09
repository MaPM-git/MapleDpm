package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThrowingWeapon extends AttackSkill {
    public ThrowingWeapon() {
        this.setName("어드밴스드 스로잉 웨폰");
        this.setAttackCount(2L);
        this.setDamage(560.0);
        this.setDelayByAttackSpeed(480L);
        this.setDotDuration(4000L);
        this.setInterval(300L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
