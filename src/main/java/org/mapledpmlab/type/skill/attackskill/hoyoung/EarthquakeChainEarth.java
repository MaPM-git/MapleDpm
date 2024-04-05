package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EarthquakeChainEarth extends AttackSkill {
    public EarthquakeChainEarth() {
        this.setName("지진쇄 : 지");
        this.setDamage(650.0 + 250);
        this.setDelayByAttackSpeed(660L);
        this.setAttackCount(6L);
        this.setCooldown(6.0);
        this.setRelatedSkill(new EarthquakeChainFalseTrue());
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
