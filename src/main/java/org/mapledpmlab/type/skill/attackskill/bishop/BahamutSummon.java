package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BahamutSummon extends AttackSkill {
    public BahamutSummon() {
        this.setName("바하뮤트");
        this.setDamage(173.0);
        this.setAttackCount(3L);
        this.setDelay(600L);
        this.setCooldown(265.0);
        this.setInterval(3000L);
        this.setDotDuration(260000L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(-40L);        // 아케인 에임 소환수 미적용
    }
}
