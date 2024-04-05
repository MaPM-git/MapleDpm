package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EarthChainEarthReinforce extends AttackSkill {
    public EarthChainEarthReinforce() {
        this.setName("토파류 : 지(강화)");
        this.setDamage(960.0 + 100 + 235);
        this.setDelayByAttackSpeed(690L);
        this.setAttackCount(4L);
        this.setRelatedSkill(new EarthquakeChainFalseTrueReinforce());
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
