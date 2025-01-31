package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CosmicShower extends AttackSkill {
    public CosmicShower(Long cosmicOrbCount) {
        this.setName("코스믹 샤워");
        this.setAttackCount(3L);
        this.setDamage(740.0 + 70);
        this.setCooldown(45.0 + cosmicOrbCount * 3);
        this.setDotDuration(45000L + cosmicOrbCount * 3000);
        this.setInterval(1050L);
        this.setAddDamage(20L + 61);    // 코스믹 샤워/버스트-리인포스, 코스믹 버스트
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
