package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BigFuseGiganticCannonball extends AttackSkill {
    public BigFuseGiganticCannonball() {
        this.setName("빅 휴즈 기간틱 캐논볼");
        this.setDamage(900.0);
        this.setAttackCount(12L);       // 벅샷
        this.setCooldown(75.0);
        this.setDotDuration(120000L);
        this.setInterval(210L);
        this.setLimitAttackCount(120L);
        this.addFinalDamage(0.45);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new BigFuseGiganticCannonballDelay());
    }
}
