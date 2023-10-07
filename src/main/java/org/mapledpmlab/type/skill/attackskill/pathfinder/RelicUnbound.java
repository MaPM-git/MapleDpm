package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class RelicUnbound extends GaugeAttackSkill {
    public RelicUnbound() {
        this.setName("렐릭 언바운드(디스차지)");
        this.setAttackCount(3L);
        this.setDamage(1100.0);
        this.setCooldown(120.0);
        this.setDotDuration(22000L);
        this.setInterval(360L);
        this.setAddDamage(20L);         // 에이션트 포스-인챈트 인헨스
        this.addFinalDamage(1.6);       // 코어강화
        this.setGaugeCharge(-250.0);
        this.setRelatedSkill(new RelicUnboundDelay());
    }
}
