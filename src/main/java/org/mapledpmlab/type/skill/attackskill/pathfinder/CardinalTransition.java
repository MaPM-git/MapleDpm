package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class CardinalTransition extends GaugeAttackSkill implements CardinalForce {
    public CardinalTransition() {
        this.setName("카디널 트랜지션");
        this.setAttackCount(6L);        // 카디널 포스-보너스 어택
        this.setDamage(547.0);
        this.setDelayByAttackSpeed(390L);
        this.setAddDamage(20L);         // 카디널 포스-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(20L);
    }
}
