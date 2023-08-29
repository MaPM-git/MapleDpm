package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CygnusPhalanx extends AttackSkill {
    public CygnusPhalanx() {
        this.setName("시그너스 팔랑크스");
        this.setAttackCount(1L * 2);
        this.setDamage(990.0);
        this.setCooldown(30.0);
        this.setDotDuration(30000L);
        this.setInterval(240L);
        this.setLimitAttackCount(70L);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new CygnusPhalanxDelay());
    }
}
