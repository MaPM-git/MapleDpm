package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WildVulcanTypeX extends AttackSkill {
    public WildVulcanTypeX() {
        this.setName("와일드 발칸 Type X");
        this.setDotDuration(4280L);
        this.setInterval(100L);
        this.setDamage(1205.0);
        this.setAttackCount(7L);
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new WildVulcanTypeXDelay());
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
