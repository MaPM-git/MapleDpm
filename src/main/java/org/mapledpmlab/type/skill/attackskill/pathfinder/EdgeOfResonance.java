package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class EdgeOfResonance extends GaugeAttackSkill implements AncientForce {
    public EdgeOfResonance() {
        this.setName("엣지 오브 레조넌스");
        this.setAttackCount(6L);
        this.setDamage(895.0);
        this.setCooldown(15.0);
        this.addFinalDamage(1.5);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(51 + 20L);    // 에이션트 포스-보스 킬러
        this.addIgnoreDefenseList(20L); // 에인션트 포스-이그노어 가드
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setGaugeCharge(-100.0);
    }
}
