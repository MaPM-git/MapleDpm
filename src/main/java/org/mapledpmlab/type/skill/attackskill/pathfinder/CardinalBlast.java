package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class CardinalBlast extends GaugeAttackSkill implements CardinalForce {
    public CardinalBlast() {
        this.setName("카디널 블래스트");
        this.setAttackCount(5 + 1L);    // 카디널 포스-보너스 어택
        this.setDamage(990.0);
        this.setDelayByAttackSpeed(480L);
        this.setAddDamage(20L);         // 카디널 포스-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(20L);
    }
}
