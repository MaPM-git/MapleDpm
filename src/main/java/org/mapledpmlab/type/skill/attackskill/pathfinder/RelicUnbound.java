package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class RelicUnbound extends GaugeAttackSkill {
    public RelicUnbound() {
        this.setName("렐릭 언바운드(디스차지)");
        this.setAttackCount(3L);
        this.setDamage(1100.0);
        this.setCooldown(120.0);
        this.setDelay(720L);
        this.setDotDuration(22000L);
        this.setInterval(360L);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(20L);         // 에이션트 포스-인챈트 인헨스
        this.addIgnoreDefenseList(20L); // 에인션트 포스-이그노어 가드
        this.addFinalDamage(1.6);       // 코어강화
        this.setGaugeCharge(-250.0);
    }
}
