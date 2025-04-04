package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ThunderSpear extends ThunderAttack {
    public ThunderSpear() {
        this.setName("썬더 스피어");
        this.setDamage(587.0);
        this.setAttackCount(3L);
        this.setDelayByAttackSpeed(900L);
        this.setDotDuration(120000L);
        this.setInterval(1080L);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
