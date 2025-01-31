package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FistMethodInhalingVortex extends AttackSkill {
    public FistMethodInhalingVortex() {
        this.setName("권술 : 흡성와류");
        this.setDamage(465.0);
        this.setDelayByAttackSpeed(990L);
        this.setAttackCount(6L);
        this.setCooldown(45.0);
        this.setDotDuration(40000L);
        this.setInterval(1000L - 200);  // 권술 : 흡성와류 - 헤이스트
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
