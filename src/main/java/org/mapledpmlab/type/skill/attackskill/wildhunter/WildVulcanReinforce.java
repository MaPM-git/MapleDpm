package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildVulcanReinforce extends AttackSkill {
    public WildVulcanReinforce() {
        this.setName("와일드 발칸(강화)");
        this.setAttackCount(1L);
        this.setDamage(530.0);
        this.setDelay(90L);
        this.setAddDamage(15L + 20 + 20);   // 와일드 발칸-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
        this.setApplyFinalAttack(true);
    }
}
