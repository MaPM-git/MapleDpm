package org.mapledpmlab.type.skill.attackskill.flamewizard;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlazingOrbitalFlame extends AttackSkill {
    public BlazingOrbitalFlame() {
        this.setName("블레이징 오비탈 플레임");
        this.setDamage(935.0);
        this.setAttackCount(6L);
        this.setCooldown(5.0);
        this.setDelay(210L);
        this.setDotDuration(960L);
        this.setInterval(240L);
        this.setLimitAttackCount(4L);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
