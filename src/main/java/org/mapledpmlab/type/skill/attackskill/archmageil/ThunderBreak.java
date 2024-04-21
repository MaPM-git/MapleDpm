package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ThunderBreak extends ThunderAttack {
    public ThunderBreak() {
        this.setName("썬더 브레이크");
        this.setDamage(860.0);
        this.setAttackCount(15L);
        this.setDelay(660L);
        this.setCooldown(40.0);
        this.setDotDuration(15000L);
        this.setInterval(210L);
        this.setLimitAttackCount(8L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);           // 코어강화
    }
}
