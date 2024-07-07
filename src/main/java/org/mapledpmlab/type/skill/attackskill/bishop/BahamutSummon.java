package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BahamutSummon extends AttackSkill {
    public BahamutSummon() {
        this.setName("바하뮤트");
        this.setDamage(173.0);
        this.setAttackCount(3L);
        this.setDelay(600L);
        this.setInterval(3000L);
        this.setDotDuration(720000L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(-40L);        // 아케인 에임 소환수 미적용
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
