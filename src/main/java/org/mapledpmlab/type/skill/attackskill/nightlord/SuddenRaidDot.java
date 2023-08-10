package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SuddenRaidDot extends AttackSkill {
    public SuddenRaidDot() {
        this.setName("써든레이드(도트)");
        this.setAttackCount(1L);
        this.setDamage(210.0);
        this.setDotDuration(10000L);
        this.setInterval(1000L);
        this.setAddDamage(20L);         // 생츄어리-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
