package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildVulcanTypeX extends AttackSkill {
    public WildVulcanTypeX() {
        this.setName("와일드 발칸 Type X");
        this.setDelay(4560L + 540);
        this.setDotDuration(4560L);
        this.setInterval(120L);
        this.setLimitAttackCount(38L);
        this.setDamage(1205.0);
        this.setAttackCount(7L);
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
