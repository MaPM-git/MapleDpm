package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ScarletChargeDriveFlame extends AttackSkill implements LefSkill {
    public ScarletChargeDriveFlame() {
        this.setName("스칼렛 차지드라이브(불길)");
        this.setDamage(565.0 + 100 + 173);
        this.setAttackCount(3L);
        this.setCooldown(3.0);
        this.setRelatedSkill(new ScarletChargeDrive());
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(600L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
