package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CosmicBurst extends AttackSkill {
    public CosmicBurst(Long cosmicOrbCount) {
        this.setName("코스믹 버스트");
        this.setAttackCount(4L * 2);
        this.setDamage(404.0);
        this.setCooldown(15.0 - cosmicOrbCount);
        this.setAddDamage(20L);         // 코스믹 샤워/버스트-리인포스
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new CosmicBurstAfterSecond(cosmicOrbCount - 1));
    }
}
