package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Blast extends AttackSkill {
    public Blast() {
        this.setName("블래스트");
        this.setApplyFinalAttack(true);
        this.setAttackCount(10 + 1 + 1L);   // 어드밴스드 홀리 차지, 블래스트-보너스 어택
        this.setDamage(535.0);
        this.setDelayByAttackSpeed(780L);
        this.setAddDamage(20L);         // 블래스트-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
