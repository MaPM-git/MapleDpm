package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InstallShield extends AttackSkill {
    public InstallShield() {
        this.setName("인스톨 실드");
        this.setAttackCount(4L);
        this.setDamage(228.0);
        this.setCooldown(60.0);
        this.setDelayByAttackSpeed(450L);
        this.setDotDuration(60000L);
        this.setInterval(2000L);
        this.setAddDamage(20L);         // 인스톨 실드-리인포스
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
