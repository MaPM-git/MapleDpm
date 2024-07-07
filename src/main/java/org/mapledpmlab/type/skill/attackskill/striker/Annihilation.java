package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Annihilation extends AttackSkill {
    public Annihilation() {
        this.setName("섬멸");
        this.setAttackCount(7L);
        this.setDamage(470.0);
        this.setDelayByAttackSpeed(480L);
        this.setAddDamage(20L + 20);        // 섬멸-리인포스, 보스 킬러
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.71);          // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
