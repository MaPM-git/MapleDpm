package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EarthquakeChainEarthAloofBlueMoon extends AttackSkill {
    public EarthquakeChainEarthAloofBlueMoon() {
        this.setName("지진쇄 : 지(고고한 청월)");
        this.setDamage(730.0 + 255);
        this.setDelayByAttackSpeed(660L);
        this.setAttackCount(5L);
        this.setDotDuration(5000L);
        this.setInterval(900L);
        this.setRelatedSkill(new EarthquakeChainFalseTrueReinforce());
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
