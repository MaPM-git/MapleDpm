package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WeaponVariety extends AttackSkill {
    public WeaponVariety() {
        this.setName("웨폰 버라이어티");
        this.setDamage(660.0);
        this.setAttackCount(4L);
        this.setCooldown(0.2);
        this.setApplyReuse(true);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
