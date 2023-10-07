package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class TripleImpact extends GaugeAttackSkill implements AncientForce {
    public TripleImpact() {
        this.setName("트리플 임팩트");
        this.setAttackCount(5L);
        this.setDamage(265.0);
        this.setDelayByAttackSpeed(540L);
        this.setCooldown(10.0);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(51 + 20L);    // 에이션트 포스-보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-50.0);
    }
}
