package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Twilight extends AttackSkill {
    public Twilight() {
        this.setName("트와일라이트");
        this.setAttackCount(3L);
        this.setDamage(453.0);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
