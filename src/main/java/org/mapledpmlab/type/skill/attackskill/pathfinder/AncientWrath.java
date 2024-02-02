package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class AncientWrath extends GaugeAttackSkill implements AncientForce {
    public AncientWrath() {
        this.setName("고대의 분노");
        this.setAttackCount(8L);
        this.setDamage(1280.0);
        this.setCooldown(10.0);
        this.setDotDuration(30L);
        this.setInterval(10L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(51 + 20L);    // 에이션트 포스-보스 킬러
    }
}
