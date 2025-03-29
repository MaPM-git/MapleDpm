package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class ObsidianBarrier extends GaugeAttackSkill {
    public ObsidianBarrier() {
        this.setName("옵시디언 배리어(블래스트)");
        this.setAttackCount(5L);
        this.setDamage(1040.0);
        this.setCooldown(120.0);
        this.setDelay(60L);
        this.setDotDuration(20000L);
        this.setInterval(500L);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(51 + 20 + 20L);    // 에이션트 포스-보스 킬러, 에인션트 포스-인챈트 인핸스
        this.addFinalDamage(1.6);       // 코어강화
        this.setGaugeCharge(-300.0);
    }
}
