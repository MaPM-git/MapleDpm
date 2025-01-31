package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuzzyRobMasqueradeSnipe extends AttackSkill {
    public FuzzyRobMasqueradeSnipe() {
        this.setName("퍼지롭 매스커레이드 : 저격");
        this.setAttackCount(7L * 2);
        this.setDamage(510.0 + 46);
        this.setDelayByAttackSpeed(780L);
        this.addIgnoreDefenseList(40L);
        this.setAddDamage(20L);                 // 퍼지롭 매스커레이드-리인포스
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
    }
}
