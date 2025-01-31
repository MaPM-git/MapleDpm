package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MaxCannonRainbow extends AttackSkill {
    public MaxCannonRainbow() {
        this.setName("맥스 캐논 레인보우");
        this.setDamage(2000.0);
        this.setAttackCount(5L);
        this.setCooldown(180.0);
        this.setDelayByAttackSpeed(480L);
        this.setDotDuration(10000L);
        this.setInterval(240L);
        this.setLimitAttackCount(39L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
