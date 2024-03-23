package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrystalIgnition extends AttackSkill {
    public CrystalIgnition() {
        this.setName("크리스탈 이그니션");
        this.setDamage(2566.0);
        this.setDelay(4200L);
        this.setAttackCount(5L);
        this.setDotDuration(4200L);
        this.setInterval(120L);
        this.setLimitAttackCount(35L);
        this.setAddDamage(20L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new CrystalIgnitionAfterDelay());
    }
}
