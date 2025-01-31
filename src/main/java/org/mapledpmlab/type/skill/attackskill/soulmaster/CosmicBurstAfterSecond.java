package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CosmicBurstAfterSecond extends AttackSkill {
    public CosmicBurstAfterSecond(Long cosmicOrbCount) {
        this.setName("코스믹 버스트(2타 이후)");
        this.setAttackCount(4L * 2);
        this.setDamage(1080.0 + 105);
        this.addFinalDamage(0.7);
        this.setAddDamage(20L);         // 코스믹 샤워/버스트-리인포스
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(480L);
        for (int i = 0; i < cosmicOrbCount - 1; i++) {
            this.getMultiAttackInfo().add(i * 60L);
        }
    }
}
