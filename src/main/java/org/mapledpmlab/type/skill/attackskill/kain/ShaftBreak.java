package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShaftBreak extends AttackSkill {
    public ShaftBreak() {
        this.setName("샤프트 브레이크");
        this.setDamage(435.0);
        this.setAttackCount(3L);
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(8.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new ShaftBreakBomb());
        this.setAddDamage(10L + 15);
        this.setApplyCooldownReduction(false);
    }
}
