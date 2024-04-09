package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EgoWeaponAlpha extends AttackSkill {
    public EgoWeaponAlpha() {
        this.setName("에고 웨폰(알파)");
        this.setAttackCount(6L);
        this.setDamage(500.0);
        this.setCooldown(15.0);
        this.setDotDuration(1000L);
        this.setInterval(120L);
        this.setLimitAttackCount(9L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
