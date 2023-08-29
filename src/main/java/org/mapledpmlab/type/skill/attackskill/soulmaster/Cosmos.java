package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Cosmos extends AttackSkill {
    public Cosmos(Long cosmicOrbCount) {
        this.setName("코스모스");
        this.setAttackCount(5L * 2);
        this.setDamage(990.0);
        this.setCooldown(90.0);
        this.setDotDuration(15000L);
        this.setInterval(600L - 30 * (cosmicOrbCount - 1));
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new CosmosDelay());
    }
}
