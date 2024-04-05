package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GoldCudgelHumanFinish extends AttackSkill {
    public GoldCudgelHumanFinish() {
        this.setName("금고봉 : 인(마무리)");
        this.setDamage(830.0);
        this.setDelayByAttackSpeed(390L);
        this.setAttackCount(8L);
        this.setAddDamage(10L + 15 + 30);   // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
