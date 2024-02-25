package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonSwift extends AttackSkill {
    public DragonSwift() {
        this.setName("드래곤 스위프트");
        this.setDamage(790.0 + 322);
        this.setAttackCount(4L);
        this.setDotDuration(3500L);
        this.setInterval(540L);
        this.setLimitAttackCount(6L);
        this.setCooldown(6.0);          // 드래곤 스위프트-쿨타임 리듀스
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
