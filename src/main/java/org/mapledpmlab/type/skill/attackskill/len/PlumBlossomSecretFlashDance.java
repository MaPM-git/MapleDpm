package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlumBlossomSecretFlashDance extends AttackSkill {
    public PlumBlossomSecretFlashDance() {
        this.setName("매화검 절기 : 섬무");
        this.setAttackCount(6L);
        this.setDamage(1050.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setDotDuration(5040L);
        this.setInterval(90L);
        this.setDelay(5040L);
        this.setLimitAttackCount(56L);
        this.setApplyFinalAttack(true);
    }
}