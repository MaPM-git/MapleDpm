package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CosmicBurstAfterSecond extends AttackSkill {
    public CosmicBurstAfterSecond(Long cosmicOrbCount) {
        this.setName("코스믹 버스트(2타 이후)");
        this.setAttackCount(4L * 2 * cosmicOrbCount);
        this.setDamage(404.0);
        this.addFinalDamage(0.7);
        this.setAddDamage(20L);         // 코스믹 샤워/버스트-리인포스
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        for (int i = 0; i < cosmicOrbCount; i++) {
            this.getMultiAttackInfo().add(480L + i * 60);
        }
    }
}
