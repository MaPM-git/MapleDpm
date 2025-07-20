package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BigFuseGiganticCannonball extends AttackSkill {
    public BigFuseGiganticCannonball() {
        this.setName("빅 휴즈 기간틱 캐논볼(2스택)");
        this.setDamage(2100.0);
        this.setAttackCount(15L);       // 벅샷
        this.setCooldown(60.0);
        this.setDelay(780L);
        this.setDotDuration(120000L);
        this.setInterval(40L);
        this.setLimitAttackCount(50L);
        this.addFinalDamage(0.45);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
