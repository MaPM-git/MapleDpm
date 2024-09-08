package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class RelicUnbound extends GaugeAttackSkill {
    public RelicUnbound() {
        this.setName("렐릭 언바운드(블래스트)");
        this.setAttackCount(8L * 6);
        this.setDamage(1375.0);
        this.setCooldown(120.0);
        this.setDelay(720L);
        this.setDotDuration(10000L);
        this.setInterval(2000L);
        this.setLimitAttackCount(4L);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(51 + 20L);    // 에이션트 포스-보스 킬러
        this.addIgnoreDefenseList(20L); // 에인션트 포스-이그노어 가드
        this.addFinalDamage(1.6);       // 코어강화
        this.setGaugeCharge(-250.0);
    }
}
