package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GrimReaper extends AttackSkill {
    public GrimReaper() {
        this.setName("그림 리퍼");
        this.setInterval(4000L);
        this.setDelay(720L);
        this.setDotDuration(62000L);
        this.setDamage(1760.0);
        this.setAttackCount(12L);
        this.setCooldown(90.0);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
