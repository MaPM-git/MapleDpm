package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ThunderSpearDelay extends ThunderAttack {
    public ThunderSpearDelay() {
        this.setName("썬더 스피어");
        this.setDelayByAttackSpeed(900L);
        this.setCooldown(120.0);        // 120초마다 사용
    }
}
