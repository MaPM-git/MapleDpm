package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EarthChainFalseTrueReinforce extends AttackSkill {
    public EarthChainFalseTrueReinforce() {
        this.setName("토파류 : 지 허/실(강화)");
        this.setDamage(960.0 + 100 + 230);
        this.setDelayByAttackSpeed(540L);
        this.setAttackCount(4L);
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
