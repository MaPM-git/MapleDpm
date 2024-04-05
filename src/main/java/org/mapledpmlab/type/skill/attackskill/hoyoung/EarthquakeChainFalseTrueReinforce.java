package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EarthquakeChainFalseTrueReinforce extends AttackSkill {
    public EarthquakeChainFalseTrueReinforce() {
        this.setName("지진쇄 : 허/실(강화)");
        this.setDamage(1110.0 + 250);
        this.setDelayByAttackSpeed(450L);
        this.setAttackCount(6L);
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
