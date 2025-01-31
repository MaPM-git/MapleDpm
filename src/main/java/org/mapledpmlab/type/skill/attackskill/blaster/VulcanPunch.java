package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VulcanPunch extends AttackSkill {
    public VulcanPunch() {
        this.setName("발칸 펀치");
        this.setAttackCount(12L);
        this.setDamage(1320.0);
        this.setDelay(1080L);
        this.setCooldown(60.0);
        this.setRelatedSkill(new VulcanPunchBeforeDelay());
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
