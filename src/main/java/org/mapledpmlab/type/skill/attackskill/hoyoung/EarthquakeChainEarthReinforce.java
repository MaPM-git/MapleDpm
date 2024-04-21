package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EarthquakeChainEarthReinforce extends AttackSkill {
    public EarthquakeChainEarthReinforce() {
        this.setName("지진쇄 : 지(강화)");
        this.setDamage(1010.0 + 255);
        this.setDelay(510L + 30);
        this.setDelayByAttackSpeed(660L);
        this.setAttackCount(6L);
        this.setCooldown(6.0);
        this.setRelatedSkill(new EarthquakeChainEarthAloofBlueMoon());
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
