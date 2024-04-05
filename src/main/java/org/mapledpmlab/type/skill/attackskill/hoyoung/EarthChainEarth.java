package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EarthChainEarth extends AttackSkill {
    public EarthChainEarth() {
        this.setName("토파류 : 지");
        this.setDamage(750.0 + 100 + 235);
        this.setDelayByAttackSpeed(690L);
        this.setAttackCount(4L);
        this.setRelatedSkill(new EarthChainFalseTrue());
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
