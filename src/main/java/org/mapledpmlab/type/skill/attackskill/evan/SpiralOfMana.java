package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiralOfMana extends AttackSkill {
    public SpiralOfMana() {
        this.setName("스파이럴 오브 마나");
        this.setDamage(265.0);
        this.setAttackCount(6L);
        this.setDotDuration(7000L);
        this.setInterval(420L);
        this.setLimitAttackCount(16L);
        this.setRelatedSkill(new SpiralOfManaDelay());
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setCooldown(7.0);
    }
}
