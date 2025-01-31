package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuzzyRobMasqueradeExecution extends AttackSkill {
    public FuzzyRobMasqueradeExecution() {
        this.setName("퍼지롭 매스커레이드 : 처형");
        this.setAttackCount(7L * 2);
        this.setDamage(330.0 + 30);
        this.setDelayByAttackSpeed(780L);
        this.addIgnoreDefenseList(40L);
        this.setCooldown(8.0);
        this.setAddDamage(20L);                 // 퍼지롭 매스커레이드-리인포스
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(360L);
    }
}
