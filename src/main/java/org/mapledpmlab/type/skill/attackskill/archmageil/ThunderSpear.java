package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ThunderSpear extends ThunderAttack {
    public ThunderSpear() {
        this.setName("썬더 스피어");
        this.setDamage(370.0);
        this.setAttackCount(3L);
        this.setCooldown(120.0);        // 120초마다 사용하기
        this.setDotDuration(120000L);
        this.setInterval(1080L);
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new ThunderSpearDelay());
        this.setApplyFinalAttack(true);
        this.setAddDamage(60L);         // 프로스트 이펙트
    }
}
