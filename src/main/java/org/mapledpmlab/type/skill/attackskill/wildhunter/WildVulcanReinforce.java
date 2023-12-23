package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildVulcanReinforce extends AttackSkill {
    public WildVulcanReinforce() {
        this.setName("와일드 발칸(강화)");
        this.setAttackCount(2L);
        this.setDamage(345.0);
        this.setDelay(70L);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
        this.setApplyFinalAttack(true);
    }
}
