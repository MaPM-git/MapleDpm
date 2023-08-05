package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ThunderBreak extends ThunderAttack {
    public ThunderBreak() {
        this.setName("썬더 브레이크");
        this.setDamage(2065.0);
        this.setAttackCount(12L);
        this.setCooldown(40.0);
        this.setDotDuration(15000L);
        this.setInterval(210L);
        this.setLimitAttackCount(8L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);           // 코어강화
        this.addFinalDamage(0.5201424);     // 1~8중첩 평균
        this.setAddDamage(60L);             // 프로스트 이펙트
        this.setRelatedSkill(new ThunderBreakDelay());
    }
}
