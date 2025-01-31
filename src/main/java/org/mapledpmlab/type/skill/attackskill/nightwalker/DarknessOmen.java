package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarknessOmen extends AttackSkill implements DarkAttack {
    public DarknessOmen() {
        this.setName("다크니스 오멘");
        this.setAttackCount(6L);
        this.setDamage(820.0);
        this.setDelayByAttackSpeed(240L);
        this.setDotDuration(7000L);
        this.setInterval(300L);
        this.setLimitAttackCount(24L);
        this.setCooldown(60.0 / 2);     // 다크니스 오멘-쿨타임 리듀스
        this.setAddDamage(20L);         // 다크니스 오멘-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
