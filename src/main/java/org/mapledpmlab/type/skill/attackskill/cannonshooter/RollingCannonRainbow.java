package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RollingCannonRainbow extends AttackSkill {
    public RollingCannonRainbow() {
        this.setName("롤링 캐논 레인보우");
        this.setDamage(800.0);
        this.setAttackCount(3L);
        this.setCooldown(90.0);
        this.setDelayByAttackSpeed(480L);
        this.setDotDuration(14000L);
        this.setInterval(480L);
        this.setLimitAttackCount(26L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
