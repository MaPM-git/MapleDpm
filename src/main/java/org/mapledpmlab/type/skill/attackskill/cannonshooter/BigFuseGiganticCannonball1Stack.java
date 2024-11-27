package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BigFuseGiganticCannonball1Stack extends AttackSkill {
    public BigFuseGiganticCannonball1Stack() {
        this.setName("빅 휴즈 기간틱 캐논볼(1스택)");
        this.setDamage(1860.0);
        this.setAttackCount(15L);       // 벅샷
        this.setCooldown(25.0);
        this.setDelay(780L);
        this.setDotDuration(120000L);
        this.setInterval(210L);
        this.setLimitAttackCount(25L);
        this.addFinalDamage(0.45);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyCooldownReduction(false);
    }
}
