package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class CardinalDischarge extends GaugeAttackSkill implements CardinalForce {
    public CardinalDischarge() {
        this.setName("카디널 디스차지");
        this.setAttackCount(6 * 2L);    // 카디널 포스-보너스 어택
        this.setDamage(305.0);
        this.setDelayByAttackSpeed(480L);
        this.setAddDamage(20L);         // 카디널 포스-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
        this.setGaugeCharge(20L);       // 화살당 10
    }
}
