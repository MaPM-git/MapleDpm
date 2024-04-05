package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GoldCudgelHumanReinforce extends AttackSkill {
    public GoldCudgelHumanReinforce() {
        this.setName("금고봉 : 인(강화)");
        this.setDamage(725.0);
        this.setDelayByAttackSpeed(420L);
        this.setAttackCount(10L);
        this.setCooldown(11.0);
        this.setAddDamage(10L + 15 + 30);   // 천지인-리인포스
        this.setRelatedSkill(new GoldCudgelHumanFinishReinforce());
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
