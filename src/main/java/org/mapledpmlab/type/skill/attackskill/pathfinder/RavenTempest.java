package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class RavenTempest extends GaugeAttackSkill implements AncientForce {
    public RavenTempest() {
        this.setName("레이븐 템페스트");
        this.setAttackCount(6L);
        this.setDamage(1000.0);
        this.setCooldown(120.0);
        this.setDelay(720L);
        this.setDotDuration(10000L);
        this.setInterval(250L);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(51 + 20L);    // 에이션트 포스-보스 킬러
        this.addFinalDamage(1.6);       // 코어강화
        this.setGaugeCharge(-300.0);
    }
}
