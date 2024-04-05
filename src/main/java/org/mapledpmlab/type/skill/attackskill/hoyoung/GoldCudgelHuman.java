package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GoldCudgelHuman extends AttackSkill {
    public GoldCudgelHuman() {
        this.setName("금고봉 : 인");
        this.setDamage(455.0);
        this.setDelayByAttackSpeed(420L);
        this.setAttackCount(10L);
        this.setCooldown(11.0);
        this.setAddDamage(10L + 15 + 30);   // 천지인-리인포스
        this.setRelatedSkill(new GoldCudgelHumanFinish());
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
