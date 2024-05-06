package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DrillContainer extends AttackSkill {
    public DrillContainer() {
        this.setName("드릴 컨테이너");
        this.setDamage(434.0);
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(30.0);
        this.setAttackCount(1L);
        this.setDotDuration(30000L);
        this.setInterval(250L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
