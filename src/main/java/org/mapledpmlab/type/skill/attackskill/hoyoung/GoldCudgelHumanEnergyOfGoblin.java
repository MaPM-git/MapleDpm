package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GoldCudgelHumanEnergyOfGoblin extends AttackSkill {
    public GoldCudgelHumanEnergyOfGoblin() {
        this.setName("금고봉 : 인(도깨비의 기운)");
        this.setDamage(825.0);
        this.setAttackCount(8L);
        this.setAddDamage(10L + 15 + 30);   // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
