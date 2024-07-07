package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlameDischarge extends AttackSkill {
    public FlameDischarge(Long flameCount) {
        this.setName("플레임 디스차지");
        this.setDamage(550.0);
        this.setDelay(840L);
        this.setAttackCount(1L);
        this.setCooldown(20.0);
        this.setDotDuration(4400L + (flameCount - 2) * 550 * 2);
        this.setInterval(60L);
        this.setLimitAttackCount(8L * (8 + (flameCount - 2) * 2));
        this.addFinalDamage(1.6);       // 코어강화
    }

    public void setByFlameCount(Long flameCount) {
        this.setDotDuration(4400L + (flameCount - 2) * 550 * 2);
        this.setLimitAttackCount(8L * (8 + (flameCount - 2) * 2));
    }
}
