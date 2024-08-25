package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class AncientWrath extends GaugeAttackSkill implements AncientForce {
    public AncientWrath() {
        this.setName("포세이큰 렐릭(고대의 분노)");
        this.setAttackCount(15L);
        this.setDamage(1280.0);
        this.setCooldown(10.0);
        this.addFinalDamage(1.1);       // 에인션트 아처리
        this.setAddDamage(50 + 51 + 20L);    // 에이션트 포스-보스 킬러
        this.addIgnoreDefenseList(20L); // 에인션트 포스-이그노어 가드
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
    }
}
