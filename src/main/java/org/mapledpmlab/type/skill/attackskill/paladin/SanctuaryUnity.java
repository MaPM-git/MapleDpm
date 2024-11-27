package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SanctuaryUnity extends AttackSkill {
    public SanctuaryUnity() {
        this.setName("생츄어리(결속)");
        this.setApplyFinalAttack(true);
        this.setAttackCount(8 + 2L);    // 생츄어리-보너스 어택
        this.setCooldown(14.0 * 0.7);   // 생츄어리-쿨타임 리듀스
        this.setDamage(620.0);
        this.setAddDamage(20L);         // 생츄어리-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.6);       // 결속
    }
}
