package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RollingCannonRainbow extends AttackSkill {
    public RollingCannonRainbow() {
        this.setName("롤링 캐논 레인보우");
        this.setDamage(1800.0);
        this.setAttackCount(5L);
        this.setCooldown(90.0);
        this.setDelayByAttackSpeed(480L);
        this.setDotDuration(10000L);
        this.setInterval(480L);
        this.setLimitAttackCount(20L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
