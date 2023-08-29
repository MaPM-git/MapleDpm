package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrossTheStyx extends AttackSkill {
    public CrossTheStyx() {
        this.setName("크로스 더 스틱스");
        this.setAttackCount(5L * 2);
        this.setDamage(830.0);
        this.setDotDuration(630L);
        this.setInterval(126L);
        this.setLimitAttackCount(5L);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.9);           // 마스터 오브 더 소드
        this.addFinalDamage(1.6);           // 코어강화
        this.setRelatedSkill(new CrossTheStyxDelay());
    }
}
