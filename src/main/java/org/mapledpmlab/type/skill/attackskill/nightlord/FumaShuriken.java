package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FumaShuriken extends AttackSkill {
    public FumaShuriken() {
        this.setName("풍마 수리검");
        this.setApplyFinalAttack(true);
        this.setAttackCount(5L);
        this.setCooldown(25.0);
        this.setDamage(660.0);
        this.setDelay(480L);
        this.setDotDuration(2000L);
        this.setInterval(180L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
