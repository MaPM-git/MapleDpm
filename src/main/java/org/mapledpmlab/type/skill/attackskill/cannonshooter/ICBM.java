package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ICBM extends AttackSkill {
    public ICBM() {
        this.setName("ICBM");
        this.setDamage(1760.0);
        this.setAttackCount(15L);       // 벅샷
        this.setCooldown(30.0);
        this.setDotDuration(1000L);
        this.setInterval(150L);
        this.setLimitAttackCount(6L);
        this.addFinalDamage(0.45);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new ICBMDelay());
    }
}
