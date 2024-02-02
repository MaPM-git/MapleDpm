package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class UltimateBlast extends GaugeAttackSkill implements AncientForce {
    public UltimateBlast() {
        this.setName("얼티밋 블래스트");
        this.setAttackCount(15L);
        this.setDamage(1000.0);
        this.setCooldown(120.0);
        this.setDelay(1800L);
        this.setDotDuration(1800L);
        this.setInterval(300L);
        this.setLimitAttackCount(6L);
        this.addFinalDamage(2.0);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(51 + 20L);    // 에이션트 포스-보스 킬러
        this.addFinalDamage(1.6);       // 코어강화
        this.setGaugeCharge(-1000.0);
    }
}
