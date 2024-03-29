package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VoidBurstCombo extends AttackSkill implements VoidSkill {
    public VoidBurstCombo() {
        this.setName("보이드 버스트(연격)");
        this.setDamage(2200.0);
        this.setAttackCount(12L);
        this.setCooldown(180.0);
        this.setDelay(3150L);
        this.setRelatedSkill(new VoidBurstSlash());
        this.addFinalDamage(1.6);   // 코어강화
        this.setAddDamage(20L);     // 보이드-리인포스
        this.setDotDuration(3150L);
        this.setInterval(630L);
        this.setLimitAttackCount(5L);
    }
}
