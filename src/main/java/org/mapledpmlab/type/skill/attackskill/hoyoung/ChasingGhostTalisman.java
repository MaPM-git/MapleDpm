package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChasingGhostTalisman extends AttackSkill {
    public ChasingGhostTalisman() {
        this.setName("추적 귀화부");
        this.setDamage(210.0 + 220);
        this.setAttackCount(5L);
        this.setCooldown(45.0);
        this.setDelayByAttackSpeed(630L);
        this.setDotDuration(50000L);
        this.setInterval(1800L - 450);  // 추적 귀화부-헤이스트
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
