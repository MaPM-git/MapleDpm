package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TeleportMastery extends AttackSkill {
    public TeleportMastery() {
        this.setName("텔레포트 마스터리");
        this.setDamage(272.0);
        this.setAttackCount(1L);
        this.setCooldown(8.0);          // 8초마다 쓰기용
        this.addFinalDamage(2.8);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setDelay(600L);
        this.setApplyFinalAttack(true);
    }
}
