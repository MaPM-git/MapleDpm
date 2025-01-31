package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlastUnity extends AttackSkill {
    public BlastUnity() {
        this.setName("블래스트(결속)");
        this.setApplyFinalAttack(true);
        this.setAttackCount(10 + 1 + 1L);   // 어드밴스드 홀리 차지, 블래스트-보너스 어택
        this.setDamage(535.0 + 80);
        this.setAddDamage(20L);         // 블래스트-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.6);       // 결속
    }
}
